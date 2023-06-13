package dk.dtu.compute.se.pisd.roborally.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.*;

/**
 *
 * @Author: Aleksander Sønder.
 */
@RestController
public class RESTController {

    private String fileToUpload="Share";

    @GetMapping("/upload")
    public String uploadFile(/*String uplfl*/) {


 //       String json = "Share";
        // Write the JSON content to a file
        String filePath = "target/classes/boards/"+fileToUpload+".json";
  //      String filePath = "target/classes/boards/"+uplfl+".json";
        System.out.println("File to web: "+filePath);

        try {
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
    @GetMapping(value = "/uploadt")
    public String downloadFile(String dlHost)
    {

      //  String uri = "http://localhost:8080/upload";
        String uri = "http://"+dlHost+":8080/upload";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        String filePath = "target/classes/boards/ShareIn.json";
        System.out.println("Download file to ShareIn.json from: "+uri);

        try {

            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            assert result != null;
            bufferedWriter.write(result);
            bufferedWriter.close();
            //
            System.out.println(result);
            return result;
        }catch (IOException e) {
            return "Failed to download the file from"+filePath+".";
 //           e.printStackTrace();

        }


    }

    public void setFileToUpload(String flName)
    {
        fileToUpload=flName;
    }

}