import java.util.Scanner;

public class AtmMachine 
{
	double balance=0;
	double WithAmt=0,depAmt=0;
	double sum;
	String passWord="";
	int ch,accNo;
	String[] pass= {"1234","2345","3456","4567","5678"};
	Scanner sc=new Scanner(System.in);
	public int getAccount() throws Exception
	{
      System.out.println("Enter Account number(0-4)");
      accNo=sc.nextInt();
      sc.nextLine();
      System.out.println("Enter password");
      passWord=sc.nextLine();
      if(pass[accNo].equals(passWord))
    	  return 1;
      else
      {
    	  throw new Exception("Incorrect Password");
      }
	}
	public int getvalue()
	{
		System.out.println("*****SIMPLE ATM******");
		System.out.println();
		System.out.println("1.Balance check");
		System.out.println("2.Deposit");
		System.out.println("3.Withdrawal");
		System.out.println("4.Terminate transaction");
		System.out.println("Enter your choice");
		ch=sc.nextInt();
		return ch;
	}
	public void getBalance()
	{
		System.out.println(balance);
	}
	public void Deposit()
	{
		System.out.println("Enter the amount for deposition");
		depAmt=sc.nextDouble();
		balance=balance+depAmt;
	}
	public void Withdrawal() throws Exception 
	{
		System.out.println("enter the amout you want to withdraw");
		WithAmt=sc.nextDouble();
		if(WithAmt>10000)
			throw new Exception("only less than Rupees 10,000 at one transaction");
		else if((balance-WithAmt)<0)
			throw new Exception("Not enough balance");
		else
			balance=balance-WithAmt;
	}
public static void main(String args[]) throws Exception
{
	AtmMachine am=new AtmMachine();
	int choice=0;
	int c=am.getAccount();
	if(c==1)
	{	
	while(choice!=4)
	{
		choice=am.getvalue();
		switch(choice)
		{
		case 1://balance check
			am.getBalance();
			break;
		case 2://deposit
			am.Deposit();
			break;
		case 3://withdraw
			am.Withdrawal();
			break;
		case 4://End
			System.out.println("you chose to terminate");
			break;
		}
	}
	}
}
}
