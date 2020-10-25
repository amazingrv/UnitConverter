package com.amazing.converter;

import javax.swing.*;

/**
 * Interface for the presenter acts as translator that bind the two
 */
public interface IPresenter {
    void getModel(JComboBox<String> box, String category);

    void getModel(JComboBox<String> box, String unitType, String inputName);

    void getResult(JTextField inputFrom, JComboBox<String> factorA,
                   JTextField outputTo, JComboBox<String> factorB);
}
