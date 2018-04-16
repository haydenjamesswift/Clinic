import java.util.Scanner;

public class Doctor {

	public String name; 	
	private String specialisationText; 	
	private String specialisation;
	
	// Set Doctors Name
	public void setName(String name)
	{
		this.name = name;
	}
	
	//Set Name Default
	public void setNameDefault()
	{
		this.name = "";
	}
	
	//Return Doctors Name
	public String getName()
	{
		return name;
	}
	
	//Set Doctors Specialisation
	public void setSpecialisation()
	{
		Scanner keyboard = new Scanner(System.in);
		int check = 0;
		
		while (check == 0)
		{
			System.out.println("What is your doctors specialisation?");
			specialisationText = keyboard.nextLine();
			
			if (specialisationText.equalsIgnoreCase("dog"))
			{
				this.specialisation = "Dog";
				check=1;
			}
			else if (specialisationText.equalsIgnoreCase("cat"))
			{
				this.specialisation = "Cat";
				check = 1;
			}
			else
			{
				System.out.println("Please input valid pet type.");
				System.out.println("------------------------------------------------------------");
				check = 0;
			}
		}
	}

	//Return Doctors Specialisation
	public String getSpecialisation()
	{
		return specialisation;
	}
	
	//Add Doctor Method
	public void addDoctor(String name)
	{
		this.setName(name);
		this.setSpecialisation();
	}
	
	//Delete Doctor Method
	public void deleteDoctor()
	{
		this.name = "";
		this.specialisation = null;
	}
	
	//Print Doctor Information
	public void printDoctor()
	{
		System.out.println("Name: " + this.getName());
		System.out.println("Specialisation: " +this.getSpecialisation());
	}
}
