package com.sss.MasterController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Values {
	public JFrame frame = new JFrame("Values");
    public JTextArea definition = new JTextArea();
    Container def = new Container();
	public Values() {
		frame.setSize(400, 400);
		frame.setAlwaysOnTop(true);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setLayout(new GridLayout(2, 4));
		def.add(definition, BorderLayout.NORTH);
		frame.add(def, BorderLayout.WEST);
		//definition.setEditable(false);
		definition.setBackground(Color.BLUE);
		definition.setForeground(Color.WHITE);
		
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		new Values();
	}
	public void setEnemy() {
		
	}
	public void setIP() {
		
	}
	public void setEvent() {
		
	}
}