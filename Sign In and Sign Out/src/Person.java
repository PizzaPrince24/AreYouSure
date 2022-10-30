import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Person {
	
	private String name;
	private long timeIn;
	private long timeOut;
	private JButton button;
	private boolean hasSignedOut = false;
	
	public Person(String name) {
		button = new JButton(name);
		this.name = name;
		button.setLocation(300,300);
		button.setSize(150,150);
		button.setFont(new Font("arial", 0, 30));
		timeIn = 0;
		timeOut = 0;
	}
	
	
	public JButton getButton() {
		return button;
	}
	
	public String getName() {
		return name;
	}
	
	public void signIn() {
		timeIn = System.currentTimeMillis();
	}
	
	public void signOut() {
		timeOut = System.currentTimeMillis();
	}
	
	public int getHours() {
		if(timeIn == 0 || timeOut == 0) {
			return 0;
		}
		return (int)((timeOut - timeIn) / 3600000);
	}
	
	public int getMinutes() {
		if(timeIn == 0 || timeOut == 0) {
			return 0;
		}
		return (int)(((timeOut - timeIn) / 60000) % 60);
	}
	
	public boolean hasSignedOut() {
		return hasSignedOut;
	}
	
	public void changeSignOut() {
		hasSignedOut = true;
	}
}
