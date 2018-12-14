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
public class StockMovimentCommandToStockMoviment implements Converter<StockMovimentCommand, StockMoviment> {
private final DampingCommandToDamping dampConverter;
private final IncomingDonationCommandToIncomingDonation incomDonatConverter;
    private final GoodCommandToGood goodConverter;
    private final UnitOfMeasureCommandToUnitOfMeasure uomConverter;
    private final ProductCommandToProduct prodConverter;
    private final SupplierInvoiceRowCommandToSupplierInvoiceRow invRowConverter;

    public StockMovimentCommandToStockMoviment(DampingCommandToDamping dampConverter, IncomingDonationCommandToIncomingDonation incomDonatConverter, GoodCommandToGood goodConverter, UnitOfMeasureCommandToUnitOfMeasure uomConverter, ProductCommandToProduct prodConverter, SupplierInvoiceRowCommandToSupplierInvoiceRow invRowConverter) {
        this.dampConverter = dampConverter;
        this.incomDonatConverter = incomDonatConverter;
        this.goodConverter = goodConverter;
        this.uomConverter = uomConverter;
        this.prodConverter = prodConverter;
        this.invRowConverter = invRowConverter;
    }


    @Synchronized
    @Nullable
    @Override
    public StockMoviment convert(StockMovimentCommand source) {
        if (source == null) {
            return null;
        }

        final StockMoviment stockMoviment = new StockMoviment();
        stockMoviment.setId(source.getId());
        stockMoviment.setDamping(dampConverter.convert(source.getDamping()));
        stockMoviment.setDonation(incomDonatConverter.convert(source.getDonation()));
        stockMoviment.setGood(goodConverter.convert(source.getGood()));
        stockMoviment.setMeasurementUnit(uomConverter.convert(source.getMeasurementUnit()));
        stockMoviment.setMovimentDate(source.getMovimentDate());
        stockMoviment.setName(source.getName());
        stockMoviment.setProduct(prodConverter.convert(source.getProduct()));
        stockMoviment.setQuantity(source.getQuantity());
        stockMoviment.setSupplierInvoiceRow(invRowConverter.convert(source.getSupplierInvoiceRow()));
        stockMoviment.setValue(source.getValue());


        return stockMoviment;
    }
}
