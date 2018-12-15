import java.util.ArrayList;
import java.util.List;

public class RandomSolution {
    public static List<Route> solve() {
        List<Route> solution = new ArrayList<>();
        List<Integer> sortedGifIDs = new ArrayList<>();

        sortedGifIDs.addAll(StoresGift.sortByLongitudeAsc());
        int id = 1;
        int maxWeight = 1010;

        // Create Routes until all gifts are assigned to a route
        while (sortedGiftIDs.size() !=0) {
            Route newRoute = new Route();
            newRoute.setRouteId(id);

            // Add gifts to the route until the max weight is reached
            while (newRoute.getWeight() < maxWeight) {
                // Check if the next gift still fits
                boolean fit = newRoute.getWeight() + StoresGift.GetWeight(sortedGifIDs.get(0)) <= maxWeight;
                if (fit) {
                    newRoute.setGift(sortedGifIDs.get(0));
                    sortedGifIDs.remove(0);
                } else {
                    break;
                }
            }

            solution.add(newRoute);
            id = id+1;
        }
        return solution;
    }
}