

import java.util.Scanner;

class Atm
{
	private String name;
	private long acNo;
	private long phNo;
	public int acMin=10000;
	private double deposit;
	private double withdraw;
	private int reSetPin;
	private double transfer;
	private double totalBalance;
	
	public long getAcNo() {
		return acNo;
	}
	public void setAcNo(long acNo) {
		this.acNo = acNo;
	}
	public long getPhNo() {
		return phNo;
	}
	public void setPhNo(long phNo) {
		this.phNo = phNo;
	}
	public double getDeposit() {
		return deposit;
	}
	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
	public double getWithdraw() {
		return withdraw;
	}
	public void setWithdraw(double withdraw) {
		this.withdraw = withdraw;
	}
	public double getTransfer() {
		return transfer;
	}
	public void setTransfer(double transfer) {
		this.transfer = transfer;
	}
	public double getTotalBalance() {
		return totalBalance;
	}
	public void setTotalBalance() {
		this.totalBalance =  acMin+deposit-transfer-withdraw;
	}
}
public class AtmProject {
	public double with,depo,trnsf;
	Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Atm a=new Atm();
		AtmProject b=new AtmProject();
		System.out.println("      welcome to ATM \nInsert your ATM card into machine");
		System.out.println(" remember your pin");
		int pin=sc.nextInt();
		System.out.println(" now enter you pin");
		while(true)
		{
		int p=sc.nextInt();
		if(pin==p)
		{
		b.disScreen(a);
		break;
		}
		else
		{
			System.out.println("your entered wrong pin");
		}
	}
	}
	void disScreen(Atm a)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("1.Balnce Enqueiry \t \t 2.Deposit Amount");
		System.out.println("3.Amount Withdraw \t \t 4.Amount transfer");
		System.out.println("5.Reset Password  \t \t 6.Mini Statement");
		System.out.println("select one field");
		int x=sc.nextInt();
		switch(x)
		{
		case 1: balance(a); break;
		case 2: deposit(a); break;
		case 3: withdraw(a); break;
		case 4: transfer(a); break;
		case 5: setpin(a); break;
		case 6: ministatement(a); break;
		default: System.out.println("your entered wrong key.");
		}
	}
	void balance(Atm a)
	{
		a.setTotalBalance();
		System.out.println("total balance is:"+a.getTotalBalance());
		exit(a);
	}
	void deposit(Atm a)
	{
		System.out.println("enter deposit amount:");
	    depo=sc.nextDouble() ;
	    a.setDeposit(depo);
	    a.setTotalBalance();
	    System.out.println("balance is:"+a.getTotalBalance());
	    exit(a);
	}
	void withdraw(Atm a)
	{
		while(true)
		{
		a.setTotalBalance();
		System.out.println("enter withdraw amount:");
		with=sc.nextDouble();
		if(a.getTotalBalance()>=with)
		{
		a.setWithdraw(with);
		a.setTotalBalance();
		System.out.println("your withdraw amount is:"+a.getWithdraw()+"\nbalance is:"+a.getTotalBalance());
		exit(a);
		break;
		}
		else
		{
			System.out.println("insufficient balance enter less amount");
		}
		}
	}
	void transfer(Atm a)
	{
		System.out.println("enter benificiary account number");
		long ac1=sc.nextLong();
		while(true)
		{
		System.out.println("reenter benificiary account number");
		long ac2=sc.nextLong();
		if(ac1==ac2)
		{
			while(true) {
		System.out.println("enter phone number");
			String ph=sc.next();
	    if(ph.length()==10)
	    {
		System.out.println("enter transfer amount:");
		trnsf=sc.nextDouble();
		a.setTransfer(trnsf);
		a.setTotalBalance();
		System.out.println("your tranfered amount is:"+a.getTransfer()+"\nbalance is:"+a.getTotalBalance());
	    break;
		}else
		{
			System.out.println("your are entered phone no. is not invalid.check and re-enter");
		}
		}
			break;
		}
		else
		{
			System.out.println("your are entered account no. is not matched.check and re-enter");
		}
	   }
		
		exit(a);
	}
	void setpin(Atm a)
	{
		while(true) {
		System.out.println("enter phone number");
		String ph=sc.next();
		if(ph.length()==10)
		{
		System.out.println("entered your OTP number to get otp to your registered mobile no.is"+ph);
		sc.nextInt();
		System.out.println("set your password.");
		sc.nextInt();
		System.out.println("your password changed successfully");
		break;
		}
		else
		{
		System.out.println("check your mobile number and re-enter");	
		}
		}
		exit(a);
	}
	void ministatement(Atm a)
	{
		a.setAcNo(044410100010660l);
		a.setDeposit(depo);
		a.setWithdraw(with);
		a.setTransfer(trnsf);
		System.out.println("account no    \tdeposit \t withdraw \t transfer");
		System.out.println(a.getAcNo()+"\t"+a.getDeposit()+"\t"+a.getWithdraw()+"\t"+a.getTransfer());
		exit(a); 
	}
	void exit(Atm a)
	{
		System.out.println("are you go home page press 1 or exit press 0");
		if(sc.nextInt()==1)
		{
	     disScreen(a);
		}
		if(sc.nextInt()==0)
		{
			System.exit(0);
		}
	}
}
