package com.muscatinecode.rapids.converters;


import com.muscatinecode.rapids.commands.IncomingDonationCommand;
import com.muscatinecode.rapids.commands.RecipeCommand;
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
public class IncomingDonationCommandToIncomingDonation implements Converter<IncomingDonationCommand, IncomingDonation> {


    @Synchronized
    @Nullable
    @Override
    public IncomingDonation convert(IncomingDonationCommand source) {
        if (source == null) {
            return null;
        }

        final IncomingDonation incomingDonation = new IncomingDonation();
        incomingDonation.setId(source.getId());
        incomingDonation.setName(source.getName());
        incomingDonation.setDonationDate(source.getDonationDate());

        return incomingDonation;
    }
}
