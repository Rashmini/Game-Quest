public class InnocentFish extends Fish {
    
    public InnocentFish(String name, GridLocation gridLocation, Grid grid) {
        super(name, gridLocation, grid);
    }  

    public void notifyW(){
        System.out.println("There is a innocent fish here!");
    }
    
    @Override
    public void update(Warrior w) {
        notifyW();
    }
}
