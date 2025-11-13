/* **********************************************************************************************
 * Author: Kanon Fujishima                                                                      *
 * Date: 8 October 2025                                                                         *
 * Purpose:run the program to pick a choice and display the student information from the choice.*
 *                                                                                              *
 * **********************************************************************************************/

import java.util.Scanner;
import java.util.Arrays;
import java.io.*;

public class StudentRecordSystem
{

	// Class Fields
	// have to be static , the code runs without error when converting into static
	
	    static Student[] studentRecords = new Student[100];
	    static int TrackStudents = 0;
	    static String FileName = "data.csv";
	    static Scanner sc = new Scanner(System.in);

	   public static void main(String[] args)
	   {
		   int choice = 0;
		   
		   System.out.println(" Reading data from " + " data.csv " + "file... " );
		   readFile(FileName);
		   System.out.println(" The file " + FileName + "contains " + TrackStudents + " Students " );
		   
		  
		   

		   do{
			   System.out.println("========= MAIN MENU ===========");
			   System.out.println(" Welcome to Student OASIS " );
			   System.out.println("===============================");
			   System.out.println(" 0. Add new Student ");
			   System.out.println(" 1. Edit existing student ");
			   System.out.println(" 2. View all student ");
			   System.out.println(" 3. Filter by Course: ");
			   System.out.println(" 4. Filter by Status: ");
			   System.out.println(" 5.  Highest CWA " );
			   System.out.println(" 6. Average CWA for each Course ");
			   System.out.println(" 7. Credit Analysis ");
			   System.out.println(" 8. EXIT ");

			   // choice validation !
			   System.out.print("Enter your choice ! ");

			   try{
				   choice = sc.nextInt();
				   sc.nextLine();


			   switch (choice)
			   {

			   case 0:
			           String NewStudentID;
			           String Newfirstname;
			           String Newlastname;
			           String NewcField;
			           String NewStatus;
			           int Newcredits = 0;
			           double Newcwa = 0.0;
			           int NewyLevel = 0;
			           
			           

				   if (TrackStudents >= studentRecords.length){
					   System.out.println(" Error !: Student array is full ; _ ; !! ");
					   break;
				   }

				   

				   System.out.println(" Hey ! Please enter the informations to add to the system !");

				   try {

				   System.out.print("Please enter new Student ID " + "");
				   NewStudentID = sc.nextLine();

				   System.out.print("Please enter new first name " + " ");
				   Newfirstname = sc.nextLine();

				   System.out.print("Please enter new last name" + " ");
				   Newlastname = sc.nextLine();

				   System.out.print("Please enter new course of field " + " ");
				   NewcField = sc.nextLine();

				   System.out.print("Please enter new status of the study time ('PT'/'FT')" + " ");
				   NewStatus = sc.nextLine();

				   System.out.print("Please enter new credits" + " ");
				   Newcredits = sc.nextInt();
				   
				   System.out.print("Please enter new cwa " + " ");
				   Newcwa = sc.nextDouble();
				   
				   System.out.print("Please enter new yLevel " + " ");
				   NewyLevel = sc.nextInt();


				   addNewStudent(NewStudentID, Newfirstname, Newlastname, NewcField, NewyLevel, Newcwa, NewStatus, Newcredits);

				   } catch (java.util.InputMismatchException e){
					   System.out.println(" Error: Invalid data type entered for aa filed !");
				   } catch (IllegalArgumentException e) {

					   System.out.println("Validation Error !" + e.getMessage());
				   } catch (Exception e) {

					   System.out.println(" something happend !");
				   }
				   break;

			  case 1: 
				   editStudent();
				   break;

			  case 2:
				   DisplayAllStudent();
				   break;

			  case 3: 
				   filterByCourse();
				   break;


			  case 4:
				   filterByStatus();
				   break;

			  case 5:
				   HighestCWA();
				   break;

			  case 6:
				   CalculateAverageCWA();
				   break;
			  case 7:
				   CreditAnalysis();
				  // System.out.println(" Bye ! ");
				   break;

			 case 8:
				   System.out.println("Bye !");
				   break;
			  default:
				   System.out.println("Invalid option. Please choose a number from menu !");
				   break;
			   }
			   }
			   catch (Exception e) {
				   System.out.println("An Error occured;_; ");

			   } 
			   
		   }while (choice != 8);

		   } 


		   /* ******************************************************
		    * METHOD: addNewStudent()                              *
		    * IMPORT: none                                         *
		    * EXPORT: StudentArray                                 *
		    * ******************************************************/

		    public static void addNewStudent(String NewStudentID, String Newfirstname, String Newlastname, String NewcField, int NewyLevel, double NewCwa, String NewStatus, int Newcredits)
		    {
			    try 
			    
			    {
			    
			    Student newStudent = new Student(NewStudentID, Newfirstname, Newlastname);
			    cDetails newDetails = new cDetails(NewcField, NewyLevel, NewCwa, NewStatus, Newcredits);
			    newStudent.setDetails(newDetails);
			    
			            studentRecords[TrackStudents] = newStudent;
				    TrackStudents++;

				    
				    System.out.println("The student added successfully !");
				    ExportAFile();
				    
				 } catch (Exception e) {
				 
				 System.out.println("Error adding student: " + e.getMessage());
				 
				 }
		    }

		    /* *****************************************************
		     * METHOD: editTheStudent()                            *
		     * IMPORT: none                                        *
		     * EXPORT: StudentArray                                *
		     * *****************************************************/

		    public static void editStudent()
		    {

			    System.out.print(" Which student u want to edit ? " + " ");
			    String chooseEditsID = sc.nextLine();

			    
			    Student currentStudent = findStudentwithID(chooseEditsID);

			    if(currentStudent == null) {

				    System.out.println(" Student with ID " + chooseEditsID + "not found.");
				    return;
			    }

				    System.out.print(" Enter a option to  edit (Field, yLevel, cwa, credits, status ) " + " ");
				    String Options = sc.nextLine().toLowerCase();
				    // REFERENCE !! 

				   
			try {
				cDetails details = currentStudent.getDetails();

				    if(Options.equals("cwa")) {

					    System.out.print(" Enter the new cwa ");
					    double Newcwa = sc.nextFloat();
					    details.setCwa(Newcwa);

					    // fix this later !
					    

				    } else if (Options.equals("ylevel")){

					    System.out.print(" Enter new year level ");
					    int NewyLevel = sc.nextInt();
					    details.setyLevel(NewyLevel);

				    } else if (Options.equals("cfield")){

					    System.out.print(" Enter new course of field");
					    String NewcField = sc.nextLine();
					    details.setcField(NewcField);

				

				    } else if (Options.equals("status")){

					    System.out.print(" Enter new status ");
					    String Newstatus = sc.nextLine();
					    details.setStatus(Newstatus);

				    } else if (Options.equals("credits")){

					    System.out.print(" Enter new credits ");
					    int Newcredits = sc.nextInt();
					    details.setCredits(Newcredits);

				    } else {

					    System.out.print(" You entered invalid option !");
					    return;

				    }
			} catch (Exception e) {
				System.out.println("Error updating student ! " + e.getMessage());
				sc.nextLine();
			}
			
			ExportAFile();
		    }

                        /* ******************************************************
			 * METHOD: findStudentwithID
			 * IMPORT:studentID
			 * EXPORT: studentTRecords
			 * ********************************************************/

                         private static  Student findStudentwithID(String studentID) {

				 for(int i=0; i < TrackStudents; i++){

					 // check the match with student ID
					 if(studentRecords[i] != null && studentRecords[i].getStudentID().equals(studentID)){
					 return studentRecords[i];
					 }
				 }
				 return null;
			 } 

			 /* ******************************************************
			  * METHOD: DisplayAllStudent()
			  * IMPORT: StudentRecords Array
			  * EXPORT: 
			  * *******************************************************/

			 private static void DisplayAllStudent(){

				 if(TrackStudents > 0){

				 for(int i=0; i < TrackStudents; i++){

					 Student CurrentStudent = studentRecords[i];
					 String SID = CurrentStudent.getStudentID();
					 String Name = CurrentStudent.getFirstname();
					 String Lastname = CurrentStudent.getLastname();
					 System.out.println(i + 1 +  " : " + SID + " " + Name + " " + Lastname + " ");
				 } 
				 
				 }else {

					 System.out.println(" Currently have no students on records ;_; . ");
				 
				 }
			}

		         /* *******************************************************
			  * METHOD: filterByCourse()                              *
			  * IMPORT: StudentRecorsds Array
			  * EXPORT: StudentRecords
			  * *******************************************************/

		         private static void filterByCourse(){

				 System.out.print(" Enter course to filter !");
				 String SearchCourse = sc.nextLine();

				 // set a status of the find result
				 boolean found = false;

				for(int i=0; i < TrackStudents; i++){

					Student CurrentStudent = studentRecords[i];

					// Get the details of the course from Details Class
					String ActualCourse = CurrentStudent.getDetails().getcField();

					if(ActualCourse.equals(SearchCourse)){

						System.out.println(CurrentStudent.getStudentID() + " - Course of : " + ActualCourse);
						found = true;

					}
				}

				if (!found) {

					System.out.println(" There is no student found on the course !");
				}
			 }

			 /* ******************************************************
			  * METHOD: filterByStatus()                             *
			  * IMPORT: StudentRecords                               *
			  * EXPORT: StudentRecords                               *
			  * *******************************************************/

			 public static void filterByStatus(){

				 String SearchStatus;

				 System.out.print(" Enter status to filter by ('PT'/'FT')");
				 SearchStatus = sc.nextLine();

				 boolean found = false;

				 for(int i=0; i < TrackStudents; i++){

					 Student currentStudent = studentRecords[i];

					 if (currentStudent != null && currentStudent.getDetails() != null){

					 String ActualStatus = currentStudent.getDetails().getstatus();

					 if(ActualStatus.equals(SearchStatus)){

						 System.out.println(currentStudent.getStudentID() + " - Status: " + ActualStatus );
						 found = true;
					 }
					 }

					 if(!found) {
						 System.out.println("No student found with status: ! " + SearchStatus );
					 }
				 }
			}

			/* *****************************************************
			 * METHOD: HighestCWA()
			 * IMPORT: StudentArray, TrackStudent
			 * EXPORT: 
			 * ******************************************************/

			private static void HighestCWA(){

				double HighestCWA = 0.0;
				Student highestStudent = null;

				for(int i=0; i < TrackStudents; i++){


					Student CurrentStudent = studentRecords[i];

					if(CurrentStudent != null && CurrentStudent.getDetails() != null) {

					      double cwa = CurrentStudent.getDetails().getcwa();

					      if(cwa > HighestCWA){
						      HighestCWA = cwa;
						      highestStudent = CurrentStudent;
					      }
					}
				}

				if(highestStudent != null){

					System.out.println(" iD : " +highestStudent.getStudentID());
					System.out.println(" Name : " + highestStudent.getFirstname() + " " + highestStudent.getLastname());
					System.out.printf(" CWA: %.2f%n", HighestCWA);

				} else {
					System.out.println("No students on the recoreds ;_; ");
				}
			}

			/* ******************************************************
			 * METHOD: CalculateAverageCWA()                        *
			 * IMPORT: StudentArray, TrackStudent                   *
			 * EXPORT:                                              *
			 * ******************************************************/

			private static void CalculateAverageCWA(){
			

				double AVGCwa = 0.0;
				double TotalCwa = 0.0;
				int StudentCount = 0;
				double cwa = 0.0;

				// Check for all students
				String SearchCourse;
				System.out.print("Which course of the cwa u want to see? ");
				SearchCourse = sc.nextLine();

				for(int i=0; i < TrackStudents; i++){

					Student CurrentStudent = studentRecords[i];

					if(CurrentStudent != null && CurrentStudent.getDetails() != null) {


					// Check the course
					String Course = CurrentStudent.getDetails().getcField();

					cwa = CurrentStudent.getDetails().getcwa();

					
				// Find if the course is exist
			//	String SearchCourse;

				//System.out.print(" Which course of the CWA you wan to see ?");
				//SearchCourse = sc.nextLine();

				if(SearchCourse.equals(Course)){

					cwa = CurrentStudent.getDetails().getcwa();

					TotalCwa = TotalCwa + cwa;
					StudentCount ++;
				}

					}
				}

				if(StudentCount > 0){
					AVGCwa = TotalCwa / StudentCount;
					System.out.printf("The Average CWA for Student in %s is %.2f%n", SearchCourse, AVGCwa);
				} else {
					System.out.println("No students fond for the course: " + SearchCourse);
				}
			}

			/* ***********************************************************
			 * METHOD: CreditAnalysis
			 * IMPORT: StudentRecord
			 * EXPOORT: 
			 * **********************************************************/

			private static void CreditAnalysis(){

				int GraduationC = 400;

				for(int i=0; i < TrackStudents; i++){

					Student CurrentStudent = studentRecords[i];

					if (CurrentStudent != null && CurrentStudent.getDetails() != null) {

					// Check the credits
					int Credits = CurrentStudent.getDetails().getcredits();
					String GraduateStudet = CurrentStudent.getStudentID();
					String Name = CurrentStudent.getFirstname();

					if(Credits >= 400){

						System.out.println("The studetID: " + GraduateStudet + " : " + Name);
						System.out.println("Congraturation !! You are graduating !");
					} else {
						System.out.println("The studentID: " + GraduateStudet + " : " + Name);
						System.out.println(" You do not have enogh credits to graduate yet !");
					}
					}
				}
			    }
			
			/* *************************************
			 * METHOD : readFile                   *
			 * IMPORT : entries                    *
			 * EXPORT : none                       *
			 * *************************************/
			private static int readFile(String pFilename)
			{
				FileInputStream fileStream = null;
				InputStreamReader isr;
				BufferedReader bufRdr;
				int lineNum;
				int entries = 0;
				String line;
				
				try{
					fileStream = new FileInputStream(pFilename);
					isr = new InputStreamReader(fileStream);
					bufRdr = new BufferedReader(isr);
					lineNum = 0;
					line = bufRdr.readLine();

				    while (line != null)
				    {
					    processLine(line, lineNum);
					    lineNum++;
					    line = bufRdr.readLine();
				    }
				    fileStream.close();
				}
				catch(IOException errorDetails)
				{
					if(fileStream != null)
					{
						try
						{
							fileStream.close();
						}
						catch(IOException ex2){
							// nothning we can do
						}
					}
					System.out.println("Eroor in the file: ");
				}
				return entries;
			}

			/* ********************************************************
			 * IMPORT: ExportIntoAFile                                *
			 * EXPORT: Filename, names, studentId, marks              *
			 * EXPORT: 
			 * ********************************************************/
			 
			 // what to return?
			private static void ExportAFile(){

				try (FileWriter writer = new FileWriter(FileName, false)) // false to overwrite
				{
					// Take the information from the array
					for (int i = 0; i < TrackStudents; i++)
					{
					        Student S = studentRecords[i];
					        
					        if( S != null && S.getDetails() != null){
					        cDetails Details = S.getDetails();
					        
						writer.write( S.getStudentID() + "," +
						              S.getFirstname() + "," +
						              S.getLastname() + "," +
						              Details.getcField() + "," +
						              Details.getyLevel() + "," +
						              Details.getcwa() + "," +
						              Details.getstatus() + "," +
						              Details.getcredits() +
						              System.lineSeparator());
						// REFERENCE

					}
					
				}

				} catch (IOException e) {
					System.out.println("An error occured while writing to the file ");
				}
			}

			/* *****************************************
			 * METHOD: ProcessLine                     *
			 * IMPORT csv.Row                          *
			 * EXPORT:                                 *
			 * *****************************************/
			private static void processLine(String line, int lineNum)
			{
			        //if(lineNum == 0) {
			         //  return;
			           
			         // }
			           // Skip the header  !
			           
			           
				String[] splitline = line.split(",");
				int lineLength = splitline.length;
				int NumOFcFields = 8;

				// check the attributes are match with the line elements
				if (splitline.length != NumOFcFields)
				{
					System.out.println(" Does not meet with the numbers of attributes we need");
					return;
				}

				try {

					String studentID = splitline[0].trim();
					String firstName = splitline[1].trim();
					String lastName = splitline[2].trim();

					String cField = splitline[3].trim();
					int yLevel = Integer.parseInt(splitline[4].trim());
					float cwa = Float.parseFloat(splitline[5].trim());
					String status = splitline[6].trim();
					int credits = Integer.parseInt(splitline[7].trim());

					if (studentID.isEmpty() || firstName.isEmpty() || lastName.isEmpty()){

						System.out.println("Skiipped the line due to empty data");
						return;
					}

					if (TrackStudents >= studentRecords.length) {
						System.out.println(" Array is already full can not be added anymore !");
								return;
					}

					Student newStudent = new Student(studentID, firstName, lastName);
					cDetails newDetails = new cDetails(cField, yLevel, cwa, status, credits);
					newStudent.setDetails(newDetails); //
					studentRecords[TrackStudents] = newStudent;
					TrackStudents++;

				} catch (Exception e) {

					System.out.println("Skkiped line " + lineNum + e.getMessage());
				}
			}
		}
		
		
		
		
		
		
		/* *******************************************************************************
		 * REFERENCE LIST                                                                *
		 * *******************************************************************************/
		
		
		
                /**
                * Title: OOP in Java: Classes, Objects, Encapsulation, Inheritance and Abstruction 
                * Author: Bext Tuychiev
                * Date: 2024
                * Code version: none
                * Availability: https://www.datacamp.com/tutorial/oop-in-java
                *
                **/
                
                
                
                /**
                * Title: Java InputMismatchException 
                * Author: John Stef / Stack Overflow Community Contributors
                * Date: 2013
                * Code version: none
                * Availability: https://stackoverflow.com/questions/16816250/java-inputmismatchexception
                *
                **/
                
                
                
                 /**
                * Title: Obeject Oriented Programming
                * Author: David McMeekin
                * Date: 2025
                * Code version: (Video from workshop )
                * Availability: https://www.youtube.com/@programmingdesignandimplem3805/playlists
                **/
                
                   /**
                * Title: Workshop slides 1 - 12
                * Author: David McMeekin
                * Date: 2025
                * Code version: (Slides from workshop )
                * Availability: https://lms.curtin.edu.au/ultra/courses/_149293_1/cl/outline
                **/
                
                  /**
                * Title: Java System line Separator () Method
                * Author: Ramesh Fadatare
                * Date: 2025
                * Code version: none
                * Availability: https://www.javaguides.net/2024/06/java-system-lineseparator-method.html
                **/
                
                
                
                
                
                





	











