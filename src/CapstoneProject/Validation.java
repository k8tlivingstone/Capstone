package CapstoneProject;

import java.awt.Checkbox;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/*This class will hold all validation checks for the application */
public class Validation {
    static boolean flag = true;
    static Timer timer;
    static Timer timer2;

    /**
     *  1. General Warning message
     */
    public static void setWarningMsg(String f) {
    	Toolkit.getDefaultToolkit().beep();
    	JOptionPane opt = new JOptionPane(f,JOptionPane.WARNING_MESSAGE);
    	JDialog dial = opt.createDialog("Warning!");
    	dial.setAlwaysOnTop(true);
    	dial.setVisible(true);
    } /*End of setWarningMsg method*/
    
    /**
     *  2. Alert message if an unexpected error is encountered 
     */
    public void unexpectedError(String Error) {
    	Toolkit.getDefaultToolkit().beep();
    	JOptionPane.showMessageDialog(null, "Unexpected Error\nAn unexpected error has been encountered. "
    			+ "Please contact the administrator"+ Error,"Warning!", JOptionPane.WARNING_MESSAGE);
    }
    
    /**
     *  3. Alert message if the Password does not match the system
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
                } else if(password == pass){
                	Toolkit.getDefaultToolkit().beep();
                	JOptionPane.showMessageDialog(null, "You must change your password. Please create"
                			+ " a unique password that is at least 8 characters long with at least one "
                			+ "uppercase letter, one lowercase letter, & one number");
                	/*Open panel for password change*/
                	
                } else if (digit == 0 && loCount == 0 && upCount > 1) {
                	Toolkit.getDefaultToolkit().beep();
                	JOptionPane.showMessageDialog(null, "Missing Lowercase letters & Digit\n"
                			+ "You need at least one lowercase letter\nYou need at least one digit",
                			"Password Error", JOptionPane.ERROR_MESSAGE);
                    flag = false;
                } else if (digit == 0 && loCount > 0 && upCount == 0) {
                	Toolkit.getDefaultToolkit().beep();
                	JOptionPane.showMessageDialog(null, "Missing Uppercase letters & Digit\n"
                			+ "You need at least one uppercase letter\nYou need at least one digit",
                			"Password Error", JOptionPane.ERROR_MESSAGE);
                    flag = false;
                } else if (digit > 0 && loCount == 0 && upCount == 0) {
                	Toolkit.getDefaultToolkit().beep();
                	JOptionPane.showMessageDialog(null, "Missing Lowercase & Uppercase letters\n"
                			+ "You need at least one lowercase and uppercase letter", "Password Error",
                			JOptionPane.ERROR_MESSAGE);
                    flag = false;
                } else if (digit == 0 && loCount == 0 && upCount == 0) {
                	Toolkit.getDefaultToolkit().beep();
                	JOptionPane.showMessageDialog(null, "Missing Lowercase & Uppercase letters & Digit\n"
                			+ "You need at least one lowercase and uppercase letter\nYou need at least "
                			+ "one digit", "Password Error", JOptionPane.ERROR_MESSAGE);
                    flag = false;
                } else if (digit == 0 && loCount > 0 && upCount > 0) {
                	Toolkit.getDefaultToolkit().beep();
                	JOptionPane.showMessageDialog(null, "Missing Digit\nYou need at least one digit",
                			"Password Error", JOptionPane.ERROR_MESSAGE);
                    flag = false;
                } else if (digit > 0 && loCount > 0 && upCount == 0) {
                	Toolkit.getDefaultToolkit().beep();
                	JOptionPane.showMessageDialog(null, "Missing Uppercase letter\nYou need at least "
                			+ "one uppercase letter", "Password Error", JOptionPane.ERROR_MESSAGE);
                    flag = false;
                } else if (digit > 0 && loCount == 0 && upCount > 0) {
                	Toolkit.getDefaultToolkit().beep();
                	JOptionPane.showMessageDialog(null, "Missing Lowercase letter\nYou need at least "
                			+ "one lowercase letter", "Password Error", JOptionPane.ERROR_MESSAGE);
                    flag = false;
                } else if (digit == 0 && loCount == 0 && upCount > 0) {
                	Toolkit.getDefaultToolkit().beep();
                	JOptionPane.showMessageDialog(null, "Missing Lowercase letter & Digit\n"
                			+ "You need at least one lowercase letter\n"
                			+ "You need at least one digit", "Password Error", JOptionPane.ERROR_MESSAGE);
                    flag = false;
                } else if (digit == 0 && loCount > 0 && upCount == 0) {
                	Toolkit.getDefaultToolkit().beep();
                	JOptionPane.showMessageDialog(null, "Missing Uppercase letter & Digit\n"
                			+ "You need at least one uppercase letter\nYou need at least one digit",
                			"Password Error", JOptionPane.ERROR_MESSAGE);
                    flag = false;
                } 
            } else if (password.length() < min) {
            	Toolkit.getDefaultToolkit().beep();
            	JOptionPane.showMessageDialog(null, "Length of Password too Short\n"
            			+ "You need at least one lowercase & uppercase\nletters & at least one digit",
            			"Password Error", JOptionPane.ERROR_MESSAGE);
                flag = false;
            } else if (password.length() >= max) {
            	Toolkit.getDefaultToolkit().beep();
            	JOptionPane.showMessageDialog(null, "Password is too long\nLimit is " + max + " characters\n"
            			+ "You need at least one lowercase & uppercase\nletters & at least one digit",
            			"Password Error", JOptionPane.ERROR_MESSAGE);
                flag = false;
            }
            return flag;
        }
    
    /**
     *  4. Dialog when user enters a username that does not exist 
     */
    public void userNamenotExist() {
    	Toolkit.getDefaultToolkit().beep();
    	JOptionPane.showMessageDialog(null, "Oops, the username is incorrect. Please try again.",
    			"Warning!", JOptionPane.WARNING_MESSAGE);
    }
    
    /**
     *  5. Dialog when user name or password is incorrect 
     */
    public void incorrectLoginInfo() {
    	Toolkit.getDefaultToolkit().beep();
    	JOptionPane.showMessageDialog(null, "\"incorrect Login Info\\nUser or password is incorect\"",
    			"Warning!", JOptionPane.WARNING_MESSAGE);
    }    
    
    /**
	 * 6. Timer function to return program to start screen if user
	 * does not continue entering information
     * @return 
	 */
	public void TimerStart(JFrame frame) {
		ActionListener timeListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(frame,"Do you need more time?", "Check-in System",
			               JOptionPane.YES_NO_OPTION,
			               JOptionPane.QUESTION_MESSAGE);
			            if(result == JOptionPane.YES_OPTION){
			        		timer.start();
			              
			            }else if (result == JOptionPane.NO_OPTION){
			            	frame.dispose();
			                CapstoneProject cap = new CapstoneProject();
//			                cap.setVisible(true);
			            }else {
			            	frame.dispose();
			                CapstoneProject cap2 = new CapstoneProject();
			            }
			}
		};
		
		ActionListener listener2 = new ActionListener() {
			public void actionPerformed(ActionEvent e2) {
				frame.dispose();
                CapstoneProject cap3 = new CapstoneProject();
			}
		};
	
		timer = new Timer(4500, timeListener);
		timer.setRepeats(false);
		timer.start();
	}
	
	/**
	 * 7. checks that letters were entered 
	 * 
	 */
	public static boolean chkNum(String num) {
//		if("0".equals(num)) {
//			JOptionPane.showConfirmDialog(null,"Only letters should be used on this form",
//		               num, JOptionPane.OK_OPTION,
//		               JOptionPane.ERROR_MESSAGE);
//			flag = false;
//		} else {
//			flag = true;
//		}
		if (flag) {
			try {
				int a = Integer.parseInt(num);
			} catch (NumberFormatException nfe) {
				JOptionPane.showConfirmDialog(null,"Only letters should be used on this form",
			               num, JOptionPane.OK_OPTION,
			               JOptionPane.ERROR_MESSAGE);
				flag = false;
			}
		}
		return flag;
	}
	
    
} /*End of Validation class*/