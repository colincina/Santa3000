import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GreedyStartSolution {
    private List<Route> solution = new ArrayList<>();
    private List<Integer> sortedGifIDs = new ArrayList<>();
    private int MAXWEIGHT = 1010;
    private int SLEIGHTWEIFGHT = 10;
    private List<Integer> remainingGifts;

    public GreedyStartSolution(){
        remainingGifts = StoresGift.sortByLatitudeAsc();
    }

    public List<Route> Solve(){
        List<Route> result = new ArrayList<Route>();
        while(!remainingGifts.isEmpty()){
            result.add(CreateNewRoute());
        }
        return result;
    }

    public Route CreateNewRoute(){
        Random rnd = new Random();
        Sleigh sleigh = new Sleigh(MAXWEIGHT,SLEIGHTWEIFGHT);
        List<Integer> actualRoute = new ArrayList<Integer>();
        // Add maybe better way
        int startPoint = rnd.nextInt(remainingGifts.size());
        actualRoute.add(startPoint);
        for(int i = 0;i<remainingGifts.size();i++){

        }
        return null;
    }

}
