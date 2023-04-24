package dk.dtu.compute.se.pisd.roborally.model.Maps;

import dk.dtu.compute.se.pisd.roborally.model.Space;
import dk.dtu.compute.se.pisd.roborally.view.SpaceView;
import org.jetbrains.annotations.NotNull;

public class StartBoard extends TileCreator {

    public StartBoard(@NotNull Space space) {super(space);}

    public static final String[][] StartBoard = {
            {"9I","4A","5B"},
            {"4A","9I","4A"},
            {"4A","4A","4A"},
            {"4A","4A","4A"},
            {"9I","4A","4A"},
            {"4A","9I","4A"},
            {"4A","9I","4A"},
            {"9I","4A","4A"},
            {"4A","4A","4A"},
            {"4A","4A","4A"},
            {"4A","9I","4A"},
            {"4A","4A","5B"}
    };
    public static int lengthOfBoard = 3;
    public static int heightOfBoard = 12;
    public static int getLengthOfBoard() { return lengthOfBoard; }
    public static int getHeightOfBoard() { return heightOfBoard; }

    public static void exexuteStartBoard(SpaceView spaceV, Space space){
        BoardCreatorBOA.CreateMap(StartBoard, lengthOfBoard, space, spaceV);
    }
}
