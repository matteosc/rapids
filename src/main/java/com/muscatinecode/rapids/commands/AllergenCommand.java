package com.muscatinecode.rapids.commands;


import com.muscatinecode.rapids.domain.Product;
import com.muscatinecode.rapids.domain.Recipe;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class AllergenCommand {

    private long id;

    private String name;

    private Set<ProductCommand> products = new HashSet<>();

    private Set<RecipeCommand> recipes = new HashSet<>();
    }

