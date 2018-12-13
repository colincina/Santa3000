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
			weight += StoresGift.GetWeight(giftIDs[j]); // Add weight of all gifts
		}

		// distance
		for(int j = 0; j < giftIDs.length ; j++){
			if(j == 0){
				weight += StoresGift.GetDistance(giftIDs[0],northPole);
				continue;
			}
			weight += StoresGift.GetDistance(giftIDs[j-1],giftIDs[j]);
		}

    	// Compute weariness from north pole to the first destination
    	distance = StoresGift.GetDistance(giftIDs[0],northPole);
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

    public List<Gift> getGifts() { return gifts; }
    public void setGifts(List<Gift> gifts) { this.gifts = gifts; }
    public double getDistance() { return distance; }
    public void setDistance(double distance) { this.distance = distance; }
    public double getWeariness() { return weariness; }
    public void setWeariness(double weariness) { this.weariness = weariness; }
}
