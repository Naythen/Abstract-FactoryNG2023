package interfataAplicatie;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.Box;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import lethalCompany.LethalCompany;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import java.awt.Font;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import tiers.*; 

public class ShopWindow {

	private JFrame frame;
	protected int dimensiuneFereastra =300;
	protected int[] ratie= {4,3};
	
	protected Color screenColor = new Color(0x050705);
	protected ImageIcon borderImagePath= new ImageIcon("\\imageResorce\\border");

	private JTextField txtLogIn;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JPanel panel_login;
	private JPanel panel_item;
	private JTextArea txtrRequestedToOrder;
	private double money = 99999d;
	private double toSpend = 0;
	private String username =new String("admin");
	private String password =new String("admin");
	
	
	private String typeItemStore;
	private ActionListener shopButtons = new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		typeItemStore = ((JButton) e.getSource()).getName();
    		System.out.println(typeItemStore);
    		panel_item.setVisible(false);
    		panel_tier.setVisible(true);
    		panel_money.setVisible(true);
    	}
    };
    private String tierItemStore;
    private ActionListener tierButtons = new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		tierItemStore = ((JButton) e.getSource()).getName();
    		System.out.println(tierItemStore);
    		panel_tier.setVisible(false);
    		panel_confirm.setVisible(true);
    		panel_money.setVisible(false);
    		try {
				prepConfirmationPanel();
			} catch (InstantiationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NoSuchMethodException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SecurityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	}
    };
    private ActionListener meniuButtons = new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		System.out.println( ((JButton) e.getSource()).getName());
    		if(((JButton) e.getSource()).getName().equals("store")){
    			panel_meniu.setVisible(false);
    			BackToTheLoby.setVisible(true);
    			panel_item.setVisible(true);
    		}
    		if(((JButton) e.getSource()).getName().equals("out")){
    			panel_meniu.setVisible(false);
    			panel_login.setVisible(true);
    			panel_money.setVisible(false);
    		}
    	}
    };
	
	private KeyListener EnterSetup = new KeyListener() {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if(panel_login.isVisible()) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					verifyAdminAccount();
				}
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
		
		}
	};
	private JTextField txtStore;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JPanel panel_tier;
	private JTextField txtTier;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JPanel panel_meniu;
	private JButton btnNewButton_6;
	private JButton btnNewButton_7;
	private JButton BackToTheLoby;
	private JPanel panel_confirm;
	private JButton btnNewButton_10;
	private JPanel panel_money;
	private JTextField textField;
	private JTextField txtMoney;
	private JTextField txtLethalCompany;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopWindow window = new ShopWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	void prepConfirmationPanel() throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException {
		String tierClass = "tiers."+tierItemStore+"Tier";//ProTier
		String create = "create"+typeItemStore;//createWeapon
		toSpend=0;
		
		try {
	        Class<?> tierItemClass = Class.forName(tierClass); // Pro class
	        @SuppressWarnings("deprecation")
			LethalCompany tier = (LethalCompany) tierItemClass.newInstance();
	        
	        java.lang.reflect.Method createMethod = tierItemClass.getMethod(create);
	        Object myItemObject = createMethod.invoke(tier);
	        
	        java.lang.reflect.Method assembleMethod = myItemObject.getClass().getMethod("assemble");
	        java.lang.reflect.Method costMethod = myItemObject.getClass().getMethod("getCost");
	        
	        assembleMethod.invoke(myItemObject);
	        toSpend = (double) costMethod.invoke(myItemObject);
	        		
	    } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
	        // Handle exceptions appropriately
	        e.printStackTrace();
	    }
		String s = " Requested item order:\n "+tierItemStore+" "+typeItemStore+"\n cost: "+ toSpend;
		txtrRequestedToOrder.setText(s);
	}
	void verifyAdminAccount() {
		String getUsername = usernameField.getText();
		char[] getPassword = passwordField.getPassword();

		// Convert the char array to a string for comparison
		String enteredPasswordString = new String(getPassword);

		System.out.println(getUsername + " " + enteredPasswordString);

		boolean usr = getUsername.equals(username);
		boolean psw = enteredPasswordString.equals(password);

		System.out.println(usr + " " + psw);

		if (usr && psw) {
		    panel_login.setVisible(false);
		    panel_meniu.setVisible(true);
		    usernameField.setText(null);
		    passwordField.setText(null);
		    panel_money.setVisible(true);
		    meniuShop();
		}

	}
	void setLoginPanel() {
	}
	void updateMoney() {
    	textField.setText(Double.toString(money));
    }
	
	void setBorderImage() {
		Image originalImage = new ImageIcon(ShopWindow.class.getResource("/resorce/border.png")).getImage();
		int newWidth = frame.getWidth()-10;
        int newHeight = frame.getHeight()-40;
        Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        borderImagePath= new ImageIcon(scaledImage);
        
        panel_item = new JPanel();
        panel_item.setVisible(false);
        
        panel_confirm = new JPanel();
        panel_confirm.setVisible(false);
        
        BackToTheLoby = new JButton("BACK");
        BackToTheLoby.setName("");
        BackToTheLoby.setForeground(Color.GREEN);
        BackToTheLoby.setFont(new Font("Monospaced", Font.BOLD, 24));
        BackToTheLoby.setFocusable(false);
        BackToTheLoby.setFocusPainted(false);
        BackToTheLoby.setBorder(null);
        BackToTheLoby.setBackground(new Color(5, 16, 5));
        BackToTheLoby.setBounds(152, 327, 317, 48);
        BackToTheLoby.setVisible(false);
        BackToTheLoby.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		typeItemStore="";
        		tierItemStore="";
        		panel_item.setVisible(false);
        		panel_tier.setVisible(false);
        		BackToTheLoby.setVisible(false);
        		panel_meniu.setVisible(true);
        		panel_confirm.setVisible(false);
        		panel_money.setVisible(true);
        	}
        });
        BackToTheLoby.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        
        panel_meniu = new JPanel();
        panel_meniu.setVisible(false);
        
        panel_login = new JPanel();
        panel_login.setForeground(new Color(128, 255, 255));
        panel_login.setBackground(new Color(5, 16, 5));
        panel_login.setBounds(52, 38, 519, 337);
        frame.getContentPane().add(panel_login);
        panel_login.setLayout(null);
        
        txtLogIn = new JTextField();
        txtLogIn.setEditable(false);
        txtLogIn.setBorder(null);
        txtLogIn.setHorizontalAlignment(SwingConstants.CENTER);
        txtLogIn.setText("Log In");
        txtLogIn.setForeground(new Color(0, 255, 0));
        txtLogIn.setFont(new Font("Monospaced", Font.BOLD, 48));
        txtLogIn.setBackground(new Color(5, 16, 5));
        txtLogIn.setBounds(10, 37, 499, 76);
        panel_login.add(txtLogIn);
        txtLogIn.setColumns(10);
        
        usernameField = new JTextField();
        usernameField.addKeyListener(EnterSetup);
        usernameField.setBorder(null);
        usernameField.setForeground(new Color(0, 255, 0));
        usernameField.setFont(new Font("Monospaced", Font.PLAIN, 24));
        usernameField.setBackground(new Color(5, 16, 5));
        usernameField.setBounds(249, 147, 228, 48);
        panel_login.add(usernameField);
        usernameField.setColumns(10);
        
        passwordField = new JPasswordField();
        passwordField.addKeyListener(EnterSetup);
        passwordField.setForeground(new Color(0, 255, 0));
        passwordField.setBorder(null);
        passwordField.setFont(new Font("Monospaced", Font.PLAIN, 24));
        passwordField.setBounds(249, 205, 228, 48);
        panel_login.add(passwordField);
        passwordField.setBackground(new Color(5, 16, 5));
        
        txtUsername = new JTextField();
        txtUsername.setEditable(false);
        txtUsername.setBorder(null);
        txtUsername.setText("Username:");
        txtUsername.setHorizontalAlignment(SwingConstants.RIGHT);
        txtUsername.setForeground(Color.GREEN);
        txtUsername.setFont(new Font("Monospaced", Font.BOLD, 24));
        txtUsername.setColumns(10);
        txtUsername.setBackground(new Color(5, 16, 5));
        txtUsername.setBounds(31, 147, 208, 48);
        panel_login.add(txtUsername);
        
        txtPassword = new JTextField();
        txtPassword.setEditable(false);
        txtPassword.setBorder(null);
        txtPassword.setText("Password:");
        txtPassword.setHorizontalAlignment(SwingConstants.RIGHT);
        txtPassword.setForeground(Color.GREEN);
        txtPassword.setFont(new Font("Monospaced", Font.BOLD, 24));
        txtPassword.setColumns(10);
        txtPassword.setBackground(new Color(5, 16, 5));
        txtPassword.setBounds(31, 205, 208, 48);
        panel_login.add(txtPassword);
        panel_meniu.setBackground(new Color(5, 16, 5));
        panel_meniu.setForeground(new Color(5, 16, 5));
        panel_meniu.setBounds(52, 38, 519, 337);
        frame.getContentPane().add(panel_meniu);
        panel_meniu.setLayout(null);
        
        btnNewButton_6 = new JButton("STORE\r\n");
        btnNewButton_6.setName("store");
        btnNewButton_6.setForeground(Color.GREEN);
        btnNewButton_6.setFont(new Font("Monospaced", Font.BOLD, 48));
        btnNewButton_6.setFocusable(false);
        btnNewButton_6.setFocusPainted(false);
        btnNewButton_6.setBorder(null);
        btnNewButton_6.setBackground(new Color(5, 16, 5));
        btnNewButton_6.setBounds(100, 154, 318, 56);
        btnNewButton_6.addActionListener(meniuButtons);
        panel_meniu.add(btnNewButton_6);
        
        btnNewButton_7 = new JButton("LOG OUT");
        btnNewButton_7.setName("out");
        btnNewButton_7.setForeground(Color.GREEN);
        btnNewButton_7.setFont(new Font("Monospaced", Font.BOLD, 48));
        btnNewButton_7.setFocusable(false);
        btnNewButton_7.setFocusPainted(false);
        btnNewButton_7.setBorder(null);
        btnNewButton_7.setBackground(new Color(5, 16, 5));
        btnNewButton_7.setBounds(100, 220, 318, 56);
        btnNewButton_7.addActionListener(meniuButtons);
        panel_meniu.add(btnNewButton_7);
        
        txtLethalCompany = new JTextField();
        txtLethalCompany.setText("LETHAL COMPANY");
        txtLethalCompany.setHorizontalAlignment(SwingConstants.CENTER);
        txtLethalCompany.setForeground(Color.GREEN);
        txtLethalCompany.setFont(new Font("Monospaced", Font.BOLD, 48));
        txtLethalCompany.setEditable(false);
        txtLethalCompany.setColumns(10);
        txtLethalCompany.setBorder(null);
        txtLethalCompany.setBackground(new Color(5, 16, 5));
        txtLethalCompany.setBounds(10, 71, 499, 52);
        panel_meniu.add(txtLethalCompany);
        
        JLabel BorderImage = new JLabel("New label");
        BorderImage.setForeground(new Color(0, 0, 0));
        BorderImage.setBounds(0, 0, 624, 425);
        frame.getContentPane().add(BorderImage);
        BorderImage.setVerticalAlignment(SwingConstants.TOP);
        BorderImage.setIcon(borderImagePath);
        frame.getContentPane().add(BackToTheLoby);
        
        panel_money = new JPanel();
        panel_money.setBackground(new Color(5, 16, 5));
        panel_money.setBounds(415, 38, 156, 48);
        frame.getContentPane().add(panel_money);
        panel_money.setLayout(null);
        panel_money.setVisible(false);
        
        textField = new JTextField();
        textField.setBorder(null);
        textField.setHorizontalAlignment(SwingConstants.LEFT);
        textField.setFont(new Font("Monospaced", Font.BOLD, 12));
        textField.setForeground(new Color(0, 255, 0));
        textField.setBackground(new Color(5, 16, 5));
        textField.setBounds(93, 10, 63, 19);
        panel_money.add(textField);
        textField.setColumns(10);
        
        
        txtMoney = new JTextField();
        txtMoney.setBorder(null);
        txtMoney.setBackground(new Color(5, 16, 5));
        txtMoney.setForeground(new Color(0, 255, 0));
        txtMoney.setFont(new Font("Monospaced", Font.BOLD, 12));
        txtMoney.setEditable(false);
        txtMoney.setHorizontalAlignment(SwingConstants.RIGHT);
        txtMoney.setText("MONEY:");
        txtMoney.setBounds(0, 10, 96, 19);
        panel_money.add(txtMoney);
        txtMoney.setColumns(10);
        panel_confirm.setBackground(new Color(5, 16, 5));
        panel_confirm.setBounds(52, 38, 519, 337);
        frame.getContentPane().add(panel_confirm);
        panel_confirm.setLayout(null);
        
        btnNewButton_10 = new JButton("Confirm");
        btnNewButton_10.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		money-=toSpend;
        		panel_confirm.setVisible(false);
        		panel_meniu.setVisible(true);
        		BackToTheLoby.setVisible(false);
        		panel_money.setVisible(true);
        		updateMoney();
        	}
        });
        btnNewButton_10.setName("WalkieTalkie");
        btnNewButton_10.setForeground(Color.GREEN);
        btnNewButton_10.setFont(new Font("Monospaced", Font.BOLD, 24));
        btnNewButton_10.setFocusable(false);
        btnNewButton_10.setFocusPainted(false);
        btnNewButton_10.setBorder(null);
        btnNewButton_10.setBackground(new Color(5, 16, 5));
        btnNewButton_10.setBounds(100, 236, 317, 41);
        panel_confirm.add(btnNewButton_10);
        
        txtrRequestedToOrder = new JTextArea();
        txtrRequestedToOrder.setText("requested to order :\r\ncost:\r\n");
        txtrRequestedToOrder.setLineWrap(true);
        txtrRequestedToOrder.setEditable(false);
        txtrRequestedToOrder.setForeground(new Color(0, 255, 0));
        txtrRequestedToOrder.setFont(new Font("Monospaced", Font.BOLD, 24));
        txtrRequestedToOrder.setBackground(new Color(5, 16, 5));
        txtrRequestedToOrder.setBounds(10, 10, 499, 167);
        panel_confirm.add(txtrRequestedToOrder);
        panel_item.setBackground(new Color(5, 16, 5));
        panel_item.setBounds(52, 38, 519, 337);
        frame.getContentPane().add(panel_item);
        
        JButton btnNewButton = new JButton("Flashlight");
        btnNewButton.setName("Flashlight");
        btnNewButton.setFocusable(false);
        btnNewButton.setBorder(null);
        btnNewButton.setFont(new Font("Monospaced", Font.BOLD, 24));
        btnNewButton.setBackground(new Color(5, 16, 5));
        btnNewButton.setForeground(new Color(0, 255, 0));
        btnNewButton.setFocusPainted(false);
        btnNewButton.addActionListener(shopButtons);
        btnNewButton.setBounds(163, 81, 198, 41);
        panel_item.setLayout(null);
        
        txtStore = new JTextField();
        txtStore.setEditable(false);
        txtStore.setBorder(null);
        txtStore.setBounds(10, 10, 499, 52);
        txtStore.setFont(new Font("Monospaced", Font.BOLD, 48));
        txtStore.setBackground(new Color(5, 16, 5));
        txtStore.setForeground(new Color(0, 255, 0));
        txtStore.setText("STORE");
        txtStore.setHorizontalAlignment(SwingConstants.CENTER);
        txtStore.setColumns(10);
        panel_item.add(txtStore);
        panel_item.add(btnNewButton);
        
        btnNewButton_1 = new JButton("Walkie Talkie");
        btnNewButton_1.setName("WalkieTalkie");
        btnNewButton_1.setForeground(Color.GREEN);
        btnNewButton_1.setFont(new Font("Monospaced", Font.BOLD, 24));
        btnNewButton_1.setFocusable(false);
        btnNewButton_1.setBorder(null);
        btnNewButton_1.setBackground(new Color(5, 16, 5));
        btnNewButton_1.setBounds(163, 132, 198, 41);
        btnNewButton_1.setFocusPainted(false);
        btnNewButton_1.addActionListener(shopButtons);
        panel_item.add(btnNewButton_1);
        
        btnNewButton_2 = new JButton("Weapon");
        btnNewButton_2.setName("Weapon");
        btnNewButton_2.setForeground(Color.GREEN);
        btnNewButton_2.setFont(new Font("Monospaced", Font.BOLD, 24));
        btnNewButton_2.setFocusable(false);
        btnNewButton_2.setBorder(null);
        btnNewButton_2.setBackground(new Color(5, 16, 5));
        btnNewButton_2.setBounds(163, 183, 198, 41);
        btnNewButton_2.setFocusPainted(false);
        btnNewButton_2.addActionListener(shopButtons);
        panel_item.add(btnNewButton_2);
        
        panel_tier = new JPanel();
        panel_tier.setVisible(false);
        panel_tier.setLayout(null);
        panel_tier.setBackground(new Color(5, 16, 5));
        panel_tier.setBounds(52, 38, 519, 337);
        frame.getContentPane().add(panel_tier);
        
        txtTier = new JTextField();
        txtTier.setEditable(false);
        txtTier.setText("TIER");
        txtTier.setHorizontalAlignment(SwingConstants.CENTER);
        txtTier.setForeground(Color.GREEN);
        txtTier.setFont(new Font("Monospaced", Font.BOLD, 48));
        txtTier.setColumns(10);
        txtTier.setBorder(null);
        txtTier.setBackground(new Color(5, 16, 5));
        txtTier.setBounds(10, 10, 499, 52);
        panel_tier.add(txtTier);
        
        btnNewButton_3 = new JButton("NOOB");
        btnNewButton_3.setName("Noob");
        btnNewButton_3.setForeground(Color.GREEN);
        btnNewButton_3.setFont(new Font("Monospaced", Font.BOLD, 24));
        btnNewButton_3.setFocusable(false);
        btnNewButton_3.setFocusPainted(false);
        btnNewButton_3.setBorder(null);
        btnNewButton_3.setBackground(new Color(5, 16, 5));
        btnNewButton_3.setBounds(163, 81, 198, 41);
        btnNewButton_3.addActionListener(tierButtons);
        
        panel_tier.add(btnNewButton_3);
        
        btnNewButton_4 = new JButton("PRO");
        btnNewButton_4.setName("Pro");
        btnNewButton_4.setForeground(Color.GREEN);
        btnNewButton_4.setFont(new Font("Monospaced", Font.BOLD, 24));
        btnNewButton_4.setFocusable(false);
        btnNewButton_4.setFocusPainted(false);
        btnNewButton_4.setBorder(null);
        btnNewButton_4.setBackground(new Color(5, 16, 5));
        btnNewButton_4.setBounds(163, 132, 198, 41);
        btnNewButton_4.addActionListener(tierButtons);
        panel_tier.add(btnNewButton_4);
        
        btnNewButton_5 = new JButton("LETHAL");
        btnNewButton_5.setName("Lethal");
        btnNewButton_5.setForeground(Color.GREEN);
        btnNewButton_5.setFont(new Font("Monospaced", Font.BOLD, 24));
        btnNewButton_5.setFocusable(false);
        btnNewButton_5.setFocusPainted(false);
        btnNewButton_5.setBorder(null);
        btnNewButton_5.setBackground(new Color(5, 16, 5));
        btnNewButton_5.setBounds(163, 183, 198, 41);
        btnNewButton_5.addActionListener(tierButtons);
        panel_tier.add(btnNewButton_5);
	}
	
	void meniuShop () {

	}
	/**
	 * Create the application.
	 */
	public ShopWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);

		frame.setBounds(100, 100, 864, 619);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setBounds(0, 0, 638, 462);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().setBackground(new Color(5, 16, 5));
        frame.getContentPane().setLayout(null);
		
		setBorderImage();
		setLoginPanel();
		
		updateMoney();
		
		frame.revalidate();
		
	}
}
