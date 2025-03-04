package sockets;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] arg) throws Exception {
	
		// Listen on port 4711
	    ServerSocket serverSocket = new ServerSocket(4711);
	    Socket socket = serverSocket.accept();

		// Start reading data from the input stream
		InputStream inputStream = socket.getInputStream();
		int data = inputStream.read();

		// Read until end of stream
		while (data != -1) {
			// Print the data received from the client
			System.out.print((char) data);
			data = inputStream.read();
		}

		// Close socket & serverSocket
		socket.close();
		serverSocket.close();
	}
}
