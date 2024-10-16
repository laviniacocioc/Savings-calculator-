/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UserInterface extends Application {

    @Override
    public void start(Stage stage) {
        // Create the root layout
        BorderPane layout = new BorderPane();

        // Create the LineChart for the center of the BorderPane
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis();
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Savings Calculator");

        layout.setCenter(lineChart);

        // Create a VBox for sliders and labels
        VBox topSection = new VBox();
        
        // Create first BorderPane for Monthly Savings
        BorderPane savingsPane = new BorderPane();
        Label savingsLabel = new Label("Monthly savings");
        Label savingsValue = new Label("25");
        Slider savingsSlider = new Slider(25, 250, 25);
        savingsSlider.setShowTickMarks(true);
        savingsSlider.setShowTickLabels(true);

        savingsPane.setLeft(savingsLabel);
        savingsPane.setCenter(savingsSlider);
        savingsPane.setRight(savingsValue);

        Slider interestSlider = new Slider(0, 10, 0);
        interestSlider.setShowTickMarks(true);
        interestSlider.setShowTickLabels(true);
        
        // Add listener to the savings slider
        savingsSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            savingsValue.setText(String.format("%.0f", newVal));
            updateChart(lineChart, savingsSlider.getValue(), interestSlider.getValue());
        });

        // Create second BorderPane for Yearly Interest Rate
        BorderPane interestPane = new BorderPane();
        Label interestLabel = new Label("Yearly interest rate");
        Label interestValue = new Label("0");
        

        interestPane.setLeft(interestLabel);
        interestPane.setCenter(interestSlider);
        interestPane.setRight(interestValue);

        // Add listener to the interest slider
        interestSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            interestValue.setText(String.format("%.1f", newVal));
            updateChart(lineChart, savingsSlider.getValue(), interestSlider.getValue());
        });

        // Add both BorderPanes to the VBox
        topSection.getChildren().addAll(savingsPane, interestPane);

        // Set the top section in the BorderPane
        layout.setTop(topSection);

        // Create the scene and set it in the stage
        Scene scene = new Scene(layout, 800, 600);
        stage.setScene(scene);
        stage.show();
        
        // Initial chart update
        updateChart(lineChart, savingsSlider.getValue(), interestSlider.getValue());
    }

    private void updateChart(LineChart<Number, Number> lineChart, double monthlySavings, double yearlyInterestRate) {
        lineChart.getData().clear();

        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        double savings = 0;
        for (int year = 0; year <= 30; year++) {
            series.getData().add(new XYChart.Data<>(year, savings));
            savings += 12 * monthlySavings;
            savings *= (1 + yearlyInterestRate / 100);
        }

        lineChart.getData().add(series);
    }

    public static void main(String[] args) {
        launch(args);
    }
}