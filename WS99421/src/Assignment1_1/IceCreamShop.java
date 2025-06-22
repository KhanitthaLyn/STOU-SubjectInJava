package Assignment1_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class IceCreamShop {
    public static void main(String[] args) {
        JFrame frame = new JFrame("ร้านไอศกรีม STOU");

        JLabel titleLabel = new JLabel("STOU ICE CREAM", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        frame.add(titleLabel, BorderLayout.NORTH);
        
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        Font thaiFont = new Font("Tahoma", Font.PLAIN, 14);

        JLabel flavorLabel = new JLabel("รสชาติ");
        flavorLabel.setFont(thaiFont);

        JRadioButton r1 = new JRadioButton("กะทิ -- 20 baht");
        JRadioButton r2 = new JRadioButton("Green Tea -- 25 baht");
        JRadioButton r3 = new JRadioButton("Chocolate -- 30 baht");
        JRadioButton r4 = new JRadioButton("Thai Tea -- 35 baht");

        JRadioButton[] radios = {r1, r2, r3, r4};
        for (JRadioButton r : radios) {
            r.setFont(thaiFont);
        }

        ButtonGroup flavorGroup = new ButtonGroup();
        flavorGroup.add(r1);
        flavorGroup.add(r2);
        flavorGroup.add(r3);
        flavorGroup.add(r4);

        JPanel flavorPanel = new JPanel();
        flavorPanel.setLayout(new BoxLayout(flavorPanel, BoxLayout.Y_AXIS));
        flavorPanel.setBorder(BorderFactory.createTitledBorder("Flavors"));
        flavorPanel.setFont(thaiFont);
        flavorPanel.add(r1);
        flavorPanel.add(r2);
        flavorPanel.add(r3);
        flavorPanel.add(r4);

        JPanel amountPanel = new JPanel();
        JLabel amountLabel = new JLabel("Amount");
        amountLabel.setFont(thaiFont);
        JTextField amountField = new JTextField("1", 5);
        JLabel cupLabel = new JLabel("ก้อน");
        cupLabel.setFont(thaiFont);
        amountPanel.add(amountLabel);
        amountPanel.add(amountField);
        amountPanel.add(cupLabel);

        JCheckBox c1 = new JCheckBox("Fugde -- 10 baht");
        JCheckBox c2 = new JCheckBox("Peanut -- 5 baht");
        JCheckBox c3 = new JCheckBox("Dried pineapple -- 10 baht");
        JCheckBox c4 = new JCheckBox("เผือก -- 5 baht");

        JCheckBox[] checks = {c1, c2, c3, c4};
        for (JCheckBox c : checks) {
            c.setFont(thaiFont);
        }

        JPanel toppingPanel = new JPanel();
        toppingPanel.setLayout(new BoxLayout(toppingPanel, BoxLayout.Y_AXIS));
        toppingPanel.setBorder(BorderFactory.createTitledBorder("Toppings"));
        toppingPanel.setFont(thaiFont);
        toppingPanel.add(c1);
        toppingPanel.add(c2);
        toppingPanel.add(c3);
        toppingPanel.add(c4);

        JButton btn = new JButton("Calculate Price");
        btn.setFont(thaiFont);
        JLabel result = new JLabel("Total: 0 baht");
        result.setFont(thaiFont);

        btn.addActionListener(e -> {
            int basePrice = 0;
            if (r1.isSelected()) basePrice = 20;
            else if (r2.isSelected()) basePrice = 25;
            else if (r3.isSelected()) basePrice = 30;
            else if (r4.isSelected()) basePrice = 35;

            int toppings = 0;
            if (c1.isSelected()) toppings += 10;
            if (c2.isSelected()) toppings += 5;
            if (c3.isSelected()) toppings += 10;
            if (c4.isSelected()) toppings += 5;

            int amount = 1;
            try {
                amount = Integer.parseInt(amountField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "กรุณากรอกจำนวนเป็นตัวเลข", "ข้อผิดพลาด", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int total = (basePrice + toppings) * amount;
            result.setText("Total: " + total + " baht");
        });

        frame.add(flavorPanel);
        frame.add(amountPanel);
        frame.add(toppingPanel);
        frame.add(btn);
        frame.add(result);

        frame.setVisible(true);
    }
}
