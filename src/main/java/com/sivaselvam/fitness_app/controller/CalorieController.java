package com.sivaselvam.fitness_app.controller;


import com.sivaselvam.fitness_app.dto.CalorieRequest;
import com.sivaselvam.fitness_app.dto.CalorieResponse;
import com.sivaselvam.fitness_app.service.CalorieService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calorie")
@CrossOrigin
public class CalorieController {

    private final CalorieService calorieService;

    public CalorieController(CalorieService calorieService) {
        this.calorieService = calorieService;
    }

    @PostMapping("/calculate")
    public CalorieResponse calculate(
            @Valid @RequestBody CalorieRequest request) {

        return calorieService.calculate(request);
    }
}