package com.muscatinecode.rapids.services;

import com.muscatinecode.rapids.commands.SupplierInvoiceCommand;
import com.muscatinecode.rapids.converters.SupplierInvoiceCommandToSupplierInvoice;
import com.muscatinecode.rapids.converters.SupplierInvoiceToSupplierInvoiceCommand;
import com.muscatinecode.rapids.domain.SupplierInvoice;
import com.muscatinecode.rapids.repositories.SupplierInvoiceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SupplierInvoiceServiceImpl implements SupplierInvoiceService {
private final SupplierInvoiceRepository repository;
private final SupplierInvoiceToSupplierInvoiceCommand supplierInvoiceToSupplierInvoiceCommand;
    private final SupplierInvoiceCommandToSupplierInvoice supplierInvoiceCommandToSupplierInvoice;

    public SupplierInvoiceServiceImpl(SupplierInvoiceRepository repository,
                                      SupplierInvoiceToSupplierInvoiceCommand supplierInvoiceToSupplierInvoiceCommand,
                                      SupplierInvoiceCommandToSupplierInvoice supplierInvoiceCommandToSupplierInvoice) {
        this.repository = repository;
        this.supplierInvoiceToSupplierInvoiceCommand = supplierInvoiceToSupplierInvoiceCommand;
        this.supplierInvoiceCommandToSupplierInvoice = supplierInvoiceCommandToSupplierInvoice;
    }

    @Override
    public Set<SupplierInvoice> listAllSupplierInvoice() {
        Set<SupplierInvoice> supplierInvoicesSet = new HashSet<>();
        repository.findAll().iterator().forEachRemaining(supplierInvoicesSet::add);
        return supplierInvoicesSet;
    }

    @Override
    public Set<SupplierInvoiceCommand> listAllSuppliersInvoiceCommands() {
        return StreamSupport.stream(repository.findAll()
                .spliterator(), false)
                .map(supplierInvoiceToSupplierInvoiceCommand::convert)
                .collect(Collectors.toSet());
    }


    @Override
    public SupplierInvoice findById(Long l) {
        Optional<SupplierInvoice> optionalSupplierInvoice = repository.findById(l);



        if (!optionalSupplierInvoice.isPresent()) {
            throw new RuntimeException("uom Not Found!");
        }

        return optionalSupplierInvoice.get();
    }

    @Override
    public SupplierInvoiceCommand findCommandById(Long l) {
        return supplierInvoiceToSupplierInvoiceCommand.convert(findById(l));
    }

    @Override
@Transactional
    public SupplierInvoiceCommand saveSupplierInvoiceCommand(SupplierInvoiceCommand command) {

        SupplierInvoice detachedSupInv = supplierInvoiceCommandToSupplierInvoice.convert(command);

        SupplierInvoice savedSup = repository.save(detachedSupInv);
        SupplierInvoiceCommand ret=supplierInvoiceToSupplierInvoiceCommand.convert(savedSup);

        return ret;
    }

    @Override
    public void deleteById(Long idToDelete) {
repository.deleteById(idToDelete);
    }

    @Override
    public List<SupplierInvoice> findAllByNameLike(String description) {
        return null;
    }
}


