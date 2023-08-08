import java.util.*;

public class MiniBank {
      Scanner input = new Scanner(System.in);
  public class Account{
          String customerName;
          String customerID;
          int balance=0;
          int previousTransaction = 0;
          int Pin;
          int account_no;
          int Dob;

          Account(String customerName, String customerID){
            this.customerName = customerName;
            this.customerID = customerID;
          }


          //pin Change


         void cPin(int accountno){
            int dob=0;
            int try_again=3;
            

            int newPin;


            if(account_no==accountno){
                System.out.println("Enter your Dob in DDMMYYYY format ");
                   if(Dob==dob){
                       System.out.print("Please enter your new pin ");
                       newPin = input.nextInt(); 
                       Pin = newPin;
                       System.out.println("Your pin has been sucessfully changed");
                      
                   }
                   else{
                     
                    for(int i=1;i<=try_again;i++){
                        try_again=try_again-i;
                         System.out.println("You have enter a invalid pin please try again ");
                         System.out.println("remainings attempts " + try_again);
                    }
                     System.out.println("You have been blocked please try again after 2 hours ");

                   }
            }
               else{
                   
                for(int i=1;i<=try_again;i++){
                    try_again=try_again-i;
                     System.out.println("You have enter a invalid pin please try again ");
                     System.out.println("remainings attempts " + try_again);
                }
                     System.out.println("You have been blocked please try again after 2 hours ");
               }
          }

           //deposit money

          void deposit(int amount){
            if(amount>0){
                balance = balance+amount;
                previousTransaction = amount;
                System.out.println("Desposit sucessfully. ");
                System.out.println("New balance " + balance);

            }
            else{
                System.out.println("Please enter amount greter than zero ");
            }
          }

          //withdraw  money

          void Withdraw(int amount,int pin){
            int try_again=3;
           
            if(pin==Pin){
                System.out.println("Your authentication sucessful ");
                 if(amount<balance){
                    System.out.println("Enter amount how you need to withraw ");
                    
                    balance=balance-amount;
                    previousTransaction = -amount;
                    System.out.println("You have sucessfully withdrawl your money from your account ");
                    System.out.println("New balance" + balance);
                   

                 }

                 else{
                    System.out.println("Insufficent balance in your account ");

                 }

            }
             else{
                    for(int i=1;i<=try_again;i++){
                        try_again=try_again-i;
                         System.out.println("You have enter a invalid pin please try again ");
                         System.out.println("remainings attempts " + try_again);
                    }
                     System.out.println("You have been blocked please try again after 2 hours ");
                    
                    


                 }
          }
              //check balance

                void Checkbalance(int pin){
                int try_again=3;
               if(Pin==pin){
                  System.out.println("Your current balance " + balance);


                 }

             else{
                    for(int i=1;i<=try_again;i++){
                        try_again=try_again-i;
                         System.out.println("You have enter a invalid pin please try again ");
                         System.out.println("remainings attempts " + try_again);
                    }
                     System.out.println("You have been blocked please try again after 2 hours ");
                    
                    


                 }
          }

            // previoustransaction

           void getPreviousTransactions(int amount){
            if(previousTransaction>0){
                
                
                System.out.println("Deposite " + balance);

            }
            else if(previousTransaction<0){
                System.out.println("Withdrawl " + balance);
            }
            else{
                System.out.println("No transaction ocurred " );
            }
          }

                void Interestcalculate(int years){
                    double interestRate = .0185;
                    double NewBalance = (balance * interestRate * years) + balance;
                  
                    System.out.println("The current interset rate is " + (interestRate * 100 ) + "%");
                    System.out.println("After" + years + "your amount will be: " + NewBalance); 

          }


    }
    public static void main(String[] args){
        
     Scanner input = new Scanner(System.in);
     System.out.println("Enter your name");
     String custName = input.nextLine();
     System.out.println("Enter your customer id ");
     String CustId = input.nextLine();

     Account account = new Account(custName,CustId);
     account.account_no = 1234;
     account.Dob=10062001;
     account.account_no=123456;

     //menu

     System.out.println("--------------------------------------");
     System.out.println("Welcome," + account.customerName + "!");
     System.out.println("Your ID," + account.customerID);
     System.out.println("Your account no," + account.account_no);
     System.out.println("---------------------------------------");
     System.out.println("Select any option from the below " + "\n");
     System.out.println("A Check balance ");
     System.out.println("B Deposit ");
     System.out.println("C Withdraw ");
     System.out.println("D Previous Transaction ");
     System.out.println("E Interest");
     System.out.println("F Pin Change ");
     System.out.println("G Exit ");

     //options selection

     char options;

     boolean flag = true;

     while(flag){
        System.out.println("Enter your choice");
        options = input.next().charAt(0);

        switch(options){
            case 'A' :   System.out.println("Enter your account pin to continue ");
                         int PIN = input.nextInt();
                         account.cPin(PIN);
                         System.out.println("Your Balance $ = " + account.balance);
                           break;

            case 'B' : int DepositAmount = input.nextInt();
                       account.deposit(DepositAmount);
                       break;
                       
            case 'C' :  System.out.println("Enter Your account pin to continue ");
                        PIN = input.nextInt();                        
                        System.out.println("Enter Your ammount to withdraw ");
                        int WithdrawAmount = input.nextInt();
                        account.Withdraw(PIN,WithdrawAmount);   
                        break;
            case 'D' :  System.out.println("Enter Your account pin to continue ");
                        PIN = input.nextInt();
                        account.getPreviousTransactions(PIN); 
                        break;
            case 'E' :  System.out.println("Enter Your account years to calculate interest ");
                        int years = input.nextInt();
                        account.Interestcalculate(years);
                        break;      
            case 'F' :  System.out.println("Enter Your account account no to continue ");
                        int accountnumber = input.nextInt();
                        account.cPin(accountnumber);
                        break;
            case 'G' :  System.out.println("Thankyou banking with us! ");   
                        input.close();
                        flag =false;

                        break;
                        
             default: System.out.println("Enter a valid input A,B,C,D,E,F and G ");           

                                                       
        }
     }
     
    }
    
}
