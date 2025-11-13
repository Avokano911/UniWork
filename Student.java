/* *************************************************
 * Author: Kanon Fujishima                         *
 * Date: 7 October 2025                            *
 * Purpose: Hold student information               *
 * NOTE:                                           *
 * *************************************************/

import java.util.*;

public class Student
{  // Class fields
   private String studentID;
   private String firstname;
   private String lastname;
   
   // inherit
   private cDetails StudentDetails;

   // Default Constructor
   public Student()
   {
	   studentID = "C90035274";
	   firstname = "Kanon";
	   lastname = "Fujishima";
	   
   }

   public Student(String pStudentID, String pFirstname, String pLastname)
   {
	   studentID = validStudentID(pStudentID);
	   firstname = validFirstname(pFirstname);
	   lastname = validLastname(pLastname);

   }

   // Copy Constructor
   public Student(Student pStudent)
   {
	   firstname = pStudent.getFirstname();
	   lastname = pStudent.getLastname();
	   studentID = pStudent.getStudentID();
	   
   }

   public String getFirstname()
   {
	   return firstname;
   }

   public String getLastname()
   {
	   return lastname;

   }

   public String getStudentID()
   {
	   return studentID;
   }


   public String validStudentID(String pStudentID)
   {
	   int EightDigits = 8;

	   if(pStudentID == null && pStudentID.trim().isEmpty()){
		   throw new IllegalArgumentException("studentID can not be empty!");
	   } else if(pStudentID.length() != EightDigits){
		   throw new IllegalArgumentException("The StudenID have to be 8 digits");
	   } 
	   
	   return pStudentID;
   
   }


   public String validFirstname(String pFirstname)
   {
	   if(pFirstname == null || pFirstname.trim().isEmpty()){
		   throw new IllegalArgumentException("Firstname can not be empty!");
	   } 
	   
	   return pFirstname;
   }

  

   public String validLastname(String pLastname)
   {
	   if(pLastname == null || pLastname.trim().isEmpty()){
		   throw new IllegalArgumentException("Lastname can not be empty!");
	   } 
		   return pLastname;
   }

   // Mutators (setters)

   public void setFirstname(String pFirstname)
   {
	   firstname = validFirstname(pFirstname);
   }

   public void setLastname(String pLastname)
   {
	   lastname = validLastname(pLastname);
   }

   public void setStudentID(String pStudentID)
   {
	   studentID = validStudentID(pStudentID);
   }
   
   // Tocollect the details from detail
   
   public cDetails getDetails()
   {
           return StudentDetails;
   }
   
   public void setDetails(cDetails pDetails)
   {
          StudentDetails = pDetails;
          
   
   }

}
 
   

  
   


   
