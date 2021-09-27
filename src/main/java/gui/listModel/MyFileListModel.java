package gui.listModel;

import javax.swing.*;
import java.io.File;

public class MyFileListModel extends DefaultListModel<File> {

    private static MyFileListModel myFileListModel;

    private MyFileListModel(){}

    public static MyFileListModel getInstance(){
        if (myFileListModel == null){
            myFileListModel = new MyFileListModel();
        }
        return myFileListModel;
    }

    public static void setInstanceToNull(){
        myFileListModel.removeAllElements();
        myFileListModel = null;
    }

    public File[] toArray(){
        File[] newArray = new File[this.getSize()];
        Object[] objects = super.toArray();
        for (int i = 0; i < this.getSize(); i++){
            newArray[i] = (File) objects[i];
        }
        return newArray;
    }
}
