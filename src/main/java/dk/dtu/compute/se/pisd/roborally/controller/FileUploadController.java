package dk.dtu.compute.se.pisd.roborally.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@RestController
public class FileUploadController {

    @PostMapping("/upload")
    public String uploadFile(@RequestBody String json) {
        try {
            // Write the JSON content to a file
            String filePath = "target/classes/boards/TestSave.json";
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(json);
            bufferedWriter.close();

            return "File uploaded successfully!";
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to upload the file.";
        }
    }
}