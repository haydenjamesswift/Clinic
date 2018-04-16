import java.util.Scanner;

public class Pet {

	private String type; 	// the type of the pet. It can be only â€œcatâ€ or â€œdogâ€.
	private String size; 	// the size of the pet. It can be only â€œsmallâ€, â€œmediumâ€ or â€œlargeâ€.
	private String name; 	// the name of the pet. 
	private double weight; 	//the weight of the pet.
	private int age; 		//the age of the pet.
	private String petDoctor;  // the doctor of the pet.
	
	//Boolean Responses
	private String yes = "yes";
	private String no = "no";
	
	// Set Pet Type
	public void setType()
	{
		Scanner keyboard = new Scanner(System.in);
		int check = 0;
		
		while (check == 0)
		{
			System.out.println("Is your pet a cat or a dog?");
			type = keyboard.nextLine();
			
			
			if (type.equalsIgnoreCase("dog"))
			{
				this.type = "Dog";
				check = 1;
			}
			else if (type.equalsIgnoreCase("cat"))
			{
				this.type = "Cat";
				check = 1;
			}
			else
			{
				System.out.println("Invalid pet type. Please try again. ");
				System.out.println("------------------------------------------------------------");
				check = 0;
			}
		}
		
	}
	
	// Get Pet Type
	public String getType()
	{
		return type;
	}
	
	// Set Pet Size
	public void setSize()
	{
		Scanner keyboard = new Scanner(System.in);
		int check = 0;
		
		while (check == 0)
		{
			System.out.println("What size is your pet? Small, medium or large?");
			size = keyboard.nextLine();
			
			if (size.equalsIgnoreCase("small"))
			{
				this.size = "Small";
				check = 1;
			}
			else if (size.equalsIgnoreCase("medium"))
			{
				this.size = "Medium";
				check = 1;
			}
			else if(size.equalsIgnoreCase("large"))
			{
				this.size = "Large";
				check = 1;
			}
			else
			{
				System.out.println("Invalid pet size. Please try again.");
				System.out.println("------------------------------------------------------------");
				check = 0;
			}
		}
	}
	
	//Get Pet Size
	public String getSize()
	{
		return size;
	}
	
	//Set Pet Name
	public void setName(String name)
	{
		this.name = name;	
	}
	
	//Set Name Default
	public void setNameDefault()
	{
		this.name = "";
	}
	
	//Get Pet Name
	public String getName()
	{
		return name;
	}
	
	//Set Pet Weight
	public void setWeight()
	{
		Scanner keyboard = new Scanner (System.in);
		int check = 0;
		
		while (check == 0)
		{
			System.out.println("What is your pet's weight in kilograms?");
			this.weight = keyboard.nextDouble();
			
			if (weight>0)
			{
				this.weight = weight;
				check = 1;
			}
			else
			{
				System.out.println("Error. Please input a positive number.");
				System.out.println("------------------------------------------------------------");				
				check = 0;
			}
		}
	}
	
	//Get Pet Weight
	public double getWeight()
	{
		return weight; 
	}
	
	//Set Pet Age
	public void setAge()
	{
		Scanner keyboard = new Scanner(System.in);
		int check = 0;
		
		while (check == 0)
		{
			System.out.println("How old is " +this.name +"?");
			this.age = keyboard.nextInt();
			
			if (age>0)
			{
				this.age = age;
				check = 1;
			}
			else
			{
				System.out.println("Error. Please input a positive number.");
				System.out.println("------------------------------------------------------------");				
				check = 0;
			}
		}
	}
	
	//Get Pet Age
	public int getAge()
	{
		return age;
	}
	
	//Set Pet's Doctor
	public void setPetDoctor(String responseDoctorAssign)
	{
		this.petDoctor = responseDoctorAssign;
		
	}
	
	//Get Pet's Doctor
	public String getPetDoctor()
	{
		return petDoctor;
	}
	
	//Add Pet Method
	public void addPet(String name)
	{
		this.setType();
		this.setName(name);
		this.setSize();
		this.setWeight();
		this.setAge();
		this.setPetDoctor("No Doctor Assigned");
	}
	
	//Delete Pet Method
	public void deletePet()
	{
		this.name = "";
		this.type = null;
		this.size = null;
		this.weight = 0;
		this.age = 0;
		this.petDoctor = null;
	}
	
	//Analyse Dog
	public void analyseDog()
	{
		System.out.println("Name: "+this.getName());
		System.out.println("Type: "+this.getType());
		System.out.println("Size: "+this.getSize());
		System.out.println("Weight: "+this.getWeight());
		
		if ((this.getSize().equalsIgnoreCase("small")) && (this.getWeight()>6)&& (this.getType().equalsIgnoreCase("Dog")))
		{
			System.out.println(this.getName()+" is overweight.");
		}
		else if ((this.getSize().equalsIgnoreCase("medium")) && (this.getWeight()>9)&& (this.getType().equalsIgnoreCase("Dog")))
		{
			System.out.println(this.getName()+" is overweight.");
		}
		else if ((this.getSize().equalsIgnoreCase("large")) && (this.getWeight()>12)&& (this.getType().equalsIgnoreCase("Dog")))
		{
			System.out.println(this.getName()+" is overweight.");
		}
		else
		{
			System.out.println(this.getName() +" is a healthy weight for a "+this.getSize() +" " + this.getType());
		}
	}
	
	//Analyse Cat
		public void analyseCat()
		{
			System.out.println("Name: "+this.getName());
			System.out.println("Type: "+this.getType());
			System.out.println("Size: "+this.getSize());
			System.out.println("Weight: "+this.getWeight());
			
			if ((this.getSize().equalsIgnoreCase("small")) && (this.getWeight()>4)&& (this.getType().equalsIgnoreCase("Cat")))
			{
				System.out.println(this.getName()+" is overweight.");
			}
			else if ((this.getSize().equalsIgnoreCase("medium")) && (this.getWeight()>6)&& (this.getType().equalsIgnoreCase("Cat")))
			{
				System.out.println(this.getName()+" is overweight.");
			}
			else if ((this.getSize().equalsIgnoreCase("large")) && (this.getWeight()>8)&& (this.getType().equalsIgnoreCase("Cat")))
			{
				System.out.println(this.getName()+" is overweight.");
			}
			else
			{
				System.out.println(this.getName() +" is a healthy weight for a "+this.getSize() +" " + this.getType());
			}
		}
		
	//Write Output
	public void printPet()
	{
		System.out.println("Name: " + this.getName());
		System.out.println("Type: " +this.getType());
		System.out.println("Size: " +this.getSize());
		System.out.println("Weight: " +this.getWeight() + " kilograms.");
		System.out.println("Age: "+this.getAge()+" years.");
		System.out.println("Doctor: "+this.getPetDoctor());



	}
}

	

