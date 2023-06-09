package dk.dtu.compute.se.pisd.roborally.controller;

import org.springframework.web.bind.annotation.*;

import java.io.*;

@RestController
public class FileUploadController {

    @GetMapping("/upload")
    public String uploadFile(/*@RequestBody String json*/) {
        try {

            String json = "TestSave";
            // Write the JSON content to a file
            String filePath = "target/classes/boards/TestSave.json";
//            FileWriter fileWriter = new FileWriter(filePath);
//            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            //
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            StringBuilder x = new StringBuilder();
            while (bufferedReader.readLine() != null) {
                x.append(bufferedReader.readLine());
            }

            bufferedReader.close();
            //
            ;
//            bufferedWriter.write(json);
//            bufferedWriter.close();

            return x.toString();//"File uploaded successfully!";
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to upload the file.";
        }
    }

    @PostMapping("/updateJsonFile")
    public String updateJsonFile() {
        try {

            String json = "TestSave";
            String filePath = "target/classes/boards/TestSave.json";

            // Write the JSON content to the file
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(json);
            bufferedWriter.close();

            return "JSON file updated successfully!";
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to update the JSON file.";
        }


    }
}