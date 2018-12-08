import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CalculateDistance {

    // adjacencyMatrix stores distances between Gift id x id
    private double[][] adjacencyMatrix = new double[1000][100000];
    private FileIO io;

    public CalculateDistance() {
        io = new FileIO();
        // CalculateAdjacencyMatrix();
    }

    public double[][] GetAdjacencyMatrix(){
        return adjacencyMatrix;
    }

    private void CalculateAdjacencyMatrix() {
        io.ReadDataFromCSV();
        List<Gift> gifts = io.GetGifts();
        for (int i = 0; i < 100000; i++) {
            for (int j = 0; j < 100000; j++) {
                double distance = CalcHaversineDistance(gifts.get(i).getDestination(),gifts.get(j).getDestination());
                adjacencyMatrix[i][j] = distance;
            }

        }
    }

    // TODO replace with readl Equation
    private double CalcHaversineDistance(Coordinate point1, Coordinate point2) {
        Random rand = new Random();
        return rand.nextDouble();
    }

}
