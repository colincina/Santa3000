import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Route> solution = new ArrayList<>();

        StoresGift.GetsList();
        DeserializeAndSerialize.SerializeGifts();

        solution = RandomSolution.solve();
    }
}
