package com.muscatinecode.rapids.converters;

import com.muscatinecode.rapids.commands.GoodCommand;
import com.muscatinecode.rapids.commands.IngredientCommand;
import com.muscatinecode.rapids.domain.Good;
import com.muscatinecode.rapids.domain.Ingredient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 6/21/17.
 */

@Component
public class GoodToGoodCommand implements Converter<Good, GoodCommand> {



    @Synchronized
    @Nullable
    @Override
    public GoodCommand convert(Good good) {
        if (good == null) {
            return null;
        }


        GoodCommand goodCommand = new GoodCommand();

        goodCommand.setId(good.getId());
        if (good.getCostCenter() != null) {
            goodCommand.setCostCenterId(good.getCostCenter().getId());
        }


        if (good.getTaxDepreciation() != null) {
            goodCommand.setTaxDepreciationId(good.getTaxDepreciation().getId());
        }


        if (good.getMeasurementUnit() != null) {
            goodCommand.setMeasurementUnitId(good.getMeasurementUnit().getId());
        }



        return goodCommand;
    }
}
