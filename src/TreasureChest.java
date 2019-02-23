import java.util.ArrayList;

public class TreasureChest {
    private GridLocation gridLocation;
    private ArrayList <Warrior> warriorList;
    
    TreasureChest(GridLocation gridLocation){
        this.gridLocation = gridLocation;
        gridLocation.setTreasure(this);
        warriorList= new ArrayList<>();
        System.out.println("Treasure chest is on (" + this.getGridLocation().getxCoordinate() + ", " + this.getGridLocation().getyCoordinate() + ")");       
    }

    public GridLocation getGridLocation() {
        return gridLocation;
    }

    public void setGridLocation(GridLocation gridLocation) {
        this.gridLocation = gridLocation;
    }    
    
    public void addW(Warrior w){
        warriorList.add(w);
    }
    
    public void removeW(Warrior w){
        warriorList.remove(w);
    }
    
    public void notifyWarrior(){
        System.out.println("notify done!");
        for(Warrior w: warriorList){
            w.updateWinner();
        }
    }
}