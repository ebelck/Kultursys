import java.awt.*;
import java.util.*;
import java.io.*;

import javax.imageio.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class Billettvindu extends JApplet {
	public Billettvindu() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 1, 0, 0));
		
		JComboBox comboBox = new JComboBox();
		panel_1.add(comboBox);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JComboBox comboBox_1 = new JComboBox();
		panel_2.add(comboBox_1);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 2, 0, 0));
		
		JButton btnBestill = new JButton("Bestill");
		panel_3.add(btnBestill);
		
		JButton btnAvbestill = new JButton("Avbestill");
		panel_3.add(btnAvbestill);
		
		JPanel panel_4 = new JPanel();
		getContentPane().add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(1, 1, 0, 0));
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		panel_4.add(textArea);
	}


}
