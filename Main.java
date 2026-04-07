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
    }
}
