package repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class RWOperations {
    private String file;

    public RWOperations(){
        this.file = "informazioni.txt";
    }

    //lettura da file
    public List<String> getData(){
        //lettura da file
        try {
            List<String> lines = Files.readAllLines(Paths.get(this.file));
            return lines;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
