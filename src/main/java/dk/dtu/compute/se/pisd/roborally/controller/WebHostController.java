package dk.dtu.compute.se.pisd.roborally.controller;

/**
 * Used when the user runs "Host a Web Game"
 *  * @author: Torben Rasmussen
 */

import dk.dtu.compute.se.pisd.roborally.model.Board;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class WebHostController {
    private List<String> wepPlayerIp = new ArrayList<>();

    final private List<Integer> PLAYER_NUMBER_OPTIONS = Arrays.asList(2, 3, 4, 5, 6);

    /**
     * Dialog to get the Web players IP address
     * @param board: Active board
     */

    public WebHostController(Board board)
    {
        System.out.println("WebHostController started");

        for (int i = 1; i < board.getPlayers().size(); i++)
        {
            TextInputDialog ipdialog = new TextInputDialog("localhost");
            ipdialog.setTitle("Web player IP address.");
            ipdialog.setHeaderText("Enter Ip for player "+(i+1)+": ");
            ipdialog.showAndWait();
            TextField s = ipdialog.getEditor();
            wepPlayerIp.add(String.valueOf(s.getCharacters()));
        }

   //     hostIp= String.valueOf(s.getCharacters());

   //     System.out.println("HostIp: "+hostIp);
    }

    public String getIpWebPlyayer(int i)
    {
        return wepPlayerIp.get(i);
    }
}
