package gui.listModel;

import javax.swing.*;
import java.awt.*;
import java.nio.file.FileSystems;

public class MyCellRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        label.setText(getFileName(value.toString()));
        return label;
    }

    private String getFileName(String value){
        String separator = FileSystems.getDefault().getSeparator();
        if (value.contains(separator)){
            int index = value.lastIndexOf(separator);
            return value.substring(index + 1);
        }
        return value;
    }
}
