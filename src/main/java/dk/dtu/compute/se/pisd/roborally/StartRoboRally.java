/*
 *  This file is part of the initial project provided for the
 *  course "Project in Software Development (02362)" held at
 *  DTU Compute at the Technical University of Denmark.
 *
 *  Copyright (C) 2019, 2020,2021: Ekkart Kindler, ekki@dtu.dk
 *
 *  This software is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; version 2 of the License.
 *
 *  This project is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this project; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 */
package dk.dtu.compute.se.pisd.roborally;

import com.google.gson.JsonElement;
import dk.dtu.compute.se.pisd.roborally.controller.GameController;
import dk.dtu.compute.se.pisd.roborally.fileaccess.LoadBoard;
import dk.dtu.compute.se.pisd.roborally.fileaccess.Adapter;
import dk.dtu.compute.se.pisd.roborally.fileaccess.IOUtil;
import dk.dtu.compute.se.pisd.roborally.model.CommandCardField;
import dk.dtu.compute.se.pisd.roborally.model.Heading;
import dk.dtu.compute.se.pisd.roborally.model.Space;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.util.Arrays;
import java.util.Objects;

/**
 * This is a class for starting up the RoboRally application. This is a
 * workaround for a strange quirk in the Open JavaFX project launcher,
 * which prevents starting a JavaFX application in IntelliJ directly:
 *
 *   https://stackoverflow.com/questions/52569724/javafx-11-create-a-jar-file-with-gradle/52571719#52571719
 *
 * @author Ekkart Kindler, ekki@dtu.dk
 */
@SpringBootApplication
@RestController
public class StartRoboRally {


    public static void main(String[] args) {
        SpringApplication.run(StartRoboRally.class, args);
        System.out.println(LoadBoard.loadBoard("TestSave").width);
    }
    @GetMapping("/hi")
    public String name(
            @RequestParam(value = "name", defaultValue = "Player") String name,

            @RequestParam(value = "2") int x
            ){

        return String.format("Player: %s %s", name, x);
    };

    //private GameController gameController;
    @GetMapping("/saved")
    public String color(@RequestParam(value = "color", defaultValue = "Gray") String y
    ){

        //LoadBoard.saveBoard(gameController.board, "TestSave");
        return String.format("Color: %s, x:%s y:%s, test:",
                y,
                String.valueOf(LoadBoard.loadBoard("TestSave").getPlayer(1).getSpace().x),
                String.valueOf(LoadBoard.loadBoard("TestSave").getPlayer(1).getSpace().y)

                //String.valueOf(LoadBoard.loadBoard("TestSave").getPlayer(0).getSpace().y)
        );
    };

    /*@GetMapping("/y")
    public class PlayerTemplate() {
        return
    }*/

@GetMapping("/info")
    public String info(

            @RequestParam(value = "name", defaultValue = "Player") String name,
            @RequestParam(value = "color", defaultValue = "Gray") String color,

            @RequestParam(value = "CommandCardField", defaultValue = "1") String[] program
            //@RequestParam(value = "CommandCard", defaultValue = "2") String[] cards,

            //@RequestParam(value = "Space", defaultValue = "0") Space space
            //@RequestParam(value = "Heading", defaultValue = "South") Heading heading


            ){
    return String.format("Player: %s, Color: %s, Space: x%s y%s, Heading: new: %s"
            , name, color, 0,0, program[0]);




    };

//    public CommandCardField[] program(@RequestParam(value = "CommandCardField", defaultValue = "1") String[] program){
//        return program;
//    };

    public CommandCardField[] cards;


    public Space space;
    public Heading heading;


//    @SpringBootApplication
//    @RestController
//    public class DemoApplication {
//        public static void main(String[] args) {
//            SpringApplication.run(DemoApplication.class, args);
//        }
//        @GetMapping("/hello")
//        public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
//            return String.format("Hello %s!", name);
//        }
//    }

    /*@RestController
    public class HelloController {

        @GetMapping("/")
        public String index() {
            return "Greetings from Spring Boot!";
        }

    }*/

    /*
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }*/

}

