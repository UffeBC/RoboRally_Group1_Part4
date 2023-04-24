package dk.dtu.compute.se.pisd.roborally.model.Maps;

import dk.dtu.compute.se.pisd.designpatterns.observer.Subject;
import dk.dtu.compute.se.pisd.roborally.model.Space;
import dk.dtu.compute.se.pisd.roborally.view.SpaceView;
import dk.dtu.compute.se.pisd.roborally.view.ViewObserver;
import org.jetbrains.annotations.NotNull;

public class TileCreator extends SpaceView  implements ViewObserver {

    public TileCreator(@NotNull Space space) {
        super(space);
    }

    // This method creates Tiles based off a positional value x and y
    public static void Creator(int xNum, int yNum, SpaceView space) {

//      url = "https://raw.githubusercontent.com/frellan/robo-rally/master/src/main/resources/maps/board_tiles.png";

        // Made for Width and Height (60)
        double positionX = xNum * 16.5;  //16.5;
        double positionY = yNum * 8.25;  //8.25;
        int sizeX = 430;
        int sizeY = 793;                            //1.85715-6

        if (SPACE_HEIGHT == 40 && SPACE_WIDTH == 40) {
            sizeX = 320;
            sizeY = 560;
        }
        else if (SPACE_HEIGHT == 60 && BoardCreatorBOA.SPACE_WIDTH == 60) {
            sizeX = 430;
            sizeY = 793;
        }

        try {
            // WITH INTERNET
//            space.setStyle("-fx-background-image: url(https://raw.githubusercontent.com/frellan/robo-rally/master/src/main/resources/maps/board_tiles.png)" +
//                    "; -fx-background-position: " + positionX + "% " + positionY + "%" +
//                    "; -fx-background-size: " + sizeX + "px " + sizeY + "px"
//            );
            //
            // WITHOUT INTERNET
            space.setStyle("-fx-background-image: url(board_tiles.jpg)" +
                    "; -fx-background-position: " + positionX + "% " + positionY + "%" +
                    "; -fx-background-size: " + sizeX + "px " + sizeY + "px"
            );
            // FAKE START
            if (xNum==9&&yNum==8)
                space.setStyle("-fx-background-image: url(StartSpot.jpg)" +
                        "; -fx-background-position: 0% 0%" +
                        "; -fx-background-size: 40px 40px"
                );
            //
        } catch (Exception e) {
            if ((space.space.x + space.space.y) % 2 == 0) { // BASIC
                space.setStyle("-fx-background-color: white;");
            } else {
                space.setStyle("-fx-background-color: black;");
            }
        }
    }

    @Override
    public void updateView(Subject subject) {}

}

