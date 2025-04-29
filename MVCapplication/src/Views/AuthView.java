package Views;

import java.awt.*;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Controller.AuthController;

public class AuthView extends JFrame {
			
	public void Login() {
		setTitle("Login");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().removeAll(); 
		getContentPane().setBackground(new Color(224, 240, 255));
		setLayout(null);
	        
	        JLabel title = new JLabel("Login");
	        title.setBounds(200, 40, 100, 30);
	        title.setFont(new Font("Arial", Font.BOLD, 26));
	        add(title);
	        
	        JPanel panel = new JPanel();
	        panel.setLayout(null);
	        panel.setBounds(75, 100, 350, 270); 
	        panel.setBackground(Color.WHITE);
	        panel.setBorder(new LineBorder(new Color(200, 200, 200), 1));
	        

	        
	        JLabel emailLabel = new JLabel("Email:");
	        emailLabel.setBounds(30, 30, 100, 25);
	        panel.add(emailLabel);

	        JTextField emailField = new JTextField();
	        emailField.setBounds(140, 30, 170, 25);
	        emailField.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
	        panel.add(emailField);

	        JLabel passwordLabel = new JLabel("Password:");
	        passwordLabel.setBounds(30, 80, 100, 25);
	        panel.add(passwordLabel);

	        JPasswordField passwordField = new JPasswordField();
	        passwordField.setBounds(140, 80, 170, 25);
	        passwordField.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
	        panel.add(passwordField);

	        JCheckBox rememberMe = new JCheckBox("Remember me");
	        rememberMe.setBounds(30, 130, 150, 25);
	        rememberMe.setBackground(Color.WHITE);
	        panel.add(rememberMe);

	        JButton loginButton = new JButton("Log in");
	        loginButton.setBounds(90, 180, 170, 35);
	        loginButton.setBackground(new Color(0, 120, 215));
	        loginButton.setForeground(Color.WHITE);
	        loginButton.setFocusPainted(false);
	        panel.add(loginButton);
	        
	        loginButton.addActionListener(new ActionListener() {
	        	
	            public void actionPerformed(ActionEvent e) {
	                String email = emailField.getText();
	                String password = String.valueOf(passwordField.getPassword());

	                AuthController controller = new AuthController();
	                boolean isValid = controller.validateLogin(email, password);
	                
	                if (email.isEmpty() || password.isEmpty()) {
	                    JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
	                    return;
	                }
	                
	                if (isValid) {
	                    JOptionPane.showMessageDialog(null, "Acceso concedido");
	                    emailField.setBorder(BorderFactory.createLineBorder(Color.GREEN));
	                    passwordField.setBorder(BorderFactory.createLineBorder(Color.GREEN));
	                } else {
	                    JOptionPane.showMessageDialog(null, "Datos incorrectos");
	                    emailField.setBorder(BorderFactory.createLineBorder(Color.RED));
	                    passwordField.setBorder(BorderFactory.createLineBorder(Color.RED));
	                }
	            }
	
	        });
	        
	        JButton registerButton = new JButton("Register");
	        registerButton.setBounds(90, 225, 170, 35);
	        registerButton.setBackground(new Color(100, 100, 100));
	        registerButton.setForeground(Color.WHITE);
	        registerButton.setFocusPainted(false);
	        registerButton.addActionListener(e -> {
	            register();
	        });
	        panel.add(registerButton);


	        add(panel);
	        setLocationRelativeTo(null);
	        setVisible(true);
	}
	public void register() {
		getContentPane().removeAll();
		setTitle("Registro");
		setSize(400, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null); 
       
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 400, 500);
        panel.setBackground(new Color(224, 240, 255));
        add(panel);


        JLabel titulo = new JLabel("SIGN UP", SwingConstants.CENTER);
        titulo.setBounds(50, 20, 300, 40);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(new Color(44, 62, 80)); // Color de texto oscuro
        panel.add(titulo);

        // NOMBRE DE USUARIO 
        JLabel nombreLabel = new JLabel("NOMBRE DE USUARIO:", SwingConstants.LEFT);
        nombreLabel.setBounds(50, 80, 300, 20);
        nombreLabel.setForeground(new Color(44, 62, 80));
        panel.add(nombreLabel);

        JTextField nombreField = new JTextField();
        nombreField.setBounds(50, 105, 300, 25);
        nombreField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panel.add(nombreField);

        //  BIO
        JLabel bioLabel = new JLabel("BIO", SwingConstants.LEFT);
        bioLabel.setBounds(50, 140, 300, 20);
        bioLabel.setForeground(new Color(44, 62, 80));
        panel.add(bioLabel);

        JTextArea bioArea = new JTextArea();
        bioArea.setBounds(50, 165, 300, 60);
        bioArea.setBorder(BorderFactory.createLineBorder(Color.GRAY)); 
        panel.add(bioArea);

        //  PREFERENCIAS 
        JLabel prefLabel = new JLabel("PREFERENCIAS", SwingConstants.LEFT);
        prefLabel.setBounds(50, 235, 300, 20);
        prefLabel.setForeground(new Color(44, 62, 80));
        panel.add(prefLabel);

        JCheckBox dulces = new JCheckBox("Dulces");
        dulces.setBounds(50, 260, 80, 20);
        dulces.setBackground(new Color(224, 240, 255));
        JCheckBox salado = new JCheckBox("Salado");
        salado.setBounds(140, 260, 80, 20);
        salado.setBackground(new Color(224, 240, 255));
        JCheckBox saludable = new JCheckBox("Saludable");
        saludable.setBounds(230, 260, 100, 20);
        saludable.setBackground(new Color(224, 240, 255));

        panel.add(dulces);
        panel.add(salado);
        panel.add(saludable);

        // TERMINOS
        JLabel terminosLabel = new JLabel("TERMINOS", SwingConstants.LEFT);
        terminosLabel.setBounds(50, 290, 300, 20); 
        terminosLabel.setForeground(new Color(44, 62, 80));
        terminosLabel.setBackground(new Color(224, 240, 255));

        panel.add(terminosLabel);

        JRadioButton aceptar = new JRadioButton("Acepto los términos");
        aceptar.setBounds(50, 315, 150, 20);
        aceptar.setBackground(Color.WHITE);
        aceptar.setBackground(new Color(224, 240, 255));

        JRadioButton noAceptar = new JRadioButton("No acepto los términos");
        noAceptar.setBounds(200, 315, 170, 20); 
        noAceptar.setBackground(Color.WHITE);
        noAceptar.setBackground(new Color(224, 240, 255));

        ButtonGroup grupoTerminos = new ButtonGroup();
        grupoTerminos.add(aceptar);
        grupoTerminos.add(noAceptar);

        panel.add(aceptar);
        panel.add(noAceptar);

        JButton boton = new JButton("Crear cuenta");
        boton.setBounds(50, 350, 300, 40); 
        boton.setBackground(new Color(39, 174, 96)); 
        boton.setForeground(Color.WHITE);
        boton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        boton.addActionListener(e -> {
        	if(nombreField.getText().isEmpty() && bioArea.getText().isEmpty())
        	{
                JOptionPane.showMessageDialog(null, "Llena los campos vacios");

        	}
        	else {
            JOptionPane.showMessageDialog(null, "Cuenta creada con éxito");
            Login();
            } 
        });
        panel.add(boton);
        add(panel);
        setVisible(true);
	}
	}

