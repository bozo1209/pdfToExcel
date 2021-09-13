package gui.buttons;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ChooseLocationButton extends JButton {

    private final String BUTTON_TEXT = "Choose location";
    private String locationSavaPath;

    public ChooseLocationButton(){
        this.setText(BUTTON_TEXT);
        this.addActionListener(this::buttonAction);
    }

    private void buttonAction(ActionEvent event){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.showOpenDialog(null);
//        System.out.println(fileChooser.getCurrentDirectory());
        System.out.println(fileChooser.getSelectedFile());
        locationSavaPath = fileChooser.getSelectedFile().getAbsolutePath() + "\\";
    }

    public String getLocationSavaPath() {
        return locationSavaPath;
    }
}
