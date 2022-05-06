package Capstone;

import java.awt.Component;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Validation {
	static boolean flag = true;
	static Timer timer;
	static Timer timer2;

	/**
	 * 1. General Warning message
	 */
	public static void setWarningMsg(String f) {
		Toolkit.getDefaultToolkit().beep();
		JOptionPane opt = new JOptionPane(f, JOptionPane.WARNING_MESSAGE);
		JDialog dial = opt.createDialog("Warning!");
		dial.setAlwaysOnTop(true);
		dial.setVisible(true);
	} /* End of setWarningMsg method */

	/**
	 * 2. Alert message if the Password does not match the system Not added to
	 * program until more usernames and passwords are needed. General password
	 * validation check
	 */
	public boolean pwdValid(String password) {
		int min = 8;
		int max = 16;
		int digit = 0;
		int upCount = 0;
		int loCount = 0;
		String pass = "Peoples22";
		if (password != pass && password.length() >= min && password.length() <= max) {
			for (int i = 0; i < password.length(); i++) {
				char c = password.charAt(i);
				if (Character.isUpperCase(c)) {
					upCount++;
				}
				if (Character.isLowerCase(c)) {
					loCount++;
				}
				if (Character.isDigit(c)) {
					digit++;
				}
			}
			if (loCount >= 1 && upCount >= 1 && digit >= 1) {
				flag = true;
			} else if (password == pass) {
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(null,
						"You must change your password. Please create"
								+ " a unique password that is at least 8 characters long with at least one "
								+ "uppercase letter, one lowercase letter, & one number");
				/* Open panel for password change */

			} else if (digit == 0 && loCount == 0 && upCount > 1) {
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(null,
						"Missing Lowercase letters & Digit\n"
								+ "You need at least one lowercase letter\nYou need at least one digit",
						"Password Error", JOptionPane.ERROR_MESSAGE);
				flag = false;
			} else if (digit == 0 && loCount > 0 && upCount == 0) {
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(null,
						"Missing Uppercase letters & Digit\n"
								+ "You need at least one uppercase letter\nYou need at least one digit",
						"Password Error", JOptionPane.ERROR_MESSAGE);
				flag = false;
			} else if (digit > 0 && loCount == 0 && upCount == 0) {
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(null,
						"Missing Lowercase & Uppercase letters\n"
								+ "You need at least one lowercase and uppercase letter",
						"Password Error", JOptionPane.ERROR_MESSAGE);
				flag = false;
			} else if (digit == 0 && loCount == 0 && upCount == 0) {
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(null, "Missing Lowercase & Uppercase letters & Digit\n"
						+ "You need at least one lowercase and uppercase letter\nYou need at least " + "one digit",
						"Password Error", JOptionPane.ERROR_MESSAGE);
				flag = false;
			} else if (digit == 0 && loCount > 0 && upCount > 0) {
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(null, "Missing Digit\nYou need at least one digit", "Password Error",
						JOptionPane.ERROR_MESSAGE);
				flag = false;
			} else if (digit > 0 && loCount > 0 && upCount == 0) {
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(null,
						"Missing Uppercase letter\nYou need at least " + "one uppercase letter", "Password Error",
						JOptionPane.ERROR_MESSAGE);
				flag = false;
			} else if (digit > 0 && loCount == 0 && upCount > 0) {
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(null,
						"Missing Lowercase letter\nYou need at least " + "one lowercase letter", "Password Error",
						JOptionPane.ERROR_MESSAGE);
				flag = false;
			} else if (digit == 0 && loCount == 0 && upCount > 0) {
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(null, "Missing Lowercase letter & Digit\n"
						+ "You need at least one lowercase letter\n" + "You need at least one digit", "Password Error",
						JOptionPane.ERROR_MESSAGE);
				flag = false;
			} else if (digit == 0 && loCount > 0 && upCount == 0) {
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(null,
						"Missing Uppercase letter & Digit\n"
								+ "You need at least one uppercase letter\nYou need at least one digit",
						"Password Error", JOptionPane.ERROR_MESSAGE);
				flag = false;
			}
		} else if (password.length() < min) {
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null,
					"Length of Password too Short\n"
							+ "You need at least one lowercase & uppercase\nletters & at least one digit",
					"Password Error", JOptionPane.ERROR_MESSAGE);
			flag = false;
		} else if (password.length() >= max) {
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null,
					"Password is too long\nLimit is " + max + " characters\n"
							+ "You need at least one lowercase & uppercase\nletters & at least one digit",
					"Password Error", JOptionPane.ERROR_MESSAGE);
			flag = false;
		}
		return flag;
	}

	/**
	 * 3. Timer function to return program to start screen if user does not continue
	 * entering information
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	public static void TimerStart(JPanel frame) {
		ActionListener timeListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window win = SwingUtilities.getWindowAncestor((Component) frame);
				int result = JOptionPane.showConfirmDialog(frame, "Do you need more time?", "Check-in System",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (result == JOptionPane.YES_OPTION) {
					timer.start();

				} else if (result == JOptionPane.NO_OPTION) {
					timer.stop();
					win.dispose();
					Capstone.model.clear();
					new Capstone();
					Capstone.getFrame().setVisible(true);
				} else {
					timer.stop();
					win.dispose();
					Capstone.model.clear();
					new Capstone();
					Capstone.getFrame().setVisible(true);
				}

			}
		};

		/**
		 * Timer is stopped, arraylist is cleared and tool returns to start screen
		 */
		ActionListener listener2 = new ActionListener() {
			public void actionPerformed(ActionEvent e2) {
				Window win = SwingUtilities.getWindowAncestor((Component) frame);
				timer.stop();
				Capstone.model.clear();
				win.dispose();
				new Capstone();
				Capstone.getFrame().setVisible(true);
			}
		};

		timer = new Timer(60000, timeListener);
		timer.setRepeats(false);
		timer.start();
	}

	/**
	 * 4. checks that letters were entered
	 * 
	 */
	public static boolean chkNum(String num) {
		if (flag) {
			try {
				@SuppressWarnings("unused")
				int a = Integer.parseInt(num);
			} catch (NumberFormatException nfe) {
				JOptionPane.showConfirmDialog(null, "Only letters should be used on this form", num,
						JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE);
				flag = false;
			}
		}
		return flag;
	}

}
