public class Main {
    public static void main(String[] args){
        User anders = new User("Anders Cojones", "anderscojones@kth.se", "42");
        User lillen = new User("Lilla Cojones", "lillacojones@kth.se", "4711");

        Auction auction = new Auction(anders, "Mina bollar");
        auction.addBid(lillen, 20);
        auction.addBid(lillen, 40);

        System.out.println(auction.toString());
    }
}
