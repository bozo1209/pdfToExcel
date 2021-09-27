package gui.buttons;

import gui.listModel.MyFileListModel;
import utilities.interfaces.CustomPair;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ChooseFilesButton extends JButton {

    private final String BUTTON_TEXT = "Choose files";
//    private ArrayList<CustomPair<String, BigDecimal>> accountsAndAmountsList;

    public ChooseFilesButton(){
        this.setText(BUTTON_TEXT);
        this.addActionListener(this::buttonAction);
    }

    private void buttonAction(ActionEvent event){
//        DefaultListModel<File> listModel = new DefaultListModel<>();
//        System.out.println("tesssssssssssssst");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true);
//        fileChooser.setCurrentDirectory(new File("C:\\Users\\mateu\\Desktop\\Nowy folder\\pdf to excel\\pdf"));
//        int response = fileChooser.showSaveDialog(null);
//        int response2 = fileChooser.showOpenDialog(null);
        fileChooser.showOpenDialog(null);
//        File[] files = fileChooser.getSelectedFiles();
//        File[] files = fileChooser.getSelectedFiles();
//        listModel.addAll(Arrays.stream(fileChooser.getSelectedFiles()).collect(Collectors.toList()));
//        System.out.println(listModel.get(1).getAbsolutePath());
//        MyListModel<File> fileMyListModel = new MyListModel<>();
//        MyFileListModel fileMyFileListModel = MyFileListModel.getInstance();
//        fileMyFileListModel.addAll(Arrays.stream(fileChooser.getSelectedFiles()).collect(Collectors.toList()));
        MyFileListModel.getInstance().addAll(Arrays.stream(fileChooser.getSelectedFiles()).collect(Collectors.toList()));
//        File[] files1 = fileMyFileListModel.toArray();
//        for (File f : files1){
//            System.out.println(f.getAbsolutePath());
//            System.out.println(f.getName());
//        }
//        ExtractsAccountsAndAmounts extractsAccountsAndAmounts = new ExtractsAccountsAndAmounts();
//        String deskPath1 = System.getProperty("user.home") + File.separator + "Desktop";
//        System.out.println(deskPath1);
//        printContentOfDirectory(deskPath1);
//        String deskPath2 = FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath();
//        System.out.println(deskPath2);
//        printContentOfDirectory(deskPath2);
//        File[] files = new File[1];
//        files[0] = file;
//        Integer integer = Integer.getInteger("5");
//        int integer = 5;
//        double dddd = (double) integer;
//        accountsAndAmountsList = extractsAccountsAndAmounts.getAccountsAndAmountsList(files);
//        extractsAccountsAndAmounts.printAccountsAndAmounts(accountsAndAmountsList);
//        System.out.println(accountsAndAmountsList.get(0).getAccount() instanceof String);
//        System.out.println(accountsAndAmountsList.get(0).getAmount() instanceof String);
//        System.out.println(accountsAndAmountsList.get(0).getAccount() instanceof BigDecimal);
//        System.out.println(accountsAndAmountsList.get(0).getAmount() instanceof BigDecimal);

    }

    /**
     * delete later
     */
//    private void printContentOfDirectory(String path){
//        File dir = new File(path);
//        File[] dirCont = dir.listFiles();
//        for (File o : dirCont){
//            if(o.isFile()){
//                System.out.printf("file: %s%n", o.getName());
//            }else if (o.isDirectory()){
//                System.out.printf("dir: %s%n", o.getName());
//            }
//        }
//    }

//    public ArrayList<CustomPair<String, BigDecimal>> getAccountsAndAmountsList() {
//        return accountsAndAmountsList;
//    }
}
