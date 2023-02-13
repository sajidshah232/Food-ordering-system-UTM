package classes;

public class MenuList {
    String foodName, foodCode, foodCategory;
    double price;

    MenuList(String foodName, double price, String foodCode, String foodCategory) {
        this.foodName = foodName;
        this.price = price;
        this.foodCode = foodCode;
        this.foodCategory = foodCategory;
    }

    public String getFoodCategory() {
        return foodCategory;
    }

    public String getFoodName() {
        return foodName;
    }

    public double getPrice() {
        return price;
    }

    public String getFoodCode() {
        return foodCode;
    }
}
