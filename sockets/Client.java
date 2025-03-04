package sockets;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] arg) throws Exception {

		// Send data on Port 4711 of your computer (localHost)
		Socket s = new Socket("localhost", 4711);

		// Prepare outputStream for sending data
		OutputStream os = s.getOutputStream();
		
		// Write data
		os.write("hello\n".getBytes());
		
		// Close socket
		s.close();
	}
}
