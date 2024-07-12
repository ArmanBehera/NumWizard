package com.practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ComboBox{

    public JComboBox<String> comboBox;

    ComboBox(JFrame frame, Rectangle bounds, String[] items){

        comboBox = new JComboBox<>(items);
        comboBox.setBounds(bounds);
        comboBox.setFocusable(false);
        frame.add(comboBox);
    }

    public void addActionListener(ActionListener a){

        comboBox.addActionListener(a);
    }

    public int getSelectedIndex(){

        return comboBox.getSelectedIndex();
    }

    public void setEnabled(boolean bool){

        comboBox.setEnabled(bool);
        comboBox.setVisible(bool);
    }
}
