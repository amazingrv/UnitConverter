package com.amazing.converter.impl;

import com.amazing.converter.IModel;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class MainModel implements IModel {

    private final double[] conversionFactors = {1000, 100, 10, 1, 0.1, 0.01, 0.001};

    private final Map<String, DefaultComboBoxModel<String>> hashmap;

    public MainModel() {
        //create a new HashMap
        hashmap = new HashMap<>();

        //first put the categories
        String[] conversionTypes = {"Weight", "Length", "Capacity"};
        hashmap.put("Types", new DefaultComboBoxModel<>(conversionTypes));

        //and then create two respective for the units (A and B)
        String[][] setUnits = {
                {"kilogram", "hectogram", "decagram", "gram", "decigram", "centigram", "milligram"},
                {"kilometer", "hectometer", "decameter", "meter", "decimeter", "centimeter", "millimeter"},
                {"kilolitre", "hectolitre", "decalitre", "litre", "decilitre", "centilitre", "millilitre"}
        };
        for (int i = 0; i < setUnits.length; i++) {
            hashmap.put(conversionTypes[i].concat("A"), new DefaultComboBoxModel<>(setUnits[i]));
            hashmap.put(conversionTypes[i].concat("B"), new DefaultComboBoxModel<>(setUnits[i]));
        }
    }

    @Override
    public ComboBoxModel<String> getModelType(String category) {
        return hashmap.get(category);
    }

    @Override
    public ComboBoxModel<String> getModelType(String category, String inputName) {
        return hashmap.get(category.concat(inputName));
    }

    @Override
    public String calculate(String input, int indexFactorA, int indexFactorB) {
        double inputValue = Double.parseDouble(input);
        double result;
        result = inputValue * (conversionFactors[indexFactorA] / conversionFactors[indexFactorB]);
        return String.valueOf(result);
    }
}