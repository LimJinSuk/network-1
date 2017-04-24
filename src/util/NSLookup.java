package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			while (true) {
				System.out.print( ">" );
				String host = scanner.nextLine();
				if ( "quit".equals( host ) ) {
					break;
				}
				
				InetAddress[] inetAddresses = InetAddress.getAllByName(host);
				for( InetAddress inetAddress : inetAddresses ) {
					System.out.println( inetAddress.getHostAddress() );
				}
			}
		} catch (UnknownHostException e) {
			System.out.println("찾을 수 없습니다.");
		} finally {
			scanner.close();
		}
	}

}
