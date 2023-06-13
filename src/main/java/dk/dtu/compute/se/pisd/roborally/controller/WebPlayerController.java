package dk.dtu.compute.se.pisd.roborally.controller;

import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class WebPlayerController
{


    final private List<Integer> PLAYER_NUMBER_OPTIONS = Arrays.asList(2, 3, 4, 5, 6);
    int playerNr;

    String hostIp;

    public WebPlayerController()
    {

        ChoiceDialog<Integer> dialog = new ChoiceDialog<>(PLAYER_NUMBER_OPTIONS.get(0), PLAYER_NUMBER_OPTIONS);
        dialog.setTitle("Your player number");
        dialog.setHeaderText("Select your players number (Host is Nr. 1)");
        Optional<Integer> result = dialog.showAndWait();

        playerNr=result.get();

        TextInputDialog ipdialog = new TextInputDialog("localhost");
        ipdialog.setTitle("Get HostIp");
        ipdialog.setHeaderText("Enter HostIp: ");
        ipdialog.showAndWait();
        TextField s = ipdialog.getEditor();

        hostIp= String.valueOf(s.getCharacters());

        System.out.println("HostIp: "+hostIp);
    }

    public int getPlayerNr()
    {
        return playerNr;
    }
}
