package com.muscatinecode.rapids.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Created by jt on 6/21/17.
 */
@Getter
@Setter
@NoArgsConstructor
public class GoodCommand {
    protected Long id;
    protected String name;
    protected Long costCenterId;
    protected Long measurementUnitId;
    protected Long taxDepreciationId;

}
