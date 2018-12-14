package com.muscatinecode.rapids.converters;


import com.muscatinecode.rapids.commands.AllergenCommand;
import com.muscatinecode.rapids.domain.Allergen;
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
public class AllergenToAllergenCommand implements Converter<Allergen, AllergenCommand> {
    @Autowired
    private ProductToProductCommand prodConv;
    @Autowired
    private RecipeToRecipeCommand recdConv;


    @Synchronized
    @Nullable
    @Override
    public AllergenCommand convert(Allergen source) {
        if (source == null) {
            System.out.println("nulla");
            return null;
        }

        final AllergenCommand command = new AllergenCommand();
        command.setId(source.getId());

        command.setName(source.getName());


        if (source.getProducts() != null && source.getProducts().size() > 0) {
            source.getProducts()
                    .forEach((Product product) -> command.getProducts().add(prodConv.convert(product)));
        }


        if (source.getRecipes() != null && source.getRecipes().size() > 0) {
            source.getRecipes()
                    .forEach(recipe -> command.getRecipes().add(recdConv.convert(recipe)));
        }
System.out.println("com "+command);
        return command;
    }
}
