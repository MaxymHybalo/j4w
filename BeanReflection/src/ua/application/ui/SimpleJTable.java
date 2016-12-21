package ua.application.ui;

import javax.swing.*;
import java.awt.*;

public class SimpleJTable {

    public static final Object[] REPRESENTER_HEADERS = {
            "Type","Data"
    };
    public static final Object[] CLONE_HEADERS = {
            "Old hash-code","New hash-code"
    };

    public SimpleJTable(String title, Object[][] data,Object[] headers) {
        JFrame frame = new JFrame(title);
        JTable table = new JTable(data,headers);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setPreferredScrollableViewportSize(new Dimension(300,150));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        frame.setSize(300,(table.getRowCount()+1)*(table.getRowHeight()+1));
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.setLocation(600,300);
        frame.setVisible(true);
    }
}
