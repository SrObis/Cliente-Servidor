import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.*;

public class Servidor {

	public static void main(String[] args) {
		
		MarcoServidor marco1=new MarcoServidor();
		
	}

}
	class MarcoServidor extends JFrame{
		
		public MarcoServidor() {
			
			setBounds(600,300,200,350);
			LaminaServidor lamina1=new LaminaServidor();
			add(lamina1);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//para quando se ciera el marco se deje de ejecutar el programa
		}
		
		
	}

	class LaminaServidor extends JPanel implements ActionListener,Runnable {
		
		private JTextField inputTexto;
		private JButton boton1;
		private JLabel texto1;
		private JTextArea areaTexto;
		
		public LaminaServidor() {
		
			texto1=new JLabel("Servidor");
			add(texto1);
			inputTexto= new JTextField(20);
			add(inputTexto);
			boton1=new JButton("ENVIAR");
			add(boton1);
			areaTexto=new JTextArea(20,20);
			add(areaTexto);
			
			boton1.addActionListener(this);
			Thread hilo1=new Thread(this);
			hilo1.start();
		}

		
		public void actionPerformed(ActionEvent e) {

			/*try {
				Socket socket1=new Socket("192.168.56.1",8001);
				DataOutputStream flujoSalida= new DataOutputStream(socket1.getOutputStream());
				flujoSalida.writeUTF(inputTexto.getText());
				flujoSalida.close();
				socket1.close();
				
			} catch (IOException e1) {
				
				e1.printStackTrace();
				
			}
			*/
		}


		@Override
		public void run() {
			try {
				ServerSocket servidor1=new ServerSocket(8001);
				while(true) {
					Socket socket1 = servidor1.accept();
					DataInputStream flujoEntrada= new DataInputStream(socket1.getInputStream());
					String mensaje =flujoEntrada.readUTF();
					areaTexto.append(mensaje+"\n");
					socket1.close();
				}
			} catch (IOException e1) {
				
				e1.printStackTrace();
				
			}
			
			
		}
		
		
		
	}