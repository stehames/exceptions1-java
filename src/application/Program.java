package application;

import java.text.ParseException;
import model.entities.Reservation;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        System.out.print("Room number: ");
        int roomNumber = sc.nextInt();

        sc.nextLine();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.nextLine());

        System.out.print("Check-out date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.nextLine());

        if (!checkOut.after(checkIn)) {
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        } else {
            Reservation res = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println(res);
            System.out.println();

            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.nextLine());

            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.nextLine());

            Date now = new Date();
            if (checkIn.before(now) || checkOut.before(now)) {
                System.out.println("Error in reservation: Reservation dates for update must be future dates");
            } else if (!checkOut.after(checkIn)) {
                System.out.println("Error in reservation: Check-out date must be after check-in date");

            } else {
                res.updateDates(checkIn, checkOut);
                System.out.println(res);
            }

        }

        sc.close();
    }

}
