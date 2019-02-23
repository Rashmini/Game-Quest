public abstract class Inhabitant{
    private String name;
    private GridLocation gridLocation;
    private Grid grid;
    
    Inhabitant(String name, GridLocation gridLocation, Grid grid){
        this.name = name;
        this.gridLocation = gridLocation;
        this.grid = grid;       
    }
    
    public void setName(String name) {
        this.name = name;
    }  
    
    public String getName() {
        return name;
    }

    public GridLocation getLocation() {
        return gridLocation;
    }

    public void setLocation(GridLocation gridLocation) {
        this.gridLocation = gridLocation;
    }

    public Grid getGrid() {
        return grid;
    }
}