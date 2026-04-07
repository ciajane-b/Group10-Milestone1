public class AfterActionReview {
    private ReportRepository repo;
    public AfterActionReview(ReportRepository r) { this.repo = r; }
    public void log(UserSession s, String action) {
        repo.saveLog(s.getUsername(), action);
        System.out.println("[SYSTEM LOGGED]: " + action);
    }
}
