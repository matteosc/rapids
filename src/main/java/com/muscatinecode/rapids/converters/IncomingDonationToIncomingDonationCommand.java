package com.muscatinecode.rapids.converters;

import com.muscatinecode.rapids.commands.IncomingDonationCommand;
import com.muscatinecode.rapids.commands.RecipeCommand;
import com.muscatinecode.rapids.domain.Category;
import com.muscatinecode.rapids.domain.IncomingDonation;
import com.muscatinecode.rapids.domain.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 6/21/17.
 */
@Component
public class IncomingDonationToIncomingDonationCommand implements Converter<IncomingDonation, IncomingDonationCommand>{


    @Synchronized
    @Nullable
    @Override
    public IncomingDonationCommand convert(IncomingDonation source) {
        if (source == null) {
            return null;
        }

        final IncomingDonationCommand command = new IncomingDonationCommand();
        command.setId(source.getId());
        command.setName(source.getName());
        command.setDonationDate(source.getDonationDate());

        return command;
    }
}
