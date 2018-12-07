package com.muscatinecode.rapids.commands;


import com.muscatinecode.rapids.domain.Difficulty;
import com.muscatinecode.rapids.domain.Good;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jt on 6/21/17.
 */
@Getter
@Setter
@NoArgsConstructor
public class CostCenterCommand {
    private Long id;
    private String name;
    private Set<GoodCommand> goods = new HashSet<>();


}
