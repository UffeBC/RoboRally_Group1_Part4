package dk.dtu.compute.se.pisd.roborally.model.actions;

import dk.dtu.compute.se.pisd.roborally.model.Maps.GoldStripe;
import dk.dtu.compute.se.pisd.roborally.model.Phase;
import dk.dtu.compute.se.pisd.roborally.model.Player;
import dk.dtu.compute.se.pisd.roborally.model.Board;

public class ActionHandler {

    public enum actions {
        CONVEYOR, REPAIR, REBOOT, WALL, LASER, PIT
    }

    public static void exePushPanel(String space, Player player) {
        //White 3-4
        if (space.equals("0A"))
            player.setSpace(player.board.getSpace(player.getSpace().x,player.getSpace().y+1)); //down
        if (space.equals("1A"))
            player.setSpace(player.board.getSpace(player.getSpace().x-1,player.getSpace().y)); //left
        if (space.equals("2A"))
            player.setSpace(player.board.getSpace(player.getSpace().x,player.getSpace().y-1)); //up
        if (space.equals("3A"))
            player.setSpace(player.board.getSpace(player.getSpace().x+1,player.getSpace().y)); //right

        //Grey 1-2-3
        if (space.equals("0B"))
            player.setSpace(player.board.getSpace(player.getSpace().x,player.getSpace().y+1)); //down
        if (space.equals("1B"))
            player.setSpace(player.board.getSpace(player.getSpace().x-1,player.getSpace().y)); //left
        if (space.equals("2B"))
            player.setSpace(player.board.getSpace(player.getSpace().x,player.getSpace().y-1)); //up
        if (space.equals("3B"))
            player.setSpace(player.board.getSpace(player.getSpace().x+1,player.getSpace().y)); //right
    }

    public static void exeConveyer(String space, Player player) {
        // CORNERS
        for (int j = 0; j < 4; j++) {
            if (space.equals("0"+(char)(67+j))||space.equals("1"+(char)(67+j)))
                player.setHeading(player.getHeading().prev()); //turn left
            if (space.equals("2"+(char)(67+j))||space.equals("3"+(char)(67+j)))
                player.setHeading(player.getHeading().next()); //turn right
        }
        if (space.equals("0C")||space.equals("3C")||space.equals("0E")||space.equals("3E")) {
            player.setSpace(player.board.getSpace(player.getSpace().x, player.getSpace().y+1));// down
        }
        if (space.equals("1D")||space.equals("2D")||space.equals("1F")||space.equals("2F")) {
            player.setSpace(player.board.getSpace(player.getSpace().x, player.getSpace().y-1));// up
        }
        if (space.equals("0D")||space.equals("2C")||space.equals("0F")||space.equals("2E")) {
            player.setSpace(player.board.getSpace(player.getSpace().x+1, player.getSpace().y));// right
        }
        if (space.equals("1C")||space.equals("3D")||space.equals("1E")||space.equals("3F")) {
            player.setSpace(player.board.getSpace(player.getSpace().x-1, player.getSpace().y));// left
        }

//        int colorSpeed = 0;
//        for (int i = 0; i < 4; i++) {
//
//        }
        // BLUE Junk
        if (space.equals("4B")||space.equals("0J")||space.equals("3K")||space.equals("4J")) {
            player.setSpace(player.board.getSpace(player.getSpace().x, player.getSpace().y-2)); // up
        }
        if (space.equals("4C")||space.equals("1K")||space.equals("2J")||space.equals("5K")){
            player.setSpace(player.board.getSpace(player.getSpace().x,player.getSpace().y+2)); // down
        }
        if (space.equals("5B")||space.equals("0K")||space.equals("1J")||space.equals("5J")){
            player.setSpace(player.board.getSpace(player.getSpace().x+2,player.getSpace().y)); // right
        }
        if (space.equals("5C")||space.equals("2K")||space.equals("3J")||space.equals("4K")){
            player.setSpace(player.board.getSpace(player.getSpace().x-2,player.getSpace().y)); // left
        }

        // Yellow Junk
        if (space.equals("0G")||space.equals("0H")||space.equals("0I")||space.equals("4I")) {
            player.setSpace(player.board.getSpace(player.getSpace().x, player.getSpace().y-1)); // up
        }
        if (space.equals("1G")||space.equals("2H")||space.equals("2I")||space.equals("5H")){
            player.setSpace(player.board.getSpace(player.getSpace().x,player.getSpace().y+1)); // down
        }
        if (space.equals("3G")||space.equals("1H")||space.equals("1I")||space.equals("4H")){
            player.setSpace(player.board.getSpace(player.getSpace().x+1,player.getSpace().y)); // right
        }
        if (space.equals("2G")||space.equals("3H")||space.equals("3I")||space.equals("5I")){
            player.setSpace(player.board.getSpace(player.getSpace().x-1,player.getSpace().y)); // left
        }



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

    public static void pushPanel(String space, Player player){
        exePushPanel(space, player);
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