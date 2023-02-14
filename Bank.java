
import java.util.*;

public class Bank {
	 //Creating ArrayList
	 static ArrayList<Act> list = new ArrayList();
	   
 public static void main(String[] args) {
	 Scanner sc = new Scanner(System.in);
	          
	 while (true) {
	      try {
	      //Taking Input
	       String req = sc.nextLine();
	      //If Stop command is given, The application will be stopped
	       if(req.equalsIgnoreCase("STOP"))
	          break;
	      //Splitting the command to get account id from string
	       String[] command = req.split("\\s+");

	       // calling functions according to input received
	       if(command[0].equalsIgnoreCase("CREATE")){
	       createAccount(command);
	       }
	       else if(command[0].equalsIgnoreCase("DEPOSIT")){
	       depositMoney(command);
	        }
	       else if(command[0].equalsIgnoreCase("WITHDRAW")){
	       withdrawMoney(command);
	       }
	       else if(command[0].equalsIgnoreCase("BALANCE")){
	        getBalance(command);
	       }
	       else{
	       //If No Related functions are found
	       System.out.println("Command Not found!!! Please Use CREATE, DEPOSIT, WITHDRAW, BALANCE");
           }
	       }
	       catch(Exception e) {
	            		System.out.println("Enter valid command");
	        }

	      }
}

	    //To create new account 
 public static void createAccount(String[] cmd) {
	  boolean b = false;
	  for(Act ac: list) {
	    if(cmd[1].equals(ac.getAccountNo())) {
	    b=true;
	    System.out.println("Account already exist..");
	  }
	  }
	  if(b==false) {
	  list.add(new Act(cmd[1],cmd[2],0.0));
	  }
 }

	    //To Deposit money in account
public static void depositMoney(String[] cmd) {
	    try {
	      double amt =Double.parseDouble(cmd[2]);
	      boolean b = false;
	      for(Act ac: list) {
	        if(cmd[1].equals(ac.getAccountNo())) {
	          b=true;
	          ac.setBalance(amt);
	   	}
	   	}
	      if(b==false) {
	      System.out.println("Account does not exist");
	    }
	    }
	    catch(Exception e) {
	      System.out.println("Command not found");
	    }
 }

	    //To withdraw money from account
public static void withdrawMoney(String[] cmd){
	  try {
	    double amt =Double.parseDouble(cmd[2]);
	    boolean b = false;
	    for(Act ac: list) {
	      if(cmd[1].equals(ac.getAccountNo())) {
	        if(ac.getBalance()>0) {
	          b=true;
	          ac.setBal(amt);
	   }
	        else {
	        b=true;
	        System.out.println("Balance is insufficient");
	  }
	  }
	      }
	    if(b==false) {
	      System.out.println("Account does not exist");
	  }
	      }
	  catch(Exception e) {
	    System.out.println("Command not found");
		    }
}
	    
        //To get the account balance
public static void getBalance(String[] cmd){
	       
	 try {
	   boolean b = false;
       for(Act ac: list) {
         if(cmd[1].equals(ac.getAccountNo())) {
         b=true;
         System.out.println(ac.getName()+" "+ac.getBalance());
   	 }
   	 }
     if(b==false) {
       System.out.println("Account does not exist");
    	}
	    }
	 catch(Exception e) {
       System.out.println("Command not found");
	 }
     }
}
class Act{
	String AccountNo ;
	String Name;
	double Balance;
	Act(String AccountNo,String Name,double Balance){
		this.AccountNo=AccountNo;
		this.Name=Name;
		this.Balance=Balance;
		
	}
	public String getAccountNo() {
		return AccountNo;
	}
	public String getName() {
		return Name;
	}
	public double getBalance() {
		return Balance;
	}
	public void setBalance(double amt) {
		this.Balance +=amt;
	}
	public void setBal(double amt) {
		this.Balance -=amt;
	}
	
}

