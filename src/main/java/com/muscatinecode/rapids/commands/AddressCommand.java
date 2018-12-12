package com.muscatinecode.rapids.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AddressCommand {

    private String zipCode;
    private String street;
    private String city;
    private String state;
    private String nation;

    private String email;
}
