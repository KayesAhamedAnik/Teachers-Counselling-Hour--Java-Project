package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class AdminFrame extends JFrame implements ActionListener
{
	private JLabel titleLabel,titleLabel2,imageLabel,facultyIdLabel,facultyNameLabel,deptLabel;
	private JTextField facultyIdTF, facultyNameTF,deptTF;
	private JButton searchBtn, insertBtn, updateBtn, deleteBtn, refreshBtn, getAllBtn,logoutBtn;
	private JPanel panel;
	private JTable facultyTable;
	private JScrollPane sp;
	private ImageIcon img;
	private Color myColor;
	private Font myFont;
	
	private User user;
	private AdminRepo AR,ar;
	private UserRepo ur;
	private Faculty F;
	
	
	public AdminFrame(User user)
	{
		super("AIUB Faculty Counselling Hours ~ Admin");
		this.setSize(1000,600);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.user = user;
		
		ar = new AdminRepo();
		ur = new UserRepo();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		myFont=new Font("Consolas",Font.BOLD,25);
		myColor=new Color(63,81,181);
		
		img=new ImageIcon("aiub.png");
		imageLabel=new JLabel(img);
		imageLabel.setBounds(350,5,160,161);
		panel.add(imageLabel);
		
		titleLabel=new JLabel("<html>AMERICAN<br>INTERNATIONAL<br>UNIVERSITY-<br>BANGLADESH");
		titleLabel.setBounds(530,5,400,140);
		titleLabel.setFont(myFont);
		titleLabel.setForeground(myColor);
		panel.add(titleLabel);
		
		titleLabel2=new JLabel("where leaders are created");
		titleLabel2.setBounds(530,140,400,20);
		panel.add(titleLabel2);
		
		
		
		
		
		facultyIdLabel=new JLabel("Faculty Id :");
		facultyIdLabel.setBounds(20,200,120,30);
		panel.add(facultyIdLabel);
		
		facultyIdTF=new JTextField();
		facultyIdTF.setBounds(140,200,120,30);
		panel.add(facultyIdTF);
		
		
		
		facultyNameLabel=new JLabel("Name       :");
		facultyNameLabel.setBounds(20,240,120,30);
		panel.add(facultyNameLabel);
		
		facultyNameTF=new JTextField();
		facultyNameTF.setBounds(140,240,120,30);
		panel.add(facultyNameTF);
		
		
		
		deptLabel=new JLabel("Department :");
		deptLabel.setBounds(20,280,120,30);
		panel.add(deptLabel);
		
		deptTF=new JTextField();
		deptTF.setBounds(140,280,120,30);
		panel.add(deptTF);
		
		
		
		insertBtn=new JButton("insert");
		insertBtn.setBounds(20,380,80,30);
		insertBtn.addActionListener(this);
		panel.add(insertBtn);
		
		updateBtn=new JButton("Update");
		updateBtn.setBounds(120,380,80,30);
		updateBtn.addActionListener(this);
		updateBtn.setEnabled(false);
		panel.add(updateBtn);
		
		deleteBtn=new JButton("Delete");
		deleteBtn.setBounds(220,380,80,30);
		deleteBtn.addActionListener(this);
		deleteBtn.setEnabled(false);
		panel.add(deleteBtn);
		
		searchBtn=new JButton("Search");
		searchBtn.setBounds(20,420,130,30);
		searchBtn.addActionListener(this);
		panel.add(searchBtn);
		
		getAllBtn=new JButton("Get all User");
		getAllBtn.setBounds(170,420,130,30);
		getAllBtn.addActionListener(this);
		panel.add(getAllBtn);
		
		
		refreshBtn=new JButton("Refresh");
		refreshBtn.setBounds(20,460,280,30);
		refreshBtn.addActionListener(this);
		panel.add(refreshBtn);
		
		logoutBtn=new JButton("Logout");
		logoutBtn.setBounds(20,500,280,30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		
		
		String data[][] = {{"", "", "", ""}};
		String head[] = {"Faculty Id", "Name", "Department"};
		facultyTable=new JTable(data,head);
		sp=new JScrollPane(facultyTable);
		sp.setBounds(320,180,600,340);
		facultyTable.setEnabled(false);
		panel.add(sp);
	
		
		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(logoutBtn.getText()))
		{
			WelcomeFrame wf=new WelcomeFrame();
			wf.setVisible(true);
			this.setVisible(false);
		}
		else if(command.equals(insertBtn.getText()))
		{
			
			if(facultyIdTF.getText().equals("")||facultyNameTF.getText().equals("")||deptTF.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this, "<html>Invalid request !<br>Fill all the fields<html>");
			}
			else{
			      
			    
					 Faculty f= new Faculty();
			        User u = new User();
			        Random rd = new Random();
			        int x = rd.nextInt(999999)+100000;
			 
			        f.setFacultyId(facultyIdTF.getText());
			        f.setName(facultyNameTF.getText());
                    f.setDepartment(deptTF.getText());
			
			        u.setUserId(facultyIdTF.getText());
			        u.setPassword(x+"");
			
			        ar.insertInDB(f);
			        ur.insertUser(u);
			        
			        JOptionPane.showMessageDialog(this, "Inserted, Id: "+facultyIdTF.getText()+"and Password: "+x);
			
			       facultyIdTF.setText("");
			       facultyNameTF.setText("");
			       deptTF.setText("");
				   
				   searchBtn.setEnabled(true);
			       insertBtn.setEnabled(true);
			       updateBtn.setEnabled(false);
			       deleteBtn.setEnabled(false);
			       refreshBtn.setEnabled(false);
					
				} 
			}				
		else if(command.equals(refreshBtn.getText()))
		{
			facultyIdTF.setText("");
			facultyNameTF.setText("");
			deptTF.setText("");
			facultyTable.setEnabled(false);
			
			
			facultyIdTF.setEnabled(true);
			searchBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
		}
		else if(command.equals(updateBtn.getText()))
		{
			if(facultyIdTF.getText().equals("")||facultyNameTF.getText().equals("")||deptTF.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this, "<html>Invalid request !<br>Fill all the fields<html>");
			}
			else{
			Faculty f = new Faculty();
			
			f.setFacultyId(facultyIdTF.getText());
			f.setName(facultyNameTF.getText());
			f.setDepartment(deptTF.getText());
			
			ar.updateInDB(f);
			
			JOptionPane.showMessageDialog(this, "Updated");
			
			facultyIdTF.setEnabled(true);
			facultyNameTF.setEnabled(true);
			deptTF.setEnabled(true);
			
			
			searchBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
			facultyIdTF.setText("");
			facultyNameTF.setText("");
			deptTF.setText("");
			
			}
		}
		else if(command.equals(deleteBtn.getText()))
		{
			if(facultyIdTF.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this, "Please Enter Faculty Id");
			}
			else{
			
			ar.deleteFromDB(facultyIdTF.getText());
			ur.deleteUser(facultyIdTF.getText());
			
			JOptionPane.showMessageDialog(this,"Deleted");
			
			facultyIdTF.setText("");
			facultyNameTF.setText("");
			deptTF.setText("");
			
			facultyIdTF.setEnabled(true);
			facultyNameTF.setEnabled(true);
			deptTF.setEnabled(true);
			
			searchBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
			}
			
		}
		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = ar.getAllFaculty();
			String head[] = {"Id", "Name", "Department"};
			
			panel.remove(sp);
			
			facultyTable = new JTable(data,head);
			facultyTable.setEnabled(false);
			sp = new JScrollPane(facultyTable);
			sp.setBounds(320,180,600,340);
			panel.add(sp);
			
			panel.revalidate();
			panel.repaint();
			
			facultyIdTF.setText("");
			facultyNameTF.setText("");
			deptTF.setText("");
			
		}
		else if(command.equals(searchBtn.getText()))
		{
			
			if(!facultyIdTF.getText().equals("") || !facultyIdTF.getText().equals(null))
			{
				Faculty f= ar.searchFaculty(facultyIdTF.getText());
				if(f!= null)
				{
					facultyNameTF.setText(f.getName());
					deptTF.setText(f.getDepartment());
					
				updateBtn.setEnabled(true);
			    deleteBtn.setEnabled(true);
				refreshBtn.setEnabled(true);
				insertBtn.setEnabled(false);
				searchBtn.setEnabled(false);
				
				facultyIdTF.setEnabled(false);
			    facultyNameTF.setEnabled(true);
			    deptTF.setEnabled(true);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild ID");
				}
				
			}
		}
		else{}
		
		
	}
	}
