package com.muscatinecode.rapids.converters;

import com.muscatinecode.rapids.commands.DampingCommand;
import com.muscatinecode.rapids.commands.RecipeCommand;
import com.muscatinecode.rapids.domain.Category;
import com.muscatinecode.rapids.domain.Damping;
import com.muscatinecode.rapids.domain.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 6/21/17.
 */
@Component
public class DampingToDampingCommand implements Converter<Damping, DampingCommand>{


    @Synchronized
    @Nullable
    @Override
    public DampingCommand convert(Damping source) {
        if (source == null) {
            return null;
        }

        final DampingCommand command = new DampingCommand();
        command.setId(source.getId());
        command.setDampingDate(source.getDampingDate());
        command.setName(source.getName());


        return command;
    }
}
