package dk.dtu.compute.se.pisd.roborally.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.*;

/**
 * RestController is used for making restful web services with the help of the @RestController annotation.
 * It is used at the class level and allows the class to handle the requests made by the client.
 * */

@RestController
public class RESTController {

    private String fileToUpload="Share";

    /**
     * GetMapping("/upload") takes the content from the json file and publish it to localhost:8080/upload
     * */
    @GetMapping("/upload")
    public String uploadFile() {

        String filePath = "target/classes/boards/"+fileToUpload+".json";
        System.out.println("File to web: "+filePath);

        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            StringBuilder x = new StringBuilder();
            while(bufferedReader.ready()){
                x.append(bufferedReader.readLine());
            }

            bufferedReader.close();

            return x.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to upload the file.";
        }
    }

    /**
     * GetMapping("/uploadt") takes the specific json (game) from /uploadt and updates the specific json file
     * */

    @GetMapping(value = "/uploadt")
    public String downloadFile(String dlHost)
    {
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
        }
    }

    public void setFileToUpload(String flName)
    {
        fileToUpload=flName;
    }

}