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
public class AddressCommandToAddress implements Converter<AddressCommand, Address> {

    @Synchronized
    @Nullable
    @Override
    public Address convert(AddressCommand source) {
        if(source == null) {
            return null;
        }

        final Address address = new Address();
        address.setCity(source.getCity());
        address.setEmail(source.getEmail());
        address.setNation(source.getNation());
        address.setState(source.getState());
        address.setStreet(source.getStreet());
        address.setZipCode(source.getZipCode());


        return address;
    }
}
