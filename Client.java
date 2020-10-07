
import java.io.*;
import java.net.*;


public class SocketClient
{
	private Socket clientSocket; 
		
	public String client (String location, int port, Request request, String ISBN, String TITLE, String AUTHOR, String PUBLISHER, int YEAR, boolean all, boolean a) throws IOException
	{
	 	try
		{
		System.out.println("Conneting to server " +location+ " on port " + port);
		Socket clientSocket = new Socket (location, port);
		System.out.println("Connected");
		InputStream din = new DataInputStream(clientSocket.getInputStream());
		OutputStream dout = new DataOutputStream(clientSocket.getOutputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	} catch(IOException e){
		e.printStackTrace();
		throw new IOException("Connection refused. Enter a new address and Port.");
		}
		
		String requestAll = request.name() + "\r\n";//needs editing
		String serverResponse = "";
		String line = din.readLine();
		if (ALL){
			requestALL +="ALL";
		}
		else{
			requestALL += "ISBN: " + ISBN + "\r\n" + "TITLE: " + TITLE + "\r\n" + "AUTHOR: " + AUTHOR + "\r\n" + "PUBLISHER: " + PUBLISHER + "\r\n" + "YEAR: " + YEAR + "\r\n";
			}
		Println(requestALL + "\r\n\\EOF");
		
		while(line!=null && !line.contains("\\EOF")){
			serverResponse = serverResponse.concat(line + "\r\n");
           		line = din.readLine();
		
		if (a) {
		   String[] split = serverResponse.split("\r\n"); //needs editing
		   serverResponseb = "";
		   for (String x : split) {
			String[] splitLine = x.split(" ");
                    if (splitLine[0].contains("ISBN:")) {
                        serverResponseb = serverResponseb.concat("@BookSubmission{\r\n\tISBN\t= \"" + x.substring(splitLine[0].length()).trim() + "\",\r\n");
                    }
                    if (splitLine[0].contains("TITLE:")) {
                        serverResponseb = serverResponseb.concat("\tTITLE\t= \"" + x.substring(splitLine[0].length()).trim() + "\",\r\n");
                    }
                    if (splitLine[0].contains("AUTHOR:")) {
                        serverResponseb = serverResponseb.concat("\tAUTHOR\t= \"" + x.substring(splitLine[0].length()).trim() + "\",\r\n");
                    }
                    if (splitLine[0].contains("PUBLISHER:")) {
                        serverResponseb = serverResponseb.concat("\tPUBLISHER\t= \"" + x.substring(splitLine[0].length()).trim() + "\",\r\n");
                    }
                    if (splitLine[0].contains("YEAR:")) {
                            serverResponseb = serverResponseb.concat("\tYEAR\t= \"" + x.substring(splitLine[0].length()).trim() + "\",\r\n}\r\n");
                    }
                }
		
		return serverResponseb;

		
		din.close();
		dout.close();
		clientSocket.close();
        }
	catch(Exception e)
	{
		e.printStackTrace(); 
		throw new IOException("Error closing connection.");
		
        }	
	
        }
	
	
public class mainClient{
	public static void main(String[] args){
	}
	}
	
	
