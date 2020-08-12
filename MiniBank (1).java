import java.util.*;
class Account
{
	protected int accno;
	protected String name;
	protected float bal;
	public void accept()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Name,Account Number and Current Balance:");
		name=sc.next();
		accno=sc.nextInt();
		bal=sc.nextFloat();
	}
		
}
class Saving extends Account
{
	private float deposit,with,t,r=7.5f,si;
	private int n;
	public void facility()
	{
		Scanner sc=new Scanner(System.in);
		do
		{
			System.out.print("Welcome To Your Savings Account (No Checque Book Facility)\nWhat Would You Like To Do?\n");
			System.out.print("1.Deposit Amt\n2.Check Balance\n3.Compute Deposit Interest\n4.Withdraw Amt\n5.Exit\nEnter Your Choice:");
			n=sc.nextInt();
			switch(n)
			{
				case 1:System.out.print("Enter the amt to be deposited:");
				deposit=sc.nextFloat();
				bal=bal+deposit;
				System.out.println(+deposit+ "INR Deposited in Your Account Successfully\nYour Savings Account Balance is "+bal+" INR");
				break;
				case 2:System.out.println("Your Savings Account Balance is "+bal+" INR");
				break;
				case 3:System.out.print("Enter the no.of years:");
				t=sc.nextFloat();
				si=(bal*t*r)/100;
				System.out.print("Your Deposit Interest is: "+si);
				break;
				case 4:System.out.print("Enter the amt to be Withdrawn:");
				with=sc.nextFloat();
				if(with>bal) System.out.println("Dear Customer You Have Insufficient Account Balance For Withdrawal");
				else 
				{
					bal=bal-with;
					System.out.println("Withdrawal of "+with+" Amt Done Successfully");
					System.out.println("Your Savings Account Balance is "+bal+" INR");
				}
				break;
				case 5:System.out.println("Thank You For Banking With Us");
				break;
				default:System.out.println("Invalid Choice");
			}
		}while(n!=5);
	}
}
class Current extends Account
{
	private float deposit,with;
	private int n;
	public void facility()
	{
		Scanner sc=new Scanner(System.in);
		do
		{
			System.out.print("Welcome To Your Current Account (No Interest Facility)\nWhat Would You Like To Do?\n");
			System.out.print("1.Deposit Amt\n2.Check Balance\n3.Issue Cheque Book\n4.Withdraw Amt\n5.Exit\nEnter Your Choice:");
			n=sc.nextInt();
			switch(n)
			{
				case 1:System.out.print("Enter the amt to be deposited:");
				deposit=sc.nextFloat();
				bal=bal+deposit;
				System.out.println(+deposit+ "INR Deposited in Your Account Successfully\nYour Savings Account Balance is "+bal+" INR");
				break;
				case 2:System.out.println("Your Current Account Balance is "+bal+" INR");
				break;
				case 3:System.out.println("Your Request for issuing a Cheque Book is Accepted\nYou Will Soon Recieve Your New Cheque Book");
				break;
				case 4:System.out.print("Enter the amt to be Withdrawn:");
				with=sc.nextFloat();
				if(with>bal) System.out.println("Dear Customer You Have Insufficient Account Balance For Withdrawal");
				else 
				{
					bal=bal-with;
					System.out.println("Withdrawal of "+with+" Amt Done Successfully");
					System.out.println("Your Current Account Balance is "+bal+" INR");
				}
				break;
				case 5:System.out.println("Thank You For Banking With Us");
				break;
				default:System.out.println("Invalid Choice");
				break;
			}
		}while(n!=5);	
	}
}
class Loan extends Account
{
	private float l;
	private int t;
	public void details()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Name,Account Number:");
		name=sc.next();
		accno=sc.nextInt();
		System.out.println("Enter the Loan Amount(Limit:1Cr):");
		l=sc.nextFloat(); 
		if(l<10000000)
		{
			
			System.out.print("Enter the number of installments (Years) in which you would repay the loan amount with interest:");
			t=sc.nextInt();
		}
		else
		{
			l=0;
			System.out.println(" SORRY!!! You Have Exceed The Loan Limit");
		}
	}
	public void facility()
	{
		int ch;
		float repay,emi,li=6.5f,r;
		Scanner sc=new Scanner(System.in);
		do
		{
			System.out.print("1.Display Loan Interest\n2.Display EMI For the Loan Credit\n3.Display Loan Credit\n4.Repay Loan\n5.Exit\nEnter Your Choice:");
			ch=sc.nextInt();
			switch(ch)
			{
				case 1:System.out.println("The Loan Interest is:"+li);
				break;
				case 2:r=li/(12*100); 
 				t=t*12; 
            			emi=(float)((l*r*Math.pow(1+r,t))/(Math.pow(1+r,t)-1));
      				System.out.println("Monthly EMI For The Loan Taken is: "+emi+" INR");
				break;
				case 3:System.out.println("Your Loan Credit= "+l+" INR");
				break;
				case 4:System.out.print("Enter The Amount That You Would Repay:");
				repay=sc.nextFloat();
				if(repay>l)
				{
					System.out.println("Your Loan Has Been Cleared\nBut You Have Paid An Excess Of "+(repay-l)+" INR\nThis Excess Amount Would Soon Be Returned Back To You.");
					l=0;
					System.out.println("Thank You For Banking With Us");
				}
				else
				{
					l=l-repay;
					System.out.println("Your Loan Credit= "+l+" INR");
				}
				break;
				case 5:System.out.println("Thank You For Banking With Us");
				break;
				default:System.out.println("Invalid Choice");
				break;
			}
		}while(ch!=5);
	}	
		
}		
public class MiniBank
{
	public static void main(String args[])
	{
		int choice;
		Scanner sc=new Scanner(System.in);
		Saving s=new Saving();
		Current c=new Current();
		Loan ln=new Loan();
		do
		{
			System.out.println("Welcome To Our Bank!!!\n1.Create a Savings Account\n2.Create a Current Account\n3.Create a Loan Account\n4.Exit Bank\nEnter Your Choice:");
			choice=sc.nextInt();
			switch(choice)
			{
				case 1:s.accept();
				s.facility();
				break;
				case 2:c.accept();
				c.facility();
				break;
				case 3:ln.details();
				ln.facility();
				break;
				case 4:System.out.println("Thank You");
				break;
				default:System.out.println("Invalid Choice");
				break;
			}
		}while(choice!=4);	
		
	}
}
			