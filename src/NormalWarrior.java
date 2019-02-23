public class NormalWarrior extends Warrior{

    public NormalWarrior(String name, GridLocation gridLocation, Grid grid, TreasureChest t) {
        super(name, gridLocation, grid, t);
    }

    @Override
    public void swim() {
        GridLocation nextLocation;
        int y=getLocation().getyCoordinate();
        int x=getLocation().getxCoordinate();
        GridLocation currentLocation = Grid.getGridLocation(x, y);
                       
        if (y==5 && x<5){
            nextLocation = Grid.getGridLocation(x+1, y);                                
            synchronized(nextLocation){
                if (nextLocation.getHasWarrior()==false){
                    currentLocation.removeWarrior(this);
                    this.setLocation(nextLocation);
                    nextLocation.setWarrior(this);                        
                }
            }              
        }
        else if (y==5 && x>5){
            nextLocation = Grid.getGridLocation(x-1, y);
            synchronized(nextLocation){
                if (nextLocation.getHasWarrior()==false){
                    currentLocation.removeWarrior(this);
                    this.setLocation(nextLocation);
                    nextLocation.setWarrior(this);            
                }
            }
        }
        else if (x==5 && y<5){
            nextLocation = Grid.getGridLocation(x, y+1);
            synchronized(nextLocation){
                if (nextLocation.getHasWarrior()==false){
                    currentLocation.removeWarrior(this);
                    this.setLocation(nextLocation);
                    nextLocation.setWarrior(this);       
                }
            } 
        }
        else if (x==5 && y>5){
            nextLocation = Grid.getGridLocation(x, y-1);
            synchronized(nextLocation){
                if (nextLocation.getHasWarrior()==false){
                    currentLocation.removeWarrior(this);
                    this.setLocation(nextLocation);
                    nextLocation.setWarrior(this);                    
                }
            }
        }
        else if (y<5 && x<5){         
            nextLocation = Grid.getGridLocation(x, y+1);
            synchronized(nextLocation){
                if (nextLocation.getHasWarrior()==false){                    
                    currentLocation.removeWarrior(this);
                    this.setLocation(nextLocation);
                    nextLocation.setWarrior(this);
                }
            }
        }       
        else if (y<5 && x>5){
            nextLocation = Grid.getGridLocation(x-1, y);
            synchronized(nextLocation){
                if (nextLocation.getHasWarrior()==false){
                    currentLocation.removeWarrior(this);
                    this.setLocation(nextLocation);
                    nextLocation.setWarrior(this);                       
                }
            }           
        }
        else if (y>5 && x<5){
            nextLocation = Grid.getGridLocation(x+1, y);
            synchronized(nextLocation){
                if (nextLocation.getHasWarrior()==false){
                    currentLocation.removeWarrior(this);
                    this.setLocation(nextLocation);
                    nextLocation.setWarrior(this);            
                }
            }           
        }  
        else if (y>5 && x>5){
            nextLocation = Grid.getGridLocation(x, y-1);
            synchronized(nextLocation){
                if (nextLocation.getHasWarrior()==false){
                    currentLocation.removeWarrior(this);
                    this.setLocation(nextLocation);
                    nextLocation.setWarrior(this);            
                }
            }           
        }
    }    

    @Override
    public void sleep() {
        setEnergy(getEnergy()-5);
        System.out.println(getName() + " is sleeping. Energy reduced by 5!");        
    }
    
    @Override
    public void eat() {
        if (getEnergy()<96){      //Max energy 100
            setEnergy(getEnergy()+5);
            System.out.println(getName() + " is eating. Energy increased by 5!");
        }
    }
}