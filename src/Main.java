import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Route> solution = new ArrayList<>();
        double weariness = 0.0;

        // Read data
        StoresGift.GetsList();

        // Compute stuff
        solution = LongitudeSortedSolution.solve();

        for (int i = 0; i < solution.size(); i++) {
            weariness = weariness + solution.get(i).getWeariness();
        }


        FileIO.WriteSolution(solution);
        
        System.out.println();
        System.out.println("#########################################");
        System.out.println("Weariness of the solution is " + weariness);
        System.out.println("#########################################");


        // Write data
        DeserializeAndSerialize.SerializeGifts();
    }
}
