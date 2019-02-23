public class KillerFish extends Fish{

    public KillerFish(String name, GridLocation gridLocation, Grid grid) {
        super(name, gridLocation, grid);
    }    

    public void kill(Warrior w){
        if (w.isImmortal()==false && !(getLocation().getxCoordinate()==5 && getLocation().getyCoordinate()==5)){
            w.setAlive(false);
            w.getTreasure().removeW(w);
            Warrior.setNoOfWarriors();
            this.getLocation().removeWarrior(w);
            System.out.println(w.getName() + " was killed! There are only "+ Warrior.getNoOfWarriors() + " warriors in the game now!");            
        }
        else if (w.isImmortal()==true && !(getLocation().getxCoordinate()==5 && getLocation().getyCoordinate()==5)){
            System.out.println(w.getName() + " is immortal. Cannot be killed!");
        }
    }    
    
    @Override
    public void update(Warrior w){
        kill(w);
    }
} 