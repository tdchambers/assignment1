import java.net.*;
import java.io.*; 
import java.util.*;

public class SocketServer extends Thread{
      public ArrayList<BookSubmission> BookList = new ArrayList<BookSubmission>();

      private ServerSocket serverSocket;
      private int port;
      private boolean isRunning= false;

    public SocketServer(int port){
        this.port= port;
    }
    
    public synchronized void stopServer(){
        this.isRunning = false;
        try {
            this.serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException("Error closing server", e);
        }
    }

    private void openServerSocket() {
        try {
            this.serverSocket = new ServerSocket(port);
            this.start(); 
        } catch (IOException e) {
            throw new RuntimeException("Cannot open port ", port);
        }
    }

    public void startRunning(){
        synchronized(this){
        }
        openServerSocket();
        isRunning = true; 
        while(isRunning){
            try {
     
                System.out.println("waiting for a connection");
                Socket socket = this.serverSocket.accept();
                RequestHandler requestHandler = new RequestHandler(socket);
                requestHandler.start();
            } catch (IOException e) {
                e.printStackTrace();
                }
                throw new RuntimeException(
                    "Error accepting client connection", e);
            }
        }
        System.out.println("Server Stopped.") ;
    }

}

public class RequestHandler extends Thread
{ 
    private Socket socket;
    RequestHandler(Socket socket)
    {
      this.socket = socket;
}

      private String submitRequest(){
      }
      private String updateRequest(){
      }
      private String getRequest(){
      }
      private String removeRequest(){
      }

      public void startRunning()
      {
            try
            {
            System.out.println("Connection Accepted");
                  DataInputStream din = new DataInputStream(socket.getInputStream());
                  DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
                  BufferedReader br = newBufferedReader(new InputStreamReader());
                 
                  out.println("Enter a Request or "Stop" to end session: ");
                  out.flush; 
                  String line = "";
                  while(!line.equals("Stop"){
                        line = din.readLine();

                        if(line.equals("SUBMIT"){
                              return submitRequest();
                           
                        }
                        else if(line.equals("UPDATE"){
                              return updateRequest();

                        }
                        else if(line.equals("GET"){
                              return getRequest();
                        }
                        elese if(line.equals("REMOVE"){
                              return removeRequest(); 
                        }
                       else if(line.equals(""){
                              dout.println("No request identified."
                              dout.flush();
                        }
                        else{
                              dout.println("Request not recognized."
                              dout.flush();
                              
 
                        dout.println("Enter another Request or "Stop" to end session: ");
                        dout.flush(); 
                        din.flush()
                        }   
                
                din.close();
                dout.close();
                socket.close();
                System.out.println("Connection has been closed");
                }
                catch( Exception e)
                {
                  System.out.println("Connection was not properly closed"); 
                  e.printStackTrace();
                  }
                  }
                 
                  
 public class mainServer{
      public static void main(String[] args) throws IOException{
            private boolean run = true; 
            ArrayList<BookSubmission> bookSubmission = new ArrayList<BookSubmission>();
            int port
            if(args[0].length ==0) {
            port =5000;
            }
            else port = Integer.parseInt(arg[0]);
            ServerSocket = serverSocket = new ServerSocket(port);
            System.out.println("Server is now running on port: " +port);
            while (run){ //this part needs editing
                  Socket clientSocket = serverSocket.accept();
           
                  SocketServer socketServer = new SocketServer(Thread.activeCount()+"",clientSocket,bookSubmission);
                  socketServer.start();
                  System.out.println("Connected"); 
                  }
           }
       }

            
            
                
//running code
SocketServer server = new SocketServer(port);
new Thread(server).start();
try {
      Thread.sleep(50000);
      }
      catch(Exception e)
      {
            e.printStackTrace();
            }
            }
server.stopServer(); 
