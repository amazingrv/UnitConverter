package com.amazing.converter.impl;

import com.amazing.converter.IModel;
import com.amazing.converter.IPresenter;
import com.amazing.converter.IView;

import javax.swing.*;

public class MainPresenter implements IPresenter {
    private final IView view;
    private final IModel model;

    public MainPresenter(IView v, IModel m) {
        view = v;
        model = m;
    }

    @Override
    public void getModel(JComboBox<String> box, String category) {
        view.setModel(box, model.getModelType(category));
    }

    @Override
    public void getModel(JComboBox<String> box, String unitType, String inputName) {
        view.setModel(box, model.getModelType(unitType, inputName));
    }

    @Override
    public void getResult(JTextField inputFrom, JComboBox<String> factorA,
                          JTextField outputTo, JComboBox<String> factorB) {
        view.setResult(outputTo, model.calculate(inputFrom.getText(),
                factorA.getSelectedIndex(),
                factorB.getSelectedIndex()));
    }
}