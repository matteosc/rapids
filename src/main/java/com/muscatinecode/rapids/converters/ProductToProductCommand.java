package com.muscatinecode.rapids.converters;

import com.muscatinecode.rapids.commands.ProductCommand;
import com.muscatinecode.rapids.domain.Product;
import lombok.Synchronized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 6/21/17.
 */
@Component
public class ProductToProductCommand implements Converter<Product, ProductCommand> {
    @Autowired
    private SupplierInvoiceRowToSupplierInvoiceRowCommand invoiceRowConveter;
    @Autowired
    private SupplierOrderRowToSupplierOrderRowCommand orderRowConveter;
    @Autowired
    private GoodToGoodCommand goodConveter;
    @Autowired
    private UnitOfMeasureToUnitOfMeasureCommand uomConveter;
    @Autowired
    private SupplierToSupplierCommand supConveter;

    @Synchronized
    @Nullable
    @Override
    public ProductCommand convert(Product source) {
        if (source == null) {
            return null;
        }

        final ProductCommand command = new ProductCommand();
        command.setId(source.getId());
        command.setArticlePerCollection(source.getArticlePerCollection());
        command.setBarCode(source.getBarCode());
        command.setCollection(source.getCollection());
        command.setGood(goodConveter.convert(source.getGood()));
        command.setKgPerMu(source.getKgPerMu());
        command.setMeasurementUnit(uomConveter.convert(source.getMeasurementUnit()));
        command.setSupplier(supConveter.convert(source.getSupplier()));
        command.setName(source.getName());
        command.setSupplierCode(source.getSupplierCode());

        /* private Set<SupplierInvoiceRowCommand> supplierInvoiceRows;
    private Set<SupplierOrderRowCommand> supplierOrderRows;

    private Set<AllergenCommand> allergens = new HashSet<>();
*/


        if (source.getSupplierInvoiceRows() != null && source.getSupplierInvoiceRows().size() > 0) {
            source.getSupplierInvoiceRows()
                    .forEach(invoiceRow -> command.getSupplierInvoiceRows().add(invoiceRowConveter.convert(invoiceRow)));
        }


        if (source.getSupplierOrderRows() != null && source.getSupplierOrderRows().size() > 0) {
            source.getSupplierOrderRows()
                    .forEach(supplierOrderRow -> command.getSupplierOrderRows().add(orderRowConveter.convert(supplierOrderRow)));
        }

        return command;
    }
}
