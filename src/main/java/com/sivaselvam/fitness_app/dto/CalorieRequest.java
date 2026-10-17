package com.sivaselvam.fitness_app.dto;

import jakarta.validation.constraints.*;

public class CalorieRequest {

    @Min(15)
    @Max(100)
    private int age;

    @NotBlank
    private String gender;

    @Positive
    private double height;

    @Positive
    private double weight;

    @NotBlank
    private String activityLevel;

    @NotBlank
    private String goal;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(String activityLevel) {
        this.activityLevel = activityLevel;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }
}