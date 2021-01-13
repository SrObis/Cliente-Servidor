import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.*;

public class Cliente {

	public static void main(String[] args) {
		
		MarcoCliente marco1=new MarcoCliente();
		
	}

}
	class MarcoCliente extends JFrame{
		
		public MarcoCliente() {
			
			setBounds(600,300,200,350);
			LaminaCliente lamina1=new LaminaCliente();
			add(lamina1);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//para quando se ciera el marco se deje de ejecutar el programa
		}
		
		
	}

	class LaminaCliente extends JPanel implements ActionListener{
		
		private JTextField inputTexto;
		private JButton boton1;
		private JLabel texto1;
		private JTextArea areaTexto;
		
		public LaminaCliente() {
		
			texto1=new JLabel("CLIENTE");
			add(texto1);
			inputTexto= new JTextField(20);
			add(inputTexto);
			boton1=new JButton("ENVIAR");
			add(boton1);
			areaTexto=new JTextArea(20,20);
			add(areaTexto);
			
			boton1.addActionListener(this);
		}

		
		public void actionPerformed(ActionEvent e) {

			try {
				Socket socket1=new Socket("192.168.6.54",8001);//192.168.88.131 id del servidor
				DataOutputStream flujoSalida= new DataOutputStream(socket1.getOutputStream());
				flujoSalida.writeUTF(inputTexto.getText());
				flujoSalida.close();
				socket1.close();
				
			} catch (IOException e1) {
				
				e1.printStackTrace();
				
			}
			
		}
		
		
		
	}