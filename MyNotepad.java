package swingdemo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.JTextArea;
public class MyNotepad {

	public static void main(String args[]) {
		
		Notepad ob=new Notepad();
	}
}

class Notepad extends JFrame implements ActionListener{
	
	JFrame f;
	JTextArea ta;
	JMenuBar mb;
	JMenu file,edit,format,help;
	JMenuItem newi,openi,savei;
	JMenuItem cuti,copyi,pastei,selectalli;
	JMenuItem bg,fg;
	JMenuItem viewHelpi,sendfbi,about;
	Notepad()
	{
		f=new JFrame();
		ta=new JTextArea();
		ta.setFont(new Font("Arial",Font.PLAIN,16));
		mb=new JMenuBar();
		
		file=new JMenu("File");
		edit=new JMenu("Edit");
		format=new JMenu("Format");
		help=new JMenu("Help");
		
		//creating file menu items
		newi=new JMenuItem("New");
		openi=new JMenuItem("Open");
		savei=new JMenuItem("Save");
		
		//creating edit menu items
		cuti=new JMenuItem("Cut");
		copyi=new JMenuItem("Copy");
		pastei=new JMenuItem("Paste");
		selectalli=new JMenuItem("Select All");
		
		//creating format menu items
		bg=new JMenuItem("Set Background");
		fg=new JMenuItem("Set Foregorund");
	
		//creating help menu items
		viewHelpi=new JMenuItem("View Help");
		sendfbi=new JMenuItem("Send Feedback");
		about=new JMenuItem("About Notepad");
		
		//adding menus to menubar
		mb.add(file);
		mb.add(edit);
		mb.add(format);
		mb.add(help);
		
		mb.setBounds(4,5,996,30);
		ta.setBounds(4,40,996,996);
		
		//adding menu items to file menu
		file.add(newi);
		file.add(openi);
		file.add(savei);
		
		//adding menu items to edit menu
		edit.add(cuti);
		edit.add(copyi);
		edit.add(pastei);
		edit.add(selectalli);
		
		//adding menu items to format menu
		format.add(bg);
		format.add(fg);
	
		//adding menu items to help menu
		help.add(viewHelpi);
		help.add(sendfbi);
		help.add(about);
		
		//adding action listeners
		cuti.addActionListener(this);
		copyi.addActionListener(this);
		pastei.addActionListener(this);
		selectalli.addActionListener(this);
		
		bg.addActionListener(this);
		fg.addActionListener(this);
		
		newi.addActionListener(this);
		openi.addActionListener(this);
		savei.addActionListener(this);
		
		f.add(mb);
		f.add(ta);
		
		
		f.setTitle("My Notepad");
		f.getContentPane().setBackground(Color.white);
		f.setLayout(null);
		f.setVisible(true);
		f.setSize(1000,1000);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==cuti) {
			
			ta.cut();
		}
		else if(e.getSource()==copyi) {
			
			ta.copy();
		}
		else if(e.getSource()==pastei) {
					
			ta.paste();
		}
		else if(e.getSource()==selectalli) {
		
			ta.selectAll();
		}
		else if(e.getSource()==bg) {
			
			JColorChooser color_box=new JColorChooser();
			Color c=color_box.showDialog(f, "Select a color", Color.white);
			//change background color of textarea
			ta.setBackground(c);
		}
		else if(e.getSource()==fg) {
			
			JColorChooser color_box=new JColorChooser();
			Color c=color_box.showDialog(f, "Select a color", Color.white);
			//change background color of textarea
			ta.setForeground(c);
		}
		else if(e.getSource()==newi) {
			
			ta.setText("");
			ta.setBackground(Color.white);
		}
		else if(e.getSource()==openi) {
			
			JFileChooser filechooser=new JFileChooser();
			int option=filechooser.showOpenDialog(f);
			File f=filechooser.getSelectedFile();
			try {
				Scanner sc=new Scanner(f);
				while(sc.hasNextLine()) {
					ta.append("\n"+sc.nextLine());
				}
				sc.close();
			}
			catch(Exception ex) {
				
			}
		}
		else if(e.getSource()==savei) {
			
			JFileChooser filechooser=new JFileChooser();
			filechooser.setDialogTitle("Specify a file to save");
			int option=filechooser.showSaveDialog(f);
			if(option==JFileChooser.APPROVE_OPTION) {
				try {
					File f=filechooser.getSelectedFile();
					String text=ta.getText();
					FileWriter mywriter=new FileWriter(f);
					mywriter .write(text);
					mywriter.close();
					System.out.println("Success");
					
				}
				catch(Exception ex) {
					
				}
			}
			
		}
			
	}
}
