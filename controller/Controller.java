package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Member;

public class Controller {
    private static Controller instance;
    static DatabaseHandler conn = new DatabaseHandler();

    public Controller() {
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public boolean addNewUser(Member member) {
        conn.connect();
        String query = "INSERT INTO member VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement statement = conn.con.prepareStatement(query);
            statement.setInt(1, member.getNomor_anggota());
            statement.setString(2, member.getNama_lengkap());
            statement.setString(3, member.getJenis_kelamin());
            statement.setDate(4, new java.sql.Date(member.getTanggal_lahir().getTime()));
            statement.setString(5, member.getFoto_member());
            statement.setDate(6, new java.sql.Date(member.getTanggal_pembuatan().getTime()));


            // Execute the SQL statement
            int rowsAffected = statement.executeUpdate();

            // Check if the insertion was successful
            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            conn.disconnect();
        }
    }

    public ArrayList<Member> getAllMemberList() {
        conn.connect();
        String query = "SELECT * FROM member";
        ArrayList<Member> members = new ArrayList<>();
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Member member = new Member();
                member.setNomor_anggota(resultSet.getInt("nomor_anggota"));
                member.setNama_lengkap(resultSet.getString("nama_lengkap"));
                member.setJenis_kelamin(resultSet.getString("jenis_kelamin"));
                member.setTanggal_lahir(resultSet.getDate("tanggal_lahir"));
                member.setFoto_member(resultSet.getString("foto_member"));
                member.setTanggal_pembuatan(resultSet.getDate("tanggal_pembuatan"));
                

                members.add(member);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return members;
    }

    public ArrayList<Member> getMemberData() {
        conn.connect();
        String query = "SELECT nomor_anggota, nama_lengkap, tanggal_lahir, foto_member, tanggal_pembuatan FROM member";
        ArrayList<Member> members = new ArrayList<>();
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Member member = new Member();
                member.setNomor_anggota(resultSet.getInt("nomor_anggota"));
                member.setNama_lengkap(resultSet.getString("nama_lengkap"));
                member.setTanggal_lahir(resultSet.getDate("tanggal_lahir"));
                member.setFoto_member(resultSet.getString("foto_member"));
                member.setTanggal_pembuatan(resultSet.getDate("tanggal_pembuatan"));
                
                members.add(member);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return members;
    }
}
