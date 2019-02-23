public class RubberEatFish extends Fish{
    
    public RubberEatFish(String name, GridLocation gridLocation, Grid grid) {
        super(name, gridLocation, grid);
    }
    
    public void eatFins(Warrior w){
        if (!(getLocation().getxCoordinate()==5 && getLocation().getyCoordinate()==5)){
            w.setMobility(false);
            Warrior.setNoOfWarriors();
            System.out.println("The swimfins of "+w.getName()+" got lost! He cannot swim now! \nThere are only "+ Warrior.getNoOfWarriors() + " warriors in the game now!");
        }
    }

    @Override
    public void update(Warrior w){
        eatFins(w);
    }
}
