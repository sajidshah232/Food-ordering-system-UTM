package classes;

import java.io.FileNotFoundException;

public interface foodFunction {
    void sortFood() throws FileNotFoundException;

    void addFood() throws FileNotFoundException;

    void deleteFood() throws FileNotFoundException;

    void UploadFoodlist();
}
