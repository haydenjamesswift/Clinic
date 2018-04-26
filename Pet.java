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
	public void setType(String type)
	{
		this.type = type;
	}
	
	// Get Pet Type
	public String getType()
	{
		return type;
	}
	
	// Set Pet Size
	public void setSize(String size)
	{
		this.size = size;
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
	public void setWeight(Double weight)
	{
		this.weight = weight;
	}
	
	//Get Pet Weight
	public double getWeight()
	{
		return weight; 
	}
	
	//Set Pet Age
	public void setAge(int age)
	{
		this.age = age;
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
		this.setSize(size);
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
		this.petDoctor = "No Doctor Assigned";
	}
	
	//Analyse Dog
	public void analyseDog()
	{
		System.out.println("Name: "+this.getName());
		System.out.println("Type: "+this.getType());
		System.out.println("Size: "+this.getSize());
		System.out.println("Weight: "+this.getWeight());
		
		if ((this.getSize().equalsIgnoreCase("small")) && (this.getWeight()>6))
		{
			System.out.println(this.getName()+" is overweight.");
		}
		else if ((this.getSize().equalsIgnoreCase("medium")) && (this.getWeight()>9))
		{
			System.out.println(this.getName()+" is overweight.");
		}
		else if ((this.getSize().equalsIgnoreCase("large")) && (this.getWeight()>12))
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
			
			if ((this.getSize().equalsIgnoreCase("small")) && (this.getWeight()>4))
			{
				System.out.println(this.getName()+" is overweight.");
			}
			else if ((this.getSize().equalsIgnoreCase("medium")) && (this.getWeight()>6))
			{
				System.out.println(this.getName()+" is overweight.");
			}
			else if ((this.getSize().equalsIgnoreCase("large")) && (this.getWeight()>8))
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

	

