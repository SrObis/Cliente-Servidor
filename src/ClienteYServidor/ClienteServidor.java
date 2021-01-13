package ClienteYServidor;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.*;

public class ClienteServidor {

	public static void main(String[] args) {
		
		MarcoCliente marco1=new MarcoCliente();
		
	}

}
	class MarcoCliente extends JFrame{
		
		public MarcoCliente() {
			
			setBounds(600,300,300,550);
			LaminaCliente lamina1=new LaminaCliente();
			add(lamina1);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//para quando se ciera el marco se deje de ejecutar el programa
		}
		
		
	}

	class LaminaCliente extends JPanel implements ActionListener{
		
		private JTextField inputTexto;//mensaje a enviar
		private JTextField areaIp;//para poner la ip
		private JButton boton1;//Enviar
		private JLabel texto1;//IP DEL DESTINATARIO
		private JLabel texto2;//"MENSAJE A ENVIAR")

		private JTextArea areaTexto;

		
		
		public LaminaCliente() {
		
			texto1=new JLabel("IP DEL DESTINATARIO");//Texto cliente
			add(texto1);
			//para poner la ip donde queremos ir
			areaIp= new JTextField(20);
			add(areaIp);
			texto2=new JLabel("MENSAJE A ENVIAR");//info mensaje
			add(texto2);
			//mensaje a enviar
			inputTexto= new JTextField(20);
			add(inputTexto);
			//boton enciar
			boton1=new JButton("ENVIAR");
			add(boton1);
			areaTexto=new JTextArea(20,20);
			add(areaTexto);
			
			boton1.addActionListener(this);
		}

		
		public void actionPerformed(ActionEvent e) {

			try {
				Socket socket1=new Socket(areaIp.getText(),8001);
				DataOutputStream flujoSalida= new DataOutputStream(socket1.getOutputStream());
				flujoSalida.writeUTF(inputTexto.getText());
				flujoSalida.close();
				socket1.close();
				
			} catch (IOException e1) {
				
				e1.printStackTrace();
				
			}
			
		}
		
		
		
	}