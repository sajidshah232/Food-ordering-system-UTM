package classes;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Admin extends Menu{

    public void editOption() throws FileNotFoundException{
        boolean loop = true;

        while(loop != false){
            Scanner option = new Scanner(System.in);
            System.out.println("\n Dear Admin what you would like to do?  ");
            System.out.println(" 1. Show All Food");
            System.out.println(" 2. Add New Food");
            System.out.println(" 3. Delete Existing Food");
            System.out.println(" 4. Exit");
            System.out.print("Select your Option: ");
            int adminOption = option.nextInt();

            switch(adminOption){
                case 1:
                    print();
                    break;
                case 2: 
                    addFood();
                    break;
                case 3:
                    deleteFood();
                    break;
                case 4:
                    loop = false;
                    System.out.println("Thank Admin!\n\n");
                    break;
                default:
                    System.out.println("Please Enter Only The Available Option (1-4)\n");
            }

        }
    }


    }

