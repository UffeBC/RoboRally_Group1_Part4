package dk.dtu.compute.se.pisd.roborally.controller;

import ch.qos.logback.core.model.Model;
import org.springframework.core.io.UrlResource;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.net.URLConnection;

import static java.lang.System.currentTimeMillis;

@RestController
public class FileUploadController {

    @PostMapping("/upload")
    public String uploadFile(/*@RequestBody String json*/) {
        try {

            String json = "TestSave2";
            // Write the JSON content to a file
            String filePath = "target/classes/boards/TestSave2.json";
//            FileWriter fileWriter = new FileWriter(filePath);
//            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            //
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            StringBuilder x = new StringBuilder();
            while(bufferedReader.ready()){
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



    //
    @GetMapping(value = "/upload/{width}")
    public String greeting(
            @RequestParam(value="width") String width, Model model) {
        model.getBodyText();
        System.out.println(model.getBodyText());
        return "hi";
    }
    //

    @GetMapping("/uploads")
    @ResponseBody
    public String getFile(/*@RequestBody String json*/) {
        try {

            //String json = "TestSave2";
            // Write the JSON content to a file
            String filePath = "target/classes/boards/TestSave.json";

            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            UrlResource resource = new UrlResource("http://localhost:8080/update");

//            @RequestParam
           // @RequestBody String s
//                    @ResponseBody


//            File fil = resource.getFile();
//
////            String fileToRead = "localhost:8080/upload";
//            FileReader fileReader = new FileReader(fil);
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//
//
//            StringBuilder x = new StringBuilder();
//            while(bufferedReader.readLine()!=null){
//                x.append(bufferedReader.readLine());
//            }
        //dependency injection


            bufferedWriter.write(2);
            bufferedWriter.close();

            return String.valueOf(UrlResource.from("http://localhost:8080/update").contentLength());//"File uploaded successfully!";
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to upload the file.";
        }
    }
}