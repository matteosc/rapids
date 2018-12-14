package com.muscatinecode.rapids.converters;


import com.muscatinecode.rapids.commands.AddressCommand;
import com.muscatinecode.rapids.commands.NotesCommand;
import com.muscatinecode.rapids.domain.Address;
import com.muscatinecode.rapids.domain.Notes;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 6/21/17.
 */
@Component
public class AddressToAddressCommand implements Converter<Address, AddressCommand>{

    @Synchronized
    @Nullable
    @Override
    public AddressCommand convert(Address source) {
        if (source == null) {
            return null;
        }

        final AddressCommand command = new AddressCommand();
        command.setCity(source.getCity());
        command.setEmail(source.getEmail());
        command.setNation(source.getNation());
        command.setState(source.getState());
        command.setStreet(source.getStreet());
        command.setZipCode(source.getZipCode());

         return command;
    }
}
