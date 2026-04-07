import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initialize the workers
        ReportRepository repo = new ReportRepository();
        AfterActionReview aar = new AfterActionReview(repo);
        FrontDeskService fd = new FrontDeskService(aar);RTRIM
        ReservationService res = new ReservationService(aar);
        OfficerService off = new OfficerService(repo);
        Scanner sc = new Scanner(System.in);

        System.out.println("=== MILITARY OUTPOST LODGING MANAGEMENT SYSTEM ===");
        System.out.print("User: "); String u = sc.nextLine();
        System.out.print("Pass: "); String p = sc.nextLine();

        UserSession session = repo.authenticate(u, p);
        
    if (session != null) {
            System.out.println("\nLogin Success. Welcome, " + session.getRank() + " " + session.getUsername());
            boolean run = true;
            while (run) {
                System.out.println("\n--- MAIN MENU ---");
                System.out.println("1. View Room Status");
                System.out.println("2. Front Desk (Check-Out)");
                System.out.println("3. Reservations (Add)");
                System.out.println("4. Officer Reports (AAR)");
                System.out.println("0. Logout");

                System.out.print("Choice: ");
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1: System.out.println("Room 101: Ready | Room 102: Occupied"); break;
                    case 2: fd.checkOut(session, "SM-5521"); break;
                    case 3: res.addReservation(session, "SGT Delacruz", "303"); break;
                    case 4: off.generateSitRep(session); break;
                    case 0: run = false; break;
                    default: System.out.println("Invalid Option.");
                }
            }
        } else {
            System.out.println("ACCESS DENIED: Invalid Credentials.");
        }
    }
}
