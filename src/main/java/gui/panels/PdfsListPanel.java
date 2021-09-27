package gui.panels;


import gui.PdfToExcelFrame;
import gui.listModel.MyCellRenderer;
import gui.listModel.MyFileListModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class PdfsListPanel extends JPanel {

    JList<File> fileJList = new JList<>();
//    DefaultListModel<File> listModel = new DefaultListModel<>();
//    JLabel label;

    public PdfsListPanel(){
//        this.setSize(PdfToExcelFrame.WIDTH, PdfToExcelFrame.HEIGHT);
        this.setLayout(new BorderLayout());
        this.setBackground(Color.RED);
//        this.setSize(30,30);
        fileJList.setModel(MyFileListModel.getInstance());
        fileJList.setBackground(Color.LIGHT_GRAY);
//        label = new JLabel();
//        listModel.addElement(new File("C:\\Users\\mateu\\Desktop\\Nowy folder\\pdf to excel\\pdf\\test.pdf"));
//        listModel.addElement(new File("C:\\Users\\mateu\\Desktop\\Nowy folder\\pdf to excel\\pdf\\test2.pdf"));
//        listModel.addElement(new File("C:\\Users\\mateu\\Desktop\\Nowy folder\\pdf to excel\\pdf\\test3.pdf"));
        fileJList.setCellRenderer(new MyCellRenderer());
//        fileJList.getSelectionModel().addListSelectionListener(e -> {
//                System.out.println(fileJList.getSelectedValue());
//                System.out.println(fileJList.getSelectedIndex());
//                label.setText(fileJList.getSelectedValue().getName());
//                System.out.println(e);
//        });
//        fileJList.getSelectionModel().addListSelectionListener(this::selectionListener);
//        fileJList.addListSelectionListener(this::selectionListener);
        fileJList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                PdfsListPanel.this.mouseReleased();
            }
        });
//        fileJList.setSize(300,300);
//        listModel.addElement(new File("C:\\Users\\mateu\\Desktop\\Nowy folder\\pdf to excel\\pdf\\test3.pdf"));
        JScrollPane jScrollPane = new JScrollPane(fileJList);
//        jScrollPane.setSize(300,300);
        jScrollPane.setPreferredSize(new Dimension(this.getSize()));
        this.add(jScrollPane);
//        this.add(new JScrollPane(fileJList));
//        this.add(label);
//        ggggggg();
    }

//    public void ggggggg(){
//        System.out.println(listModel.get(1).getAbsolutePath());
//        System.out.println(listModel.getElementAt(2).getAbsolutePath());
//        File[] objects = (File[]) listModel.toArray();
//        Object[] objects2 = listModel.toArray();
//    }

    private void mouseReleased(){
//        System.out.println(fileJList.getSelectedValue());
//        System.out.println(e.getSource());
//        MyMouseAdaptor myMouseAdaptor = new MyMouseAdaptor();
//        myMouseAdaptor.mouseReleased(e);
        if (!MyFileListModel.getInstance().isEmpty()){
//            System.out.println("dddddddddddddddddddddddddddddddd");
            MyFileListModel.getInstance().remove(fileJList.getSelectedIndex());
        }
//        MyFileListModel.getInstance().remove(fileJList.getSelectedIndex());
    }

}
