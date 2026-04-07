public class ReservationService {
    private AfterActionReview aar;
    public ReservationService(AfterActionReview a) { this.aar = a; }
    public void addReservation(UserSession s, String name, String room) {
        System.out.println("Room " + room + " assigned to " + name);
        aar.log(s, "Created reservation for " + name + " in " + room);
    }
}
