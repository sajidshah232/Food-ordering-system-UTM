package classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class Menu implements foodFunction {
    ArrayList<MenuList> foodList = new ArrayList<MenuList>();
    int repeat = 0;

    public static enum FoodCategory
    {
        CASE1("MALAY FOODS"),
        CASE2("CHINESE FOODS"),
        CASE3("THAI FOODS");

        private String categoryName;

        FoodCategory(String categoryName)
        {

            this.categoryName = categoryName;
        }

        public String getCategory()
        {
            return categoryName;
        }
    }

    public void sortFood() throws FileNotFoundException {

        Scanner input = new Scanner(new File("./assets/Menu.txt"));

        while (input.hasNextLine()) {
            String s = input.nextLine();

            if (s.length() > 0) {
                String[] arr = s.split(",");
                String categoryName = arr[0];
                String foodName = arr[1];
                double pricelist = Double.parseDouble(arr[2]);
                String foodCode = arr[3];

                MenuList food = new MenuList(foodName.toUpperCase(), pricelist, foodCode, categoryName);
                foodList.add(food);

            }
        }
    }

    public void addFood() throws FileNotFoundException {
        Scanner edit = new Scanner(System.in);
        int i = 1;
        String categoryName, foodCode;

        System.out.println("\nFood Categoary:-");
        for (FoodCategory output : FoodCategory.values()) {
            System.out.println(i + ". " + output.getCategory());
            i++;
        }

        System.out.print("Select The Food Category: ");
        int adminChoice = edit.nextInt();

        System.out.print("\nEnter the food name: ");
        String foodName = edit.next();

        System.out.print("Enter the food price: ");
        double foodPrice = edit.nextDouble();

        System.out.print("Enter the food code number (eg: 01): ");
        String foodId = edit.next();


        if (adminChoice == 1) {

            categoryName = "CASE1";
            foodCode = "MALAY" + foodId;
        } else if (adminChoice == 2) {
            categoryName = "CASE2";
            foodCode = "CHINESE " + foodId;
        } else {
            categoryName = "CASE3";
            foodCode = "THAI" + foodId;
        }

        if (repeat == 0) {
            sortFood();
            repeat++;
        }

        MenuList food = new   MenuList(foodName, foodPrice, foodCode, categoryName);
        foodList.add(food);
        UploadFoodlist();
    }

    public void deleteFood() throws FileNotFoundException {
        Scanner deleteScanner = new Scanner(System.in);
        System.out.print(" To delete Food item, Please Enter the Food ID : ");
        String FoodId = deleteScanner.nextLine();

        if (repeat == 0) {
            sortFood();
            repeat++;
        }

        int c = 0;
        int temp = 0;
        for (  MenuList foodListChoice : foodList) {

            if (foodListChoice.getFoodCode().equals(FoodId)) {
                System.out.println("\n The Food is deleted: ");
                System.out.println(foodListChoice.getFoodName() + " : RM " + foodListChoice.getPrice());

                temp = c;
            }
            c++;
        }
        foodList.remove(temp);
        UploadFoodlist();
    }

    public void UploadFoodlist() {

        try {

            File file = new File("./assets/Menu.txt");
            PrintWriter writer = new PrintWriter(file);

            for (  MenuList menu : foodList) {
                writer.println(
                        menu.getFoodCategory() + "," + menu.getFoodName() + "," + menu.getPrice() + "," + menu.getFoodCode());
            }
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void print(int option) throws FileNotFoundException {
        if (repeat == 0) {
            sortFood();
            repeat++;
        }

       for (  MenuList foodListChoice : foodList) {

            if (foodListChoice.getFoodCategory().equals("CASE1") && option == 1) {

                System.out.println(foodListChoice.getFoodCode() + ". " + foodListChoice.getFoodName() + " : RM "
                        + foodListChoice.getPrice());
            } else if (foodListChoice.getFoodCategory().equals("CASE2") && option == 2) {
                System.out.println(foodListChoice.getFoodCode() + ". " + foodListChoice.getFoodName() + " : RM "
                        + foodListChoice.getPrice());
            } else if (foodListChoice.getFoodCategory().equals("CASE3") && option == 3) {
                System.out.println(foodListChoice.getFoodCode() + ". " + foodListChoice.getFoodName() + " : RM "
                        + foodListChoice.getPrice());
            }
        }
    }

    public void print() throws FileNotFoundException {
        if (repeat == 0) {
            sortFood();
            repeat++;
        }


        System.out.println("\nMalay Food");
        for (  MenuList foodListChoice : foodList) {
            if (foodListChoice.getFoodCategory().equals("CASE1"))
                System.out.println(foodListChoice.getFoodCode() + ". " + foodListChoice.getFoodName() + " : RM "
                        + foodListChoice.getPrice());
        }

        System.out.println("\nChinese Food");
        for (  MenuList foodListChoice : foodList) {
            if (foodListChoice.getFoodCategory().equals("CASE2"))
                System.out.println(foodListChoice.getFoodCode() + ". " + foodListChoice.getFoodName() + " : RM "
                        + foodListChoice.getPrice());
        }

        System.out.println("\nTHAI Food");
        for (  MenuList foodListChoice : foodList) {
            if (foodListChoice.getFoodCategory().equals("CASE3"))
                System.out.println(foodListChoice.getFoodCode() + ". " + foodListChoice.getFoodName() + " : RM "
                        + foodListChoice.getPrice());
        }
    }

}
