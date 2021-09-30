package gui.panels;


import gui.listModel.MyCellRenderer;
import gui.listModel.MyFileListModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class PdfsListPanel extends JPanel {

    private final JList<File> fileJList = new JList<>();

    public PdfsListPanel(){
        this.setLayout(new BorderLayout());
        this.setBackground(Color.RED);
        fileJList.setModel(MyFileListModel.getInstance());
        fileJList.setBackground(Color.LIGHT_GRAY);
        fileJList.setCellRenderer(new MyCellRenderer());
        fileJList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                PdfsListPanel.this.mouseReleased();
            }
        });
        JScrollPane jScrollPane = new JScrollPane(fileJList);
        jScrollPane.setPreferredSize(new Dimension(this.getSize()));
        this.add(jScrollPane);
    }

    private void mouseReleased(){
        if (!MyFileListModel.getInstance().isEmpty()){
            MyFileListModel.getInstance().remove(fileJList.getSelectedIndex());
        }
    }

}
