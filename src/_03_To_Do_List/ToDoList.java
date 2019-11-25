package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener{
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 * 
	 * When add task is clicked:
	 * 		ask the user for a  task and save it to an array list
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list.
	 */
	
	JFrame jf;
	
	JPanel jp;
	
	JButton jb1;
	JButton jb2;
	JButton jb3;
	JButton jb4;
	JButton jb5;
	
	String lastSavedFileName = "src/_03_To_Do_List/test.txt";
	
	ArrayList<String> tasks;
	
	void InitFrame() {
		jf = new JFrame("hi");
		
		jp = new JPanel();
		
		jb1 = new JButton("add task");
		jb2 = new JButton("view tasks");
		jb3 = new JButton("remove task");
		jb4 = new JButton("save list");
		jb5 = new JButton("load list");
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
		jb5.addActionListener(this);

		jf.setVisible(true);
		
		jp.add(jb1);
		jp.add(jb2);
		jp.add(jb3);
		jp.add(jb4);
		jp.add(jb5);
		
		jf.add(jp);
		
		tasks = new ArrayList<String>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(lastSavedFileName));
			String s = "";
			while ((s = br.readLine()) != null ){
				tasks.add(s);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jb1) {
			tasks.add(JOptionPane.showInputDialog("Input a task"));
		}else if(e.getSource() == jb2) {
			String s = "";
			for(int i = 0; i < tasks.size(); i++) {
				s += "Task " + i + " = " + tasks.get(i) + "\n";
				System.out.println("gsdg");
			}
			JOptionPane.showMessageDialog(null, s);
		}else if(e.getSource() == jb3) {
			int i = Integer.parseInt(JOptionPane.showInputDialog("Which one should be removed?"));
			tasks.remove(i);
		}else if(e.getSource() == jb4) {
			try{
				FileWriter fw = new FileWriter("src/_03_To_Do_List/test.txt");
				String s = "";
				for(int i = 0; i < tasks.size(); i++) {
					s += tasks.get(i) + "\n";
				}
				fw.append(s);
				fw.close();
			}catch (IOException e1) {
				e1.printStackTrace();
			}
		}else if(e.getSource() == jb5) {
			lastSavedFileName = JOptionPane.showInputDialog("Where is the list");
			try {
				BufferedReader br = new BufferedReader(new FileReader(lastSavedFileName));
				String s = "";
				tasks.clear();
				while ((s = br.readLine()) != null ){
					tasks.add(s);
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 		
			
		}
	}
}
