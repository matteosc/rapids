package com.muscatinecode.rapids.commands;

import com.muscatinecode.rapids.domain.CateType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by jt on 21/6/17.
 */
@Setter
@Getter
@NoArgsConstructor
public class CategoryCommand {
    private Long id;
    private String description;
    private CateType cateType;
}
