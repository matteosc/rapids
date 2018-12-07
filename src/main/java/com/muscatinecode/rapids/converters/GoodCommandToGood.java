package com.muscatinecode.rapids.converters;

import com.muscatinecode.rapids.commands.GoodCommand;

import com.muscatinecode.rapids.domain.*;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 6/21/17.
 */


@Component
public class GoodCommandToGood implements Converter<GoodCommand, Good> {


    @Nullable
    @Override
    public Good convert(GoodCommand source) {
        if (source == null) {
            return null;
        }

        final Good good = new Good();
        good.setId(source.getId());
good.setName(source.getName());



        if(source.getMeasurementUnitId() != null){
            UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
            unitOfMeasure.setId(source.getMeasurementUnitId());
            good.setMeasurementUnit(unitOfMeasure);

        }



        if(source.getTaxDepreciationId() != null){
            TaxDepreciation taxDepreciation = new TaxDepreciation();
            taxDepreciation.setId(source.getTaxDepreciationId());
            good.setTaxDepreciation(taxDepreciation);

        }




        if(source.getCostCenterId() != null){
            CostCenter costCenter = new CostCenter();
            costCenter.setId(source.getCostCenterId());
            good.setCostCenter(costCenter);
            costCenter.addGood(good);
        }




        return good;
    }
}
