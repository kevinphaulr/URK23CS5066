package TRAVELAROUND;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Booking {
    public static boolean insert(String name, String place, int members, double cost, String method, String payID) {
        try {
            Connection con = DBConnection.getConnection();
            String query = "INSERT INTO bookings (passenger_name, place, num_members, total_cost, payment_method, payment_id) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, place);
            ps.setInt(3, members);
            ps.setDouble(4, cost);
            ps.setString(5, method);
            ps.setString(6, payID);
            int i = ps.executeUpdate();
            return i > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
