package com.muscatinecode.rapids.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by jt on 21/6/17.
 */
@Setter
@Getter
@NoArgsConstructor
public class DurableCategoryCommand {
    private Long id;
    private String description;
}
