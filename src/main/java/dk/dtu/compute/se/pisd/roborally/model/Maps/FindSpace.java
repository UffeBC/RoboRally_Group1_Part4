package dk.dtu.compute.se.pisd.roborally.model.Maps;

import dk.dtu.compute.se.pisd.roborally.model.Core.Value;
import dk.dtu.compute.se.pisd.roborally.model.Player;

public class FindSpace {
    public static String ofPlayer(Player player) {
        int x = player.getSpace().x;
        int y = player.getSpace().y;
        System.out.printf("playerx:%s playery:%s\r\n",x,y);
        System.out.println(Value.map);
        if (Value.map == "GoldenStripe" && x>3)
            return GoldStripe.GoldStripeArray[y][x-3];
        else if (Value.map == " RingOfDeath" && x>3)
            return RingOfDeath.RingOfDeath[y][x-3];
        else if (Value.map == "WhirlWind" && x>3)
            return RingOfDeath.RingOfDeath[y][x-3];
        else return StartBoard.StartBoard[y][x];
    }

}
