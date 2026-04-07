public class OfficerService {
    public OfficerService(ReportRepository r) { }
    public void generateSitRep(UserSession s) {
        if (!s.getRank().equals("CPT")) {
            System.out.println("ACCESS DENIED: Officer rank required for SitRep.");
            return;
        }
        System.out.println("=== COMMANDER SITREP GENERATED ===");
        System.out.println("Status: Outpost Secure | Personnel: 100%");
    }
}
