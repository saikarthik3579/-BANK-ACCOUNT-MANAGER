

import java.util.Scanner;
        
class Bank{
  public static void main(String[] args){
       
      Scanner sc = new Scanner(System.in);
         
       System.out.println("Enter the Bank Name\t    ");
       BankAccount.bankName	=sc.nextLine();
     
       System.out.println("Enter the Branch Name\t  ");
       BankAccount.branchName	=sc.nextLine();

       System.out.println("Enter IFSC\t ");
       BankAccount.ifsc		=sc.next();	


      System.out.print("How many accounts you want to open? ");
      int noOfAccounts = sc.nextInt();
            BankAccount[] acc = new BankAccount[noOfAccounts];
      if(noOfAccounts != 0){


	
      
      for(int index=0; index < noOfAccounts; index++){
         System.out.print("\nEnter Customer "+ (index+1) +" details\n");
         acc[index]			=new BankAccount();

	 System.out.print("Enter account number\t:");
         acc[index].accNum		=sc.nextLong(); sc.nextLine();


         System.out.print("Enter account holder name\t");
         acc[index].accHName		=sc.nextLine();


	 System.out.print("Balance\t");
         acc[index].balance		=sc.nextDouble();


         System.out.print("Enter Customer "+(index+1)+" address details\n");
         acc[index].address		=new Address(); 



	 System.out.print("Enter Door number\t");
	 acc[index].address.dno		=sc.next();


         System.out.print("Enter street number\t");
         acc[index].address.strNum		=sc.nextInt(); sc.nextLine();


	 System.out.print("Enter the city name\t");
         acc[index].address.city		=sc.nextLine();
         
         System.out.print("Accounts Created\n");
         
    }
}
       
        System.out.print("Choose your option:\n 1.deposit \n 2.Withdraw \n 3.Transfer \n 4.Display Info\n");
        int choice=sc.nextInt();
        long InaccNum;
        double amount;
          switch(choice){
                 case 1:System.out.print("Enter the account Holder number\t");
                           InaccNum=sc.nextLong();
           	           for(int i=0; i<noOfAccounts; i++){
                                if(acc[i].accNum == InaccNum){
                                      System.out.print("Enter the money\n");
                                       amount=sc.nextDouble();
                                      acc[i].deposit(amount);
                                      System.out.print("ammount credited");
                                      break;
                                 }
                            }
                         break;
       
                  case 2:System.out.print("Enter the account Holder number\t");
			  InaccNum=sc.nextLong();
			  for(int i=0; i<noOfAccounts; i++){
                                if(acc[i].accNum == InaccNum){
                                      System.out.print("Enter the money\t");
                                           amount=sc.nextDouble();
				      acc[i].withdraw(amount);
                                      break;
                                 }
                            }
                          break;
                         

                 case 3:   System.out.print("Enter the src account Holder number\t");
                           long srcAccountNumber=sc.nextLong();
			System.out.print("Enter the des account Holder number\t");
                           long desAccountNumber=sc.nextLong();
                           BankAccount srcAccount=null,desAccount=null;
                            
                              for(int i=0; i<noOfAccounts; i++){
                                  if(acc[i].accNum==srcAccountNumber){
                                        srcAccount=acc[i];
                                  }
                                  if(acc[i].accNum==desAccountNumber){
                                        desAccount=acc[i];
                                  }
                            }
                                  System.out.print("Enter the money\t");
                                     amount=sc.nextDouble();
                                  if(srcAccount!=null && desAccount!=null){
                                   srcAccount.transferMoney(desAccount,amount);
                                    srcAccount.display();
                                    desAccount.display();
                                  } 
                             break;    
                  case 4:System.out.print("Enter the account Holder number");
			  InaccNum=sc.nextLong();
                          for(int i=0; i<noOfAccounts; i++){
                                if(acc[i].accNum==InaccNum){
                                  acc[i].display();
                                  break;
                                }
                          }       
                  default:  System.out.print("Invalid choice");
                            break;
     
}

                
 }

}