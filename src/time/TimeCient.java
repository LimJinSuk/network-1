package time;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class TimeCient {
	private static final String SERVER_IP = "192.168.1.39";
	private static final int SERVER_PORT = 7070;
	private static final int BUFFER_SIZE = 1024;
	
	public static void main(String[] args) {
		DatagramSocket socket = null;

		try {
			socket = new DatagramSocket();

			String message = "";
			byte[] sendData = message.getBytes("utf-8");
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,
					new InetSocketAddress(SERVER_IP, SERVER_PORT));
			socket.send( sendPacket );
			
			DatagramPacket receivePacket = new DatagramPacket( new byte[ BUFFER_SIZE ], BUFFER_SIZE, new InetSocketAddress( SERVER_IP, SERVER_PORT ) );
			socket.receive( receivePacket  );
			String datetime = new String( receivePacket.getData(), 0, receivePacket.getLength(), "utf-8" );
			System.out.println( datetime );
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if( socket != null && socket.isClosed() == false ) {
				socket.close();
			}
		}
	}
}
