
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OptionMenu extends Account {
    int selection;
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
    HashMap <Integer, Integer> data = new HashMap<Integer, Integer>();

    /* Validate customer number and pin */
    public void getLogin() throws IOException {
        int x = 1;
        do {
            try {
                data.put(767609758, 5643);
                data.put(934455848, 6329);
                System.out.println("Welcome to ABC ATM!!!");
                System.out.println("Enter Your Customer Number:");
                setCustomerNumber(menuInput.nextInt());
                System.out.println("Enter The Pin Number:");
                setPinNumber(menuInput.nextInt());

            } catch (Exception e) {
                System.out.println("\nInvalid Characters.only number\n");
                x = 2;
            }
            for (Map.Entry<Integer, Integer> entry : data.entrySet()) {
                if (entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber()) {
                    getAccountType();
                }x=2;
            }if (x==2){
                System.out.println("\nInvalid Credential or You are exit\n");
            }
        }while (x == 1) ;
    }


    /* Display Selection menu*/
    public void getAccountType() {
            System.out.println(".......... Select Account Type ..........");
            System.out.println("Type 1-Checking Account");
            System.out.println("Type 2-Savings Account");
            System.out.println("Type 3- Exit");
            System.out.println("Enter Your Choice:");
            selection = menuInput.nextInt();
            switch (selection) {
                case 1:
                    getChecking();
                    break;
                case 2:
                    getSavings();
                    break;
                case 3:
                    System.out.println("Thank you for using ABC ATM,Visit Again!");
                    break;
                default:
                    System.out.println("\nInvalid Choice.\n");
                    getAccountType();
            }
        }
    /* Display the checking account selection*/
    public void getChecking(){
        System.out.println(".......... Checking account ..........");
        System.out.println("Type 1-View Balance");
        System.out.println("Type 2-Withdraw Funds");
        System.out.println("Type 3-Deposit Funds:");
        System.out.println("Type 4- Exit");
        System.out.println("Enter Your Choice:");
        selection = menuInput.nextInt();
        switch(selection){
            case 1:
                System.out.println("Checking Account Balance:"+ moneyFormat.format(getCheckingBalance()));
                getAccountType();
                break;
            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank you for using ABC ATM,Visit Again!");
                break;
            default:
                System.out.println("\nInvalid Choice.\n");
                getChecking();
        }
    }
    /* Display savings account selection*/
    public void getSavings(){
        System.out.println(".......... Savings account ..........");
        System.out.println("Type 1-View Balance");
        System.out.println("Type 2-Withdraw Funds");
        System.out.println("Type 3-Deposit Funds:");
        System.out.println("Type 4- Exit");
        System.out.println("Enter Your Choice:");
        selection = menuInput.nextInt();
        switch(selection){
            case 1:
                System.out.println("Checking Account Balance:"+moneyFormat.format(getSavingBalance()));
                getAccountType();
                break;
            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getSavingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank you for using ABC ATM,Visit Again!");
                break;
            default:
                System.out.println("\nInvalid Choice\n");
                getSavings();
                break;
        }
    }

}