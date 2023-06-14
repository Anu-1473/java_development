import java.util.*;
class ATM{
    int amount;
    int ac;
    List<Integer> list=new ArrayList<Integer>();
    public ATM(int amount,int accountnumber){
        this.amount=amount;
        ac=accountnumber;
    }
    public void Withdraw(int amt){
        if(amt>amount){
            System.out.println("insufficient balance");
        }
        else{
            amount=amount-amt;
            System.out.println("amount withdrawn from account number"+ac);
        }
    }
    public void Deposit(int amt){
        if(amt>0){
            amount=amount+amt;
        }
    }
    
}
public class ATMinterface{
    public static void main(String args []){
        int choice;
        Scanner in=new Scanner(System.in);
       
        int i=0;
        int a;
        int number;
        System.out.println("enter the no of users");
        int n=in.nextInt();
        ATM arr[]=new ATM[n];
        for(i=0;i<n;i++){
            System.out.println("enter the account number "+(i+1));
    
            a=in.nextInt();
            System.out.println("enter the initial amount");
            number=in.nextInt();
            arr[i]=new ATM(number,a);
        }
        /*System.out.println("user details");
        for(i=0;i<n;i++){
            System.out.println("account no:"+arr[i].ac+"amount"+arr[i].amount);
        }*/
        do{
            System.out.print("1.transaction History\n2.Withdraw\n3.Deposit\n4.Transfer\n5.Quit");
            choice=in.nextInt();
            switch(choice){
                case 1:
                  System.out.println("enter the account number:");
                  int acc=in.nextInt();
                  int j;
                  System.out.println("account numbers to which amount transfered from "+acc);
                  for(j=0;j<n;j++){
                    if(arr[j].ac==acc){
                        for(int k=0;k<arr[j].list.size();k++){
                         System.out.println(arr[j].list.get(k));
                        } 
                    }
                  }
                  break;
                case 2:
                System.out.println("enter the ac number");
                int account=in.nextInt();
                System.out.println("enter the amount you want to withdraw:");
                int amount=in.nextInt();
        
                for(i=0;i<n;i++){
                    //System.out.println("entered in for loop");
                    if(arr[i].ac==account){
                        System.out.println("account found");
                        arr[i].Withdraw(amount);
                        break;
                    }
                }
                break;
                case 3:
                System.out.println("enter the ac number");
                int account2=in.nextInt();
                     System.out.println("enter the amount you want to Deposit:");
                     int amount1=in.nextInt();
                    
                     for(j=0;j<n;j++){
                         if(arr[j].ac==account2){
                             arr[j].Deposit(amount1);
                         }
                     }
                      break;
                case 4:
                    System.out.println("enter your account number");
                    int acn=in.nextInt();
                     System.out.println("enter the amount you want to Tranfer:");
                int amount2=in.nextInt();
                int ind=-1;
                for(i=0;i<n;i++){
                    if(arr[i].ac==acn){
                        arr[i].Withdraw(amount2);
                        ind=i;
                        break;
                    }
                }
                    System.out.println("enter the account number you want to transfer money");
                    int ac=in.nextInt();
                    for(i=0;i<n;i++){
                    if(arr[i].ac==ac){
                        arr[i].Deposit(amount2);
                        break;
                    }

                }
                if(i==n&& ind!=-12){
                    arr[ind].Deposit(amount2);
                }
                if(ind!=-1){
                arr[ind].list.add(ac);
                }
                break;
                case 5:
                   System.out.println("------Thank you----");
                   break;
            }
        }while(choice!=5);
    }
}