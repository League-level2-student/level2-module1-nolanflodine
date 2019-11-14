package intro_to_array_lists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GuestBook implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button = new JButton("Add Name");
	JButton button2 = new JButton("View Name");
	ArrayList<String> names = new ArrayList<String>();
	
	public static void main(String[] args) {
	GuestBook g = new GuestBook();
	g.meth();
		
	}
	// Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names". 
		void meth(){
		button.addActionListener(this);
		button2.addActionListener(this);
		panel.add(button);
		panel.add(button2);
		frame.add(panel);
		frame.pack();
		}
	// When the add name button is clicked, display an input dialog that asks the user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
		if(arg0.getSource().equals(button)) {
	     String namess=JOptionPane.showInputDialog("Enter a name");
	     names.add(namess);
	  
		}
		if(arg0.getSource().equals(button2)) {
			for (int i = 0; i < names.length; i++) {
				String s = names[i];
			}
		}
			JOptionPane.showMessageDialog(null, s);
		}
}
