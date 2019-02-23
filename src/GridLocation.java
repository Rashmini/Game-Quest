public class GridLocation {
    private final int xCoordinate;
    private final int yCoordinate;
    private boolean hasLotus;
    private boolean hasFish;
    private boolean hasWarrior;
    private LotusFlower lotus;    
    private Fish fish;
    private Warrior warrior;
    private TreasureChest treasure;
    
    GridLocation(int x, int y){
        this.xCoordinate=x;
        this.yCoordinate=y;
        hasLotus=false;
        hasFish=false;
        hasWarrior=false;
    }   
    
    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public boolean getHasLotus() {
        return hasLotus;
    }

    public void setHasLotus(boolean hasLotus) {
        this.hasLotus = hasLotus;
    } 

    public boolean getHasFish() {
        return hasFish;
    }
    
    private void setHasFish(boolean hasFish) {
        this.hasFish=hasFish;
    }    
    
    public boolean getHasWarrior() {
        return hasWarrior;
    }

    public void setHasWarrior(boolean hasWarrior) {
        this.hasWarrior = hasWarrior;
    }    

    public void addFish(Fish fish) {
        setHasFish(true);
        this.fish = fish;
    }
    
    public void addLotus(LotusFlower lotus) {
        setHasLotus(true);
        this.lotus = lotus;
    }   
    
    public void removeLotus(LotusFlower lotus) {
        this.lotus = null;
        setHasLotus(false);
    }     
        
    public void notifyObserver(Observer observer,Warrior w){
        observer.update(w);
    }    

    public Warrior getWarrior() {
        return warrior;
    }

    public void setWarrior(Warrior warrior) {
        setHasWarrior(true);
        this.warrior = warrior;
        System.out.println(warrior.getName() + " is on (" + warrior.getLocation().getxCoordinate()+" ,"+warrior.getLocation().getyCoordinate()+")");        
        
        if (warrior.getLocation().getxCoordinate()==5 && warrior.getLocation().getyCoordinate()==5){
            warrior.getTreasure().notifyWarrior();
            warrior.setEndTime(System.currentTimeMillis());            
            System.out.println("Game was ended!");
            System.out.println('\n'+warrior.getName()+ " is on (5, 5). He is the winner!");
            System.out.println(warrior.getName()+" taken a time of "+ warrior.calculateTime()+ " milliseconds!");   
            warrior.WriteToFile((warrior.getName()+" won within "+ warrior.calculateTime()+ " milliseconds!"), "GameRecords.txt");
        }

        if (hasFish==true){
            notifyObserver(fish,warrior);
        }
        if (hasLotus==true){
            notifyObserver(lotus,warrior);
        }
    }
    
    public void removeWarrior(Warrior warrior) {
        this.warrior = null;
        setHasWarrior(false);
    }    

    public void setTreasure(TreasureChest treasure) {
        this.treasure = treasure;
    }
}