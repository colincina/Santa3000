import java.util.List;
import 

public class Route {
    private List<Gift> gifts;
    private double distance;
    private double weariness;

    public Route(List<Gift> pGifts) {
        gifts = pGifts;
    }

    public double computeWeariness(int[] giftIDs) {
    	Coordinate northPole = new Coordinate(90, 0);
    	double baseWeight = 10; // Temporary hardcoded, should come from the sleigh
    	double weight = 0.0;
    	double weariness = 0.0;
    	double distance;
    	int size = giftIDs.length;
    	
    	// Compute the full weight of the sleigh
    	weight = baseWeight; // Add weight of the sleigh
    	for ( int i = 0; i < size; i++) { 
    		weight = weight + getWeight(i); // Add weight of all gifts
    	}
    	
    	// Compute weariness from north pole to the first destination
    	distance = getDistance(northPole, gifts.get(0).getDestination());
    	weariness = distance * weight;
    	
    	// Compute weariness for all destinations
    	for ( int i = 1; i < size; i++) {
    		weight = weight - gifts.get(i-1).getWeight(); // Remove weight of the gift of the previous destination
    		distance = getDistance(gifts.get(i-1).getDestination(), gifts.get(i).getDestination());
    		weariness = weariness + (distance * weight);
    	}
    	
    	// Compute weariness from last destination back to the north pole
    	weight = weight - gifts.get(size-1).getWeight(); // Remove the weight of the gift of the last destination, weight should now be equal the base weight
    	distance = getDistance(gifts.get(size-1).getDestination(), northPole);
    	weariness = weariness + (distance * weight);
    	
        return weariness;
    }
    
	public double getDistance(Coordinate point1, Coordinate point2) {
		double distance;
		
		// TODO get distance from adjacency matrix if available, otherwise compute haversine distance and add the value to the adjacency matrix
		
		distance = computeHaversineDistance(point1, point2);
	    return distance;
	}

    // TODO move function into a final class ---> Calculate Distance
    public double computeHaversineDistance(Coordinate point1, Coordinate point2) {
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

    public List<Gift> getGifts() { return gifts; }
    public void setGifts(List<Gift> gifts) { this.gifts = gifts; }
    public double getDistance() { return distance; }
    public void setDistance(double distance) { this.distance = distance; }
    public double getWeariness() { return weariness; }
    public void setWeariness(double weariness) { this.weariness = weariness; }
}
