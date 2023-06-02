package dk.dtu.compute.se.pisd.roborally.fileaccess.model;

import dk.dtu.compute.se.pisd.roborally.model.CommandCardField;
import dk.dtu.compute.se.pisd.roborally.model.Heading;
import dk.dtu.compute.se.pisd.roborally.model.Space;


import java.util.ArrayList;
import java.util.List;

public class PlayerTemplate {

    public String name;
    public String color;

    public CommandCardField[] program;
    public CommandCardField[] cards;


    public Space space;
    public Heading heading;

    public int x, y;
}
