package hust.itep.quanlynhankhau.dao;

import hust.itep.quanlynhankhau.database.DatabaseConnection;
import hust.itep.quanlynhankhau.model.NhanKhau;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NhanKhauDAO {
    public boolean addNhanKhau(NhanKhau nhanKhau) {
        if (nhanKhau.getId() != null) {
            return false;
        }

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement(
                            "insert into nhan_khau(maNhanKhau, HoTen) " +
                                    "values " +
                                    "(" +
                                    "?, ?" +
                                    ")"
                    );

            preparedStatement.setString(1, nhanKhau.getMaNhanKhau());
            preparedStatement.setString(2, nhanKhau.getHoTen());

            if (preparedStatement.executeUpdate() == 0) {
                return false;
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    public boolean deleteNhanKhau(NhanKhau nhanKhau) {
        boolean success = true;

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from nhan_khau where id=?");
            // Parameters start with 1
            preparedStatement.setInt(1, nhanKhau.getId());

            if (preparedStatement.executeUpdate() == 0) {
                success = false;
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return success;
    }

    public ArrayList<NhanKhau> getAllNhanKhau() {
        ArrayList<NhanKhau> nhanKhaus = new ArrayList<>();

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "select * from nhan_khau"
            );

            ResultSet resultSets = statement.executeQuery();

            while (resultSets.next()) {
                int id = resultSets.getInt("id");
                NhanKhau nhanKhau = new NhanKhau(id);

                String maNhanKhau = resultSets.getString("maNhanKhau");
                nhanKhau.setMaNhanKhau(maNhanKhau);

                String hoTen = resultSets.getString("hoTen");
                nhanKhau.setHoTen(hoTen);

                String gioiTinh = resultSets.getString("gioiTinh");
                nhanKhau.setGioiTinh(gioiTinh);

                String bietDanh = resultSets.getString("bietDanh");
                nhanKhau.setBietDanh(bietDanh);

                Date namSinh = resultSets.getDate("namSinh");
                nhanKhau.setNamSinh(namSinh);

                nhanKhaus.add(nhanKhau);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nhanKhaus;
    }

}
