package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

import repository.*;
import entity.*;

public class FacultyFrame extends JFrame implements ActionListener
{
	private JPanel panel;
	private JLabel facultyIdLabel,facultyNameLabel,deptLabel,emailLabel,roomLabel,updateLabel,tsfLabel;
	private JTextField emailTF,roomTF,facultyIdTF,facultyNameTF,deptTF,tsfTF;
	private JCheckBox c1,c2,c3,c4,c5,c6,c7,c8,c9;
	private JPasswordField passTF;
	private JComboBox day;
	private JButton loadBtn,editBtn,updateBtn,logoutBtn,tsfUpdateBtn,viewTsfBtn;
	private JRadioButton r1,r11,r2,r22,r3,r33,r4,r44,r5,r55,r6,r66,r7,r77,r8,r88,r9,r99;
	private ButtonGroup bg1,bg2,bg3,bg4,bg5,bg6,bg7,bg8,bg9;
	private JTable tsfTable;
	private JScrollPane sp;
	private Font myFont;
	private Color myColor;
	
	private FacultyRepo fr;
	private TsfRepo tr;
	private Tsf t;
	private Faculty f;
	
	
	public FacultyFrame(LoginFrame lf,String userId)
	{
		super("AIUB Faculty counselling Hours ~ Faculty");
		this.setSize(1600,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setBackground(Color.WHITE);
		
		panel = new JPanel();
		panel.setLayout(null);
		//panel.setBackground(Color.WHITE);
		//myFont=new Font("Consolas",Font.BOLD,25);
		//myColor=new Color(63,81,181);
		
		tr=new TsfRepo();
		fr=new FacultyRepo();
		
		
		
		
		facultyIdLabel=new JLabel("Faculty Id :");
		facultyIdLabel.setBounds(20,170,120,30);
		panel.add(facultyIdLabel);
		
		facultyIdTF=new JTextField();
		facultyIdTF.setBounds(140,170,120,30);
		facultyIdTF.setText(userId);
		facultyIdTF.setEnabled(false);
		panel.add(facultyIdTF);
		
		
		
		facultyNameLabel=new JLabel("Name     :");
		facultyNameLabel.setBounds(20,240,120,30);
		panel.add(facultyNameLabel);
		
		facultyNameTF=new JTextField();
		facultyNameTF.setBounds(140,240,120,30);
		facultyNameTF.setEnabled(false);
		panel.add(facultyNameTF);
		
		
		
		deptLabel=new JLabel("Department :");
		deptLabel.setBounds(20,275,120,30);
		panel.add(deptLabel);
		
		deptTF=new JTextField();
		deptTF.setBounds(140,275,120,30);
		deptTF.setEnabled(false);
		panel.add(deptTF);
		
		
		emailLabel=new JLabel("Email  :");
		emailLabel.setBounds(20,310,80,30);
		panel.add(emailLabel);
		
		
		emailTF=new JTextField();
		emailTF.setBounds(140,310,120,30);
		emailTF.setEnabled(false);
		panel.add(emailTF);
		
		roomLabel=new JLabel("Room No :");
		roomLabel.setBounds(20,345,120,30);
		panel.add(roomLabel);
		
		roomTF=new JTextField();
		roomTF.setBounds(140,345,120,30);
		roomTF.setEnabled(false);
		panel.add(roomTF);
		
		loadBtn=new JButton("Refresh Info");
		loadBtn.setBounds(20,400,240,30);
		loadBtn.addActionListener(this);
		panel.add(loadBtn);
		
		editBtn=new JButton("Edit Info");
		editBtn.setBounds(20,435,240,30);
		editBtn.addActionListener(this);
		editBtn.setEnabled(false);
		panel.add(editBtn);
		
		
		updateBtn=new JButton("Update Info");
		updateBtn.setBounds(20,470,240,30);
		updateBtn.addActionListener(this);
		updateBtn.setEnabled(false);
		panel.add(updateBtn);
		
		
		logoutBtn=new JButton("Logout");
		logoutBtn.setBounds(20,505,240,30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		String week[]={"Select Day","Sunday","Monday","Tuesday","Wednesday","Thursday"};
		day=new JComboBox(week);
		day.setBounds(280,170,240,30);
		panel.add(day);
		
		c1=new JCheckBox("08:00AM -09:00AM");
		c1.setBounds(280,205,140,40);
		panel.add(c1);
		c1.addActionListener(this);
		
		r1=new JRadioButton("Counselling Hour ");
		r1.setBounds(420,205,140,20);
		panel.add(r1);
		
		r11=new JRadioButton("Class Hour ");
		r11.setBounds(420,225,140,20);
		panel.add(r11);
		
		bg1=new ButtonGroup();
		bg1.add(r1);
		bg1.add(r11);
		
		
		c2=new JCheckBox("09:00AM-10:00AM");
		c2.setBounds(280,255,140,40);
		panel.add(c2);
		
		r2=new JRadioButton("Counselling Hour ");
		r2.setBounds(420,255,140,20);
		panel.add(r2);
		
		r22=new JRadioButton("Class Hour ");
		r22.setBounds(420,275,140,20);
		panel.add(r22);
		
		bg2=new ButtonGroup();
		bg2.add(r2);
		bg2.add(r22);
		
		
		c3=new JCheckBox("10:00AM-11:00AM");
		c3.setBounds(280,305,140,40);
		panel.add(c3);
		
		r3=new JRadioButton("Counselling Hour ");
		r3.setBounds(420,305,140,20);
		panel.add(r3);
		
		r33=new JRadioButton("Class Hour ");
		r33.setBounds(420,325,140,20);
		panel.add(r33);
		
		bg3=new ButtonGroup();
		bg3.add(r3);
		bg3.add(r33);
		
		
		c4=new JCheckBox("11:00AM-12:00PM");
		c4.setBounds(280,355,140,40);
		panel.add(c4);
		
		r4=new JRadioButton("Counselling Hour ");
		r4.setBounds(420,355,140,20);
		panel.add(r4);
		
		r44=new JRadioButton("Class Hour ");
		r44.setBounds(420,375,140,20);
		panel.add(r44);
		
		bg4=new ButtonGroup();
		bg4.add(r4);
		bg4.add(r44);
		
		
		c5=new JCheckBox("12:00PM-01:00PM");
		c5.setBounds(280,405,140,40);
		panel.add(c5);
		
		r5=new JRadioButton("Counselling Hour ");
		r5.setBounds(420,405,140,20);
		panel.add(r5);
		
		r55=new JRadioButton("Class Hour ");
		r55.setBounds(420,425,140,20);
		panel.add(r55);
		
		bg5=new ButtonGroup();
		bg5.add(r5);
		bg5.add(r55);
		
		
		c6=new JCheckBox("01:00PM-02:00PM");
		c6.setBounds(280,455,140,40);
		panel.add(c6);
		
		r6=new JRadioButton("Counselling Hour ");
		r6.setBounds(420,455,140,20);
		panel.add(r6);
		
		r66=new JRadioButton("Class Hour ");
		r66.setBounds(420,475,140,20);
		panel.add(r66);
		
		bg6=new ButtonGroup();
		bg6.add(r6);
		bg6.add(r66);
		
		
		c7=new JCheckBox("02:00PM-03:00PM");
		c7.setBounds(280,505,140,40);
		panel.add(c7);
		
		r7=new JRadioButton("Counselling Hour ");
		r7.setBounds(420,505,140,20);
		panel.add(r7);
		
		r77=new JRadioButton("Class Hour ");
		r77.setBounds(420,525,140,20);
		panel.add(r77);
		
		bg7=new ButtonGroup();
		bg7.add(r7);
		bg7.add(r77);
		
		
		c8=new JCheckBox("03:00PM-04:00PM");
		c8.setBounds(280,555,140,40);
		panel.add(c8);
		
		r8=new JRadioButton("Counselling Hour ");
		r8.setBounds(420,555,140,20);
		panel.add(r8);
		
		r88=new JRadioButton("Class Hour ");
		r88.setBounds(420,575,140,20);
		panel.add(r88);
		
		bg8=new ButtonGroup();
		bg8.add(r8);
		bg8.add(r88);
		
		
		c9=new JCheckBox("04:00PM-05:00PM");
		c9.setBounds(280,605,140,40);
		panel.add(c9);
		
		r9=new JRadioButton("Counselling Hour ");
		r9.setBounds(420,605,140,20);
		panel.add(r9);
		
		r99=new JRadioButton("Class Hour ");
		r99.setBounds(420,625,140,20);
		panel.add(r99);
		
		bg9=new ButtonGroup();
		bg9.add(r9);
		bg9.add(r99);
		
		tsfUpdateBtn=new JButton("Update TSF");
		tsfUpdateBtn.setBounds(420,655,280,30);
		tsfUpdateBtn.addActionListener(this);
		panel.add(tsfUpdateBtn);
		
		viewTsfBtn=new JButton("View TSF");
		viewTsfBtn.setBounds(420,690,280,30);
		viewTsfBtn.addActionListener(this);
		panel.add(viewTsfBtn);
		
		String colName[]={"DAY","08:00AM-09:00AM","09:00AM-10:00AM","10:00AM-11:00AM","11:00AM-12:00PM","12:00PM-01:00PM,01:00PM-02:00PM,03:00PM-04:00PM,04:00PM-05:00PM"};
		String values[][]={{"","","","","","","","","","","","","","","","","","","","","",}};
		tsfTable=new JTable(values,colName);
		sp=new JScrollPane(tsfTable);
		sp.setBounds(560,170,1015,475);
		tsfTable.setEnabled(false);
		panel.add(sp);
	
	
		
		this.add(panel);	
	}

	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		
		
		if(command.equals(logoutBtn.getText()))
		{
			WelcomeFrame wf=new WelcomeFrame();
			wf.setVisible(true);
			this.setVisible(false);
		}
		else if(command.equals(editBtn.getText()))
		{
			facultyNameTF.setEnabled(true);
			deptTF.setEnabled(true);
			emailTF.setEnabled(true);
			roomTF.setEnabled(true);
			
			updateBtn.setEnabled(true);
			editBtn.setEnabled(false);
		}
		 
		else if(command.equals(updateBtn.getText()))
			{
			      
			      
			
				 Faculty f=new Faculty();
				if(!roomTF.getText().equals(" ")||!facultyNameTF.getText().equals(" ")||!deptTF.getText().equals(" ")||!emailTF.getText().equals(" "))
			    
				{  if(f!=null)
					{
						f.setFacultyId(facultyIdTF.getText());
					f.setName(facultyNameTF.getText());
				   f.setDepartment(deptTF.getText());
				   f.setEmail(emailTF.getText());
				   f.setRoomNo(roomTF.getText());
				   
				   fr.updateInDB(f);
			
			       JOptionPane.showMessageDialog(this, "Updated");
				  
				  facultyNameTF.setEnabled(false);
			      deptTF.setEnabled(false);
			      emailTF.setEnabled(false);
			      roomTF.setEnabled(false);

				  updateBtn.setEnabled(false);
			      editBtn.setEnabled(true);
				  }
					
				  else
				  {
					JOptionPane.showMessageDialog(this, "Invalid Request");
				  }
					
			    }
		        
			}
			else if(command.equals(tsfUpdateBtn.getText()))
			{
				String n=day.getSelectedItem().toString();
				if(!n.equals("Select Day"))
				{
					Tsf t=new Tsf();
					t.setFacultyId(facultyIdTF.getText());
					t.setDay(day.getSelectedItem().toString());
					if(c1.isSelected())
					{  
				    String type;
						if(r1.isSelected())
						{
							 type=r1.getText();	
						}
						else if(r11.isSelected())
						{
						  type=r11.getText();	
						}
						else
						{
							type="";
						}
						
						t.setT8(type);
						
					}
					else {t.setT8("");}
					if(c2.isSelected())
					{  
				    String type;
						if(r2.isSelected())
						{
							 type=r2.getText();
						}
						else if(r22.isSelected())
						{
						  type=r22.getText();	
						}
						else
						{
							type="";
						}
						t.setT9(type);
						
					}
					else{ t.setT9("");}
					if(c3.isSelected())
					{  
				    String type;
						if(r3.isSelected())
						{
							 type=r3.getText();
							
						}
						else if(r33.isSelected())
						{
						  type=r33.getText();
							
						}
						else
						{
							type="";
						}
						t.setT10(type);
						
					}
					else {t.setT10("");}
					
					if(c4.isSelected())
					{  
				    String type;
						if(r4.isSelected())
						{
							 type=r4.getText();
							
						}
						else if(r44.isSelected())
						{
						  type=r44.getText();
							
						}
						else
						{
							type="";
						}
						t.setT11(type);
						
					}
					else {t.setT11("");}
					
					if(c5.isSelected())
					{  
				    String type;
						if(r5.isSelected())
						{
							 type=r5.getText();
							
						}
						else if(r55.isSelected())
						{
						  type=r55.getText();
							
							
						}
						else
						{
							type="";
						}
						t.setT12(type);
						
					}
					else {t.setT12("");}
					
					if(c6.isSelected())
					{  
				    String type;
						if(r6.isSelected())
						{
							 type=r6.getText();
							
						}
						else if(r66.isSelected())
						{
						  type=r66.getText();
							
						}
						else
						{
							type="";
						}
						t.setT1(type);
					}
					else {t.setT1("");}
					if(c7.isSelected())
					{  
				    String type;
						if(r7.isSelected())
						{
							 type=r7.getText();
							
						}
						else if(r77.isSelected())
						{
						  type=r77.getText();
							
							
						}
						else
						{
							type="";
						}
						t.setT2(type);
						
					}
					else {t.setT2("");}
					if(c8.isSelected())
					{  
				    String type;
						if(r8.isSelected())
						{
							 type=r8.getText();
							
						}
						else if(r88.isSelected())
						{
						  type=r88.getText();
							
							
						}
						else
						{
							type="";
						}
						t.setT3(type);
						
					}
					else {t.setT3("");}
					if(c9.isSelected())
					{  
				    String type;
						if(r9.isSelected())
						{
							 type=r9.getText();
							
						}
						else if(r99.isSelected())
						{
						  type=r99.getText();
							
						}
						else
						{
							type="";
						}
						t.setT4(type);
						
					}
					else {t.setT4("");}
					
					tr.insertInDB(t);
					
					day.setSelectedIndex(0);
				
				bg1.clearSelection();
				bg2.clearSelection();
				bg3.clearSelection();
				bg4.clearSelection();
				bg5.clearSelection();
				bg6.clearSelection();
				bg7.clearSelection();
				bg8.clearSelection();
				bg9.clearSelection();
				
				c1.setSelected(false);
				c2.setSelected(false);
				c3.setSelected(false);
				c4.setSelected(false);
				c5.setSelected(false);
				c6.setSelected(false);
				c7.setSelected(false);
				c8.setSelected(false);
				c9.setSelected(false);
				}
				else 
				{
				JOptionPane.showMessageDialog(this, "Select Day and Try again.");
				}
			}	
			
			else if(command.equals(viewTsfBtn.getText()))
			{
				
				panel.remove(sp);
			    String data[][]=tr.getTsf(facultyIdTF.getText());
			    String head[]={"DAY","08:00AM-09:00AM","09:00AM-10:00AM","10:00AM-11:00AM","11:00AM-12:00PM","12:00PM-01:00PM","01:00PM-02:00PM","03:00PM-04:00PM","04:00PM-05:00PM"};
			
			
			tsfTable=new JTable(data,head);
		    sp=new JScrollPane(tsfTable);
		    sp.setBounds(560,170,1015,475);
		    panel.add(sp);
		
		    panel.revalidate();
			panel.repaint();
			}
			else if(command.equals(loadBtn.getText()))
			{
				Faculty f= fr.searchFaculty(facultyIdTF.getText());
				if(f!=null)
				{
					facultyNameTF.setText(f.getName());
					deptTF.setText(f.getDepartment());
					emailTF.setText(f.getEmail());
					roomTF.setText(f.getRoomNo());
					
					
					
					editBtn.setEnabled(true);
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Invalid Request!");
				}
			}
			
			else{}			
		}		
}
	
	
