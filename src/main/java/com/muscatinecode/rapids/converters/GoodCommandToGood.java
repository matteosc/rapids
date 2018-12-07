package com.muscatinecode.rapids.converters;

import com.muscatinecode.rapids.commands.GoodCommand;
import com.muscatinecode.rapids.commands.IngredientCommand;
import com.muscatinecode.rapids.domain.CostCenter;
import com.muscatinecode.rapids.domain.Good;
import com.muscatinecode.rapids.domain.Ingredient;
import com.muscatinecode.rapids.domain.Recipe;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 6/21/17.
 */


protected Long measurementUnitId;
protected Long taxDepreciationId;
@Component
public class GoodCommandToGood implements Converter<GoodCommand, Good> {

    private final UnitOfMeasureCommandToUnitOfMeasure uomConverter;

    @Nullable
    @Override
    public Good convert(GoodCommand source) {
        if (source == null) {
            return null;
        }

        final Good good = new Good();
        good.setId(source.getId());
good.setName(source.getName());



        if(source.getCostCenterId() != null){
            CostCenter costCenter = new CostCenter();
            costCenter.setId(source.getCostCenterId();
            good.setCostCenter(costCenter);
            costCenter.addGood(good);
        }







        ingredient.setAmount(source.getAmount());
        ingredient.setDescription(source.getDescription());
        ingredient.setUom(uomConverter.convert(source.getUom()));
        return ingredient;
    }
}
