package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import controller.Controller;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.Member;

public class Hasil {
    Controller con = Controller.getInstance();
    ArrayList<Member> showMember = con.getMemberData();
    //Object[] data = new Object[showMember.size()];

    private static ImageIcon scaleImage(String imagePath, int width, int height) {
        ImageIcon icon = new ImageIcon(imagePath);
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImg);
    }

    public Hasil () {
        JFrame frame = new JFrame("Hasil");
        //Color color = new Color(204, 236,236,255);
        frame.setSize(600, 400);
        frame.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 600, 400);
        //panel.setBackground(color);

        JLabel namaLabel = new JLabel("Name ");
        namaLabel.setBounds(230, 60, 100, 30);
        panel.add(namaLabel);

        JLabel tempat_lahirLabel = new JLabel("Birth Date ");
        tempat_lahirLabel.setBounds(230, 90, 200, 30);
        panel.add(tempat_lahirLabel);
        
        JLabel jenis_kelaminLabel = new JLabel("Valid Until ");
        jenis_kelaminLabel.setBounds(230, 120, 100, 30);
        panel.add(jenis_kelaminLabel);

        JLabel goldarLabel = new JLabel("No ");
        goldarLabel.setBounds(230, 150, 200, 30);
        panel.add(goldarLabel);
        
        for (int i = 0; i < showMember.size(); i++) {
            Member member = showMember.get(i);

            String foto = member.getFoto_member();
            JLabel fotoLabel = new JLabel(scaleImage(foto, 130, 170));
            fotoLabel.setBounds(30, 10, 200, 250);
            panel.add(fotoLabel);

            String nama = member.getNama_lengkap();
            JLabel namaLabel2 = new JLabel(": " + nama);
            namaLabel2.setBounds(350, 60, 400, 30);
            panel.add(namaLabel2);

            String tanggal_lahir = member.getTanggal_lahir().toString();
            JLabel tempat_lahirLabel2 = new JLabel(": " + tanggal_lahir);
            tempat_lahirLabel2.setBounds(350, 90, 400, 30);
            panel.add(tempat_lahirLabel2);

            String valid_until = member.getTanggal_pembuatan().toString();
            JLabel valid_untilLabel = new JLabel(": " + valid_until);
            valid_untilLabel.setBounds(350, 120, 200, 30);
            panel.add(valid_untilLabel);

            int no = member.getNomor_anggota();
            JLabel jenis_kelaminLabel2 = new JLabel(": " + no);
            jenis_kelaminLabel2.setBounds(350, 150, 400, 30);
            panel.add(jenis_kelaminLabel2);
        }

        JLabel barcode = new JLabel(scaleImage("pictures/Picture1/Picture1-0000.jpg", 250, 100));
        barcode.setBounds(280, 240, 250, 100);
        panel.add(barcode);

        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Hasil();
    }
}
