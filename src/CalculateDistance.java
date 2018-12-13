import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CalculateDistance {

    // adjacencyMatrix stores distances between Gift id x id

    public static void CalculateAdjacencyMatrix() {
        float[][] adjacencyMatrix = new float[100000][100000];
        FileIO.ReadDataFromCSV();
        List<Gift> gifts = StoresGift.GetGifts();
        for (int i = 0; i < 100000; i++) {
            for (int j = 0; j < 100000; j++) {
                float distance = (float)CalcHaversineDistance(gifts.get(i).getDestination(),gifts.get(j).getDestination());
                adjacencyMatrix[i][j] = distance;
            }

        }
    }

    public static double CalcHaversineDistance(Coordinate point1, Coordinate point2) {
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
