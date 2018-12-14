import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

    public static double GetDistance(int id, int target){
        return Gifts.get(id).GetDistance(target);
    }

    public static double GetDistance(int id, Coordinate pCoor) {
        return Gifts.get(id).GetDistance(pCoor);
    }

    /*
    Sorts the Gifts by Latitude in ascending order and returns a List of the sorted Gift IDs
    @ return :  null if GetList has not been called yet
                The ordered list of Gift IDs.
     */
    public static List<Integer> sortByLatitudeAsc() {
        List<Integer> retVal = new ArrayList<>();
        if(!Gifts.isEmpty()) {
            List<Gift> clonedGifts = cloneGifts();
            Collections.sort(clonedGifts, new Comparator<Gift>() {
                public int compare(Gift a, Gift b) {
                    if(a.getDestination().getLatitude() == b.getDestination().getLatitude()) {
                        return 0;
                    }
                    return a.getDestination().getLatitude() > b.getDestination().getLatitude() ? 1 : -1;
                }
            });
            for(Gift g : clonedGifts) {
                retVal.add(g.getId());
            }
            return retVal;
        }
        else {
            return null;
        }
    }

    /*
    Sorts the Gifts by Longitude in ascending order and returns a List of the sorted Gift IDs
    @ return :  null if GetList has not been called yet
                The ordered list of Gift IDs.
     */
    public static List<Integer> sortByLongitudeAsc() {
        List<Integer> retVal = new ArrayList<>();
        if(!Gifts.isEmpty()) {
            List<Gift> clonedGifts = cloneGifts();
            Collections.sort(clonedGifts, new Comparator<Gift>() {
                public int compare(Gift a, Gift b) {
                    if(a.getDestination().getLongitude() == b.getDestination().getLongitude()) {
                        return 0;
                    }
                    return a.getDestination().getLongitude() > b.getDestination().getLongitude() ? 1 : -1;
                }
            });
            for(Gift g : clonedGifts) {
                retVal.add(g.getId());
            }
            return retVal;
        }
        else {
            return null;
        }
    }

    public static void DeserializeGifts() {
    }

    private static List<Gift> cloneGifts() {
            ArrayList<Gift> retval = new ArrayList<Gift>(Gifts.size());
            retval.addAll(Gifts);
            return retval;
    }
}


