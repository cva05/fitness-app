package com.sivaselvam.fitness_app.service;


import com.sivaselvam.fitness_app.dto.CalorieRequest;
import com.sivaselvam.fitness_app.dto.CalorieResponse;
import org.springframework.stereotype.Service;

@Service
public class CalorieService {

    public CalorieResponse calculate(CalorieRequest request) {

        double bmr;

        // Mifflin-St Jeor equation
        if (request.getGender().equalsIgnoreCase("male")) {

            bmr = (10 * request.getWeight())
                    + (6.25 * request.getHeight())
                    - (5 * request.getAge())
                    + 5;

        } else {

            bmr = (10 * request.getWeight())
                    + (6.25 * request.getHeight())
                    - (5 * request.getAge())
                    - 161;
        }

        double activityMultiplier =
                getActivityMultiplier(request.getActivityLevel());

        double maintenanceCalories =
                bmr * activityMultiplier;

        double targetCalories =
                calculateTargetCalories(
                        maintenanceCalories,
                        request.getGoal()
                );

        double heightInMeters =
                request.getHeight() / 100;

        double bmi =
                request.getWeight()
                        / (heightInMeters * heightInMeters);

        double protein =
                request.getWeight() * 1.6;

        return new CalorieResponse(
                round(bmr),
                round(maintenanceCalories),
                round(targetCalories),
                round(bmi),
                round(protein)
        );
    }

    private double getActivityMultiplier(String activityLevel) {

        return switch (activityLevel.toLowerCase()) {

            case "sedentary" -> 1.2;

            case "light" -> 1.375;

            case "moderate" -> 1.55;

            case "very_active" -> 1.725;

            default -> 1.2;
        };
    }

    private double calculateTargetCalories(
            double maintenanceCalories,
            String goal) {

        return switch (goal.toLowerCase()) {

            case "lose" ->
                    maintenanceCalories - 500;

            case "gain" ->
                    maintenanceCalories + 300;

            default ->
                    maintenanceCalories;
        };
    }

    private double round(double value) {

        return Math.round(value * 100.0) / 100.0;
    }
}