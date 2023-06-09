package dk.dtu.compute.se.pisd.roborally.controller;

import ch.qos.logback.core.model.Model;
import dk.dtu.compute.se.pisd.roborally.model.Player;
import org.springframework.core.io.UrlResource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.processing.Generated;
import java.io.*;
import java.net.URLConnection;
import java.util.List;

import static java.lang.System.currentTimeMillis;

@RestController
public class FileUploadController {

    @GetMapping("/upload")
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
    @GetMapping(value = "/uploadt")
    public String greeting() throws IOException {
        String uri = "http://localhost:8080/upload";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        String filePath = "target/classes/boards/TestSave.json";
        FileWriter fileWriter = new FileWriter(filePath);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        assert result != null;
        bufferedWriter.write(result);
        bufferedWriter.close();
        //
        System.out.println(result);
        //
        return result;
    }
    //

//    //
//    @Generated("jsonschema2pojo")
//    public class Example {
//
//        public Integer width;
//        public Integer height;
//        public List<Object> spaces;
//        public Integer numberOfPlayers;
//        public List<Player> players;
//        public String map;
//        public Integer amountOfPlayers;
//        public Boolean movePlayer;
//        public Integer selectedPLayer;
//        public Integer clickCounter;
//
//        /**
//         * No args constructor for use in serialization
//         *
//         */
//        public Example() {
//        }
//
//        /**
//         *
//         * @param numberOfPlayers
//         * @param amountOfPlayers
//         * @param selectedPLayer
//         * @param players
//         * @param movePlayer
//         * @param clickCounter
//         * @param width
//         * @param spaces
//         * @param map
//         * @param height
//         */
//        public Example(Integer width, Integer height, List<Object> spaces, Integer numberOfPlayers, List<Player> players, String map, Integer amountOfPlayers, Boolean movePlayer, Integer selectedPLayer, Integer clickCounter) {
//            super();
//            this.width = width;
//            this.height = height;
//            this.spaces = spaces;
//            this.numberOfPlayers = numberOfPlayers;
//            this.players = players;
//            this.map = map;
//            this.amountOfPlayers = amountOfPlayers;
//            this.movePlayer = movePlayer;
//            this.selectedPLayer = selectedPLayer;
//            this.clickCounter = clickCounter;
//        }
//
//    }
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
            // 10.209.211.226

        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to upload the file.";
        }
    }
}