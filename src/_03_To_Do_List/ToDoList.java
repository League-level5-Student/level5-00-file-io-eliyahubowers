package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
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
	
	void InitFrame() {
		jf = new JFrame("hi");
		
		jp = new JPanel();
		
		jb1 = new JButton("add task");
		jb2 = new JButton("view tasks");
		jb3 = new JButton("remove task");
		jb4 = new JButton("save list");
		jb5 = new JButton("load list");
		
		jb1.addActionListener(this);
		
		jf.setVisible(true);
		
		jp.add(jb1);
		jp.add(jb2);
		jp.add(jb3);
		jp.add(jb4);
		jp.add(jb5);
		
		jf.add(jp);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
