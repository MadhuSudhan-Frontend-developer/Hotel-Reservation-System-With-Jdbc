package com.projectJdbc.service;

import java.sql.*;

import com.projectJdbc.config.DBConnection;

public class ReservationService {
    public boolean addReservation(int userId, String guestName, int roomNumber, String contactNumber) {
        String query = "INSERT INTO reservations (user_id, guest_name, room_number, contact_number) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, userId);
            stmt.setString(2, guestName);
            stmt.setInt(3, roomNumber);
            stmt.setString(4, contactNumber);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void viewReservations(int userId) {
        String query = "SELECT * FROM reservations WHERE user_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("Reservation ID: " + rs.getInt("reservation_id"));
                System.out.println("Guest Name: " + rs.getString("guest_name"));
                System.out.println("Room Number: " + rs.getInt("room_number"));
                System.out.println("Contact Number: " + rs.getString("contact_number"));
                System.out.println("Reservation Date: " + rs.getTimestamp("reservation_date"));
                System.out.println("-----------------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean cancelReservation(int reservationId) {
        String query = "DELETE FROM reservations WHERE reservation_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, reservationId);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
