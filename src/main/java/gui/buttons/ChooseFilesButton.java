package gui.buttons;

import gui.listModel.MyFileListModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ChooseFilesButton extends JButton {

    public ChooseFilesButton(){
        String BUTTON_TEXT = "Choose files";
        this.setText(BUTTON_TEXT);
        this.addActionListener(this::buttonAction);
    }

    private void buttonAction(ActionEvent event){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true);
        fileChooser.showOpenDialog(null);
        MyFileListModel.getInstance().addAll(Arrays.stream(fileChooser.getSelectedFiles()).collect(Collectors.toList()));
    }

}
