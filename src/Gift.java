import java.io.Serializable;
import java.util.HashMap;

public class Gift implements Serializable {

    private double weight;
    private Coordinate destination;
    private int id;
    private HashMap<Integer,Double> neighbors;

    public Gift(double pWeight, Coordinate pDest, int pID) {
        weight = pWeight;
        destination = pDest;
        id = pID;
        neighbors = new HashMap<>();
    }

    public double GetDistance(int target){
        System.out.println("Get distance to id " + target);
        double distance = 0;
        if(!neighbors.containsKey(target)) {
            System.out.println("Distance not available, calc...");
            Coordinate targetCoordinate = StoresGift.GetCoordinate(id);
            distance =  CalcHaversineDistance(destination, targetCoordinate);
            neighbors.put(target,distance);
        } else {
            System.out.println("Distance already calculated, read.");
            distance = neighbors.get(target);
        }
        return distance;
    }

    public double GetDistance(Coordinate pCoord){
        return CalcHaversineDistance(destination, pCoord);
    }
    public double GetDistance(Gift pGift) { return CalcHaversineDistance(destination, pGift.getDestination()); }

    public void StoreNeighbor(int id, double distance){
        neighbors.put(id,distance);
    }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }
    public Coordinate getDestination() { return destination; }
    public void setDestination(Coordinate destination) { this.destination = destination; }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    private double CalcHaversineDistance(Coordinate point1, Coordinate point2) {
        double R = 6371.0088; // Source value: 6372.8, where does this value come from? exchanged with mean radius from wikipedia.org // Radius in kilometers
        double lat1 = point1.getLatitude();
        double lon1 = point1.getLongitude();
        double lat2 = point2.getLatitude();
        double lon2 = point2.getLongitude();
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        double a = Math.pow(Math.sin(dLat / 2),2) + Math.pow(Math.sin(dLon / 2),2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.asin(Math.sqrt(a));
        return R * c;

        // Source: http://rosettacode.org/wiki/Haversine_formula#Java
    }
}
