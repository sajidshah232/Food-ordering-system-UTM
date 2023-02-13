package classes;

import java.util.Vector;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Customer {
    String name, address, phone;
    double total;
    Vector<  MenuList> Cart = new Vector<  MenuList>();

    public Customer(String name, String address, String pNumb){
        this.name = name;
        this.address = address;
        this.phone = pNumb;
    }

    public String getName()
    { return name;
    }
    public String getAdress()
    {
        return address;
    }
    public String getPhone()
    { return phone;
    }
    
    public void addCart() throws FileNotFoundException{
        Scanner foodSelection = new Scanner(System.in);
        Scanner list = new Scanner(new File("./assets/Menu.txt"));
        
        
        System.out.print("Please enter the food code: ");
        String code = foodSelection.next();

        while(list.hasNextLine()){
            String food = list.nextLine();
            
            if(food.length() > 0){
                String[] arr = food.split(",");
                String categoryName = arr[0];
                String foodName = arr[1];
                double pricelist = Double.parseDouble(arr[2]);
                String foodCode = arr[3];

                if(code.toUpperCase().equals(foodCode)){
                    MenuList menu = new   MenuList(foodName, pricelist ,foodCode , categoryName);
                    Cart.add(menu);
                }
                
            }
        }
    }

    public void removeCart(){
        Scanner remove = new Scanner(System.in);
        boolean out = true;
        while(out != false){
            System.out.println("--------------------------------------------------\n"+
                              "|                     YOUR ORDER SUMMARY                  |\n"+
                              "---------------------------------------------------\n");
            if(Cart.size() != 0){
                int i = 1;
                for(  MenuList list : Cart){
                    System.out.println(i + ". " + list.getFoodName() + "\t\tRM" + list.getPrice());
                    i++;
                }

                System.out.print("Enter the food number to remove (Enter 0 to exit):");
                int index = remove.nextInt();

                if(index <= Cart.size() && index != 0){
                    Cart.remove(index - 1);
                }else if(index == 0){
                    out = false;
                }
            }else{
                System.out.println("Food Cart is Empty");
                out = false;
            }
        }
    }

    public void count(){
        for(MenuList list : Cart){
            total += list.getPrice();
        }
        System.out.println("\nTotal bill: RM " + total +"\n");
    }

    public void printReceipt(){
        int i = 1;
        System.out.println("-----------------------------------------------------\n"+
                           "|                 YOUR TOTAL BILL               |\n"+
                           "----------------------------------------------------\n");
        System.out.println("Name   : " + getName());
        System.out.println("Address: " + getAdress());
        System.out.println("Phone Number: " + getPhone());
        System.out.println("\nOrdered Items ");
        for(  MenuList list : Cart){
            System.out.println(i + ". " + list.getFoodName() + "\t\tRM" + list.getPrice());
            i++;
        }
        count();
    }
}
