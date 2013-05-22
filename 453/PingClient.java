import java.io.*;   
import java.net.*;   

public class PingClient {   
     
    public static void main(String[] args)throws Exception {   
    
	long totalrtt = 0;
	long max = 0;
	long min = 0;
	int drops = 0;
	boolean chk = true;
	if (args.length != 2) {  // check if number of arguments are correct
	    System.out.println("Required arguments: host port");   
	    return;   
	}   
	String server = args[0]; // Read first argument from user 
	String serport = args[1]; // Read second argument from user
	int serverPort = Integer.parseInt(serport);   
    
	DatagramSocket socket = new DatagramSocket(); // Create new datagram socket
	socket.setSoTimeout(1000); // Set socket timeout value in milliseconds. Read API for DatagramSocket to do this

	InetAddress serverAddress = InetAddress.getByName(server); //Convert server to InetAddress format; Check InetAddress API for this
	byte[] sendData = new byte[1024];   
	for(int i = 0; i < 10; i++) {  
	    Long time = new Long(System.currentTimeMillis());
	    String payload = "PING " + i + " " + time + " \r\n"; // Construct data payload for PING as per the instructions
	    sendData = payload.getBytes(); // Convert payload into bytes
	    // Create new datagram packet
	    DatagramPacket packet = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
	    socket.send(packet); // send packet
	    DatagramPacket reply = new DatagramPacket(new byte[1024], 1024); // Create datagram packet for reply
	    
	    try {
		socket.receive(reply);
		byte[] retPacketArr = reply.getData();
		ByteArrayInputStream bais = new ByteArrayInputStream(retPacketArr);
		InputStreamReader isr = new InputStreamReader(bais);
		BufferedReader br = new BufferedReader(isr);
		String line = br.readLine();
		
		int packetNum = i;	    
		for(int j = 0; j < 2; j++)
		    packetNum = Integer.parseInt(line.split(" ")[1]);
	    	    
		if (packetNum != i) {
		    System.out.println("Received out of order packet");
		}
		else {
		    System.out.println("Received from " + reply.getAddress().getHostAddress() + ": " + new String(line));
		    long rtt = System.currentTimeMillis() - time;  // calculate roundtrip time
		    totalrtt += rtt;		

		    if (chk) {
			min = rtt;
			chk = false;
		    }else if (rtt < min) { // calculate total, max and min rtt
			min = rtt;
			System.out.println("min: " + min);
		    }else if (rtt > max){
			max = rtt;
			System.out.println("max: " + max);
		    }
		}
	    } catch(SocketTimeoutException e) {
		System.out.println("error: socket time out :/");
		drops++;
	    } // end try/catch
	    
	    FileWriter fstream = new FileWriter("results.txt");
	    BufferedWriter out = new BufferedWriter(fstream);
	    out.write("max: " + max + "\n");
	    out.write("min: " + min + "\n");
	    out.write("avg: " + (totalrtt / (10-drops)) + "\n");
	    out.write("drops: " + drops + "\n");
	    out.close();
	}
	System.out.println("max: " + max);
	System.out.println("min: " + min);
	System.out.println("avg: " + (totalrtt / (10-drops)));
	System.out.println("drops: " + drops);
    }
}
