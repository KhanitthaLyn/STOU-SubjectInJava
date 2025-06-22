import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Enumeration;
import java.util.HashSet;

public class ApplicationMain {
    public static void main(String[] args) {
    
        setUIFont(new Font("Tahoma", Font.PLAIN, 14));

        SwingUtilities.invokeLater(() -> {
            JobApplicationForm form = new JobApplicationForm();

            form.submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String gender = form.femaleButton.isSelected() ? "หญิง" :
                                    (form.maleButton.isSelected() ? "ชาย" : "ไม่ระบุ");

                    HashSet<String> selectedQuals = new HashSet<>();
                    for (JComboBox<String> box : form.qualificationBoxes) {
                        String item = (String) box.getSelectedItem();
                        if (item != null && !item.equals("เลือกความรู้ความสามารถ")) {
                            selectedQuals.add(item);
                        }
                    }

                    HashSet<String> selectedPositions = new HashSet<>();
                    for (JComboBox<String> box : form.positionBoxes) {
                        String item = (String) box.getSelectedItem();
                        if (item != null && !item.equals("เลือกตำแหน่งที่ต้องการสมัคร")) {
                            selectedPositions.add(item);
                        }
                    }

                    if (selectedQuals.size() > 5) {
                        JOptionPane.showMessageDialog(form, "กรุณาเลือกความสามารถไม่เกิน 5 รายการ");
                        return;
                    }

                    if (selectedPositions.size() > 3) {
                        JOptionPane.showMessageDialog(form, "กรุณาเลือกตำแหน่งไม่เกิน 3 รายการ");
                        return;
                    }

                   
                    StringBuilder sb = new StringBuilder();
                    sb.append("เลขประจำตัวผู้สมัคร: ").append(form.idField.getText()).append("\n");
                    sb.append("ชื่อ-นามสกุล: ").append(form.nameField.getText()).append("\n");
                    sb.append("ที่อยู่: ").append(form.addressField.getText()).append("\n");
                    sb.append("จังหวัด: ").append(form.provinceField.getText()).append("\n");
                    sb.append("เพศ: ").append(gender).append("\n");
                    sb.append("วุฒิการศึกษาสูงสุด: ").append(form.educationField.getText()).append("\n");
                    sb.append("วิชาเอก: ").append(form.majorField.getText()).append("\n\n");

                    int index = 1;
                    for (JComboBox<String> box : form.qualificationBoxes) {
                        String item = (String) box.getSelectedItem();
                        if (item != null && !item.equals("เลือกความรู้ความสามารถ")) {
                            sb.append("ความรู้ความสามารถ ").append(index++).append(": ").append(item).append("\n");
                        }
                    }

                    index = 1;
                    for (JComboBox<String> box : form.positionBoxes) {
                        String item = (String) box.getSelectedItem();
                        if (item != null && !item.equals("เลือกตำแหน่งที่ต้องการสมัคร")) {
                            sb.append("ตำแหน่งที่ต้องการสมัคร ").append(index++).append(": ").append(item).append("\n");
                        }
                    }

                  
                    showSummaryDialog(form, sb.toString());
                }
            });
        });
    }
 
    public static void setUIFont(Font font) {
        Enumeration<Object> keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof javax.swing.plaf.FontUIResource) {
                UIManager.put(key, new javax.swing.plaf.FontUIResource(font));
            }
        }
    }

    public static void showSummaryDialog(JFrame parent, String summaryText) {
        JDialog dialog = new JDialog(parent, "รายละเอียดของผู้สมัคร", true);
        dialog.setSize(450, 500);
        dialog.setLayout(new BorderLayout());
        dialog.setLocationRelativeTo(parent);

        Font thaiFont = new Font("Tahoma", Font.PLAIN, 14);
        Font boldFont = new Font("Tahoma", Font.BOLD, 16);

        JLabel title = new JLabel("รายละเอียดของผู้สมัคร", SwingConstants.CENTER);
        title.setFont(boldFont);
        dialog.add(title, BorderLayout.NORTH);

        JTextArea textArea = new JTextArea(summaryText);
        textArea.setFont(thaiFont);
        textArea.setEditable(false);
        textArea.setBackground(new Color(240, 240, 240));
        textArea.setMargin(new Insets(10, 15, 10, 15));

        JScrollPane scrollPane = new JScrollPane(textArea);
        dialog.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton closeButton = new JButton("แก้ไข");
        closeButton.setFont(thaiFont);
        closeButton.addActionListener(e -> dialog.dispose());
        buttonPanel.add(closeButton);
        dialog.add(buttonPanel, BorderLayout.SOUTH);

        dialog.setVisible(true);
    }
}
