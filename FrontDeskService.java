public class FrontDeskService {
    private AfterActionReview aar;
    public FrontDeskService(AfterActionReview a) { this.aar = a; }
    public void checkOut(UserSession s, String memberId) {
        if (s.getRank().equals("PVT")) {
            System.out.println("Error: Privates cannot authorize check-outs.");
            return;
        }
        System.out.println("Processing Check-out for: " + memberId);
        aar.log(s, "Authorized check-out for " + memberId);
    }
}
