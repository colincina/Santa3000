

public class Gift {

    private double weight;
    private Coordinate destination;
    private int id;

    public Gift(double pWeight, Coordinate pDest, int pID) {
        weight = pWeight;
        destination = pDest;
        id = pID;
    }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }
    public Coordinate getDestination() { return destination; }
    public void setDestination(Coordinate destination) { this.destination = destination; }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
}
