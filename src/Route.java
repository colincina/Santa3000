import java.util.List;

public class Route {
	private int routeId;
    private List<Integer> gifts;
    private double distance;
    private double weariness;

    public Route() {
    }

    public double getWeight() {
    	int size = this.gifts.size();
    	int weight = 0;
    	for (int i = 0; i < size; i++) {
    		weight = weight + StoresGift.GetWeight(this.gifts.get(i));
		}
    	return weight;
	}

    public double getWeariness() {
    	Coordinate northPole = new Coordinate(90, 0);
    	double baseWeight = 10; // Temporary hardcoded, should come from the sleigh
    	double weight = 0.0;
    	double weariness = 0.0;
    	double distance;
    	int size = this.gifts.length;
    	
    	// Compute the full weight of the sleigh
    	weight = baseWeight; // Add weight of the sleigh
		for ( int j = 0; j < size; j++) {
			weight += StoresGift.GetWeight(this.gifts[j]); // Add weight of all gifts
		}

    	// Compute weariness from north pole to the first destination
    	distance = StoresGift.GetDistance(this.gifts[0],northPole);
    	weariness = distance * weight;
    	
    	// Compute weariness for all destinations
    	for (int i = 1; i < size; i++) {
    		weight = weight - StoresGift.GetWeight(this.gifts[i]); // Remove weight of the gift of the previous destination
    		distance = StoresGift.GetDistance(this.gifts[i-1], this.gifts[i]);
    		weariness = weariness + (distance * weight);
    	}
    	
    	// Compute weariness from last destination back to the north pole
		weight = weight - StoresGift.GetWeight(this.gifts[size-1]); // Remove the weight of the gift of the last destination, weight should now be equal the base weight
		distance = StoresGift.GetDistance(this.gifts[size-1], northPole);
    	weariness = weariness + (distance * weight);
    	
        return weariness;
    }

    public List<Integer> getGifts() { return gifts; }
    public void setGifts(List<Integer> gifts) { this.gifts = gifts; }
    public double getDistance() { return distance; }
    public void setDistance(double distance) { this.distance = distance; }
    public void setWeariness(double weariness) { this.weariness = weariness; }
    public void setRouteId(int id){
    	routeId = id;
	}
	public int getRouteId(){
    	return this.routeId;
	}
}
