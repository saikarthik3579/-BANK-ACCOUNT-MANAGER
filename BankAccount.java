public class BankAccount{

   static String bankName;
   static String branchName;
   static String ifsc;

   long accNum;
   String accHName;
   double balance;
   
   Address address;

   public void deposit(double amt)throws IllegalArgumentException{
       if(amt <= 0)
           throw new IllegalArgumentException("Don't pass negative amount");
       
       this.balance=balance+amt;
       alert(amt,"Credited to");

   }
  
   public double withdraw(double amt)throws IllegalArgumentException,IllegalStateException{
       if(amt <= 0)
           throw new IllegalArgumentException("Do not pass negative number");

       if(amt > this.balance)
           throw new IllegalStateException("Insufficient Funds");

        this.balance=balance-amt;
        alert(amt,"debited from");

        return amt;

   }
   
   private  void alert(double amt,String action){    
       System.out.println("Cash "+amt+" is "+action+"  account "+accNum);
       System.out.println("Current Balance in your account is:"+balance);
   }
   
   public void transferMoney(BankAccount desAcc,double amt)
                                   throws IllegalArgumentException,IllegalStateException{

         this.withdraw(amt);
         desAcc.deposit(amt);
	 System.out.print("Cash"+amt+"is transferred to"+desAcc.accNum);

   }
   
   void display(){
     System.out.println(" Bank Name"	+bankName);
     System.out.println(" Branch Name"	+branchName);
     System.out.println(" ifsc\t\t"	+ifsc);
     System.out.println(" accNum\t\t:"  +accNum);
     System.out.println(" accHName\t"   +accHName);
     System.out.println(" balance\t:"   +balance);
     System.out.println(" strnum\t"     +address.strNum);
     System.out.println(" dno\t"        +address.dno);
     System.out.println(" city\t"       +address.city);
    }


}