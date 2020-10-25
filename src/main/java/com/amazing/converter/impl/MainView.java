package com.amazing.converter.impl;

import com.amazing.converter.IPresenter;
import com.amazing.converter.IView;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ContainerEvent;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;

public class MainView extends JFrame implements IView {
    private JComboBox<String> comboBoxMainType;
    private JComboBox<String> comboBoxTypeB;
    private JComboBox<String> comboBoxTypeA;
    private JTextField textInputA;
    private JTextField textInputB;

    private IPresenter presenter;

    public MainView() {
        // createGUI method call
        // activate only for UI modification
    }

    @Override
    public void setPresenter(IPresenter p) {
        presenter = p;
        createGUI(); // disable this line when modifying ui
    }

    private void createGUI() {
        setResizable(false);
        setTitle("Amazing Unit Converter");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 387, 268);
        JPanel contentPane = new JPanel();
        contentPane.addContainerListener(this);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel labelSelectType = new JLabel("Select a Type :");
        labelSelectType.setBounds(88, 20, 86, 21);
        contentPane.add(labelSelectType);

        comboBoxMainType = new JComboBox<>();
        comboBoxMainType.setBounds(177, 16, 109, 26);
        contentPane.add(comboBoxMainType);

        textInputA = new JTextField();
        textInputA.setBounds(16, 67, 122, 28);
        contentPane.add(textInputA);
        textInputA.setText("0.0");
        textInputA.setColumns(10);

        comboBoxTypeA = new JComboBox<>();
        comboBoxTypeA.setBounds(16, 120, 122, 26);
        comboBoxTypeA.addItemListener(this);
        comboBoxTypeA.addFocusListener(this);
        contentPane.add(comboBoxTypeA);

        JLabel label = new JLabel("=");
        label.setBounds(157, 81, 55, 47);
        contentPane.add(label);
        label.setFont(new Font("SansSerif", Font.PLAIN, 16));
        label.setHorizontalAlignment(SwingConstants.CENTER);

        textInputB = new JTextField();
        textInputB.setBounds(236, 67, 122, 28);
        contentPane.add(textInputB);
        textInputB.setText("0.0");
        textInputB.setColumns(10);

        comboBoxTypeB = new JComboBox<>();
        comboBoxTypeB.setBounds(236, 120, 122, 26);
        comboBoxTypeB.addItemListener(this);
        comboBoxTypeB.addFocusListener(this);
        contentPane.add(comboBoxTypeB);

        comboBoxMainType.addItemListener(this);

        setVisible(true);
    }

    public void componentAdded(ContainerEvent e) {
        // call the presenter when they are added to the screen
        if (e.getChild() instanceof JComboBox<?>) {
            if (e.getChild() == comboBoxMainType) {
                presenter.getModel(comboBoxMainType, "Types");
            } else if (e.getChild() == comboBoxTypeA) {
                presenter.getModel(comboBoxTypeA, (String) comboBoxMainType.getSelectedItem(), "A");
            } else if (e.getChild() == comboBoxTypeB) {
                presenter.getModel(comboBoxTypeB, (String) comboBoxMainType.getSelectedItem(), "B");
            }
        }
    }

    public void itemStateChanged(ItemEvent e) {
        // request a new type model to be set
        if (e.getSource() == comboBoxMainType) {
            presenter.getModel(comboBoxTypeA, (String) comboBoxMainType.getSelectedItem(), "A");
            presenter.getModel(comboBoxTypeB, (String) comboBoxMainType.getSelectedItem(), "B");
        }
        // otherwise calculate and show the result
        else if (e.getSource() == comboBoxTypeB) {
            presenter.getResult(textInputA, comboBoxTypeA, textInputB, comboBoxTypeB);
        } else if (e.getSource() == comboBoxTypeA) {
            presenter.getResult(textInputB, comboBoxTypeB, textInputA, comboBoxTypeA);
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource() == comboBoxTypeB) {
            presenter.getResult(textInputA, comboBoxTypeA, textInputB, comboBoxTypeB);
        } else if (e.getSource() == comboBoxTypeA) {
            presenter.getResult(textInputB, comboBoxTypeB, textInputA, comboBoxTypeA);
        }
    }

    @Override
    public void setModel(JComboBox<String> box, ComboBoxModel<String> model) {
        box.setModel(model);
        box.setSelectedIndex(0);
    }

    @Override
    public void setResult(JTextField outputTo, String result) {
        outputTo.setText(result);
    }

    @Override
    public void componentRemoved(ContainerEvent e) {
        // no need for a defintion
    }

    @Override
    public void focusLost(FocusEvent e) {
        // no need for a defintion
    }
}