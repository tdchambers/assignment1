import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
public class GUI extends JFrame{
	/*--------------------------------
  Have NOT tested with the other files 
	  
  ----------------------------------------*/
  private final SocketServer socketServer;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
		
	//Labels
	
	
	
	
	private JLabel Port_label = new JLabel("Port #: ", SwingConstants.LEFT);
	

	
	
	
	//Buttons
	public static JButton SubmitButton = new JButton("SUBMIT REQUEST");
	public static JButton Clear= new JButton("CLEAR");

	
	//TextFields
	
	public JLabel IP_label = new JLabel("IP Address: ", SwingConstants.LEFT);
	
	public static JTextField IPtxt = new JTextField();
	
	public JLabel Request_label = new JLabel("Request: ", SwingConstants.LEFT);

	public static JTextField PORTtxt  = new JTextField();

	public JLabel Response_label = new JLabel("Response: ", SwingConstants.LEFT);

	public static JTextField REQUESTtxt = new JTextField();

	public static JTextField p4 = new JTextField();
	
	public static JTextField ISBNtxt = new JTextField();
	public static JTextField TITLEtxt = new JTextField(); 
	public static JTextField PUBLISHERtxt = new JTextField();
	public static JTextField AUTHORtxt = new JTextField(); 
	public static JTextField YEARtxt = new JTextField(); 

	public JLabel ISBNlabel = new JLabel("ISBN: ", SwingConstants.LEFT);
	public JLabel TITLElabel = new JLabel("TITLE: ", SwingConstants.LEFT);
	public JLabel PUBLISHERlabel = new JLabel("PUBLISHER: ", SwingConstants.LEFT);
	public JLabel AUTHORlabel = new JLabel("AUTHOR: ", SwingConstants.LEFT);
	public JLabel YEARlabel = new JLabel("YEAR: ", SwingConstants.LEFT);

	

	public void settingFonts() {
		
		//this.go.setFont(new Font("Verdana", Font.PLAIN, 18));
		
		//this.Port_label.setFont(new Font("Verdana", Font.PLAIN, 18));

		




		
	}
	public void addElements() {
	SubmitButton.setBackground(Color.GREEN);
	SubmitButton.setOpaque(true);
	
	
	this.add(IP_label);
	this.add(IPtxt);
	this.add(Port_label);


	this.add(PORTtxt);

	this.add(Request_label);
	this.add(REQUESTtxt);
	
	
	
	this.add(ISBNlabel);
	this.add(ISBNtxt);
	this.add(TITLElabel);
	this.add(TITLEtxt);
	this.add(AUTHORlabel);
	this.add(AUTHORtxt);
	this.add(PUBLISHERlabel);
	this.add(PUBLISHERtxt);
	this.add(YEARlabel);
	this.add(YEARtxt);

	
	
	this.add(SubmitButton);
	this.add(Clear);
	this.add(Response_label);
	this.add(p4);	
	

		
	}
	
	public void SubmitButtonHandler(ActionEvent e) {
		  String ISBN = ISBNtxt.getText().trim();
          // Handle Title
          String TITLE = TITLEtxt.getText().trim();
          // Handle Author
          String AUTHOR = AUTHORtxt.getText().trim();
          // Handle Publisher
          String PUBLISHER = PUBLISHERtxt.getText().trim();
          // Handle Year
          String YEAR = YEARtxt.getText().trim();
          if (YEARtxt.getText().length() > 0)
              try {
                  //YEAR = Integer.parseInt(YEARtxt.getText());
              } catch (NumberFormatException exception) {
                  JOptionPane.showMessageDialog(this, "Invalid Year", "Error", JOptionPane.ERROR_MESSAGE);
                  return;
              }
      
        	String[] reqData = {ISBN, TITLE, AUTHOR, PUBLISHER, YEAR};
        
          
		if(REQUESTtxt.getText().toLowerCase().trim() == "submit") {
			socketServer.submitRequest(reqData);
		}
		if(REQUESTtxt.getText().toLowerCase().trim() == "get") {
			socketServer.getRequest(reqData);
		}
		if(REQUESTtxt.getText().toLowerCase().trim() == "remove") {
			socketServer.updateRequest(reqData);
		}
		if(REQUESTtxt.getText().toLowerCase().trim() == "update") {
			
		}
		
	}

	
	public void layoutView() {
		this.setLayout(new GridLayout(0,2,4,1));
		this.settingFonts();
		this.addElements();
		

		
		SubmitButton.addActionListener(this::SubmitButtonHandler);
		this.setTitle("Server GUI");
	
		
		
	}
	
	
	
	
	

}
