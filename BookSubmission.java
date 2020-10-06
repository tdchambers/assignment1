public class BookSubmission{
  String title = "";

  String author = "";
  String publisher = "";
  int YEAR = "" ;
  String ISBN = ""; 
  
  //getter methods 
  
  public String getTitle(){
    return title; 
    }
    
  public String getAuthor(){
    return author; 
    }
    
   public String getPublisher(){
     return publisher; 
        }
     
   public int getYear(){
    return YEAR;
    }
    
   public String getISBN(){
   return ISBN;    
   }
  
  //setter methods 
  
  public void setTitle(String title){
    this.title = title; } 
    
     public void setAuthor (String author){
    this.author = author ; } 
    
    
   public void setPublisher(String publisher){
    this.publisher = publisher; } 
    
   public void setISBN(String ISBN){
    this.ISBN = ISBN}
   
   public void setYEAR (int YEAR){
    this.YEAR = YEAR; }
   
   }
