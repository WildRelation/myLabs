import java.util.ArrayList;
public class Auction {
    private User user;
    private String item;
    private ArrayList<Bid> bids;

    public Auction(User user, String item){
        this.user = user;
        this.item = item;
        bids = new ArrayList<>();
    }

    public void addBid(User user, int bid){
        bids.add(new Bid(user, bid));
    }
    @Override
    public String toString() {
        return "Auction{" +
                "user=" + user.getUsername() +
                ", item='" + item + '\'' +
                ", bids=" + String.format("" + bids) +
                '}';
    }
}
