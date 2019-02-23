public class LotusFlower extends Inhabitant implements Observer{
    private String name;
    private GridLocation gridLocation;
    private boolean hasPetals=true;
    private int noOfPetals=100;

    public LotusFlower(String name, GridLocation gridLocation, Grid grid) {
        super(name, gridLocation, grid);
        gridLocation.addLotus(this);
        System.out.println( this.getName() + " is on (" + this.getLocation().getxCoordinate() + ", " + this.getLocation().getyCoordinate() + ")");
    }

    public boolean getHasPetals() {
        return hasPetals;
    }

    public void setHasPetals(boolean hasPetals) {
        this.hasPetals = hasPetals;
    }

    public int getNoOfPetals() {
        return noOfPetals;
    }

    public void setNoOfPetals(int noOfPetals) {
        this.noOfPetals = noOfPetals;
    }
    
    public void getPlucked() {
        setNoOfPetals(getNoOfPetals() - 1);
        if (getNoOfPetals()==0){
            setHasPetals(false);
            gridLocation.removeLotus(this);
        }
    }

    @Override
    public void update(Warrior w) {
        w.pluckLotusPetal(this);
        getPlucked();
    }
}