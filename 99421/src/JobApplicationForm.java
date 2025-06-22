import javax.swing.*;
import java.awt.*;

public class JobApplicationForm extends JFrame {
    public JTextField idField, nameField, addressField, provinceField, educationField, majorField;
    public JRadioButton maleButton, femaleButton;
    public JComboBox<String>[] qualificationBoxes;
    public JComboBox<String>[] positionBoxes;
    public JButton submitButton;

    private final String[] qualOptions = {
        "เลือกความรู้ความสามารถ", "Web_ASP", "C++", "Database Admnistrator,DB2", "Database Admnistrator,ORACLE", "Graphc Design",
        "JAVA", "Management", "Nework", "Secretarial work,45 words/min", "Secretarial work,60 words/min", "System Analyst, Level 1", "System Analyst, Level 2", "Visual Basic"
    };

    private final String[] posOptions = {
        "เลือกตำแหน่งที่ต้องการสมัคร", "Technical Programmer", "WebDeveloper", "General Manager",
        "ICT Specialst", "E-usness Analys", "ICT Documenter", "Database Administrator",
        "PC Administrator", "Nework Specialist", "ICT Manager"
    };

    public JobApplicationForm() {
        setTitle("แบบฟอร์มสมัครงานด้าน ICT - STOU-TEC");
        setSize(800, 750);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        Font thaiFont = new Font("Tahoma", Font.PLAIN, 14);
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // หัวเรื่อง
        JPanel headerPanel = new JPanel(new GridLayout(0, 1));
        JLabel title = new JLabel("บริษัท STOU-TEC จำกัด", SwingConstants.CENTER);
        title.setFont(new Font("Tahoma", Font.BOLD, 18));
        JLabel subtitle = new JLabel("แบบฟอร์มใบสมัครพนักงาน", SwingConstants.CENTER);
        subtitle.setFont(new Font("Tahoma", Font.BOLD, 18));
     
        JLabel instructions = new JLabel("<html>ใบสมัครสำหรับงานด้าน ICT นี้ โปรดผู้สมัครกรอกรายละเอียดลงในฟอร์มนี้<br>บริษัท STOU-TEC จำกัด ทำการคัดเลือกตามความเหมาะสม</html>", SwingConstants.CENTER);
        instructions.setFont(new Font("Tahoma", Font.BOLD, 14));
        headerPanel.add(title);
        headerPanel.add(subtitle);
        headerPanel.add(instructions);
        add(headerPanel, BorderLayout.NORTH);


        int row = 0;
        panel.add(new JLabel("เลขประจำตัวผู้สมัคร (AP_ID):", JLabel.RIGHT), gbc);
        idField = new JTextField(); 

        row++;
        gbc.gridx = 0; gbc.gridy = row; panel.add(new JLabel("ชื่อ-นามสกุล (AP_NAME):", JLabel.RIGHT), gbc);
        gbc.gridx = 1; nameField = new JTextField(); nameField.setFont(thaiFont); panel.add(nameField, gbc);

        row++;
        gbc.gridx = 0; gbc.gridy = row; panel.add(new JLabel("ที่อยู่ (AP_ADDRESS):", JLabel.RIGHT), gbc);
        gbc.gridx = 1; addressField = new JTextField(); addressField.setFont(thaiFont); panel.add(addressField, gbc);

        row++;
        gbc.gridx = 0; gbc.gridy = row; panel.add(new JLabel("จังหวัด (AP_CHW):", JLabel.RIGHT), gbc);
        gbc.gridx = 1; provinceField = new JTextField(); provinceField.setFont(thaiFont); panel.add(provinceField, gbc);

        row++;
        gbc.gridx = 0; gbc.gridy = row; panel.add(new JLabel("เพศ (AP_SEX):", JLabel.RIGHT), gbc);
        gbc.gridx = 1;
        
        JPanel genderPanel = new JPanel();
        ButtonGroup genderGroup = new ButtonGroup();
        femaleButton = new JRadioButton("หญิง");
        maleButton = new JRadioButton("ชาย");
        genderGroup.add(femaleButton);
        genderGroup.add(maleButton);
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        panel.add(genderPanel, gbc);

        row++;
        gbc.gridx = 0; gbc.gridy = row; panel.add(new JLabel("วุฒิการศึกษาสูงสุด (AP_ED):", JLabel.RIGHT), gbc);
        gbc.gridx = 1; educationField = new JTextField(); educationField.setFont(thaiFont); panel.add(educationField, gbc);

        row++;
        gbc.gridx = 0; gbc.gridy = row;
        JLabel edExample = new JLabel("(เช่น B.S., B.A., M.S., M.BA., M.A.)");
        panel.add(edExample, gbc);
        
        row++;
        gbc.gridx = 0; gbc.gridy = row; panel.add(new JLabel("วิชาเอก (AP_MAJ):", JLabel.RIGHT), gbc);
        gbc.gridx = 1; majorField = new JTextField(); majorField.setFont(thaiFont); panel.add(majorField, gbc);

     
        row++;
        gbc.gridx = 0; gbc.gridy = row; gbc.gridwidth = 2;
        JLabel qualLabel = new JLabel("ความรู้ความสามารถหรือคุณสมบัติเฉพาะตำแหน่ง (QUAL_DESC) (ตอบได้ไม่เกิน 5 รายการ)");
        qualLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(qualLabel, gbc);
        gbc.gridwidth = 1;

        qualificationBoxes = new JComboBox[5];
        for (int i = 0; i < 5; i++) {
            row++;
            gbc.gridx = 0; gbc.gridy = row;
            panel.add(new JLabel("ความสามารถ " + (i + 1) + ":", JLabel.RIGHT), gbc);
            gbc.gridx = 1;
            qualificationBoxes[i] = new JComboBox<>(qualOptions);
            qualificationBoxes[i].setFont(thaiFont);
            panel.add(qualificationBoxes[i], gbc);
        }
        
        row++;
        gbc.gridx = 0; gbc.gridy = row; gbc.gridwidth = 2;
        JLabel posLabel = new JLabel("ตำแหน่งที่ต้องการสมัคร (POS_NAME) : (ตอบได้ไม่เกิน 3 ตำแหน่ง)");
        posLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(posLabel, gbc);
        gbc.gridwidth = 1;

        positionBoxes = new JComboBox[3];
        for (int i = 0; i < 3; i++) {
            row++;
            gbc.gridx = 0; gbc.gridy = row;
            panel.add(new JLabel("ตำแหน่งที่สมัคร " + (i + 1) + ":", JLabel.RIGHT), gbc);
            gbc.gridx = 1;
            positionBoxes[i] = new JComboBox<>(posOptions);
            positionBoxes[i].setFont(thaiFont);
            panel.add(positionBoxes[i], gbc);
        }

        row++;
        gbc.gridx = 0; gbc.gridy = row; gbc.gridwidth = 2;
        submitButton = new JButton("ตกลง");
        submitButton.setFont(thaiFont);
        panel.add(submitButton, gbc);

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }
}
