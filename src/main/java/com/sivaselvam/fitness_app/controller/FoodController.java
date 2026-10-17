package com.sivaselvam.fitness_app.controller;


import com.sivaselvam.fitness_app.entity.Food;
import com.sivaselvam.fitness_app.repository.FoodRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foods")
@CrossOrigin
public class FoodController {

    private final FoodRepository foodRepository;

    public FoodController(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @GetMapping
    public List<Food> getFoods() {
        return foodRepository.findAll();
    }

    @GetMapping("/search")
    public List<Food> searchFood(
            @RequestParam String name) {

        return foodRepository
                .findByNameContainingIgnoreCase(name);
    }

    @GetMapping("/{id}")
    public Food getFood(@PathVariable Long id) {

        return foodRepository
                .findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Food not found"));
    }
}