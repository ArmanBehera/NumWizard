package com.practice;

import javax.swing.*;
import java.awt.*;

public class TextField extends JTextField{


    TextField(JFrame frame, Rectangle bounds, String text){

        this.setText(text);
        this.setBounds(bounds);
        frame.add(this);
    }

    public String returnText(){

        return this.getText();
    }
}
