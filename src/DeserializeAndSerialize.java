import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DeserializeAndSerialize {

    public static String serializePath = ".\\Data\\SerializedGifts.txt";

    public static boolean SerializeGifts(){
        try{
            FileOutputStream fileOut = new FileOutputStream(serializePath);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(StoresGift.Gifts);
            out.close();
            fileOut.close();
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public static List<Gift> DeserializeGifts(){
        List<Gift> Gifts = new ArrayList<Gift>();
        try {
            FileInputStream fileIn = new FileInputStream(serializePath);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Gifts = (ArrayList<Gift>)in.readObject();
            in.close();
            fileIn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return Gifts;
    }


}
