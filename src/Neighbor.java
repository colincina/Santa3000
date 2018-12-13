public class Neighbor {

    private int id;
    private double distanceToParent;

    public Neighbor(int id, double distance){
        this.id = id;
        this.distanceToParent = distance;
    }


    public int GetId(){
        return this.id;
    }

    public double GetDistance(){
        return this.distanceToParent;
    }
}
