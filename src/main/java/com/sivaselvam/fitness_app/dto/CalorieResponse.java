package com.sivaselvam.fitness_app.dto;


public class CalorieResponse {

    private double bmr;
    private double maintenanceCalories;
    private double targetCalories;
    private double bmi;
    private double protein;

    public CalorieResponse(double bmr,
                           double maintenanceCalories,
                           double targetCalories,
                           double bmi,
                           double protein) {

        this.bmr = bmr;
        this.maintenanceCalories = maintenanceCalories;
        this.targetCalories = targetCalories;
        this.bmi = bmi;
        this.protein = protein;
    }

    public double getBmr() {
        return bmr;
    }

    public double getMaintenanceCalories() {
        return maintenanceCalories;
    }

    public double getTargetCalories() {
        return targetCalories;
    }

    public double getBmi() {
        return bmi;
    }

    public double getProtein() {
        return protein;
    }
}