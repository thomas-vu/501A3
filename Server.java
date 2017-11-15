import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.lang.Thread;
import java.net.ServerSocket;
import java.net.Socket;
import org.jdom2.output.*;

public class Server extends Thread
{
    private ServerSocket serverSocket;

    public static void main(String[] args)
    {
    	int port = 8080;
    	try
    	{
    		Thread t = new Server(port);
    		t.start();
    	}
    	catch (Exception e) { e.printStackTrace(); }
    }

    public Server(int port)
    {
    	try
    	{
    		serverSocket = new ServerSocket(port);
    		serverSocket.setSoTimeout(100000);
    	}
    	catch (Exception e) { e.printStackTrace(); }
    }

    public void run()
    {
    	while (true)
    	{
    		try
    		{
    			System.out.println("Server running on: " + serverSocket.getLocalPort());
    			Socket server = serverSocket.accept();
    			System.out.println("Server connected to: " + server.getRemoteSocketAddress());
		
    			DataInputStream in = new DataInputStream(server.getInputStream());
    			DataOutputStream out = new DataOutputStream(server.getOutputStream());
    			out.writeUTF("Thank you for connecting to this server.");
    			
    			ObjectCreator objectCreator = new ObjectCreator();
    			Object obj = objectCreator.createObject();
    			
    			Serializer serializer = new Serializer();
    			org.jdom2.Document doc = serializer.serialize(obj);

    			XMLOutputter xout = new XMLOutputter(Format.getPrettyFormat());
    			xout.output(doc, out);
		
    			server.close();
    		}
    		catch (Exception e) { e.printStackTrace(); }
    	}
    }   
}