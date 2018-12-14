import java.util.ArrayList;
import java.util.List;

import
public class RandomSolution {
    public static List<Route> solve() {
        List<Route> solution = new ArrayList<>();
        List<Integer> sortedGifIDs = new ArrayList<>();

        sortedGifIDs.addAll(StoresGift.sortByLongitudeAsc());
        int id = 1;
        int maxWeight = 1010;

        // Create Routes until all gifts are assigned to a route
        while (sortedGiftIDs.size() = !0) {
            Route newRoute = new Route();
            newRoute.setRouteId(id);

            // Add gifts to the route until the max weight is reached
            while (newRoute.getWeight() < maxWeight) {

            }

            solution.add(newRoute);
            id = id+1;
        }
    }
}