import java.util.List;

public class Route {
    private List<Gift> gifts;
    private double distance;
    private double weariness;

    public Route(List<Gift> pGifts) {
        gifts = pGifts;
    }

    public double computeWeariness() {
        //TODO implement the weariness computation
        return 0.0;
    }

    public double computeHaversineDistance() {
        //TODO implement the haverstine Distance calculation.
        return 0.0;
    }

    public List<Gift> getGifts() { return gifts; }
    public void setGifts(List<Gift> gifts) { this.gifts = gifts; }
    public double getDistance() { return distance; }
    public void setDistance(double distance) { this.distance = distance; }
    public double getWeariness() { return weariness; }
    public void setWeariness(double weariness) { this.weariness = weariness; }
}
