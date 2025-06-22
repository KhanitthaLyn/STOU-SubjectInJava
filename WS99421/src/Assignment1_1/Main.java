package Assignment1_1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Main extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private JTextField txtSearch;
    private DBService service;

    public Main() {
        super("Database Manipulation With JTable");
        service = new DBService();
        setLayout(new BorderLayout());

        // Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menuData = new JMenu("Data");
        JMenuItem loadItem = new JMenuItem("Load Data From DB");
        loadItem.addActionListener(e -> loadData());
        menuData.add(loadItem);
        menuData.addSeparator();
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        menuData.add(exitItem);
        menuBar.add(menuData);
        setJMenuBar(menuBar);

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        txtSearch = new JTextField(20);
        JButton btnSearch = new JButton("Search");
        btnSearch.addActionListener(e -> searchData());
        topPanel.add(new JLabel("Keyword"));
        topPanel.add(txtSearch);
        topPanel.add(btnSearch);
        add(topPanel, BorderLayout.NORTH);

        model = new DefaultTableModel(new String[]{"Name", "Username", "Password"}, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnAdd = new JButton("Add");
        JButton btnUpdate = new JButton("Update");
        JButton btnDelete = new JButton("Delete");

        btnAdd.addActionListener(e -> addUser());
        btnUpdate.addActionListener(e -> updateUser());
        btnDelete.addActionListener(e -> deleteUser());

        bottomPanel.add(btnAdd);
        bottomPanel.add(btnUpdate);
        bottomPanel.add(btnDelete);
        add(bottomPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void loadData() {
        model.setRowCount(0);
        for (String[] row : service.selectUser()) {
            model.addRow(row);
        }
    }

    private void searchData() {
        model.setRowCount(0);
        for (String[] row : service.selectUser(txtSearch.getText().trim())) {
            model.addRow(row);
        }
    }

    private void addUser() {
        JTextField name = new JTextField();
        JTextField username = new JTextField();
        JTextField password = new JPasswordField();
        Object[] message = {
                "Name:", name,
                "Username:", username,
                "Password:", password
        };

        if (JOptionPane.showConfirmDialog(this, message, "Add User", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            service.insertUser(name.getText(), username.getText(), password.getText());
            loadData();
        }
    }

    private void updateUser() {
        int row = table.getSelectedRow();
        if (row >= 0) {
            String username = (String) model.getValueAt(row, 1);
            JTextField name = new JTextField((String) model.getValueAt(row, 0));
            JTextField password = new JPasswordField((String) model.getValueAt(row, 2));
            Object[] message = {
                    "Name:", name,
                    "Password:", password
            };

            if (JOptionPane.showConfirmDialog(this, message, "Update User", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                service.updateUser(name.getText(), username, password.getText());
                loadData();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select a row to update.");
        }
    }

    private void deleteUser() {
        int row = table.getSelectedRow();
        if (row >= 0) {
            String username = (String) model.getValueAt(row, 1);
            if (JOptionPane.showConfirmDialog(this, "Delete user: " + username + "?", "Confirm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                service.deleteUser(username);
                loadData();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select a row to delete.");
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}