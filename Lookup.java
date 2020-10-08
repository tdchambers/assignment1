import java.util.*

public class Lookup{

  public static BookSubmission lookupISBN(ArrayList<BookSubmission> bookSubmissions, String ISBN){
    for (BookSubmission bookSubmission : bookSubmissions)
          if(bookSubmission.getISBN().equals(ISBN)){
                return bookSubmission;
            }
            else{
              return null;
              }
             }
             
     
