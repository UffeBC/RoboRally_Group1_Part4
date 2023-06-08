package dk.dtu.compute.se.pisd.roborally.model;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UploadingFilesApplication {
/*
    public static void main(String[] args) {
        SpringApplication.run(UploadingFilesApplication.class, "share");
    }

 */
    public void uploadf(String flo)
    {
        SpringApplication.run(UploadingFilesApplication.class, flo);
    }

}
