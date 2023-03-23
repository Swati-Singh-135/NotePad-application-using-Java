import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.undo.UndoManager;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Color;
import java.awt.TextArea;

//import java.awt.event.*;
//import javax.swing.*;
//import java.awt.*;
//import java.io.*;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

class TextForm implements ActionListener
{
	String fileName;
	String fileAddress;
	JFrame frame;
	JMenuBar menuBar;
	JTextArea textArea;
	ImageIcon icon;
	JScrollPane scrollPane;
	//File menu
	JMenu menuFile,menuEdit,menuFormat,menuColor;
	JMenuItem Inew,Iopen,Isave,Isaveas,Iexist;
	//Edit menu
	JMenuItem Iundo,Iredo;
	//Format menu
	JMenu menuFont,menuFontSize;
	JMenuItem IfontArial,IfontCSMS,IfontTNR,FontSize8,FontSize12,FontSize16,FontSize20,FontSize24,FontSize28;
	
	Font arial,conicSansMS,timesNewRoman;
	String selectedFont;
	//Color menulist
	JMenuItem Icolor1,Icolor2,Icolor3;
	
	
	UndoManager um = new UndoManager();
	
	
	public TextForm()
	{
		frame = new JFrame("Type in Text");
		frame.setSize(600,600);
		frame.setLocationRelativeTo(null);
		//frame.getContentPane().setBackground(Color.CYAN);
		icon = new ImageIcon("D:/Java Codes/icon.jpg");
		frame.setIconImage(icon.getImage());
		//Toolkit t = Toolkit.getDefaultToolKit();
		//Dimension d = t.getScreenSize();
		//frame.setSize(d.width,d.height);
		frame.setLayout(null);
		menuBar = new JMenuBar();
		
		
		
		textArea = new JTextArea();
		textArea.getDocument().addUndoableEditListener(new UndoableEditListener()
		{
			public void undoableEditHappened(UndoableEditEvent e)
			{
				um.addEdit(e.getEdit());
				
			}
		});
		//scrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//scrollPane.setBorder(BorderFactory.createEmptyBorder());
		//frame.add(scrollPane);
		textArea.setBounds(0,0,1560,770);
		
		//Menu List
		menuFile = new JMenu("File");
		menuBar.add(menuFile);
		menuEdit = new JMenu("Edit");
		menuBar.add(menuEdit);
		menuFormat = new JMenu("Format");
		menuBar.add(menuFormat);
		menuColor = new JMenu("Theme");
		menuBar.add(menuColor);
		
		
		//MenuItem list menuFile
		Inew = new JMenuItem("New");	
		Iopen = new JMenuItem("Open");	
		Isave = new JMenuItem("Save");	
		Isaveas = new JMenuItem("SaveAs");
		Iexist = new JMenuItem("Exit");
		
		
		//MenuItem list menuEdit
		Iundo = new JMenuItem("Undo");
		Iredo = new JMenuItem("Redo");
		
		
		
		//menu list 
		menuFont = new JMenu("Font");
		menuFontSize = new JMenu("Font Size");
		//MenuItem list menuFont
		IfontArial = new JMenuItem("Plain");
		IfontCSMS = new JMenuItem("Bold");
		IfontTNR = new JMenuItem("Italic");
		//MenuItem list menuFontSize
		FontSize8 = new JMenuItem("8");
		FontSize12 = new JMenuItem("12");
		FontSize16 = new JMenuItem("16");
		FontSize20 = new JMenuItem("20");
		FontSize24 = new JMenuItem("24");
		FontSize28 = new JMenuItem("28");
		
		
		
		
		
		//MenuItem list menuColor
		Icolor1 = new JMenuItem("White");
		Icolor2 = new JMenuItem("Black");
		Icolor3 = new JMenuItem("Blue");
		
		
		
	
		
		
		//adding MenuItem in menuFile
		menuFile.add(Inew);
		menuFile.add(Iopen);
		menuFile.add(Isave);
		menuFile.add(Isaveas);
		menuFile.add(Iexist);
		
		
		// adding MenuItem in menuEdit
		menuEdit.add(Iundo);
		menuEdit.add(Iredo);
		
		
		
		//adding MenuItem in menuFormat
		//menuFormat.add(Iwrap);
		//adding menu in menuFormat
		menuFormat.add(menuFont);
		menuFormat.add(menuFontSize);
		//adding MenuItem in menuFont
		menuFont.add(IfontArial);
		menuFont.add(IfontCSMS);
		menuFont.add(IfontTNR);
		//adding MenuItem in menuFontSize
		menuFontSize.add(FontSize8);
		menuFontSize.add(FontSize12);
		menuFontSize.add(FontSize16);
		menuFontSize.add(FontSize20);
		menuFontSize.add(FontSize24);
		menuFontSize.add(FontSize28);
		
		
		
		
		//adding MenuItem in menuColor
		menuColor.add(Icolor1);
		menuColor.add(Icolor2);
		menuColor.add(Icolor3);
		
		
		
		
		frame.setJMenuBar(menuBar);
		//createTextarea();
		//frame.add(scrollPane);
		frame.add(textArea);
		selectedFont = "Arial";
		createFont(16);
		//wordWrap();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		Inew.addActionListener(this);
		Iopen.addActionListener(this);
		Isave.addActionListener(this);
		Isaveas.addActionListener(this);
		Iexist.addActionListener(this);
		
		
		//Iwrap.addActionListener(this);
		IfontArial.addActionListener(this);
		IfontCSMS.addActionListener(this);
		IfontTNR.addActionListener(this);
		FontSize8.addActionListener(this);
		FontSize12.addActionListener(this);
		FontSize16.addActionListener(this);
		FontSize20.addActionListener(this);
		FontSize24.addActionListener(this);
		FontSize28.addActionListener(this);
		
		Icolor1.addActionListener(this);
		Icolor2.addActionListener(this);
		Icolor3.addActionListener(this);
		
		Iundo.addActionListener(this);
		Iredo.addActionListener(this);
	}
	
	/*public void createTextarea()
	{
		textArea = new JTextArea();
		
		scrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		frame.add(scrollPane);
		//window.add(textArea);
	}*/
	
	public void actionPerformed(ActionEvent ev)
	{
		
		
		//code for file menu
		if(ev.getActionCommand().equals("New"))
		{
			textArea.setText("");
			frame.setTitle("New");
			
			fileName = null;
			fileAddress = null;
		}
		else if(ev.getActionCommand().equals("Open"))
		{
			FileDialog fd = new FileDialog(frame, "Open", FileDialog.LOAD);
			fd.setVisible(true);
			
			if(fd.getFile()!=null)
			{
				fileName = fd.getFile();
				fileAddress = fd.getDirectory();
				
				frame.setTitle(fileName);
			}
			try
			{
				BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName));
				
				textArea.setText("");
				
				String line = null;
				while((line = br.readLine())!=null)
				{
					textArea.append(line + "\n");
				}
				br.close();
			}
			catch(Exception e)
			{
				System.out.println("File not found!");
			}
		}
		else if(ev.getActionCommand().equals("Save"))
		{
			if(fileName==null)
			{
				if(ev.getActionCommand().equals("SaveAs"))
				{
					FileDialog fd = new FileDialog(frame, "Save", FileDialog.SAVE);
					fd.setVisible(true);
			
					if(fd.getFile()!=null)
					{
						fileName = fd.getFile();
						fileAddress = fd.getDirectory();
				
						frame.setTitle(fileName);
					}
					try
					{
						FileWriter fw = new FileWriter(fileAddress + fileName);
						fw.write(textArea.getText());
						fw.close();
					}
					catch(Exception e)
					{
						System.out.println("Something went wrong -.-");
					}
				}
			}
			try
			{
				FileWriter fw = new FileWriter(fileAddress + fileName);
				fw.write(textArea.getText());
				frame.setTitle(fileName);
				fw.close();
			}
			catch(Exception e)
			{
				System.out.println("Something went wrong -.-");
			}
		}
		else if(ev.getActionCommand().equals("SaveAs"))
		{
			FileDialog fd = new FileDialog(frame, "Save", FileDialog.SAVE);
			fd.setVisible(true);
			
			if(fd.getFile()!=null)
			{
				fileName = fd.getFile();
				fileAddress = fd.getDirectory();
				
				frame.setTitle(fileName);
			}
			try
			{
				FileWriter fw = new FileWriter(fileAddress + fileName);
				fw.write(textArea.getText());
				fw.close();
			}
			catch(Exception e)
			{
				System.out.println("Something went wrong -.-");
			}
		}
		else if(ev.getActionCommand().equals("Exit"))
		{
			System.exit(0);
		}
		
		
		
		
		else if(ev.getActionCommand().equals("8"))
		{
			createFont(8);
			
		}
		else if(ev.getActionCommand().equals("12"))
		{
			createFont(12);
			
		}
		else if(ev.getActionCommand().equals("16"))
		{
			createFont(16);
			
		}
		else if(ev.getActionCommand().equals("20"))
		{
			createFont(20);
			
		}
		else if(ev.getActionCommand().equals("24"))
		{
			createFont(24);
			
		}
		else if(ev.getActionCommand().equals("28"))
		{
			createFont(28);
			
		}
		else if(ev.getActionCommand().equals("Plain"))
		{
			setFont("Plain");
		}
		else if(ev.getActionCommand().equals("Bold"))
		{
			setFont("Bold");
		}
		else if(ev.getActionCommand().equals("Italic"))
		{
			setFont("Italic");
		}
		else if(ev.getActionCommand().equals("White"))
		{
			frame.getContentPane().setBackground(Color.white);
			textArea.setBackground(Color.white);
			textArea.setForeground(Color.black);
		}
		else if(ev.getActionCommand().equals("Black"))
		{
			frame.getContentPane().setBackground(Color.black);
			textArea.setBackground(Color.black);
			textArea.setForeground(Color.white);
		}
		else if(ev.getActionCommand().equals("Blue"))
		{
			frame.getContentPane().setBackground(Color.blue);
			textArea.setBackground(Color.blue);
			textArea.setForeground(Color.white);
		}
		
		else if(ev.getActionCommand().equals("Undo"))
		{
			um.undo();
		}
		else if(ev.getActionCommand().equals("Redo"))
		{
			um.redo();
		}
		
	}
	
	
	public void createFont(int fontSize)
	{
		arial = new Font("Plain", Font.PLAIN, fontSize);
		conicSansMS = new Font("Bold", Font.BOLD, fontSize);
		timesNewRoman = new Font("Italic", Font.ITALIC, fontSize);
		
		setFont(selectedFont);
	}
	
	public void setFont(String font)
	{
		selectedFont = font;
		
		switch(selectedFont)
		{
			case "Plain":
				textArea.setFont(arial);
				break;
			case "Bold":
				textArea.setFont(conicSansMS);
				break;
			case "Italic":
				textArea.setFont(timesNewRoman);
				break;
		}
	}
	
	
	
	public static void main(String ...a)
	{
		TextForm tf = new TextForm();
	}
}