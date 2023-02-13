import classes.Admin;
import classes.Customer;
import classes.Menu.FoodCategory;
import java.util.Scanner;
import classes.MenuList;
import classes.Menu;
public class Test{
    public static void main(String[] args) throws Exception {
        boolean loop = true;

        Scanner sc = new Scanner(System.in);
        while(loop != false){
            System.out.print("-------------------------------------------------\n"+
                         "         WELCOME TO ARCADE MERANTI \n" +
                    "            FOOD ORDERING SYSTEM        \n"+
                         "--------------------------------------------------\n"+
                         "\nDEAR USER, YOU WANT TO ACCESS AS :\n\n"+
                         "  \t(1). Manager \n"+
                         "  \t(2). Customer\n"+
                         "  \t(3). Exit  \n\n"+
                         "SELECT AN OPTION- ");
            int loginOption = sc.nextInt();

            switch(loginOption){
                case 1:
                    Admin adm1 = new Admin();

                    adm1.editOption();
                    break;

                case 2:
                    Menu food = new Menu();
                    boolean exit = true;
                    System.out.println("\nPlease Enter Your Details");
                    System.out.print("Enter your Good Name: ");
                    String name = sc.next();
            
                    System.out.print("Enter your Address For Delivery: ");
                    String address;
                    address = sc.next();

                    System.out.print("Enter your Active Phone Number: ");
                    String pNumb = sc.next();

                    Customer customer = new Customer(name, address, pNumb);

                    while(exit != false){
                        int i = 1;
                        System.out.println("\nWhat Food are you craving for? ");
                        for(FoodCategory output : FoodCategory.values()){
                            System.out.println(i + ". " + output.getCategory());
                            i++;
                        }
                        System.out.println("4. View your order");
                        System.out.println("5. Make payment");

                        System.out.print("Insert your choice: ");
                        int categoryOption = sc.nextInt();

                        switch(categoryOption){

                            case 1:
                                System.out.println("\nMalay Food:");
                                food.print(categoryOption);
                                customer.addCart();
                                break;

                            case 2:
                                System.out.println("\nChinese Food:");
                                food.print(categoryOption);
                                customer.addCart();
                                break;

                            case 3:
                                System.out.println("\nThai Food:");
                                food.print(categoryOption);
                                customer.addCart();
                                break;

                            case 4:
                                customer.removeCart();
                                break;

                            case 5:
                                exit = false;
                                customer.printReceipt();
                                System.out.println("\tThank You! Please come again\n");
                                break;
                            
                            default:
                                System.out.println("Please enter only the available option (1-6):");
                        }
                    }
                    break;

                case 3:
                    loop = false;
                    break;

                default:
                    System.out.println("Please enter only the available option (1-3):");
            }
        }
        sc.close();
    }
}