package com.muscatinecode.rapids.services;

import com.muscatinecode.rapids.commands.SupplierCommand;
import com.muscatinecode.rapids.converters.SupplierCommandToSupplier;
import com.muscatinecode.rapids.converters.SupplierToSupplierCommand;
import com.muscatinecode.rapids.domain.Supplier;
import com.muscatinecode.rapids.repositories.SupplierRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SupplierServiceImpl implements SupplierService{
    private final SupplierRepository repository;
    private final SupplierToSupplierCommand supplierToSupplierCommand;
    private final SupplierCommandToSupplier supplierCommandToSupplier;

    public SupplierServiceImpl(SupplierRepository repository, SupplierToSupplierCommand supplierToSupplierCommand, SupplierCommandToSupplier supplierCommandToSupplier) {
        this.repository = repository;
        this.supplierToSupplierCommand = supplierToSupplierCommand;
        this.supplierCommandToSupplier = supplierCommandToSupplier;
    }


    @Override
    public Set<Supplier> listAllSuppliers() {
        Set<Supplier> supplierSet = new HashSet<>();
        repository.findAll().iterator().forEachRemaining(supplierSet::add);
        return supplierSet;
    }

    @Override
    public Set<SupplierCommand> listAllSuppliersCommands() {
        return StreamSupport.stream(repository.findAll()
                .spliterator(), false)
                .map(supplierToSupplierCommand::convert)
                .collect(Collectors.toSet());
    }

    @Override
    public Supplier findById(Long l) {
        Optional<Supplier> optionalSupplier = repository.findById(l);



        if (!optionalSupplier.isPresent()) {
            throw new RuntimeException("uom Not Found!");
        }

        return optionalSupplier.get();

    }

    @Override
    @Transactional
    public SupplierCommand findCommandById(Long l) {
        return supplierToSupplierCommand.convert(findById(l));
    }

    @Override
    @Transactional
    public SupplierCommand saveSupplierCommand(SupplierCommand command) {

        Supplier detachedSup = supplierCommandToSupplier.convert(command);

        Supplier savedSup = repository.save(detachedSup);
        SupplierCommand ret=supplierToSupplierCommand.convert(savedSup);

        return ret;
    }

    @Override
    public void deleteById(Long idToDelete) {
repository.deleteById(idToDelete);
    }

    @Override
    public List<Supplier> findAllByNameLike(String description) {
        return null;
    }
}
