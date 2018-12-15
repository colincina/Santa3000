import java.util.ArrayList;
import java.util.List;

public class LongitudeSortedSolution {
    public static List<Route> solve() {
        List<Route> solution = new ArrayList<>();
        List<Integer> sortedGifIDs = new ArrayList<>();

        sortedGifIDs.addAll(StoresGift.sortByLongitudeAsc());
        int id = 1;
        double maxWeight = 1010;

        System.out.println("#### START GENERATING INITIAL SOLUTION ####");

        // Create routes until all gifts are assigned to a route
        while (sortedGifIDs.size() > 0) {
            Route newRoute = new Route();
            newRoute.setRouteId(id);
            System.out.println("---- Create a new route with id " + id);

            // Add gifts to the route until the max weight is reached
            while (newRoute.getWeight() < maxWeight && sortedGifIDs.size() > 0) {
                // Check if the next gift still fits
                System.out.println("-------- Check if fit");
                boolean fit = (newRoute.getWeight() + StoresGift.GetWeight(sortedGifIDs.get(0))) <= maxWeight;
                if (fit) {
                    System.out.println("Add gift with id " + sortedGifIDs.get(0) + " to route");
                    newRoute.setGift(sortedGifIDs.get(0));
                    sortedGifIDs.remove(0);
                } else {
                    System.out.println("-------- Route full with " + newRoute.getGifts().size() + " gifts");
                    System.out.println("-------- There are " + sortedGifIDs.size() + " gifts left");
                    break;
                }
            }

            solution.add(newRoute);
            id = id+1;
        }
        System.out.println("#### FINISHED GENERATING INITIAL SOLUTION ####");
        return solution;
    }
}