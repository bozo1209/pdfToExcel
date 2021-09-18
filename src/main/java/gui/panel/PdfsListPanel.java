package gui.panel;


import gui.listModel.MyCellRenderer;
import gui.listModel.MyFileListModel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.File;

public class PdfsListPanel extends JPanel {

    JList<File> fileJList = new JList<>();
//    DefaultListModel<File> listModel = new DefaultListModel<>();

    public PdfsListPanel(){
        this.setBackground(Color.RED);
        fileJList.setModel(MyFileListModel.getInstance());
        fileJList.setBackground(Color.LIGHT_GRAY);
//        listModel.addElement(new File("C:\\Users\\mateu\\Desktop\\Nowy folder\\pdf to excel\\pdf\\test.pdf"));
//        listModel.addElement(new File("C:\\Users\\mateu\\Desktop\\Nowy folder\\pdf to excel\\pdf\\test2.pdf"));
//        listModel.addElement(new File("C:\\Users\\mateu\\Desktop\\Nowy folder\\pdf to excel\\pdf\\test3.pdf"));
        fileJList.setCellRenderer(new MyCellRenderer());
//        listModel.addElement(new File("C:\\Users\\mateu\\Desktop\\Nowy folder\\pdf to excel\\pdf\\test3.pdf"));
        this.add(new JScrollPane(fileJList));
        ggggggg();
    }

    public void ggggggg(){
//        System.out.println(listModel.get(1).getAbsolutePath());
//        System.out.println(listModel.getElementAt(2).getAbsolutePath());
//        File[] objects = (File[]) listModel.toArray();
//        Object[] objects2 = listModel.toArray();
    }
}
