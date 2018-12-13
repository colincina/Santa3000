import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileIO {

    public static String CSVPath = ".\\Data\\gifts.csv";
    public static String path = ".\\Data\\Distances.txt";


    public static List<Gift> ReadDataFromCSV(){
        List<Gift> Gifts = new ArrayList<Gift>();
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        boolean first = true;
        try{
            br = new BufferedReader(new FileReader(CSVPath));
            while((line = br.readLine())!= null)
            {
                String[] giftString = line.split(cvsSplitBy);
                if(first){
                    first = false;
                    continue;
                }
                int id = Integer.parseInt(giftString[0]);
                double latitude = Double.parseDouble(giftString[1]);
                double longitude = Double.parseDouble(giftString[2]);
                double weight = Double.parseDouble(giftString[3]);
                Coordinate coord = new Coordinate(latitude,longitude);
                Gift gift = new Gift(weight,coord,id);
                Gifts.add(gift);
                //System.out.println("GiftId :"+giftString[0]+" , Latitude : "+giftString[1]+", Longitude : "+giftString[2]+", Weight : "+ giftString[3]);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return Gifts;
    }


// S
    public static Boolean WriteToTextFile(Double[][] distances){

        try {
            Files.write(Paths.get("myfile.txt"), "the text".getBytes(), StandardOpenOption.APPEND);
        }catch (Exception e) {
            //exception handling left as an exercise for the reader
        }
        return true;
    }
}
