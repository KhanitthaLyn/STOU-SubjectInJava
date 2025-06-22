package Assignment1_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SongDetail {

    public static void main(String[] args) {

        JFrame frame = new JFrame("รายละเอียดเพลง");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        Font thaiFont = new Font("Tahoma", Font.PLAIN, 14);

        JLabel songLabel = new JLabel("ชื่อเพลง:");
        songLabel.setFont(thaiFont);
        JTextField songField = new JTextField(20);
        songField.setFont(thaiFont);

        JLabel artistLabel = new JLabel("ชื่อศิลปิน:");
        artistLabel.setFont(thaiFont);
        JTextField artistField = new JTextField(20);
        artistField.setFont(thaiFont);

        JButton showButton = new JButton("แสดงข้อมูล");
        showButton.setFont(thaiFont);

        frame.add(songLabel);
        frame.add(songField);
        frame.add(artistLabel);
        frame.add(artistField);
        frame.add(showButton);

        showButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String song = songField.getText();
                String artist = artistField.getText();

                JFrame resultFrame = new JFrame("รายละเอียดเพลง");
                resultFrame.setSize(400, 200);
                JTextArea textArea = new JTextArea();
                textArea.setFont(thaiFont); // ตั้งฟอนต์ไทย

                textArea.setText("---- โปรไฟล์เพลง ----\n"
                        + "ชื่อเพลง -> " + artist + "\n"
                        + "ชื่อศิลปิน -> " + song);

                textArea.setEditable(false);
                resultFrame.add(textArea);
                resultFrame.setVisible(true);
            }
        });

        frame.setVisible(true);
    }
}
