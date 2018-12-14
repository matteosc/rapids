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
public class ProductCommandToProduct implements Converter<ProductCommand, Product> {

private  GoodCommandToGood goodConverter;
private  UnitOfMeasureCommandToUnitOfMeasure uomConverter;
private  SupplierCommandToSupplier supConverter;
@Autowired
    private   SupplierOrderRowCommandToSupplierOrderRow supordrowConverter;
  @Autowired
    private  SupplierInvoiceRowCommandToSupplierInvoiceRow supInvrowConverter;
  @Autowired
    private  AllergenCommandToAllergen allConv;




    @Synchronized
    @Nullable
    @Override
    public Product convert(ProductCommand source) {
        if (source == null) {
            return null;
        }
/*


    private Set<SupplierInvoiceRowCommand> supplierInvoiceRows;
    private Set<SupplierOrderRowCommand> supplierOrderRows;

    private Set<AllergenCommand> allergens = new HashSet<>();
*
* */
        final Product product = new Product();
        product.setId(source.getId());
        product.setName(source.getName());
        product.setSupplierCode(source.getSupplierCode());
        product.setCollection(source.isCollection());
        product.setArticlePerCollection(source.getArticlePerCollection());
        product.setBarCode(source.getBarCode());
        product.setGood(goodConverter.convert(source.getGood()));
        product.setMeasurementUnit(uomConverter.convert(source.getMeasurementUnit()));
        product.setSupplier(supConverter.convert(source.getSupplier()));


        if (source.getSupplierInvoiceRows() != null && source.getSupplierInvoiceRows().size() > 0) {
            source.getSupplierInvoiceRows()
                    .forEach(supplierInvoiceRowCommand -> product.getSupplierInvoiceRows().add(supInvrowConverter.convert(supplierInvoiceRowCommand)));
        }

        if (source.getSupplierOrderRows() != null && source.getSupplierOrderRows().size() > 0) {
            source.getSupplierOrderRows()
                    .forEach(supplierOrderRow -> product.getSupplierOrderRows().add(supordrowConverter.convert(supplierOrderRow)));
        }

        if (source.getAllergens() != null && source.getAllergens().size() > 0) {
            source.getAllergens()
                    .forEach(allergen -> product.getAllergens().add(allConv.convert(allergen)));
        }





        return product;
    }
}
