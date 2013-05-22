public class ClassProject
{
	//instance variables
	private int ProjectID;
	private String ProjectOwner;
	private double mark;
	private double grade;
	private int weight;
	
	//default constructor
	public ClassProject()
	{
	}
	
	//copy constructor
	public ClassProject(ClassProject otherClassProject)
	{
		ProjectID = otherClassProject.ProjectID;
		ProjectOwner = otherClassProject.ProjectOwner;
		mark = otherClassProject.mark;
		grade = otherClassProject.grade;
		weight = otherClassProject.weight;
	}
	
	//methods
	public void setProject(int id, String owner, double mk, double grd, int wt)
	{
		ProjectID = id;
		ProjectOwner = owner;
		mark = mk;
		grade = grd;
		weight = wt;
	}
	
	public void setProjectID(int id)
	{
		ProjectID = id;
	}
	
	public void setProjectOwner(String owner)
	{
		ProjectOwner = owner;
	}
	
	public void setMark(double mk)
	{
		mark = mk;
	}
	
	public void setGrade(double grd)
	{
		grade = grd;
	}
	
	public void setWeight(int wt)
	{
		weight = wt;
	}
	
	public int getProjectID()
	{
		return ProjectID;
	}
	
	public String getProjectOwner()
	{
		return ProjectOwner;
	}
	
	public double getMark()
	{
		return mark;
	}
	
	public double getGrade()
	{
		return grade;
	}
	
	public int getWeight()
	{
		return weight;
	}
	
	public boolean equals(ClassProject project1, ClassProject project2)
	{
		if(project1 == project2)
			return true;
		else
			return false;
	}
}