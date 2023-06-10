package dk.dtu.compute.se.pisd.roborally.controller;

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



    public WebHostController(Board board)
    {
        System.out.println("WebHostController started");

        for (int i = 1; i < board.getPlayers().size(); i++)
        {
            TextInputDialog ipdialog = new TextInputDialog("Web player IP address");
            ipdialog.setTitle("Get player IP");
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
