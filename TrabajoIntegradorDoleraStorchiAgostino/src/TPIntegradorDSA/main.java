package TPIntegradorDSA;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



public class main {

	public static void main(String[] args) {
		
		ArrayList <Cliente> Mecanico = new ArrayList <Cliente>(); 
		
		Cliente Lautaro = new Cliente("Lautaro", "Perez", "Plata", "Escobar", "lautaro.perez16", 123, 2);
		
		Mecanico.add(Lautaro);
		
		
		menu(Mecanico);
		

	}

	
	
	public static void menu(ArrayList <Cliente> a) {
		ArrayList <Cliente> array = new ArrayList<Cliente>();
		
		
		do {
			int option = Integer.parseInt(JOptionPane.showInputDialog(null,
							"1) Registrar nuevo usuario \n"+
							"2) Ingresar con usuario \n" +
							"3) Salir \n" +
							"Ingrese opci�n del 1 al 3", "Men� Mec�nico", JOptionPane.QUESTION_MESSAGE));
		
			switch(option) {
			case 1:
				array= register(a);
				a.addAll(array);
				break;
			case 2:
				login(a); break;
			case 3:
				System.exit(0); break;
			}
		
		} while(true);
		
	}
	
	public static void login(ArrayList <Cliente> lista) {
		JTextField user = new JTextField();
		JTextField pass = new JTextField();
		Boolean register = false;
		int matricula = 0;
		
		Object[] message = {
			    "Usuario:", user,
			    "Contrase�a:", pass,		    
			};
			Component parent = null;
			int option = JOptionPane.showConfirmDialog(parent, message, "Ingrese sus credenciales ", JOptionPane.OK_CANCEL_OPTION);
			if (option == JOptionPane.OK_OPTION){
			    String value1 = user.getText();
			    String value2 = pass.getText();
			}
		
		String StrPassword = pass.getText();
		int IntPassword = Integer.parseInt(StrPassword);
		
			
		for (int i=0; i<lista.size(); i++) {
			if ((lista.get(i).getUsuario().equalsIgnoreCase(user.getText()) && (lista.get(i).getPassowrd()==IntPassword)) ) {
				register = true;
			}
		}	
			
		if (register == false) {
			JOptionPane.showMessageDialog(null, "Las credenciales son incorrectas o usted no est� registrado");
		} else {
			JOptionPane.showMessageDialog(null, "�Inicio de sesi�n con �xito!");
			ServicioOption(lista);
		}
		
	}
	
	public static ArrayList <Cliente> register(ArrayList <Cliente> a) {
		
		ArrayList <Cliente> Usuario = new ArrayList<Cliente>();
		
		JTextField nombre = new JTextField();
		JTextField apellido = new JTextField();
		JTextField localidad = new JTextField();
		Boolean register = false;
		int servicio = 0;
		int tipo = 0;
		
		Object[] message = {
		    "Nombre: ", nombre,
		    "Apellido: ", apellido,
		    "Localidad: ", localidad,
		};
		Component parent = null;
		int option = JOptionPane.showConfirmDialog(parent, message, "Ingrese sus datos personales: ", JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION){
		    String value1 = nombre.getText();
		    String value2 = apellido.getText();
		    String value4 = localidad.getText();
		}
		
		int password = (int) (Math.random()*10000);
		
		String usuario = nombre.getText().toLowerCase() + "."+ apellido.getText().toLowerCase();
		System.out.println(usuario);
		System.out.println(password);
		
		
		/*
		do {
			option = Integer.parseInt(JOptionPane.showInputDialog(null,
											"1) Auxilio Mec�nico \n" +
											"2) Gr�a \n" +
											"3) Cerrajero \n" +
											"4) Salir " +
											"Ingrese opci�n del 1 al 4", "Servicios Mec�nicos", JOptionPane.QUESTION_MESSAGE));
			switch(option) {
				case 1: servicio = 1 ;
				register = true; break;
				case 2: servicio = 2;
				register = true; break;
				case 3: servicio = 3;
				register = true; break;
				case 4: System.exit(0); break;
			}
		} while(register = false);
		*/
		
		
		int seleccion = JOptionPane.showOptionDialog( null,"Seleccione el tipo de servicio que usted desea adquirir: ",
				  "Servicio Mec�nico",JOptionPane.YES_NO_CANCEL_OPTION,
				   JOptionPane.QUESTION_MESSAGE,null,// null para icono por defecto.
				  new Object[] { "Auxilio Mec�nico", "Gr�a", "Cerrajero",},null);
				     
				 if (seleccion != -1){
				           servicio = seleccion+1;
				 }
		

		int tipo = JOptionPane.showOptionDialog( null,"Seleccione el tipo de servicio que usted desea adquirir: ",
						  "Servicio Mec�nico",JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE,null,// null para icono por defecto.
						new Object[] { "Oro", "Plata",},null);
						     
					if (seleccion != -1){
						         tipo = tipo+1;
						}
				 
				 
				 
		
		//Cliente user = new Cliente (nombre.getText(), apellido.getText(), tipo.getText(), localidad.getText(), usuario, password, servicio);
		//Usuario.add(user);
		
		String message2 ="";
		
		message2 = message2 + "	Los datos del usuario son:\n\n "+ usuario + " \n"+ password + "\n\n >>Recu�rdelos para volver a iniciar sesi�n<< " ;
		JOptionPane.showMessageDialog(null, message2);
		
		return Usuario;
	}
	
	public static void ServicioOption(ArrayList<Cliente> lista) {
		int contMeca;
		int contGrua;
		int contCerrajero;
		int distMax = 700;
		
		
		
		
		for (int i=0; i<lista.size(); i++) {
			switch (lista.get(i).getServicio()) {
			case 1: System.out.println("Auxilio Mec�nico"); 
				
			
			break;
			case 2: System.out.println("Grua");
					if (lista.get(i).getTipo().equalsIgnoreCase("Oro")) {
						
					} else {
						
					}
				break;
			case 3: System.out.println("Cerrajero");
				break;
			default:
				break;
			}
		
			
		}
		
	}
	
}
