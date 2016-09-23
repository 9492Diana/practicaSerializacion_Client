import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.util.ArrayList;


public class Comunicacion extends Thread {

	private ArrayList<Clic> ref;
	private DatagramSocket ds;
	private String identificador;
	
	public Comunicacion(ArrayList<Clic> clics) {	
		identificador = "Jose";
		ref = clics;
		try {
			ds = new DatagramSocket(5001);
		} catch (SocketException e) {		
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		try {
			sleep(100);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}

	public void enviar(int mx, int my) {		
		
		try {
			Clic mensajeEnvio = new Clic(mx, my, identificador);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(mensajeEnvio);
			oos.flush();
			byte[] buf = baos.toByteArray();
		//	System.out.println("el tamano en bytes es: " + buf.length);
			DatagramPacket paq = new DatagramPacket(buf, buf.length, InetAddress.getByName("127.0.0.1"), 5000);
			ds.send(paq);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
		
	}
}
