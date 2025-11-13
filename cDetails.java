/* **************************************************
 * Author: Kanon Fujishima                          *
 * Date: 7 October 2025                             *
 * Purpose: A Details for Students recording system *
 * **************************************************/
import java.util.Locale;
import java.util.Objects;

public class cDetails
{
	// Class fields
	private String cField;
        private int yLevel;
	private double cwa;
	private String status;
	private int credits;



       // Defaulls Constructor
       public cDetails()
       {
	       // Calling mutators
	       // PUT REFERENCE LATER !
	       cField = "Information Technology";
	       cwa = 0.0;
	       status = "FT";
	       credits = 0;
	}

       
       // Constructor
       public cDetails(String pFeild, int pyLevel, double pcwa, String pstatus,
		       int pcredits)
      {
	      cField = validcField(pFeild);
	      yLevel = validyLevel(pyLevel);
	      cwa = validcwa(pcwa);
	      status = validStatus(pstatus);
	      credits = validCredits(pcredits);
      }

      // Copy Constructor
      public cDetails(cDetails pDetails)
      {
	      cField = pDetails.getcField();
	      yLevel = pDetails.getyLevel();
	      cwa = pDetails.getcwa();
	      status = pDetails.getstatus();
	      credits = pDetails.getcredits();

      }

      public String getcField()
      {
	      return cField;
      }

      public int getyLevel()
      {
	      return yLevel;
      }

      public double getcwa()
      {
	      return cwa;
      }

      public String getstatus()
      {
	      return status;
      }

      public int getcredits()
      {
              return credits;
      }

      public String validcField(String pField){
	      if(pField == null || pField.trim().isEmpty()){

		      // REFERENCE !
		      throw new IllegalArgumentException("invalid data type!");
	      } 
	      return pField;
      }

      public int validyLevel(int pyLevel){
      
	      if (pyLevel < 1 || pyLevel > 4){
		      throw new IllegalArgumentException("Input have to be greater than 0 and less than 5.");
	      } 
		      return pyLevel;

      }

     public double validcwa(double pCwa){
	     if(pCwa < 0.0 || pCwa > 100.0){
	       throw new IllegalArgumentException("cwa can not be less than 0 AND greater than 101.");
	     }
		     return pCwa;
	     }

     public String validStatus(String pStatus){
	     // REFERENCE 
	     if(pStatus == null || pStatus.trim().isEmpty()){
		     throw new IllegalArgumentException("Status can not be null");
	     }else if (!pStatus.toUpperCase().equals("PT") && !pStatus.toUpperCase().equals("FT")){
		     throw new IllegalArgumentException("Status need to be either 'PT' for Part-Time Student or 'FT' for full-time Student ");
	     }else{
		     return pStatus;
	     }

     }

     public int validCredits(int pCredits){
	     if(pCredits < 0 || pCredits > 401){
		     throw new IllegalArgumentException("Credit can not be negative or more than 401");
	     } 
		     return pCredits;
	     }

     public void setcField(String pcField){

	     cField = validcField(pcField);

     }

     public void setyLevel(int pyLevel){

	     yLevel = validyLevel(pyLevel);

     }

     public void setCwa(double pCwa){

	     cwa = validcwa(pCwa);

     }

     public void setStatus(String pStatus){

	     status = validStatus(pStatus);

     }

     public void setCredits(int pCredits){

	     credits = validCredits(pCredits);

     }
}









      


