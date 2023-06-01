package dk.dtu.compute.se.pisd.roborally.model.actions;

import dk.dtu.compute.se.pisd.roborally.model.Maps.GoldStripe;
import dk.dtu.compute.se.pisd.roborally.model.Phase;
import dk.dtu.compute.se.pisd.roborally.model.Player;
import dk.dtu.compute.se.pisd.roborally.model.Board;

public class ActionHandler {

    public enum actions {
        CONVEYOR, REPAIR, REBOOT, WALL, LASER, PIT
    }

    public static void exeConveyer(String space, Player player) {
        //---------------BLUES----------------------
        // Blue Corners

        if (space.equals("0C")) player.setHeading(player.getHeading().prev());
        if (space.equals("1C")) player.setHeading(player.getHeading().prev());
        if (space.equals("2C")) player.setHeading(player.getHeading().next());
        if (space.equals("3C")) player.setHeading(player.getHeading().next());

        if (space.equals("0D")) player.setHeading(player.getHeading().prev());
        if (space.equals("1D")) player.setHeading(player.getHeading().prev());
        if (space.equals("2D")) player.setHeading(player.getHeading().next());
        if (space.equals("3D")) player.setHeading(player.getHeading().next());

        // Blue Straights

        if (space.equals("4B")) player.setSpace(player.board.getSpace(player.getSpace().x, player.getSpace().y - 2));
        if (space.equals("5B")) player.setSpace(player.board.getSpace(player.getSpace().x + 2, player.getSpace().y));
        if (space.equals("4C")) player.setSpace(player.board.getSpace(player.getSpace().x, player.getSpace().y + 2));
        if (space.equals("5C")) player.setSpace(player.board.getSpace(player.getSpace().x - 2, player.getSpace().y));

        // Blue Junctions


        if (space.equals("0J")) player.setSpace(player.board.getSpace(player.getSpace().x, player.getSpace().y - 1));
        if (space.equals("1J")) player.setSpace(player.board.getSpace(player.getSpace().x + 1, player.getSpace().y));
        if (space.equals("2J")) player.setSpace(player.board.getSpace(player.getSpace().x, player.getSpace().y + 1));
        if (space.equals("3J")) player.setSpace(player.board.getSpace(player.getSpace().x - 1, player.getSpace().y));
        if (space.equals("4J")) player.setSpace(player.board.getSpace(player.getSpace().x, player.getSpace().y - 1));
        if (space.equals("5J")) player.setSpace(player.board.getSpace(player.getSpace().x + 1, player.getSpace().y));

        if (space.equals("0K")) player.setSpace(player.board.getSpace(player.getSpace().x, player.getSpace().y - 1));
        if (space.equals("1K")) player.setSpace(player.board.getSpace(player.getSpace().x + 1, player.getSpace().y));
        if (space.equals("2K")) player.setSpace(player.board.getSpace(player.getSpace().x, player.getSpace().y + 1));
        if (space.equals("3K")) player.setSpace(player.board.getSpace(player.getSpace().x - 1, player.getSpace().y));
        if (space.equals("4K")) player.setSpace(player.board.getSpace(player.getSpace().x - 1, player.getSpace().y));
        if (space.equals("5K")) player.setSpace(player.board.getSpace(player.getSpace().x, player.getSpace().y + 1));

        //-------------YELLOWS---------------------
        // Yellow Corners

        if (space.equals("0E")) player.setHeading(player.getHeading().prev());
        if (space.equals("0E")) player.setSpace(player.board.getSpace(player.getSpace().x, player.getSpace().y + 1));
        if (space.equals("1E")) player.setHeading(player.getHeading().prev());
        if (space.equals("1E")) player.setSpace(player.board.getSpace(player.getSpace().x - 1, player.getSpace().y));
        if (space.equals("2E")) player.setHeading(player.getHeading().next());
        if (space.equals("2E")) player.setSpace(player.board.getSpace(player.getSpace().x + 1, player.getSpace().y));
        if (space.equals("3E")) player.setHeading(player.getHeading().next());
        if (space.equals("3E")) player.setSpace(player.board.getSpace(player.getSpace().x, player.getSpace().y + 1));

        if (space.equals("0F")) player.setHeading(player.getHeading().prev());
        if (space.equals("0F")) player.setSpace(player.board.getSpace(player.getSpace().x + 1, player.getSpace().y));
        if (space.equals("1F")) player.setHeading(player.getHeading().prev());
        if (space.equals("1F")) player.setSpace(player.board.getSpace(player.getSpace().x, player.getSpace().y + 1));
        if (space.equals("2F")) player.setHeading(player.getHeading().next());
        if (space.equals("2F")) player.setSpace(player.board.getSpace(player.getSpace().x, player.getSpace().y + 1));
        if (space.equals("3F")) player.setHeading(player.getHeading().next());
        if (space.equals("3F")) player.setSpace(player.board.getSpace(player.getSpace().x - 1, player.getSpace().y));
        // Yellow Straights

        if (space.equals("0G")) player.setSpace(player.board.getSpace(player.getSpace().x, player.getSpace().y - 1));
        if (space.equals("1G")) player.setSpace(player.board.getSpace(player.getSpace().x, player.getSpace().y + 1));
        if (space.equals("2G")) player.setSpace(player.board.getSpace(player.getSpace().x - 1, player.getSpace().y));
        if (space.equals("3G")) player.setSpace(player.board.getSpace(player.getSpace().x + 1, player.getSpace().y));


        // Yellow Junctions

        if (space.equals("0H")) player.setSpace(player.board.getSpace(player.getSpace().x, player.getSpace().y - 1));
        if (space.equals("1H")) player.setSpace(player.board.getSpace(player.getSpace().x + 1, player.getSpace().y));
        if (space.equals("2H")) player.setSpace(player.board.getSpace(player.getSpace().x, player.getSpace().y + 1));
        if (space.equals("3H")) player.setSpace(player.board.getSpace(player.getSpace().x - 1, player.getSpace().y));
        if (space.equals("4H")) player.setSpace(player.board.getSpace(player.getSpace().x + 1, player.getSpace().y));
        if (space.equals("5H")) player.setSpace(player.board.getSpace(player.getSpace().x, player.getSpace().y + 1));

        if (space.equals("0I")) player.setSpace(player.board.getSpace(player.getSpace().x, player.getSpace().y - 1));
        if (space.equals("1I")) player.setSpace(player.board.getSpace(player.getSpace().x + 1, player.getSpace().y));
        if (space.equals("2I")) player.setSpace(player.board.getSpace(player.getSpace().x, player.getSpace().y + 1));
        if (space.equals("3I")) player.setSpace(player.board.getSpace(player.getSpace().x - 1, player.getSpace().y));
        if (space.equals("4I")) player.setSpace(player.board.getSpace(player.getSpace().x, player.getSpace().y - 1));
        if (space.equals("5I")) player.setSpace(player.board.getSpace(player.getSpace().x - 1, player.getSpace().y));

        // pit
        if (space.equals("5A"))
            for (int i = player.getSpace().y; i < 12; i++) {
                for (int j = player.getSpace().x; j < 15; j++) {
                    if (space.equals("6A")) {
                        player.setSpace(player.board.getSpace(j, i));
                        break;
                    }
                    if (space.equals("6A")) break;
                }

            }

    }

    public static void exePit(String space) {
        if (space.equals("5A"))
            System.out.println("HitPit");

    }

    public static void exeReboot(Player currentplayer) {

//        currentplayer.setSpace();
    }


    public static void exeAction(String space, Player player) {
//        System.out.println(space);
        exeConveyer(space, player);

    }

    public static void exeGiveToken(String space, Player player) {
        if (space.equals("1N")){
            if(player.getCheckToken() == 0){
                player.setCheckToken();

            }
        }
        else if (space.equals("2N")){
            if(player.getCheckToken() == 1 ){
                player.setCheckToken();
            }
        }
        else if (space.equals("3N")){
            if(player.getCheckToken() == 2 ){
                player.setCheckToken();
                player.board.setPhase(Phase.GAME_WON);
            }
        }
    }
}