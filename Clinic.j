import java.util.Scanner;

import javax.xml.ws.Response;

public class Clinic 
{
	
	private void run() 
	{
		Scanner keyboard = new Scanner(System.in);
		
		//initialise Check
		int check = 0;
		int check2 = 0;
		//Initialise Count
		int count = 0;
		
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
		String name = "";
		
		//Initialise Doctors
		Doctor doctor1 = new Doctor();
		doctor1.setNameDefault();
		Doctor doctor2 = new Doctor();
		doctor2.setNameDefault();
		
		//Initialise Pets
		Pet pet1= new Pet();
		pet1.setNameDefault();
		Pet pet2 = new Pet();
		pet2.setNameDefault();
		Pet pet3 = new Pet();
		pet3.setNameDefault();
		Pet pet4 = new Pet();
		pet4.setNameDefault();
		
		//Main Loop
		while (count < 100)
		{
			System.out.println("What would you like to do?");
			System.out.println("A. Add doctor.");
			System.out.println("B. Add pet.");
			System.out.println("C. Assign doctor.");
			System.out.println("D. Analyse pet.");
			System.out.println("E. Delete doctor.");
			System.out.println("F. Delete pet.");
			System.out.println("G. Print doctor information.");
			System.out.println("H. Print pet information.");
			System.out.println("I. Print pet list for specific doctor.");
			System.out.println("J. Exit.");
			
			responseMain = keyboard.nextLine();
				
			if (responseMain.equalsIgnoreCase("Add doctor") || responseMain.equalsIgnoreCase("A"))
			{	
				if (doctor1.getName().equalsIgnoreCase(""))
				{
					check = 0;
					
					while (check == 0)
					{
						System.out.println("What is the name of the doctor?");
						name = keyboard.nextLine();
						
						if (name.equalsIgnoreCase(doctor2.getName()))
						{
							System.out.println("This doctor already exists.");
							System.out.println("----------------------------------------------------------------");
							check = 0;
						}
						else
						{
							doctor1.addDoctor(name);
							System.out.println("Doctor 1 added successfully.");
							check = 1;
						}
					}
				}
				else if (doctor2.getName().equalsIgnoreCase(""))
				{
					check = 0;
					
					while (check == 0)
					{
						System.out.println("What is the name of the doctor?");
						name = keyboard.nextLine();
						
						if (name.equalsIgnoreCase(doctor1.getName()))
						{
							System.out.println("This doctor already exists.");
							System.out.println("----------------------------------------------------------------");
							check = 0;
						}
						else
						{
							doctor2.addDoctor(name);
							System.out.println("Doctor 2 added successfully.");
							check = 1;
						}
					}
				}
				else
				{
					System.out.println("Maximum number of doctors reached.");
				}
			}	
			else if (responseMain.equalsIgnoreCase("Add pet") || responseMain.equalsIgnoreCase("B"))	
			{
				if (pet1.getName().equalsIgnoreCase(""))
				{
					check = 0;
					
					while (check == 0)
					{
						System.out.println("What is your pets name?");
						name = keyboard.nextLine();
						
						if (name.equalsIgnoreCase(pet2.getName()) || name.equalsIgnoreCase(pet3.getName()) || name.equalsIgnoreCase(pet4.getName()))
						{
							System.out.println("This pet already exists.");
							check = 0;
						}
						else 
						{
							pet1.addPet(name);
							check = 1;
						}
					}
				}
				else if (pet2.getName().equalsIgnoreCase(""))
				{
					check = 0;
					
					while (check == 0)
					{
						System.out.println("What is your pets name?");
						name = keyboard.nextLine();
						
						if (name.equalsIgnoreCase(pet1.getName()) || name.equalsIgnoreCase(pet3.getName()) || name.equalsIgnoreCase(pet4.getName()))
						{
							System.out.println("This pet already exists.");
							check = 0;
						}	
						else 
						{
							pet2.addPet(name);
							check = 1;
						}
					}
				}
				else if (pet3.getName().equalsIgnoreCase(""))
				{
					check = 0; 
					
					while (check == 0)
					{
						System.out.println("What is your pets name?");
						name = keyboard.nextLine();
						
						if (name.equalsIgnoreCase(pet1.getName()) || name.equalsIgnoreCase(pet2.getName()) || name.equalsIgnoreCase(pet4.getName()))
						{
							System.out.println("This pet already exists.");
							check = 0;
						}
						else 
						{
							pet3.addPet(name);
							check = 1;
						}
					}
				}
				else if (pet4.getName().equalsIgnoreCase(""))
				{
					check = 0;
					
					while (check == 0)
					{
						System.out.println("What is your pets name?");
						name = keyboard.nextLine();
						
						if (name.equalsIgnoreCase(pet1.getName()) || name.equalsIgnoreCase(pet2.getName()) || name.equalsIgnoreCase(pet3.getName()))
						{
							System.out.println("This pet already exists.");
							check = 0;
						}
						else 
						{
							pet4.addPet(name);
							check = 1;
						}
					}
				}
				else
				{
					System.out.println("Maximum number of pets reached.");
				}		
			}
			else if (responseMain.equalsIgnoreCase("Assign Doctor") || responseMain.equalsIgnoreCase("C"))
			{
				check2 = 0;
		
				while (check2 == 0)
				{
					System.out.println("Which pet would you like to assign a doctor to?");
					System.out.println("A. "+pet1.getName());
					System.out.println("B. "+pet2.getName());
					System.out.println("C. "+pet3.getName());
					System.out.println("D. "+pet4.getName());
					responsePetAssign = keyboard.nextLine();
	
					if (responsePetAssign.equalsIgnoreCase(pet1.getName())||responsePetAssign.equalsIgnoreCase("A"))
					{
						check2 = 1;
		
						if (pet1.getPetDoctor().equalsIgnoreCase("No Doctor Assigned"))
						{
							check = 0;
	
							while (check == 0)
							{
								System.out.println("Which doctor would you like to assign " +pet1.getName() +" to?");
								System.out.println("A. "+doctor1.getName());
								System.out.println("B. "+doctor2.getName());
								System.out.println("Cancel");
								responseDoctorAssign = keyboard.nextLine();

								if (responseDoctorAssign.equalsIgnoreCase(doctor1.getName()))
								{
									if(pet1.getType().equalsIgnoreCase(doctor1.getSpecialisation()))
									{
										pet1.setPetDoctor(responseDoctorAssign);
										check = 1;
									}
									else
									{
										System.out.println("Your chosen doctor is not qualified for " +pet1.getType()+"s. Please Try again.");
										check = 0;
									}
								}	
								else if (responseDoctorAssign.equalsIgnoreCase(doctor2.getName()))
								{
									if(pet1.getType().equalsIgnoreCase(doctor2.getSpecialisation()))
									{
										pet1.setPetDoctor(responseDoctorAssign);
										check = 1;
									}
									else
									{
										System.out.println("Your chosen doctor is not qualified for " +pet1.getType()+"s. Please try again.");
										check = 0;
									}
								}
								else if (responseDoctorAssign.equalsIgnoreCase("cancel"))
								{
									check = 1;
								}
								else 
								{
									System.out.println("This doctor does not exist.");
									check = 0;
								}
							}
						}
						else
						{
						System.out.println(pet1.getName()+" already has "+pet1.getPetDoctor()+" assigned. Would you like to change doctors? Yes or No?");
						responseChangeDoctor = keyboard.nextLine();

							if (responseChangeDoctor.equalsIgnoreCase("No"))
							{
								System.out.println(pet1.getName()+"'s doctor will remain as " +pet1.getPetDoctor());
							}
							else if (responseChangeDoctor.equalsIgnoreCase("Yes"))
							{
								check = 0;

								while (check == 0)
								{
									System.out.println("Which doctor would you like to assign " +pet1.getName() +" to?");
									System.out.println("A. "+doctor1.getName());
									System.out.println("B. "+doctor2.getName());
									System.out.println("Cancel");
									responseDoctorAssign = keyboard.nextLine();

									if (responseDoctorAssign.equalsIgnoreCase(doctor1.getName()))
									{
										if(pet1.getType().equalsIgnoreCase(doctor1.getSpecialisation()))
										{
											pet1.setPetDoctor(responseDoctorAssign);	
											check = 1;
										}
										else
										{
											System.out.println("Your chosen doctor is not qualified for " +pet1.getType()+"s. Please Try again.");
											check = 0;
										}
									}
									else if (responseDoctorAssign.equalsIgnoreCase(doctor2.getName()))
									{
										if(pet1.getType().equalsIgnoreCase(doctor2.getSpecialisation()))
										{
											pet1.setPetDoctor(responseDoctorAssign);
											check = 1;
										}
										else
										{
											System.out.println("Your chosen doctor is not qualified for " +pet1.getType()+"s. Please try again.");
											check = 0;
										}
									}
									else if (responseDoctorAssign.equalsIgnoreCase("cancel"))
									{
										check = 1;
									}
									else 
									{
										System.out.println("This doctor does not exist.");
										check = 0;
									}
								}	
							}
						}
					}	
					else if (responsePetAssign.equalsIgnoreCase(pet2.getName())||responsePetAssign.equalsIgnoreCase("B"))
					{
						check2 = 1;

						if (pet2.getPetDoctor().equalsIgnoreCase("No Doctor Assigned"))
						{
							check = 0;

							while (check == 0)
							{
								System.out.println("Which doctor would you like to assign " +pet2.getName() +" to?");
								System.out.println("A. "+doctor1.getName());
								System.out.println("B. "+doctor2.getName());
								System.out.println("Cancel");
								responseDoctorAssign = keyboard.nextLine();

								if (responseDoctorAssign.equalsIgnoreCase(doctor1.getName()))
								{
									if(pet2.getType().equalsIgnoreCase(doctor1.getSpecialisation()))
									{
										pet2.setPetDoctor(responseDoctorAssign);
										check = 1;
									}
									else
									{
										System.out.println("Your chosen doctor is not qualified for " +pet2.getType()+"s. Please Try again.");
										check = 0;
									}
								}
								else if (responseDoctorAssign.equalsIgnoreCase(doctor2.getName()))
								{
									if(pet2.getType().equalsIgnoreCase(doctor2.getSpecialisation()))
									{
										pet2.setPetDoctor(responseDoctorAssign);
										check = 1;
									}
									else
									{
										System.out.println("Your chosen doctor is not qualified for " +pet2.getType()+"s. Please try again.");
										check = 0;
									}
								}
								else if (responseDoctorAssign.equalsIgnoreCase("cancel"))
								{
									check = 1;
								}
								else 
								{
									System.out.println("This doctor does not exist.");
									check = 0;
								}
							}
						}
						else
						{
							System.out.println(pet2.getName()+" already has "+pet2.getPetDoctor()+" assigned. Would you like to change doctors? Yes or No?");
							responseChangeDoctor = keyboard.nextLine();

							if (responseChangeDoctor.equalsIgnoreCase("No"))
							{
								System.out.println(pet2.getName()+"'s doctor will remain as " +pet2.getPetDoctor());
							}	
							else if (responseChangeDoctor.equalsIgnoreCase("Yes"))
							{
								check = 0;

								while (check == 0)
								{
									System.out.println("Which doctor would you like to assign " +pet1.getName() +" to?");
									System.out.println("A. "+doctor1.getName());
									System.out.println("B. "+doctor2.getName());
									System.out.println("Cancel");
									responseDoctorAssign = keyboard.nextLine();

									if (responseDoctorAssign.equalsIgnoreCase(doctor1.getName()))
									{
										if(pet2.getType().equalsIgnoreCase(doctor1.getSpecialisation()))
										{
											pet2.setPetDoctor(responseDoctorAssign);
											check = 1;
										}
										else
										{
											System.out.println("Your chosen doctor is not qualified for " +pet2.getType()+"s. Please Try again.");
											check = 0;
										}
									}
									else if (responseDoctorAssign.equalsIgnoreCase(doctor2.getName()))
									{
										if(pet2.getType().equalsIgnoreCase(doctor2.getSpecialisation()))
										{
											pet2.setPetDoctor(responseDoctorAssign);
											check = 1;
										}
										else
										{
											System.out.println("Your chosen doctor is not qualified for " +pet2.getType()+"s. Please try again.");
											check = 0;
										}
									}
									else if (responseDoctorAssign.equalsIgnoreCase("cancel"))
									{
										check = 1;
									}
									else 
									{
										System.out.println("This doctor does not exist.");
										check = 0;
									}
								}
							}
						}
					}
					else if (responsePetAssign.equalsIgnoreCase(pet3.getName())||responsePetAssign.equalsIgnoreCase("C"))
					{
						check2 = 1;
	
						if (pet3.getPetDoctor().equalsIgnoreCase("No Doctor Assigned"))
						{
							check = 0;

							while (check == 0)
							{
								System.out.println("Which doctor would you like to assign " +pet3.getName() +" to?");
								System.out.println("A. "+doctor1.getName());
								System.out.println("B. "+doctor2.getName());
								System.out.println("Cancel");
								responseDoctorAssign = keyboard.nextLine();
	
								if (responseDoctorAssign.equalsIgnoreCase(doctor1.getName()))
								{
									if(pet3.getType().equalsIgnoreCase(doctor1.getSpecialisation()))
									{
										pet3.setPetDoctor(responseDoctorAssign);
										check = 1;
									}
									else
									{
										System.out.println("Your chosen doctor is not qualified for " +pet3.getType()+"s. Please Try again.");
										check = 0;
									}
								}	
								else if (responseDoctorAssign.equalsIgnoreCase(doctor2.getName()))
								{
									if(pet3.getType().equalsIgnoreCase(doctor2.getSpecialisation()))
									{
										pet3.setPetDoctor(responseDoctorAssign);
										check = 1;
									}
									else
									{
										System.out.println("Your chosen doctor is not qualified for " +pet3.getType()+"s. Please try again.");
										check = 0;
									}
								}
								else if (responseDoctorAssign.equalsIgnoreCase("cancel"))
								{
									check = 1;
								}
								else 
								{
									System.out.println("This doctor does not exist.");
									check = 0;
								}
							}
						}
						else
						{
							System.out.println(pet3.getName()+" already has "+pet3.getPetDoctor()+" assigned. Would you like to change doctors? Yes or No?");
							responseChangeDoctor = keyboard.nextLine();

							if (responseChangeDoctor.equalsIgnoreCase("No"))
							{
								System.out.println(pet3.getName()+"'s doctor will remain as " +pet3.getPetDoctor());
							}
							else if (responseChangeDoctor.equalsIgnoreCase("Yes"))
							{
								check = 0;

								while (check == 0)
								{
									System.out.println("Which doctor would you like to assign " +pet3.getName() +" to?");
									System.out.println("A. "+doctor1.getName());
									System.out.println("B. "+doctor2.getName());
									System.out.println("Cancel");
									responseDoctorAssign = keyboard.nextLine();

									if (responseDoctorAssign.equalsIgnoreCase(doctor1.getName()))
									{
										if(pet3.getType().equalsIgnoreCase(doctor1.getSpecialisation()))
										{
											pet3.setPetDoctor(responseDoctorAssign);	
											check = 1;
										}
										else
										{
											System.out.println("Your chosen doctor is not qualified for " +pet3.getType()+"s. Please Try again.");
											check = 0;
										}
									}
									else if (responseDoctorAssign.equalsIgnoreCase(doctor2.getName()))
									{
										if(pet3.getType().equalsIgnoreCase(doctor2.getSpecialisation()))
										{
											pet3.setPetDoctor(responseDoctorAssign);
											check = 1;
										}
										else
										{
											System.out.println("Your chosen doctor is not qualified for " +pet3.getType()+"s. Please try again.");
											check = 0;
										}
									}
									else if (responseDoctorAssign.equalsIgnoreCase("cancel"))
									{
										check = 1;
									}
									else 
									{
										System.out.println("This doctor does not exist.");
										check = 0;
									}
								}	
							}
						}
					}
					else if (responsePetAssign.equalsIgnoreCase(pet4.getName())||responsePetAssign.equalsIgnoreCase("D"))
					{
						check2 = 1;
		
						if (pet4.getPetDoctor().equalsIgnoreCase("No Doctor Assigned"))
						{
							check = 0;
	
							while (check == 0)
							{
								System.out.println("Which doctor would you like to assign " +pet4.getName() +" to?");
								System.out.println("A. "+doctor1.getName());
								System.out.println("B. "+doctor2.getName());
								System.out.println("Cancel");
								responseDoctorAssign = keyboard.nextLine();

								if (responseDoctorAssign.equalsIgnoreCase(doctor1.getName()))
								{
									if(pet4.getType().equalsIgnoreCase(doctor1.getSpecialisation()))
									{
										pet4.setPetDoctor(responseDoctorAssign);
										check = 1;
									}
									else
									{
										System.out.println("Your chosen doctor is not qualified for " +pet4.getType()+"s. Please Try again.");
										check = 0;
									}
								}	
								else if (responseDoctorAssign.equalsIgnoreCase(doctor2.getName()))
								{
									if(pet1.getType().equalsIgnoreCase(doctor2.getSpecialisation()))
									{
										pet4.setPetDoctor(responseDoctorAssign);
										check = 1;
									}
									else
									{
										System.out.println("Your chosen doctor is not qualified for " +pet4.getType()+"s. Please try again.");
										check = 0;
									}
								}
								else if (responseDoctorAssign.equalsIgnoreCase("cancel"))
								{
									check = 1;
								}
								else 
								{
									System.out.println("This doctor does not exist.");
									check = 0;
								}
							}
						}
						else
						{
							System.out.println(pet1.getName()+" already has "+pet4.getPetDoctor()+" assigned. Would you like to change doctors? Yes or No?");
							responseChangeDoctor = keyboard.nextLine();

							if (responseChangeDoctor.equalsIgnoreCase("No"))
							{
								System.out.println(pet1.getName()+"'s doctor will remain as " +pet4.getPetDoctor());
							}
							else if (responseChangeDoctor.equalsIgnoreCase("Yes"))
							{
								check = 0;

								while (check == 0)
								{
									System.out.println("Which doctor would you like to assign " +pet4.getName() +" to?");
									System.out.println("A. "+doctor1.getName());
									System.out.println("B. "+doctor2.getName());
									System.out.println("Cancel");
									responseDoctorAssign = keyboard.nextLine();

									if (responseDoctorAssign.equalsIgnoreCase(doctor1.getName()))
									{
										if(pet4.getType().equalsIgnoreCase(doctor1.getSpecialisation()))
										{
											pet4.setPetDoctor(responseDoctorAssign);	
											check = 1;
										}
										else
										{
											System.out.println("Your chosen doctor is not qualified for " +pet4.getType()+"s. Please Try again.");
											check = 0;
										}
									}
									else if (responseDoctorAssign.equalsIgnoreCase(doctor2.getName()))
									{
										if(pet4.getType().equalsIgnoreCase(doctor2.getSpecialisation()))
										{
											pet4.setPetDoctor(responseDoctorAssign);
											check = 1;
										}
										else
										{
											System.out.println("Your chosen doctor is not qualified for " +pet4.getType()+"s. Please try again.");
											check = 0;
										}
									}
									else if (responseDoctorAssign.equalsIgnoreCase("cancel"))
									{
										check = 1;
									}
									else 
									{
										System.out.println("This doctor does not exist.");
										check = 0;
									}
								}	
							}
						}
					}	
					else
					{
						System.out.println("This pet does not exist. Please Try again.");
						check2 = 0;
					}
				}
			}
			else if (responseMain.equalsIgnoreCase("Analyse pet")|| responseMain.equalsIgnoreCase("D"))
			{
				check = 0;
				
				while (check == 0)
				{
					System.out.println("Which pet would you like to analyse?");
					System.out.println("A. " +pet1.getName());
					System.out.println("B. " +pet2.getName());
					System.out.println("C. " +pet3.getName());
					System.out.println("D. " +pet4.getName());
					responseAnalyse = keyboard.nextLine();
					
					if (responseAnalyse.equalsIgnoreCase(pet1.getName())|| responseAnalyse.equalsIgnoreCase("A")&& pet1.getType().equalsIgnoreCase("dog"))
					{
						pet1.analyseDog();
						check = 1;
					}
					else if (responseAnalyse.equalsIgnoreCase(pet2.getName())|| responseAnalyse.equalsIgnoreCase("B")&& pet2.getType().equalsIgnoreCase("dog"))
					{
						pet2.analyseDog();
						check = 1;
					}
					else if (responseAnalyse.equalsIgnoreCase(pet3.getName())|| responseAnalyse.equalsIgnoreCase("C") && pet3.getType().equalsIgnoreCase("dog"))
					{
						pet3.analyseDog();
						check = 1;
					}
					else if (responseAnalyse.equalsIgnoreCase(pet4.getName())|| responseAnalyse.equalsIgnoreCase("D")&& pet4.getType().equalsIgnoreCase("dog"))
					{
						pet4.analyseDog();
						check = 1;
					}
					else if (responseAnalyse.equalsIgnoreCase(pet1.getName())|| responseAnalyse.equalsIgnoreCase("A")&& pet1.getType().equalsIgnoreCase("cat"))
					{
						pet1.analyseCat();
						check = 1;
					}
					else if (responseAnalyse.equalsIgnoreCase(pet2.getName())|| responseAnalyse.equalsIgnoreCase("B")&& pet2.getType().equalsIgnoreCase("cat"))
					{
						pet2.analyseCat();
						check = 1;
					}
					else if (responseAnalyse.equalsIgnoreCase(pet3.getName())|| responseAnalyse.equalsIgnoreCase("C") && pet3.getType().equalsIgnoreCase("cat"))
					{
						pet3.analyseCat();
						check = 1;
					}
					else if (responseAnalyse.equalsIgnoreCase(pet4.getName())|| responseAnalyse.equalsIgnoreCase("D")&& pet4.getType().equalsIgnoreCase("dog"))
					{
						pet4.analyseCat();
						check = 1;
					}
					else
					{
						System.out.println("This pet does appear in our system. Please try again.");
						check = 0;
					}
				}
			}
			
			else if (responseMain.equalsIgnoreCase("Delete doctor") || responseMain.equalsIgnoreCase("E"))
			{
				if (doctor1.getName().equalsIgnoreCase("") && doctor2.getName().equalsIgnoreCase(""))
				{
					System.out.println("No results found.");
				}
				else
				{
					check = 0;
					
					while(check == 0)
					{
						System.out.println("Which doctor would you like to delete?");
						System.out.println("A. " +doctor1.getName());
						System.out.println("B. " +doctor2.getName() );
						System.out.println("C. Cancel.");
						responseDeleteDoctor = keyboard.nextLine();
						
						if (responseDeleteDoctor.equalsIgnoreCase(doctor1.getName()) || responseDeleteDoctor.equalsIgnoreCase("A"))
						{
							doctor1.deleteDoctor();
							check = 1;
						}
						else if (responseDeleteDoctor.equalsIgnoreCase(doctor2.getName()) || responseDeleteDoctor.equalsIgnoreCase("B"))
						{
							doctor2.deleteDoctor();
							check = 1;
						}
						else if (responseDeleteDoctor.equalsIgnoreCase("cancel") || responseDeleteDoctor.equalsIgnoreCase("C"))
						{
							check = 1;
						}
						else
						{
							System.out.print("Cannot find this doctor in our system.");
							System.out.println("------------------------------------------------------------");
							check = 0;

						}	
					}
				}
			}
			else if (responseMain.equalsIgnoreCase("Delete pet") || responseMain.equalsIgnoreCase("F"))
			{
				if (pet1.getName().equalsIgnoreCase("") && pet2.getName().equalsIgnoreCase("")&& pet3.getName().equalsIgnoreCase("")&& pet4.getName().equalsIgnoreCase(""))
				{
					System.out.println("No results found.");
				}
				else
				{
					check = 0;
					
					while (check == 0)
					{
						System.out.println("Which pet would you like to delete?");
						
						if(pet1.getName().equalsIgnoreCase("") && pet2.getName().equalsIgnoreCase("") && pet3.getName().equalsIgnoreCase("") && pet4.getName().equalsIgnoreCase(""))
						{
							System.out.println("No pets to delete.");
						}
						else 
						{
						System.out.println("A. " +pet1.getName());
						System.out.println("B. " +pet2.getName());
						System.out.println("C. " +pet3.getName());
						System.out.println("D. " +pet4.getName());
						System.out.println("Cancel.");
						responseDeletePet = keyboard.nextLine();
						}
						
						if (responseDeletePet.equalsIgnoreCase(pet1.getName()) || responseDeletePet.equalsIgnoreCase("A"))
						{
							pet1.deletePet();
							check = 1;
						}
						else if (responseDeletePet.equalsIgnoreCase(pet2.getName())|| responseDeletePet.equalsIgnoreCase("B"))
						{
							pet2.deletePet();
							check = 1;
						}
						else if (responseDeletePet.equalsIgnoreCase(pet3.getName())|| responseDeletePet.equalsIgnoreCase("C"))
						{
							pet3.deletePet();
							check = 1;
						}
						else if (responseDeletePet.equalsIgnoreCase(pet4.getName())|| responseDeletePet.equalsIgnoreCase("D"))
						{
							pet4.deletePet();
							check = 1;
						}
						else if (responseDeletePet.equalsIgnoreCase("cancel"))
						{
							check = 1;
						}
						else
						{
							System.out.println("Cannot find this pet in our system.");
							System.out.println("------------------------------------------------------------");
							check = 0;
							
						}
					}
				}
			}
			else if (responseMain.equalsIgnoreCase("Print doctor information")|| responseMain.equalsIgnoreCase("G"))
			{	
				if (doctor1.getName().equalsIgnoreCase("") && doctor2.getName().equalsIgnoreCase(""))
				{
					System.out.println("No Doctors");
				}
				else
				{
					System.out.println("Who's information would you like to print?");
					System.out.println("A. "+doctor1.getName());
					System.out.println("B. "+doctor2.getName());
					System.out.println("C. Print full list");
					
					responsePrintDoctor = keyboard.nextLine();
					
					if (responsePrintDoctor.equalsIgnoreCase(doctor1.getName()) || responsePrintDoctor.equalsIgnoreCase("A"))
					{
						doctor1.printDoctor();
					}
					else if (responsePrintDoctor.equalsIgnoreCase(doctor2.getName()) || responsePrintDoctor.equalsIgnoreCase("B"))
					{
						doctor2.printDoctor();
					}
					else if (responsePrintDoctor.equalsIgnoreCase("print full list") || responsePrintDoctor.equalsIgnoreCase("C"))
					{
						doctor1.printDoctor();
						doctor2.printDoctor();
					}
					else
					{
						System.out.println("Cannot find records in our system.");
					}
				}
			}
			else if (responseMain.equalsIgnoreCase("Print pet information")|| responseMain.equalsIgnoreCase("H"))
			{
				if (pet1.getName().equalsIgnoreCase("") && pet2.getName().equalsIgnoreCase("") && pet3.getName().equalsIgnoreCase("") && pet4.getName().equalsIgnoreCase(""))
				{
					System.out.println("No Pets");
				}
				else
				{
					System.out.println("Who's information would you like to print?");
					System.out.println("A. " +pet1.getName());
					System.out.println("B. " +pet2.getName() );
					System.out.println("C. " +pet3.getName() );
					System.out.println("D. " +pet4.getName() );
					System.out.println("E. Print full list.");
					
					responsePrintPet = keyboard.nextLine();
					
					if (responsePrintPet.equalsIgnoreCase(pet1.getName()) || responsePrintPet.equalsIgnoreCase("A"))
					{
						pet1.printPet();
					}
					else if (responsePrintPet.equalsIgnoreCase(pet2.getName()) || responsePrintPet.equalsIgnoreCase("B"))
					{
						pet2.printPet();
					}
					else if (responsePrintPet.equalsIgnoreCase(pet3.getName()) || responsePrintPet.equalsIgnoreCase("C"))
					{
						pet3.printPet();
					}
					else if (responsePrintPet.equalsIgnoreCase(pet4.getName()) || responsePrintPet.equalsIgnoreCase("D"))
					{
						pet4.printPet();
					}
					else if (responsePrintPet.equalsIgnoreCase("Print full list") || responsePrintPet.equalsIgnoreCase("E"))
					{
						pet1.printPet();
						System.out.println("---------------------------------------------------------");
						pet2.printPet();
						System.out.println("---------------------------------------------------------");
						pet3.printPet();
						System.out.println("---------------------------------------------------------");
						pet4.printPet();
					}
					else
					{
						System.out.println("Cannot find records in our system.");
					}
				}
			}	
			else if (responseMain.equalsIgnoreCase("I"))
			{
				System.out.println("Which doctor would you like to print pet information for?");
				System.out.println("A. " +doctor1.getName());
				System.out.println("B. " +doctor2.getName());
				responseDoctorPetList = keyboard.nextLine();
				
				if ((doctor1.getName() == "")&&(doctor2.getName()==""))
				{
					System.out.println("There are no doctors in the system.");
				}
				else if (responseDoctorPetList.equalsIgnoreCase("A")|| responseDoctorPetList.equalsIgnoreCase(doctor1.getName()))
				{
					System.out.println("The pets under "+doctor1.getName() + "'s care are:");
					
					if(pet1.getPetDoctor().equalsIgnoreCase(doctor1.getName()))
					{
						
					}
					
				}
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


