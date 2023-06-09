package dk.dtu.compute.se.pisd.roborally.controller;

import dk.dtu.compute.se.pisd.roborally.fileaccess.LoadBoard;
import dk.dtu.compute.se.pisd.roborally.model.Board;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.io.*;

@RestController
public class FileUploadController {

    @GetMapping("/upload")
    public String uploadFile(/*@RequestBody String json*/) {
        try {

            String json = "Share";
            // Write the JSON content to a file
            String filePath = "target/classes/boards/Share.json";
            System.out.println("File to web: "+filePath);

            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            StringBuilder x = new StringBuilder();
            while (bufferedReader.ready() != false)
            {

                x.append(bufferedReader.readLine());
            }

            bufferedReader.close();


            return x.toString();//"File uploaded successfully!";
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to upload the file.";
        }
    }

    //@PostMapping("/upload")
//    @GetMapping("/upload")
    @RequestMapping("/target/classes/boards/ShareIn.json")
    public String updateJsonFile() {
        try {
            String filePath = "target/classes/boards/ShareIn.json";

            // Write the JSON content to the file
            StringBuilder x = new StringBuilder();
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(x.toString());
            bufferedWriter.close();

            return "JSON file updated successfully!";
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to update the JSON file.";
        }


    }
}