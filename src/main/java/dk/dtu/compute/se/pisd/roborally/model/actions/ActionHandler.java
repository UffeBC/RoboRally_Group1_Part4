package dk.dtu.compute.se.pisd.roborally.model.actions;

import dk.dtu.compute.se.pisd.roborally.model.Maps.GoldStripe;
import dk.dtu.compute.se.pisd.roborally.model.Player;

public class ActionHandler {

    public enum actions{
        CONVEYOR, REPAIR, REBOOT, WALL, LASER, PIT
    }
    public static void exeConveyer(String space, Player player) {
        //---------------BLUES----------------------
        // Blue Corners
        for (int i = 0; i < 4; i++) {
            if (space.equals(i+"C") || space.equals(i+"D"))
                System.out.println("Blue Corner");
        }
        if (space.equals("0C")) player.setHeading(player.getHeading().prev());
        if (space.equals("1C")) player.setHeading(player.getHeading().prev());
        if (space.equals("2C")) player.setHeading(player.getHeading().next());
        if (space.equals("3C")) player.setHeading(player.getHeading().next());

        if (space.equals("0D")) player.setHeading(player.getHeading().prev());
        if (space.equals("1D")) player.setHeading(player.getHeading().prev());
        if (space.equals("2D")) player.setHeading(player.getHeading().next());
        if (space.equals("3D")) player.setHeading(player.getHeading().next());

        // Blue Straights
        for (int i = 4; i < 6; i++) {
            if (space.equals(i+"B") ||space.equals(i+"C"))
                System.out.println("Blue Straight");
        }
        if (space.equals("4B")) player.setSpace(player.board.getSpace(player.getSpace().x, player.getSpace().y - 2));
        if (space.equals("5B")) player.setSpace(player.board.getSpace(player.getSpace().x+2,player.getSpace().y));
        if (space.equals("4C")) player.setSpace(player.board.getSpace(player.getSpace().x,player.getSpace().y+2));
        if (space.equals("5C")) player.setSpace(player.board.getSpace(player.getSpace().x-2,player.getSpace().y));

        // Blue Junctions
        for (int i = 0; i < 6; i++) {
            if (space.equals(i+"J") || space.equals(i+"K"))
                System.out.println("Blue Junction");
        }
        if (space.equals("0J")) player.setSpace(player.board.getSpace(player.getSpace().x,player.getSpace().y-1));
        if (space.equals("1J")) player.setSpace(player.board.getSpace(player.getSpace().x+1,player.getSpace().y));
        if (space.equals("2J")) player.setSpace(player.board.getSpace(player.getSpace().x,player.getSpace().y+1));
        if (space.equals("3J")) player.setSpace(player.board.getSpace(player.getSpace().x-1,player.getSpace().y));
        if (space.equals("4J")) player.setSpace(player.board.getSpace(player.getSpace().x,player.getSpace().y-1));
        if (space.equals("5J")) player.setSpace(player.board.getSpace(player.getSpace().x+1,player.getSpace().y));

        if (space.equals("0K")) player.setSpace(player.board.getSpace(player.getSpace().x,player.getSpace().y-1));
        if (space.equals("1K")) player.setSpace(player.board.getSpace(player.getSpace().x+1,player.getSpace().y));
        if (space.equals("2K")) player.setSpace(player.board.getSpace(player.getSpace().x,player.getSpace().y+1));
        if (space.equals("3K")) player.setSpace(player.board.getSpace(player.getSpace().x-1,player.getSpace().y));
        if (space.equals("4K")) player.setSpace(player.board.getSpace(player.getSpace().x-1,player.getSpace().y));
        if (space.equals("5K")) player.setSpace(player.board.getSpace(player.getSpace().x,player.getSpace().y+1));

        //-------------YELLOWS---------------------
        // Yellow Corners
        for (int i = 0; i < 4; i++) {
            if (space.equals(i+"E") || space.equals(i+"F"))
                System.out.println("Yellow Corner");
        }
        if (space.equals("0E")) player.setHeading(player.getHeading().prev());
        if (space.equals("0E")) player.setSpace(player.board.getSpace(player.getSpace().x,player.getSpace().y+1));
        if (space.equals("1E")) player.setHeading(player.getHeading().prev());
        if (space.equals("1E")) player.setSpace(player.board.getSpace(player.getSpace().x-1,player.getSpace().y));
        if (space.equals("2E")) player.setHeading(player.getHeading().next());
        if (space.equals("2E")) player.setSpace(player.board.getSpace(player.getSpace().x+1,player.getSpace().y));
        if (space.equals("3E")) player.setHeading(player.getHeading().next());
        if (space.equals("3E")) player.setSpace(player.board.getSpace(player.getSpace().x,player.getSpace().y+1));

        if (space.equals("0F")) player.setHeading(player.getHeading().prev());
        if (space.equals("0F")) player.setSpace(player.board.getSpace(player.getSpace().x+1,player.getSpace().y));
        if (space.equals("1F")) player.setHeading(player.getHeading().prev());
        if (space.equals("1F")) player.setSpace(player.board.getSpace(player.getSpace().x,player.getSpace().y+1));
        if (space.equals("2F")) player.setHeading(player.getHeading().next());
        if (space.equals("2F")) player.setSpace(player.board.getSpace(player.getSpace().x,player.getSpace().y+1));
        if (space.equals("3F")) player.setHeading(player.getHeading().next());
        if (space.equals("3F")) player.setSpace(player.board.getSpace(player.getSpace().x-1,player.getSpace().y));
        // Yellow Straights
        for (int i = 0; i < 4; i++) {
            if (space.equals(i+"G")) {
                System.out.println("Yellow Straights");
            }
        }
        if (space.equals("0G")) player.setSpace(player.board.getSpace(player.getSpace().x,player.getSpace().y-1));
        if (space.equals("1G")) player.setSpace(player.board.getSpace(player.getSpace().x,player.getSpace().y+1));
        if (space.equals("2G")) player.setSpace(player.board.getSpace(player.getSpace().x-1,player.getSpace().y));
        if (space.equals("3G")) player.setSpace(player.board.getSpace(player.getSpace().x+1,player.getSpace().y));


        // Yellow Junctions
        for (int i = 0; i < 6; i++) {
            if (space.equals(i+"H") || space.equals(i+"I"))
                System.out.println("Yellow Junctions");
        }
        if (space.equals("0H")) player.setSpace(player.board.getSpace(player.getSpace().x,player.getSpace().y-1));
        if (space.equals("1H")) player.setSpace(player.board.getSpace(player.getSpace().x+1,player.getSpace().y));
        if (space.equals("2H")) player.setSpace(player.board.getSpace(player.getSpace().x,player.getSpace().y+1));
        if (space.equals("3H")) player.setSpace(player.board.getSpace(player.getSpace().x-1,player.getSpace().y));
        if (space.equals("4H")) player.setSpace(player.board.getSpace(player.getSpace().x+1,player.getSpace().y));
        if (space.equals("5H")) player.setSpace(player.board.getSpace(player.getSpace().x,player.getSpace().y+1));

        if (space.equals("0I")) player.setSpace(player.board.getSpace(player.getSpace().x,player.getSpace().y-1));
        if (space.equals("1I")) player.setSpace(player.board.getSpace(player.getSpace().x+1,player.getSpace().y));
        if (space.equals("2I")) player.setSpace(player.board.getSpace(player.getSpace().x,player.getSpace().y+1));
        if (space.equals("3I")) player.setSpace(player.board.getSpace(player.getSpace().x-1,player.getSpace().y));
        if (space.equals("4I")) player.setSpace(player.board.getSpace(player.getSpace().x,player.getSpace().y-1));
        if (space.equals("5I")) player.setSpace(player.board.getSpace(player.getSpace().x-1,player.getSpace().y));

        // pit
        if (space.equals("5A"))
            for (int i = player.getSpace().y; i < 12; i++) {
                for (int j = player.getSpace().x; j < 15; j++) {
                    if (space.equals("6A")) {
                        player.setSpace(player.board.getSpace(j,i));
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
    public static void exeReboot(Player currentplayer){

//        currentplayer.setSpace();
    }


    public static void exeAction(String space, Player player) {
//        System.out.println(space);
        exeConveyer(space, player);

    }
}
