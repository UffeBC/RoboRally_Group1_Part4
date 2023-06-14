import dk.dtu.compute.se.pisd.roborally.StartRoboRally;
import dk.dtu.compute.se.pisd.roborally.controller.RESTController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @deprecated
 */
public class REST_Test {
    private String args;

    @Test
    public void RestT() {
        SpringApplication.run(StartRoboRally.class, args);
        RESTController flicntr = new RESTController();
        flicntr.uploadFile();
        assertEquals(flicntr.downloadFile("localhost"), flicntr);
    }



}
