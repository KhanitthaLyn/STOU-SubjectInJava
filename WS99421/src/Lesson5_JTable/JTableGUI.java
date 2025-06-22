package Lesson5_JTable;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

public class JTableGUI extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private JTextField searchField;

    public JTableGUI() {
        setTitle("JTable");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 350);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel searchLabel = new JLabel("Keyword");
        searchLabel.setBounds(120, 20, 60, 25);
        add(searchLabel);

        searchField = new JTextField();
        searchField.setBounds(190, 20, 160, 25);
        add(searchField);

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(360, 20, 90, 25);
        add(searchButton);

        model = new DefaultTableModel(new Object[]{"Name", "Username", "Password"}, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(100, 60, 400, 120);
        add(scrollPane);

        model.addRow(new Object[]{"Suda", "ssuda", "1234"});
        model.addRow(new Object[]{"Payu", "spayu", "1234"});
        model.addRow(new Object[]{"Pichai", "spichai", "0000"});
        model.addRow(new Object[]{"Anirut", "sanirut", "1111"});
        model.addRow(new Object[]{"Jeera", "sjeerat", "9999"});

        JButton addButton = new JButton("Add");
        addButton.setBounds(170, 200, 80, 30);
        add(addButton);

        JButton updateButton = new JButton("Update");
        updateButton.setBounds(260, 200, 80, 30);
        add(updateButton);

        JButton deleteButton = new JButton("Delete");
        deleteButton.setBounds(350, 200, 80, 30);
        add(deleteButton);

        addButton.addActionListener(e -> openAddForm());

        updateButton.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) {
                JDialog dialog = new JDialog(this, "Update User", true);
                dialog.setSize(300, 250);
                dialog.setLocationRelativeTo(this);
                dialog.setLayout(null);

                JLabel nameLabel = new JLabel("Name");
                nameLabel.setBounds(30, 20, 100, 25);
                dialog.add(nameLabel);

                JTextField nameField = new JTextField((String) model.getValueAt(row, 0));
                nameField.setBounds(30, 45, 220, 25);
                dialog.add(nameField);

                JLabel userLabel = new JLabel("Username");
                userLabel.setBounds(30, 75, 100, 25);
                dialog.add(userLabel);

                JTextField userField = new JTextField((String) model.getValueAt(row, 1));
                userField.setBounds(30, 100, 220, 25);
                dialog.add(userField);

                JLabel passLabel = new JLabel("Password");
                passLabel.setBounds(30, 130, 100, 25);
                dialog.add(passLabel);

                JTextField passField = new JTextField((String) model.getValueAt(row, 2));
                passField.setBounds(30, 155, 220, 25);
                dialog.add(passField);

                JButton updateBtn = new JButton("Update");
                updateBtn.setBounds(50, 190, 80, 30);
                dialog.add(updateBtn);

                JButton cancelBtn = new JButton("Cancel");
                cancelBtn.setBounds(150, 190, 80, 30);
                dialog.add(cancelBtn);

                updateBtn.addActionListener(ev -> {
                    String name = nameField.getText().trim();
                    String user = userField.getText().trim();
                    String pass = passField.getText().trim();
                    if (!name.isEmpty() && !user.isEmpty() && !pass.isEmpty()) {
                        model.setValueAt(name, row, 0);
                        model.setValueAt(user, row, 1);
                        model.setValueAt(pass, row, 2);
                        dialog.dispose();
                    } else {
                        JOptionPane.showMessageDialog(dialog, "กรอกข้อมูลให้ครบ");
                    }
                });

                cancelBtn.addActionListener(ev -> dialog.dispose());

                dialog.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "าเลือกแถวที่ต้องการแก้ไข");
            }
        });

        deleteButton.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) {
                model.removeRow(row);
            }
        });

        searchButton.addActionListener(e -> {
            String keyword = searchField.getText().toLowerCase();
            TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
            table.setRowSorter(sorter);
            if (keyword.trim().isEmpty()) {
                sorter.setRowFilter(null);
            } else {
                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + keyword));
            }
        });
    }

    private void openAddForm() {
        JDialog dialog = new JDialog(this, "Add New User", true);
        dialog.setSize(300, 250);
        dialog.setLocationRelativeTo(this);
        dialog.setLayout(null);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(30, 20, 100, 25);
        dialog.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(30, 45, 220, 25);
        dialog.add(nameField);

        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(30, 75, 100, 25);
        dialog.add(userLabel);

        JTextField userField = new JTextField();
        userField.setBounds(30, 100, 220, 25);
        dialog.add(userField);

        JLabel passLabel = new JLabel("Password");
        passLabel.setBounds(30, 130, 100, 25);
        dialog.add(passLabel);

        JTextField passField = new JTextField();
        passField.setBounds(30, 155, 220, 25);
        dialog.add(passField);

        JButton confirmBtn = new JButton("Add");
        confirmBtn.setBounds(50, 190, 80, 30);
        dialog.add(confirmBtn);

        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(150, 190, 80, 30);
        dialog.add(cancelBtn);

        confirmBtn.addActionListener(e -> {
            String name = nameField.getText().trim();
            String user = userField.getText().trim();
            String pass = passField.getText().trim();
            if (!name.isEmpty() && !user.isEmpty() && !pass.isEmpty()) {
                model.addRow(new Object[]{name, user, pass});
                dialog.dispose();
            } else {
                JOptionPane.showMessageDialog(dialog, "กรุณากรอกข้อมูล");
            }
        });

        cancelBtn.addActionListener(e -> dialog.dispose());

        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JTableGUI().setVisible(true));
    }
}
