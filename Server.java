import java.net.*;
import java.io.*; 
import java.util.*;

public class SocketServer extends Thread{
      Private ArrayList<BookSubmission> bookSubmissions;

      private ServerSocket serverSocket;
      private int port;
      private boolean isRunning= false;

    public ServerSocket(int port, ServerSocket serverSocket, ArrayList<BookSubmission> bookSubmissions ){
        this.port = port;
        this.serverSocket = serverSocket;
        this.bookSubmissions = bookSubmissions; 
    }
    
    public synchronized void stopServer(){
        this.isRunning = false;
         try{
        din.close();
        dout.close();
        serverSocket.close(); 
          }
           catch( Exception e){
                  System.out.println("Connection was not properly closed"); 
                  e.printStackTrace();
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

      private String submitRequest(String []requestData){
     
            String serverMessage;
            String submission = "":
            BookSubmission bookSubmissions = new BookSubmission();
            for (String line : requestData){
                  String[] words = line.split(" ");
                  
                 switch(words[0]){
                        case "ISBN":
            
                        if(IsbnLookup(bookSubmission, words[1] != null){
                              message = "ISBN already exists in directory";
                              return message;
                              }
                         bookSubmission.setISBN(words[1]);
                        break;
                              
                        case "TITLE":
                              submission = line.substring(words[0].length()).trim();
                              bookSubmission.setTITLE(submission);
                        break;
                        
                        case "AUTHOR":
                              submission = line.substring(words[0].length()).trim();
                              bookSubmission = set.AUTHOR(submission)
                        break;
                        
                        case "PUBLISHER":
                             submission = line.substring(words[0].length()).trim();
                             bookSubmission = setPUBLISHER(submission)
                        break;
                        
                        case "YEAR":
                               bookSubmission.setYEAR(Integer.parseInt(words[1]));

                        break;
                        }
                        }
                        message = "The entry with ISBN code " + ISBN+" has been added to the bibliography successfully.");
                        bookSubmission.add(bookSubmission); 
                        return message;  
                   
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
                 
                  dout.println("Enter a Request or "Stop" to end session: ");
                  dout.flush(); 
                  String line = "";
                  String serverMessage = "";
                  String clientMessage = "";
                  line = din.readLine(); 
                        while(line!=null){
                              while(!line.contains("\\EOF")){
                                    clientMessage = clientMessage.concat(line+"\r\n");
                                    line = din.readLine();
                              }
                              
                              String request = clientMessage[0].trim();
                              clientMessage = clientMessage.split(("\n").trim()+"\r\n\\EOF");
                              if(request.equals("SUBMIT"){
                                    serverMessage = submitRequest(clientMessage);

                              }
                              else if(request.equals("UPDATE"){
                                    serverMessage = updateRequest(clientMessage);

                              }
                              else if(request.equals("GET"){
                                    serverMessage = getRequest(clientMessage);
                              }
                              else if(request.equals("REMOVE"){
                                    serverMessage = removeRequest(clientMessage);
                              }
                             else if(request.equals(""){
                                    dout.println("No request identified.")
                                    dout.flush();
                              }
                              else if (request.equals("Stop"){
                                    dout.println("Stopping connection");
                                    dout.flush();
                                    stopServer();
                              else{
                                    dout.println("Request not recognized."
                                    dout.flush()
                                                 }
                              
                        dout.println(serverMessage);
                        dout.flush(); 
                        dout.println("Enter another Request or "Stop" to end session: ");
                        dout.flush(); 
                        line = in.readLine(); 
                                                 
                        }   
                            }catch (IOException e){
                                  e.printStackTrace();
                                     
                  }
                    System.out.println("Connection has been closed");
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

            
            
                
