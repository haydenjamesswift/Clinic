public class Doctor{

	public String name; 		
	private String specialisation;
	
	// Add a New Doctor
	public Doctor()
	{
		this.name = "";
		this.specialisation = "";
	}
	
	// Set Doctor Information
	public void setInfo(String name, String specialisationText)
	{
		this.name = name;
		this.specialisation = specialisationText;
	}
	
	//Set Doctors Name
	public void setName(String name)
	{
		this.name = name;
	}
	
	//Return Doctors Name
	public String getName()
	{
		return name;
	}
	
	//Set Doctors Specialisation
	public void setSpecialisation(String specialisationText)
	{	
		this.specialisation = specialisationText;
	}

	//Return Doctors Specialisation
	public String getSpecialisation()
	{
		return specialisation;
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
