package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

import repository.*;
import entity.*;

public class ViewTsfFrame extends JFrame implements ActionListener//,MouseListener
{
	private JPanel panel;
	private JLabel titleLabel,titleLabel2,imageLabel,infoLabel;
	private ImageIcon img;
	private JButton viewBtn,exitBtn,refreshBtn,selectDeptBtn,loadBtn;
	private JTextField facultyIdTF;
	private JLabel facultyIdLabel;
	private Font myFont;
	private Color myColor;
	private JTable tsfTable;
	private JScrollPane sp,sp1;

	
	private User user;
	private FacultyRepo fr;
	private UserRepo ur;
	private TsfRepo tr;
	
	public ViewTsfFrame()
	{
		super("AIUB Counselling Hours ~ Home");
		this.setSize(1220,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setBackground(Color.WHITE);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		myFont=new Font("Consolas",Font.BOLD,25);
		myColor=new Color(63,81,181);
		
		fr=new FacultyRepo();
		tr=new TsfRepo();
		
		img=new ImageIcon("aiub.png");
		imageLabel=new JLabel(img);
		imageLabel.setBounds(350,5,160,161);
		panel.add(imageLabel);
		
		titleLabel=new JLabel("<html>AMERICAN<br>INTERNATIONAL<br>UNIVERSITY-<br>BANGLADESH<html>");
		titleLabel.setBounds(530,5,400,140);
		titleLabel.setFont(myFont);
		titleLabel.setForeground(myColor);
		panel.add(titleLabel);
		
		titleLabel2=new JLabel("where leaders are created");
		titleLabel2.setBounds(530,140,400,20);
		panel.add(titleLabel2);
		
		viewBtn=new JButton("View Tsf");
		viewBtn.setBounds(850,180,100,40);
		viewBtn.addActionListener(this);
		panel.add(viewBtn);
		
		facultyIdLabel=new JLabel("Enter Faculty Id:");
		facultyIdLabel.setBounds(545,180,150,40);
		panel.add(facultyIdLabel);
		
		facultyIdTF=new JTextField();
		facultyIdTF.setBounds(695,180,150,40);
		panel.add(facultyIdTF);
		
		/*String data[][] = {{"", "", "", "",""}};
		String head[] = {"Faculty Id", "Name", "Department","Email","Room No",};
		
		tsfTable=new JTable(data,head);
		sp=new JScrollPane(tsfTable);
		tsfTable.setEnabled(false);
		panel.add(sp);tsfTable=new JTable(data,head);
		sp=new JScrollPane(tsfTable);
		sp.setBounds(350,240,800,300);
		tsfTable.setEnabled(false);
		panel.add(sp);
		*/
		infoLabel=new JLabel("Load To View Teachers Information");
		infoLabel.setBounds(5,240,300,120);
		//infoLabel.setOpaque(true);
		panel.add(infoLabel);
		
		loadBtn=new JButton("load");
		loadBtn.setBounds(5,400,200,40);
		loadBtn.addActionListener(this);
		panel.add(loadBtn);
		
		refreshBtn=new JButton("Refresh");
		refreshBtn.setBounds(5,445,200,40);
		refreshBtn.addActionListener(this);
		panel.add(refreshBtn);
		
		exitBtn=new JButton("Exit");
		exitBtn.setBounds(5,490,200,40);
		exitBtn.addActionListener(this);
		panel.add(exitBtn);
		
		
		this.add(panel);
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(refreshBtn.getText()))
		{
			facultyIdTF.setText("");
			

		}
		else if(command.equals(loadBtn.getText()))
		{
			
			String data[][] = fr.getAllFaculty();;
		String head[] = {"Faculty Id", "Name", "Department","Email","Room No",};
		
		tsfTable=new JTable(data,head);
		sp=new JScrollPane(tsfTable);
		tsfTable.setEnabled(false);
		panel.add(sp);tsfTable=new JTable(data,head);
		sp=new JScrollPane(tsfTable);
		sp.setBounds(210,240,1000,300);
		panel.add(sp);
		
		
		}
        else if(command.equals(viewBtn.getText()))
		{
			if(!facultyIdTF.getText().equals(null))
			{
				
			panel.remove(sp);
			String data[][]=tr.getTsf(facultyIdTF.getText());
			String head[]={"DAY","08:00AM-09:00AM","09:00AM-10:00AM","10:00AM-11:00AM","11:00AM-12:00PM","12:00PM-01:00PM","01:00PM-02:00PM","03:00PM-04:00PM","04:00PM-05:00PM"};
			
			
			tsfTable=new JTable(data,head);
		    sp=new JScrollPane(tsfTable);
		    sp.setBounds(210,240,1000,300);
		    panel.add(sp);
		
		    panel.revalidate();
			panel.repaint();
			}
			else
			{
				
					JOptionPane.showMessageDialog(this,"Invaild Request");
				
			}
		
		}
   			
		else if(command.equals(exitBtn.getText()))	
		{
			System.exit(0);
		}				
		 else
				{
					JOptionPane.showMessageDialog(this,"Invaild Request");
				}
			
}
}
	
	
	
	
