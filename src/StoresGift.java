import java.util.ArrayList;
import java.util.List;

public class StoresGift {

    public static List<Gift> Gifts = new ArrayList<Gift>();
    public static void GetsList(){
        Gifts = FileIO.ReadDataFromCSV();
    }


    public static double GetWeight(int id){
        return Gifts.get(id).getWeight();
    }

    public static Coordinate GetCoordinate(int id){
        return Gifts.get(id).getDestination();
    }

    public static Coordinate GetDistance(int id, int target){
        return Gifts.get(id).getDestination();
    }
}
