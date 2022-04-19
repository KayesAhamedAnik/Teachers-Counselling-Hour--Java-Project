package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

import repository.*;
import entity.*;

public class WelcomeFrame extends JFrame implements ActionListener
{
	private JPanel panel;
	private Color backgroundColor,btnColor;
	private JButton viewTsfBtn,loginBtn;
	private Font myFont,myFont2;
	private JLabel label,imageLabel;
	private ImageIcon img;
	
	
	
	public WelcomeFrame()
	{
		super("AIUB Faculty Counselling Hours");
		this.setSize(800, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.backgroundColor=new Color(0,118,118);

		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(backgroundColor);
		
		btnColor=new Color(255,191,0);
		myFont=new Font("Consolas",Font.BOLD,20);
		myFont2=new Font("Consolas",Font.BOLD,25);
		
		
		img=new ImageIcon("aiub.png");
		imageLabel=new JLabel(img);
		imageLabel.setBounds(320,20,160,161);
		panel.add(imageLabel);
		
		
		
		label=new JLabel("Welcome To AIUB TSF System");
		label.setBounds(200,160,400,100);
		label.setBackground(backgroundColor);
		label.setFont(myFont2);
		panel.add(label);
		
		viewTsfBtn=new JButton("View TSF");
		viewTsfBtn.setBounds(320,252,180,50);
		viewTsfBtn.setBackground(btnColor);
		viewTsfBtn.addActionListener(this);
		viewTsfBtn.setFont(myFont);
		panel.add(viewTsfBtn);
		
		
		loginBtn=new JButton("LOG IN ");
		loginBtn.setBounds(320,307,180,50);
		loginBtn.setBackground(btnColor);
		loginBtn.addActionListener(this);
		loginBtn.setFont(myFont);
		panel.add(loginBtn);
	
		this.add(panel);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(loginBtn.getText()))
		{
		
					LoginFrame lif = new LoginFrame();
					lif.setVisible(true);
					this.setVisible(false);
		}
		else if(command.equals(viewTsfBtn.getText()))
		{
			ViewTsfFrame vtf=new ViewTsfFrame();
			vtf.setVisible(true);
			this.setVisible(false);
		}
		
		else{}
	}
	
}