import java.util.List;

public class Sleigh {

    private int maxWeight;
    private int ownWeight;
    private List<Route> routes;


    public Sleigh(int pMaxWeight, int pOwnWeight) {
        maxWeight = pMaxWeight;
        ownWeight = pOwnWeight;
    }

    public int getMaxWeight() { return maxWeight; }
    public void setMaxWeight(int maxWeight) { this.maxWeight = maxWeight; }
    public int getOwnWeight() { return ownWeight; }
    public void setOwnWeight(int ownWeight) { this.ownWeight = ownWeight; }
}
