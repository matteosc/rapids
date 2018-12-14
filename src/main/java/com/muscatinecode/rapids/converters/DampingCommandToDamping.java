package com.muscatinecode.rapids.converters;


import com.muscatinecode.rapids.commands.DampingCommand;
import com.muscatinecode.rapids.commands.RecipeCommand;
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
public class DampingCommandToDamping implements Converter<DampingCommand, Damping> {



    @Synchronized
    @Nullable
    @Override
    public Damping convert(DampingCommand source) {
        if (source == null) {
            return null;
        }

        final Damping damping = new Damping();
        damping.setId(source.getId());
        damping.setName(source.getName());
        damping.setDampingDate(source.getDampingDate());


        return damping;
    }
}
