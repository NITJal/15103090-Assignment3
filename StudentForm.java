import java.util.Scanner;

public class StudentForm {
	String name="";
	String email="";
	String address="";
	String RollNo="";
	String phNo="";
	boolean b;
	double HsgMarks,Ugmarks;
	final static double HSG=360,UG=300;
	Scanner sc=new Scanner(System.in);
	public void getData1() throws Exception 
	{
	System.out.println("Enter your name");	
	name=sc.nextLine();
	b=containsNumber(name);
	if(b==true)
		throw new Exception("invalid name: only characters allowed");
	//////////////////////////
	System.out.println("Enter email");	
	email=sc.nextLine();
	///////////////////////////
	System.out.println("Enter your address");	
	address=sc.nextLine();
	///////////////////////////
	System.out.println("Enter your contact number");	
	phNo=sc.nextLine();
	b=isNumeric(phNo);
	if(b==false)
		throw new Exception("NumberFormatException: enter a valid number");
	///////////////////////////
	System.out.println("Enter your roll number");	
	RollNo=sc.nextLine();
	b=isNumeric(RollNo);
	if(b==false)
		throw new Exception("NumberFormatException: enter a valid number");
	///////////////////////////
	System.out.println("Enter your HSG marks(<=360)");	
	HsgMarks=sc.nextDouble();
	//////////////////////////
	System.out.println("Enter your UG marks(<=300)");	
	Ugmarks=sc.nextDouble();
	}
	public void displayData()
	{
		if(HsgMarks>=(0.60)*HSG  && Ugmarks>=(0.70)*UG)
			System.out.println(name+" is eligible");
		else
			System.out.println(name+" is not eligible");
	}
	static boolean containsNumber(String c) {
        char[] ch = new char[10];
        ch = c.toCharArray();

        for (int i = 0; i < ch.length; i++) {
            if ((ch[i] >= 48) && (ch[i] <= 57)) {
                return true;
            }
        }
        return false;
    }
	public static boolean isNumeric(String str)
	{
	    for (char c : str.toCharArray())
	    {
	        if(!Character.isDigit(c)) return false;
	    }
	    return true;
	}
public static void main(String args[]) throws Exception
{
	StudentForm sf=new StudentForm();
	sf.getData1();
	sf.displayData();
}
}
