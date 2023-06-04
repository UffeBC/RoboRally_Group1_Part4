package dk.dtu.compute.se.pisd.roborally.model.Core;

import dk.dtu.compute.se.pisd.roborally.model.Player;

public class Value {
    public static String map;

    public static int amountOfPlayers;

    // USED IN BOARD_VIEW
    public static boolean MovePlayer;
    public static Player selectedPLayer;


    public static int clickCounter = 0;

    public int getAmountOfPlayers()
    {
        return amountOfPlayers;
    }
    public String getMap()
    {
        return map;
    }

    public boolean getMovePlayer()
    {
        return MovePlayer;
    }

    public Player getSelectedPLayer()
    {
        return selectedPLayer;
    }
}
