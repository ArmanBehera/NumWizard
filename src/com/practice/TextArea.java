package com.practice;

import javax.swing.*;
import java.awt.*;

public class TextArea extends JTextArea{

    TextArea(JFrame frame, Rectangle bounds, String text){

        this.setText(text);
        this.setBounds(bounds);
        this.setFocusable(false);
        this.setEditable(false);
        this.setLineWrap(true);
        this.setWrapStyleWord(true);
        this.setBackground(frame.getContentPane().getBackground());
        this.setFont(new Font("Sans Serif", Font.PLAIN, 13));
        frame.add(this);
    }

    public void set(String text){

        this.setText(text);
    }
}
