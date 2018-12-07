package com.muscatinecode.rapids.converters;


import com.muscatinecode.rapids.commands.CostCenterCommand;
import com.muscatinecode.rapids.domain.CostCenter;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;




/**
 * Created by jt on 6/21/17.
 */
@Component
public class CostCenterCommandToCostCenter implements Converter<CostCenterCommand, CostCenter> {
    private final GoodCommandToGood goodConverter;

    public CostCenterCommandToCostCenter(GoodCommandToGood goodConverter) {
        this.goodConverter = goodConverter;
    }


// todo create good converter



    @Synchronized
    @Nullable
    @Override
    public CostCenter convert(CostCenterCommand source) {
        if (source == null) {
            return null;
        }

        final CostCenter costCenter = new CostCenter();
        costCenter.setId(source.getId());
        costCenter.setName(source.getName());


        if (source.getGoods() != null && source.getGoods().size() > 0) {
            source.getGoods()
                    .forEach(good -> costCenter.getGoods().add( goodConverter.convert(good)));
        }


        return costCenter;
    }
}
