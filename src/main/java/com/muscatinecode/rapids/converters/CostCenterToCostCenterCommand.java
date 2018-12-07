package com.muscatinecode.rapids.converters;

import com.muscatinecode.rapids.commands.CostCenterCommand;
import com.muscatinecode.rapids.commands.RecipeCommand;
import com.muscatinecode.rapids.domain.Category;
import com.muscatinecode.rapids.domain.CostCenter;
import com.muscatinecode.rapids.domain.Good;
import com.muscatinecode.rapids.domain.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
private Long id;
private String name;
private Set<Good> goods = new HashSet<Good>();

/**
 * Created by jt on 6/21/17.
 */
@Component
public class CostCenterToCostCenterCommand implements Converter<CostCenter, CostCenterCommand>{

    private final CategoryToCategoryCommand categoryConveter;



    @Synchronized
    @Nullable
    @Override
    public CostCenterCommand convert(CostCenter source) {
        if (source == null) {
            return null;
        }

        final CostCenterCommand command = new CostCenterCommand();
        command.setId(source.getId());
        command.setName(source.getName());


        if (source.getGoods() != null && source.getGoods().size() > 0){
            source.getGoods()
                    .forEach((Good good) -> command.getGoods().add(goodConveter.convert(good)));
        }



        return command;
    }
}
