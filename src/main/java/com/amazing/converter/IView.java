package com.amazing.converter;

import javax.swing.*;
import java.awt.event.ContainerListener;
import java.awt.event.FocusListener;
import java.awt.event.ItemListener;

/**
 * Interface for the view and contains different UI elements
 */
public interface IView extends ContainerListener, ItemListener, FocusListener {
    void setPresenter(IPresenter p);

    void setModel(JComboBox<String> box, ComboBoxModel<String> model);

    void setResult(JTextField outputTo, String result);
}