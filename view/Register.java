package view;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import controller.Controller;
import controller.DateLabelFormatter;
import model.Member;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

public class Register {
    private String filePath;
    Controller con = Controller.getInstance();
    
    public Register() {
        JFrame frame = new JFrame("Form Registrasi");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JLabel titleLabel = new JLabel("Form Registrasi Member GardenIce");
        titleLabel.setBounds(100, 10, 250, 30);
        frame.add(titleLabel);
        
        // Nama Lengkap
        JLabel namaLabel = new JLabel("Nama Lengkap");
        namaLabel.setBounds(20, 50, 100, 25);
        frame.add(namaLabel);
        JTextField namaField = new JTextField();
        namaField.setBounds(150, 50, 200, 25);
        frame.add(namaField);
        
        // Jenis Kelamin
        JLabel genderLabel = new JLabel("Jenis Kelamin");
        genderLabel.setBounds(20, 90, 100, 25);
        frame.add(genderLabel);
        JRadioButton priaButton = new JRadioButton("Pria");
        priaButton.setBounds(150, 90, 60, 25);
        JRadioButton wanitaButton = new JRadioButton("Wanita");
        wanitaButton.setBounds(220, 90, 70, 25);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(priaButton);
        genderGroup.add(wanitaButton);
        frame.add(priaButton);
        frame.add(wanitaButton);
        
        // Tanggal Lahir
        JLabel tanggal_lahirLabel = new JLabel("Tanggal Lahir");
        tanggal_lahirLabel.setBounds(20, 130, 100, 25);
        frame.add(tanggal_lahirLabel);
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl tanggal_lahirPicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        tanggal_lahirPicker.setBounds(150, 130, 200, 30);
        frame.add(tanggal_lahirPicker);

        // Foto Member
        JLabel photoLabel = new JLabel("Foto Member");
        photoLabel.setBounds(20, 170, 100, 25);
        frame.add(photoLabel);
        JButton photoButton = new JButton("Pilih File");
        photoButton.setBounds(150, 170, 100, 25);
        JLabel photoPathLabel = new JLabel();
        photoPathLabel.setBounds(260, 170, 120, 25);
        frame.add(photoButton);
        frame.add(photoPathLabel);
        
        photoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser(
                        "D:Documents/Kuliah/Semester pendek/Prak PBO/Quiz2/pictures");
                int option = fileChooser.showOpenDialog(frame);
                if (option == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    photoPathLabel.setText(selectedFile.getName());
                    filePath = selectedFile.getAbsolutePath();
                }
            }
        });
        
        // Tanggal Pembuatan
        JLabel tanggal_pembuatanLabel = new JLabel("Tanggal Pembuatan");
        tanggal_pembuatanLabel.setBounds(20, 210, 120, 25);
        frame.add(tanggal_pembuatanLabel);
        UtilDateModel model2 = new UtilDateModel();
        Properties p2 = new Properties();
        JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, p2);
        JDatePickerImpl tanggal_pembuatanPicker = new JDatePickerImpl(datePanel2, new DateLabelFormatter());
        tanggal_pembuatanPicker.setBounds(150, 210, 200, 30);
        frame.add(tanggal_pembuatanPicker);
        
        // Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(80, 280, 100, 30);
        frame.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    //String nik = nikField.getText();
                    String nama = namaField.getText();
                    //String tempat_lahir = tempat_lahirField.getText();
                    java.util.Date selectedDate = (java.util.Date) tanggal_lahirPicker.getModel().getValue();
                    Date tanggal_lahir = null;
                    if (selectedDate != null) {
                        tanggal_lahir = new Date(selectedDate.getTime());
                    }
                    String jenis_kelamin = priaButton.isSelected() ? "Pria" : "Wanita";
                    String foto = filePath;
                    java.util.Date selectedDate2 = (java.util.Date) tanggal_pembuatanPicker.getModel().getValue();
                    Date tanggal_pembuatan = null;
                    if (selectedDate2 != null) {
                        tanggal_pembuatan = new Date(selectedDate2.getTime());
                    }

                    ArrayList<Member> listMember = con.getAllMemberList();
                    Member newMember = new Member(0, nama, jenis_kelamin, tanggal_lahir, foto, tanggal_pembuatan, listMember.size() + 1);
                
                    boolean cek = con.addNewUser(newMember);
                    if (cek) {
                        JOptionPane.showMessageDialog(frame, "Data Berhasil Ditambah", "Success",
                                JOptionPane.WARNING_MESSAGE);
                        new Hasil();
                    } else {
                        JOptionPane.showMessageDialog(frame, "Data Gagal Ditambah", "Error",
                                JOptionPane.WARNING_MESSAGE);
                    }
                frame.dispose();
            }
        });

        // Exit Button
        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(210, 280, 100, 30);
        frame.add(exitButton);

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();;
                new Home();
            }
        });
        
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Register();
    }
}
