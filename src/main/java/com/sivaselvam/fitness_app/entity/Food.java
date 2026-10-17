package com.sivaselvam.fitness_app.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "foods")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private double servingSize;

    private double calories;

    private double protein;

    private double carbohydrates;

    private double fat;

    public Food() {
    }

    public Food(String name,
                double servingSize,
                double calories,
                double protein,
                double carbohydrates,
                double fat) {

        this.name = name;
        this.servingSize = servingSize;
        this.calories = calories;
        this.protein = protein;
        this.carbohydrates = carbohydrates;
        this.fat = fat;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getServingSize() {
        return servingSize;
    }

    public double getCalories() {
        return calories;
    }

    public double getProtein() {
        return protein;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public double getFat() {
        return fat;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setServingSize(double servingSize) {
        this.servingSize = servingSize;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }
}