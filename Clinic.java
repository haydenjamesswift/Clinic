import java.util.*;
import java.io.*;

public class Clinic
{
	//Initialises All Doctor Objects
	public void initialiseDoctor(Doctor[] inputArray)
	{
		for(int i = 0; i < inputArray.length; i++)
		{
			inputArray[i] = new Doctor();
		}
	}
	
	//Initialises All Pet Objects
	public void initialisePet(Pet[] inputArray)

	{
		for(int i = 0; i < inputArray.length; i++)
		{
			inputArray[i] = new Pet();
		}
	}
		
	//Finds the Next Empty Index in Pet Array
	public int nextBlankPet(Pet[] inputArray)
	{
		int nextPet = 0;
		for(int i = 0; i < inputArray.length; i++)
		{
			if (inputArray[i].getName().equals(""))
			{
				nextPet = i;
				i = inputArray.length;
			}
		}
		return nextPet;
	}
	
	//Finds the Next Empty Index in Doctor Array
	public int nextBlankDoctor(Doctor[] inputArray)
	{
		int nextDoctor = 0;
		
		for(int i = 0; i < inputArray.length; i++)
		{
			if (inputArray[i].getName().equals(""))
			{
				nextDoctor = i;
				i = inputArray.length;
			}
		}
		return nextDoctor;
	}
	
	//Returns Index Value for the Pet that the User has Selected
	public int responsePet(Pet[] inputArray, String response)
	{
		int responseValue = 0;
		int errorValue = 999;
		
		if (response.equalsIgnoreCase("cancel"))
		{
			return errorValue;
		}
		else
		{
			for (int i = 0; i<inputArray.length; i++)
			{
				if(inputArray[i].getName().equalsIgnoreCase(response))
				{
					responseValue = i;
					return responseValue;
				}
			}
		}
		return errorValue;	
	}
	
	//Returns Index Value for the Doctor that the User has Selected
	public int responseDoctor(Doctor[] inputArray, String response)
	{
		int responseValue = 0;
		
		for (int i = 0; i<inputArray.length; i++)
		{
			if(inputArray[i].getName().equalsIgnoreCase(response))
			{
				responseValue = i;
			}
			else
			{
				responseValue = -1;
			}
		}
		return responseValue;
	}
	
	public boolean errorCheck(int responseValue)
	{
		boolean error = false;
		
		if(responseValue > -1)
		{
			error = false;
		}
		else
		{
			error = true;
		}
		return error;
	}
	
	
	
	//Prints a List of All Pets, Used When Presenting Pets for User to Choose From.
	public void printPetList(Pet[] inputArray)
	{
		for(int i = 0; i < nextBlankPet(inputArray); i++) 
		{
		    System.out.println(inputArray[i].getName());
		}
		System.out.println("Cancel.");
	}
	
	//Prints a List of All Doctors, Used When Presenting Doctors for User to Choose From.
	public void printDoctorList(Doctor[] inputArray)
	{
		for(int i = 0; i < inputArray.length; i++) 
		{
		    if(!inputArray[i].getName().equals(""))
	    	{
		    	System.out.println(inputArray[i].getName());
	    	}
		}
		System.out.println("Cancel.");
	}
	
	public boolean errorDoctor(Doctor[] inputArray, String response)
	{
		boolean errorValue = false;
		for(int i = 0; i<inputArray.length;)
		{
			if (response.equalsIgnoreCase(inputArray[i].getName()))
			{
				errorValue = true;
				break;
			}
			else
			{
				errorValue = false;
			}
		}
		return errorValue;
	}
	
	public boolean errorPet(Pet[] inputArray, String response)
	{
		boolean errorValue = true;
		for(int i = 0; i<inputArray.length;)
		{
			if (response.equalsIgnoreCase(inputArray[i].getName()))
			{
				errorValue = true;
			}
			else
			{
				errorValue = false;
			}
		}
		return errorValue;
	}
	
	public Doctor[] resizeDoctor(Doctor[] inputArray, int plus)
	{
		Doctor[] resizedArray = new Doctor[inputArray.length+plus];
		
		for(int i = 0; i < resizedArray.length; i++)
		{
			resizedArray[i]=inputArray[i];
		}
		
		return resizedArray;
	}
	
	public Pet[] resizePet(Pet[] inputArray, int plus)
	{
		Pet[] resizedArray = new Pet[inputArray.length+plus];
		
		for(int i = 0; i < resizedArray.length; i++)
		{
			resizedArray[i]=inputArray[i];
		}
		
		return resizedArray;
	}

	//-----------------------------------------------MAIN METHOD-------------------------------------------------//
	
	private void run() 
	{
		Scanner keyboard = new Scanner(System.in);
		
		//initialise Check
		int check = 0;
		int check2 = 0;
		
		//Initialise Count
		int count = 0;
		int numberOfDoctors = 0;
		int numberOfPets = 0;
		
		//Initialise Arrays
		Doctor[] doctors = new Doctor[3];
		initialiseDoctor(doctors);
		Pet[] pets = new Pet[1000];
		initialisePet(pets);
		
		//Initialise Checks
		int nextPet = 0;
		int nextDoctor = 0;
		int targetPet = 0;
		int targetDoctor = 0;
		
		//Initisialise Strings
		String responseMain = ""; 
		String responseDeleteDoctor = "";
		String responseDeletePet = "";
		String responsePrintDoctor = "";
		String responsePrintPet = "";
		String responsePetAssign = "";
		String responseDoctorAssign = "";
		String responseChangeDoctor = "";
		String responseAnalyse = "";
		String responseDoctorPetList = "";
		String specialisationText = "";		
		String name = "";
		
		//Initialise Pet Characteristics
		String type = "";
		String size = "";
		int weight = 0;
		int age = 0;
		String petDoctor = "";
	
		//Main Loop
		while (count < 100)
		{
			System.out.println("What would you like to do?");
			System.out.println("A. Add a Doctor.");
			System.out.println("B. Add a Pet.");
			System.out.println("C. Assign a Doctor.");
			System.out.println("D. Analyse a Pet.");
			System.out.println("E. Delete a Doctor.");
			System.out.println("F. Delete a Pet.");
			System.out.println("G. Print a Doctors Information.");
			System.out.println("H. Print a Pets Information.");
			System.out.println("I. Print a List of Pets Under a Specific Doctor.");
			System.out.println("J. Exit.");
			
			responseMain = keyboard.nextLine();
				
			if (responseMain.equalsIgnoreCase("Add doctor") || responseMain.equalsIgnoreCase("A"))//If user selects Add Doctor
			{
				numberOfDoctors++;
				if (numberOfDoctors > 3)
				{
					doctors = resizeDoctor(doctors, 1);
				}
				System.out.println("No: "+numberOfDoctors);
				
				check2 = 0;
				while (check2 ==0)
				{
					System.out.println("What is the name of the doctor?");
					name = keyboard.nextLine();
					for(int i = 0; i < doctors.length; i++)
					{
						if (name.equalsIgnoreCase(doctors[i].getName()))
						{
							System.out.println("This doctor already exists.");
							i = doctors.length;
							check2 = 0;
						}
						else
						{
							check2 = 1;
						}
					}
				}
				check2 = 0;
				
				while (check2 == 0)
				{
					System.out.println("What is the doctors specialisation?");
					specialisationText = keyboard.nextLine();
					if (specialisationText.equalsIgnoreCase("Dog")) //Specialisation must be either Cat or Dog
					{
						specialisationText = "Dog";
						check2 = 1;
					}
					else if (specialisationText.equalsIgnoreCase("Cat")) //Specialisation must be either Cat or Dog
					{
						specialisationText = "Cat";
						check2 = 1;
					}
					else
					{
						System.out.println("Invalid input. Please try again."); //If not Cat or Dog, Invalid Input.
						check2 = 0;
					}	
				}
				nextDoctor = nextBlankDoctor(doctors);//Finds next empty index in doctor array. This will be where new doctor is added. 
				doctors[nextDoctor].setInfo(name, specialisationText);
				System.out.println(doctors[nextDoctor].getName()+" has been added successfully!");
			}
			else if (responseMain.equalsIgnoreCase("Add pet") || responseMain.equalsIgnoreCase("B"))	
			{
				numberOfPets++;
				if (numberOfPets > 3)
				{
					pets = resizePet(pets, 1);
				}
				
				//Pets Name
				check2 = 0;
				while (check2 == 0)
				{
					System.out.println("What is the name of the pet?"); //Ask Pets Name
					name = keyboard.nextLine();
					
					for(int i = 0; i < pets.length; i++)
					{
						if (name.equalsIgnoreCase(pets[i].getName()))
						{
							System.out.println("This pet already exists.");
							i = pets.length;
							check2 = 0;
						}
						else
						{
							check2 = 1;
						}
					}
				}
				
				//Pets Type
				check = 0;
				while(check == 0)
				{
					System.out.println("Is your pet a cat or a dog?"); //Ask Pets Type
					type = keyboard.nextLine();
					
					if (type.equalsIgnoreCase("Dog")) //Checks if pet is a dog. 
					{
						type = "Dog";
						check = 1;
					}
					else if (type.equalsIgnoreCase("Cat")) //Checks if pet is a cat
					{
						type = "Cat";
						check = 1;
					}
					else
					{
						System.out.println("Invalid input. Please try again."); //Invalid if not Cat or Dog
						check = 0;
					}
				}
				
				//Pets Size
				check = 0;
				while(check == 0)
				{
					System.out.println("What size is your pet?"); //Asks Pet Size
					size = keyboard.nextLine();
				
					if (size.equalsIgnoreCase("Small")) //Pet Size must be either Small, Medium or Large
					{
						size = "Small";
						check = 1;
					}
					else if (size.equalsIgnoreCase("Medium"))//Pet Size must be either Small, Medium or Large
					{
						size = "Medium";
						check = 1;
					}
					else if (size.equalsIgnoreCase("Large")) //Pet Size must be either Small, Medium or Large
					{
						size = "Large";
						check = 1;
					}
					else
					{
						System.out.println("Invalid input. Please try again."); //Invalid if not Small, Medium or Large. 
						check = 0;
					}
				}
				
				//Pets Weight
				check = 0; 
				while(check == 0)
				{
					System.out.println("How much does the pet weight?"); 
					weight = keyboard.nextInt();
				
					if (weight<0)
					{
						System.out.println("Invalid input. Please try again."); //Weight must be a positive number. 
						check = 0;
					}
					else
					{
						check = 1;
					}
				}
				
				//Pets Age
				check = 0; 
				while(check == 0)
				{
					System.out.println("How old is the pet?"); //Asks Pet Age. 
					age = keyboard.nextInt();
				
					if (age<0)
					{
						System.out.println("Invalid input. Please try again."); //Age must be a positive number.
						check = 0;
					}
					else
					{
						check = 1;
					}
				}
				
				//Pets Default Doctor
				petDoctor = "No Doctor Assigned"; 
				
				nextPet = nextBlankPet(pets);
				pets[nextPet].setInfo(name, type, size, weight, age, petDoctor);	
			}
			else if (responseMain.equalsIgnoreCase("Assign Doctor") || responseMain.equalsIgnoreCase("C"))
			{
				
				if(pets[0].getName().equals(""))//If first index in Pet Array is empty, there are no pets.
				{
					System.out.println("No Pets");
				}
				else //If first index in Pet Array is not empty, there are pets.
				{
					check = 0;
					check2 = 0;
					int check3 = 0;
					
					while (check == 0)
					{
						System.out.println("Which pet would you like to assign a doctor to?");
						
						printPetList(pets);
						responsePetAssign = keyboard.nextLine();
						
						targetPet = responsePet(pets, responsePetAssign);
						
						if (responsePetAssign.equalsIgnoreCase("Cancel"))//Exit loop is user wants to cancel.
						{
							check = 1;
						}
						else if (!pets[targetPet].getPetDoctor().equals("No Doctor Assigned") && (errorCheck(targetPet)==false)) //User has input a valid pet and desired pet already has a doctor assigned.  
						{
							while(check3 == 0)
							{
								System.out.println(pets[targetPet].getName()+" already has a doctor assigned. Would you like to change their doctor?");
								System.out.println("Yes? or No?");
								responseChangeDoctor = keyboard.nextLine();
								
								if(responseChangeDoctor.equalsIgnoreCase("Yes"))
								{
									while (check2 == 0)
									{
										System.out.println("Which doctor would you like to assign "+pets[targetPet].getName()+" to?");
										
										printDoctorList(doctors);
										responseDoctorAssign = keyboard.nextLine();
										
										targetDoctor = responseDoctor(doctors, responseDoctorAssign);
									
										if (responseDoctorAssign.equalsIgnoreCase("Cancel"))
										{
											check =1;
											check2 = 1;
											check3 =1;
										}
										else if(pets[targetPet].getType().equals(doctors[targetDoctor].getSpecialisation())&& (errorDoctor(doctors, responseDoctorAssign) == true))
										{
											pets[targetPet].setPetDoctor(doctors[targetDoctor].getName());
											System.out.println(pets[targetPet].getName()+"'s doctor has been set to "+doctors[targetDoctor].getName());
											check = 1;
											check2 = 1;
											check3 = 1;
										}
										else if (!pets[targetPet].getType().equals(doctors[targetDoctor].getSpecialisation())&& (errorDoctor(doctors, responseDoctorAssign) == true))
										{
											System.out.println("This doctor is not qualified to take care of this pet. Please try again.");
											check2 = 0;
										}
										else if(errorDoctor(doctors, responseDoctorAssign) == false)
										{
											System.out.println("Cannot find this doctor in our system. Please try again.");
											check2 = 0;
										}
									}
								}
								else
								{
									check3 = 1;
									check = 1;
								}
							}
						}
						else if (errorCheck(targetPet)==false) //User has input a valid pet name and desired pet does not already have a doctor assigned.
						{
							while (check2 == 0)
							{
								System.out.println("Which doctor would you like to assign this pet to?");
								
								printDoctorList(doctors);
								responseDoctorAssign = keyboard.nextLine();
								
								targetDoctor = responseDoctor(doctors, responseDoctorAssign);
								
								if (responseDoctorAssign.equalsIgnoreCase("Cancel"))
								{
									check =1;
									check2 = 1;
									check3 =1;
								}
								else if(pets[targetPet].getType().equals(doctors[targetDoctor].getSpecialisation())&& (errorDoctor(doctors, responseDoctorAssign)==true))
								{
									pets[targetPet].setPetDoctor(doctors[targetDoctor].getName());
									System.out.println(pets[targetPet].getName()+"'s doctor has been set to "+doctors[targetDoctor].getName());
									check2 = 1;
									check = 1;	
								}
								else if (!pets[targetPet].getType().equals(doctors[targetDoctor].getSpecialisation())&& (errorDoctor(doctors, responseDoctorAssign)==true))
								{
									System.out.println("This doctor is not qualified to take care of this pet");
									System.out.println("Please try again.");
									check2 = 0;
								}	
								else if (errorDoctor(doctors, responseDoctorAssign) == false)
								{
									System.out.println("Cannot find this doctor in our system. Please try again.");
									check2 = 0;
								}
							}
						}	
						else if (errorCheck(targetPet)==true)//User has not input a valid pet name. Asks them to try again.
						{
							System.out.println("Cannot find this pet in our system. Please try again.");
							check = 0;
						}
					}
				}
			}
			else if (responseMain.equalsIgnoreCase("Analyse pet")|| responseMain.equalsIgnoreCase("D")) //User wants to analyse a specific pet.
			{
				check = 0;
				
				while (check == 0)
				{
					System.out.println("Which pet would you like to analyse?");
					printPetList(pets);
					responseAnalyse = keyboard.nextLine();
					
					targetPet = responsePet(pets, responseAnalyse);
					
					if (responseAnalyse.equalsIgnoreCase("cancel"))//User wants to cancel. Exit loop and send user back to home page. 
					{
						check = 1;
					}
					else if(pets[targetPet].getType().equals("Dog") && errorCheck(targetPet)==false)//User has input a valid pet name and desired pet is a dog.
					{
						pets[targetPet].analyseDog();
						check = 1;
					}
					else if(pets[targetPet].getType().equals("Cat")&& errorCheck(targetPet)==false)//User has input a valid pet name and desired pet is a cat.
					{
						pets[targetPet].analyseCat();
						check = 1;
					}
					else if(errorCheck(targetPet)==true) //User has not input a valid pet name. Ask them to try again. 
					{
						System.out.println("Cannot find this pet in our system. Please try again.");
						check = 0;
					}
				}
			}				
			else if (responseMain.equalsIgnoreCase("Delete doctor") || responseMain.equalsIgnoreCase("E")) //User wants to delete a doctor.
			{
				if(doctors[0].getName().equals("")) //If first index in Doctor Array is empty, there are no doctors.
				{
					System.out.println("No results found.");
				}
				else //If first index in Doctor Array is not empty, there are doctors. 
				{
					check = 0;
					while (check == 0)
					{
						System.out.println("Which doctor would you like to delete?");
						printDoctorList(doctors);
						responseDeleteDoctor = keyboard.nextLine(); //User inputs desired doctors name to delete.
						
						targetDoctor = responseDoctor(doctors, responseDeleteDoctor); //Finds the index of the desired doctor.
						
						if(responseDeleteDoctor.equalsIgnoreCase("cancel")) //User wants to cancel. Exit loop and send user back to home page. 
						{
							check = 1;
						}
						else if(errorDoctor(doctors, responseDeleteDoctor)==true) //User has input a valid doctor name. 
						{
							doctors[targetDoctor].deleteDoctor(); //Deletes doctor in this index.
							
							for(int i = targetDoctor; i < doctors.length-1; i++) //This loop shuffles all doctors in index positions greater than the doctor that has been deleted down one position. 
							{
								doctors[i].setName(doctors[i+1].getName());
								doctors[i].setSpecialisation(doctors[i+1].getSpecialisation());
							}
							check = 1;
						}
						else if(errorDoctor(doctors, responseDeleteDoctor)==false)//User has not input a valid doctor name. Ask them to try again. 
						{
							System.out.println("Cannot find this doctor in our system. Please try again.");
							check = 0;
						}
					}	
				}
			}
			else if (responseMain.equalsIgnoreCase("Delete pet") || responseMain.equalsIgnoreCase("F")) //User wants to delete a pet.
			{
				if(pets[0].getName().equals("")) //If first index in Pet Array is empty, there are not pets.
				{
					System.out.println("No results found.");
				}
				else //If first index in Pet Array is not empty, there are pets.
				{
					check = 0;
					while (check == 0)
					{
						System.out.println("Which pet would you like to delete?");
						printPetList(pets);
						responseDeletePet = keyboard.nextLine(); //User inputs desired pets name to delete.
						
						targetPet = responsePet(pets, responseDeletePet);//Finds index position for desired pet.
						
						if(responseDeletePet.equalsIgnoreCase("cancel")) //User wants to cancel. Exit loop and sent user back to home page.
						{
							check = 1;
						}
						else if(errorPet(pets, responseDeletePet)==true) //User has input a valid pet name. Delete this pet.
						{
							pets[targetPet].deletePet();
							
							for(int i = targetPet; i < pets.length-1; i++) //Shuffle all pets after desired pet down one position to fill gap. 
							{
								pets[i].setName(pets[i+1].getName());
								pets[i].setType(pets[i+1].getType());
								pets[i].setSize(pets[i+1].getSize());
								pets[i].setWeight(pets[i+1].getWeight());
								pets[i].setAge(pets[i+1].getAge());
								pets[i].setPetDoctor(pets[i+1].getPetDoctor());
							}
							check = 1;
						}
						else if(errorPet(pets, responseDeletePet)==false) //User has not input a valid pet name. Ask them to try again.
						{
							System.out.println("Cannot find this pet in our system. Please try again.");
							check = 0;
						}
					}	
				}
			}
			else if (responseMain.equalsIgnoreCase("Print doctor information")|| responseMain.equalsIgnoreCase("G")) //User wants to print a doctors information.
			{
				if (doctors[0].getName().equals("")) //If first index in Doctor Array is empty, there are no doctors.
				{
					System.out.println("No Doctors");
				}
				else //If first index in Doctor Array is not empty, there are doctors.
				{
					check = 0;
					while (check == 0)
					{
						System.out.println("Which doctors information would you like to print");
					
						printDoctorList(doctors);
						responsePrintDoctor = keyboard.nextLine();
						
						targetDoctor = responseDoctor(doctors, responsePrintDoctor);
					
						if(responsePrintDoctor.equalsIgnoreCase("cancel")) //User wants to cancel. Exit loop and send user to home page.
						{
							check = 1;
						}
						else if (errorCheck(targetDoctor)==false) //User has input a valid doctor name. Print information for this doctor.
						{
							doctors[targetDoctor].printDoctor();
							check = 1;
						}
						else if (errorCheck(targetDoctor)==true)//User has not input a valid doctor name. Ask them to try again.
						{
							System.out.println("Cannot find this doctor in our system.");
							check = 0;
						}
					}
				}
			}
			else if (responseMain.equalsIgnoreCase("Print pet information")|| responseMain.equalsIgnoreCase("H")) //User wants to print pet information.
			{	
				if (pets[0].getName().equals(""))//If first index in Pet Array is empty, there are no pets.
				{
					System.out.println("No Pets"); //If first index in Pet Array is not empty, there are pets
				}
				else
				{
					check = 0;
					while (check == 0)
					{
						System.out.println("Which pets information would you like to print");
						
						printPetList(pets);
						responsePrintPet = keyboard.nextLine();
						
						targetPet = responsePet(pets, responsePrintPet);
					
						if(responsePrintPet.equalsIgnoreCase("cancel")) //Users wants to cancel. Exit loop and return to home page.
						{
							check = 1;
						}
						else if (errorPet(pets, responsePrintPet)==true) //User has input a valid pet name. Print information for this pet.
						{
							pets[targetPet].printPet();
							check = 1;
						}
						else if (errorPet(pets, responsePrintPet)==false) //User has not input a valid pet name. Ask them to try again.
						{
							System.out.println("Cannot find this pet in our system.");
							check = 0;
						}
					}
				}
			}	
			else if (responseMain.equalsIgnoreCase("I")) //User wants to print pet information for a specific doctor.
			{
				if(doctors[0].getName().equals("")) //If first index in Doctor Array is empty, there are no doctors
				{
					System.out.println("There are no doctors in the system.");
				}
				else //If first index in Doctor Array is  not empty, there are doctors
				{
					check = 0;
					while (check == 0)
					{
						String doctorPrintOut = "";
						int petCount = 0;
						
						System.out.println("Which doctor would you like to print pet information for?");
						printDoctorList(doctors);
						responseDoctorPetList = keyboard.nextLine();
						
						targetDoctor = responseDoctor(doctors, responseDoctorPetList);
						
						if(responseDoctorPetList.equalsIgnoreCase("Cancel")) //User wants to cancel. Return to main menu.
						{
							check = 1;
						}
						else if (errorDoctor(doctors, responseDoctorPetList)==true) //User has input a valid doctor name.
						{
							for(int i = 0; i<pets.length; i++) //Compares desired doctors name with every pets assigned doctor.
							{
								if(pets[i].getPetDoctor().equalsIgnoreCase(doctors[targetDoctor].getName())) //If a pets doctor is the same as desired doctors name, add this pets name to the list. 
								{
									doctorPrintOut = doctorPrintOut + pets[i].getName() + "\n";
									petCount++;
								}
							}
							if (petCount > 0) //If pet count has been increment, then this doctor does have pets assigned to them.
							{
								System.out.println("The pets under "+doctors[targetDoctor].getName()+"'s care are:"); //Prints the list.
								System.out.println(doctorPrintOut);
								check = 1;
							}
							else //If pet count has not been incremented, there are no pets under this doctor.
							{
								System.out.println("There are no pets under "+doctors[targetDoctor].getName()+"'s care."); 
								check = 1;
							}
						}
						else if (errorDoctor(doctors, responseDoctorPetList)==false) //User has not input a valid doctor name. Ask them to try again.
						{
							System.out.println("Cannot find this doctor in our system. Please try again.");
							check = 0;
						}
					}
				}
			}
			else if (responseMain.equalsIgnoreCase("Save"))
			{
				String fileName = "VetManagement.txt";
				PrintWriter outputStream = null;
				
				try 
				{
					outputStream = new PrintWriter (fileName);
				}
				catch (Exception e) 
				{
					System.out.println("Cannot find this file.");
				}
				outputStream.println("Doctors");
				for(int i = 0; i<doctors.length;i++)
				{
					outputStream.println("name "+doctors[i].getName());
					outputStream.println("specialisation "+doctors[i].getSpecialisation());
				}
				outputStream.println("");
				outputStream.println("Pets");
				for(int i = 0;i<pets.length;i++)
				{
					outputStream.println("name "+pets[i].getName());
					outputStream.println("type "+pets[i].getType());
					outputStream.println("size "+pets[i].getSize());
					outputStream.println("weight "+pets[i].getWeight());
					outputStream.println("age "+pets[i].getAge());
					outputStream.println("doctor "+pets[i].getPetDoctor());
				}
				outputStream.close();
			}
			else if (responseMain.equalsIgnoreCase("J")||responseMain.equalsIgnoreCase("Exit")) //User wants to exit. 
			{
				System.exit(0);
			}
			System.out.println("-------------------------------------------------------------");
		}
	}
		
	public static void main(String[] args)
	{
		Clinic clinic = new Clinic();
		clinic.run();
		
	}
}
