public abstract class Fish extends Inhabitant implements Observer{
    private String name;
    private GridLocation gridLocation;

    public Fish(String name, GridLocation gridLocation, Grid grid) {
        super(name, gridLocation, grid);
        System.out.println( this.getName() + " is on (" + this.getLocation().getxCoordinate() + ", " + this.getLocation().getyCoordinate() + ")");
        gridLocation.addFish(this);
    }
}
