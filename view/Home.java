package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home {
    public Home() {
        JFrame frame = new JFrame("Garden Ice");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 400, 300);

        // Welcome Label
        JLabel welcomeLabel = new JLabel("Welcome, employee!");
        welcomeLabel.setBounds(130, 80, 200, 30);
        panel.add(welcomeLabel);

        // Register Button
        JButton registerButton = new JButton("Register");
        registerButton.setBounds(60, 180, 100, 30);
        panel.add(registerButton);

        // Register Button Action
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Register();
            }
        });

        // View Member List Button
        JButton viewMemberListButton = new JButton("View Member List");
        viewMemberListButton.setBounds(180, 180, 150, 30);
        panel.add(viewMemberListButton);

        // View Member List Button Action
        viewMemberListButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showInputDialog(frame, "Masukkan nomor anggota");
                JOptionPane.showMessageDialog(frame, "Data Gagal Ditambah", "Error",
                                JOptionPane.WARNING_MESSAGE);
            }
        });

        frame.add(panel);
    }

    public static void main(String[] args) {
        new Home();
    }
}
