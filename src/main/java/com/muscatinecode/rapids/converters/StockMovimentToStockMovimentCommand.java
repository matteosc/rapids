package com.muscatinecode.rapids.converters;

import com.muscatinecode.rapids.commands.StockMovimentCommand;
import com.muscatinecode.rapids.domain.StockMoviment;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 6/21/17.
 */
@Component
public class StockMovimentToStockMovimentCommand implements Converter<StockMoviment, StockMovimentCommand>{
 private final DampingToDampingCommand dampConv;
    private final IncomingDonationToIncomingDonationCommand indonConv;
    private final GoodToGoodCommand goodConv;
    private final UnitOfMeasureToUnitOfMeasureCommand uomConv;
    private final ProductToProductCommand prodConv;
    private final SupplierInvoiceRowToSupplierInvoiceRowCommand invRowConv;

    public StockMovimentToStockMovimentCommand(DampingToDampingCommand dampConv,
                                               IncomingDonationToIncomingDonationCommand indonConv,
                                               GoodToGoodCommand goodConv,
                                               UnitOfMeasureToUnitOfMeasureCommand uomConv,
                                               ProductToProductCommand prodConv,
                                               SupplierInvoiceRowToSupplierInvoiceRowCommand invRowConv) {
        this.dampConv = dampConv;
        this.indonConv = indonConv;
        this.goodConv = goodConv;
        this.uomConv = uomConv;
        this.prodConv = prodConv;
        this.invRowConv = invRowConv;
    }


    @Synchronized
    @Nullable
    @Override
    public StockMovimentCommand convert(StockMoviment source) {
        if (source == null) {
            return null;
        }

        final StockMovimentCommand command = new StockMovimentCommand();
        command.setId(source.getId());
        command.setDamping(dampConv.convert(source.getDamping()));
        command.setDonation(indonConv.convert(source.getDonation()));
        command.setGood(goodConv.convert(source.getGood()));
        command.setMeasurementUnit(uomConv.convert(source.getMeasurementUnit()));
        ;
        command.setMovimentDate(source.getMovimentDate());
        command.setName(source.getName());
        command.setProduct(prodConv.convert(source.getProduct()));

        command.setQuantity(source.getQuantity());
        command.setSupplierInvoiceRow(invRowConv.convert(source.getSupplierInvoiceRow()));
        command.setValue(source.getValue());




        return command;
    }
}
