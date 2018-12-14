package com.muscatinecode.rapids.converters;


import com.muscatinecode.rapids.commands.AllergenCommand;
import com.muscatinecode.rapids.domain.Allergen;
import lombok.Synchronized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 6/21/17.
 */
@Component
public class AllergenCommandToAllergen implements Converter<AllergenCommand, Allergen> {
    @Autowired
    private  ProductCommandToProduct productConverter;
    @Autowired
private  RecipeCommandToRecipe recConv;


    @Synchronized
    @Nullable
    @Override
    public Allergen convert(AllergenCommand source) {



        if (source == null) {
            return null;
        }

        final Allergen allergen = new Allergen();
        allergen.setId(source.getId());
        allergen.setName(source.getName());

        /*

    private Set<ProductCommand> products = new HashSet<>();

    private Set<RecipeCommand> recipes = new HashSet<>();
         */

        if (source.getRecipes() != null && source.getRecipes().size() > 0) {
            source.getRecipes()
                    .forEach(recipe -> allergen.getRecipes().add(recConv.convert(recipe)));
        }

        if (source.getProducts() != null && source.getProducts().size() > 0) {
            source.getProducts()
                    .forEach(product -> allergen.getProducts().add(productConverter.convert(product)));
        }


        return allergen;
    }
}
