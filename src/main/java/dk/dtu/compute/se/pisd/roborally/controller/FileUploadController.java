package dk.dtu.compute.se.pisd.roborally.controller;

import org.springframework.web.bind.annotation.*;

import java.io.*;

@RestController
public class FileUploadController {

    @PostMapping("/upload")
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
            while(bufferedReader.readLine()!=null){
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




    @GetMapping("/upload")
    public String getFile(/*@RequestBody String json*/) {
        try {

            String json = "TestSave2";
            // Write the JSON content to a file
            String filePath = "target/classes/boards/TestSave.json";

            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            FileReader fileReader = new FileReader("http://10.209.211.226:8080/upload");
            BufferedReader bufferedReader = new BufferedReader(fileReader);


            StringBuilder x = new StringBuilder();
            while(bufferedReader.readLine()!=null){
                x.append(bufferedReader.readLine());
            }
        //dependency injection


            bufferedWriter.write(x.toString());
            bufferedWriter.close();

            return x.toString();//"File uploaded successfully!";
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to upload the file.";
        }
    }
}