package com.muscatinecode.rapids.controllers.Recipe;

import com.muscatinecode.rapids.services.RecipeService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jt on 6/1/17.
 */
@Slf4j
@Controller
public class RecipeIndexController {

    private final RecipeService recipeService;

    public RecipeIndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"recipe", "recipe/", "recipe/index"})
    public String getIndexPage(Model model) {
        log.debug("Getting Index page");

        model.addAttribute("recipes", recipeService.getRecipes());

        return "recipe/index";
    }
}
