package com.amazing.runner;

import com.amazing.converter.IPresenter;
import com.amazing.converter.IView;
import com.amazing.converter.impl.MainModel;
import com.amazing.converter.impl.MainPresenter;
import com.amazing.converter.impl.MainView;

import javax.swing.*;
import java.awt.*;

public class App {
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (Exception e) {
                // If Nimbus is not available, fall back to cross-platform
                try {
                    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
                } catch (Exception ex) {
                    // not worth my time
                }
            }

            try {
                IView v = new MainView();
                IPresenter p = new MainPresenter(v, new MainModel());
                v.setPresenter(p);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
