package com.projectJdbc;

import java.util.Scanner;
import com.projectJdbc.service.UserService;
import com.projectJdbc.service.ReservationService;
public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        ReservationService reservationService = new ReservationService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Hotel Reservation System");
        System.out.println("1. Register");
        System.out.println("2. Login");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice == 1) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            if (userService.registerUser(username, password)) {
                System.out.println("Registration successful!");
            } else {
                System.out.println("Registration failed!");
            }
        } else if (choice == 2) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            if (userService.loginUser(username, password)) {
                System.out.println("Login successful!");
                while (true) {
                    System.out.println("1. Add Reservation");
                    System.out.println("2. View Reservations");
                    System.out.println("3. Cancel Reservation");
                    System.out.println("4. Exit");
                    int option = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    if (option == 1) {
                        System.out.print("Enter guest name: ");
                        String guestName = scanner.nextLine();
                        System.out.print("Enter room number: ");
                        int roomNumber = scanner.nextInt();
                        System.out.print("Enter contact number: ");
                        String contactNumber = scanner.next();
                        if (reservationService.addReservation(1, guestName, roomNumber, contactNumber)) {
                            System.out.println("Reservation added successfully!");
                        } else {
                            System.out.println("Failed to add reservation.");
                        }
                    } else if (option == 2) {
                        reservationService.viewReservations(1);
                    } else if (option == 3) {
                        System.out.print("Enter reservation ID to cancel: ");
                        int reservationId = scanner.nextInt();
                        if (reservationService.cancelReservation(reservationId)) {
                            System.out.println("Reservation cancelled successfully!");
                        } else {
                            System.out.println("Failed to cancel reservation.");
                        }
                    } else if (option == 4) {
                        break;
                    }
                }
            } else {
                System.out.println("Invalid login!");
            }
        }
    }
}
