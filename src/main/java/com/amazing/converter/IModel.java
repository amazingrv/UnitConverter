package com.amazing.converter;

import javax.swing.*;

/**
 * Interface for the model contains business logic
 */
public interface IModel {
    ComboBoxModel<String> getModelType(String category);

    ComboBoxModel<String> getModelType(String category, String inputName);

    String calculate(String input, int indexFactorA, int indexFactorB);
}