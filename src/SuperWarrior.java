public class SuperWarrior extends Warrior{
    private boolean hasBinocular=true;

    public SuperWarrior(String name, GridLocation gridLocation, Grid grid, TreasureChest t) {
        super(name, gridLocation, grid, t);
        Binocular binocular = new Binocular();
    }
    
    @Override
    public void swim(){
        GridLocation nextLocation;
        int y=getLocation().getyCoordinate();
        int x=getLocation().getxCoordinate();
        GridLocation currentLocation = Grid.getGridLocation(x, y);
        
        if (isImmortal()==false && (!(x+1==11)) && (Grid.getGridLocation(x+1, y).getHasLotus()==true)){
            nextLocation = Grid.getGridLocation(x+1, y);    
            synchronized(nextLocation){
                if (nextLocation.getHasWarrior()==false){
                    currentLocation.removeWarrior(this);
                    this.setLocation(nextLocation);
                    nextLocation.setWarrior(this);
                }
            }            
        }
        else if (isImmortal()==false && (!(y+1==11)) && (Grid.getGridLocation(x, y+1).getHasLotus()==true)){
            nextLocation = Grid.getGridLocation(x, y+1);    
            synchronized(nextLocation){
                if (nextLocation.getHasWarrior()==false){
                    currentLocation.removeWarrior(this);
                    this.setLocation(nextLocation);
                    nextLocation.setWarrior(this);
                }
            }            
        } 
        else if (isImmortal()==false && (!(x-1==-1)) && (Grid.getGridLocation(x-1, y).getHasLotus()==true)){
            nextLocation = Grid.getGridLocation(x-1, y);    
            synchronized(nextLocation){
                if (nextLocation.getHasWarrior()==false){
                    currentLocation.removeWarrior(this);
                    this.setLocation(nextLocation);
                    nextLocation.setWarrior(this);
                }
            }            
        }    
        else if (isImmortal()==false && (!(y-1==-1)) && (Grid.getGridLocation(x, y-1).getHasLotus()==true)){
            nextLocation = Grid.getGridLocation(x, y-1);    
            synchronized(nextLocation){
                if (nextLocation.getHasWarrior()==false){
                    currentLocation.removeWarrior(this);
                    this.setLocation(nextLocation);
                    nextLocation.setWarrior(this);
                }
            }            
        }  
        else if (y==5 && x<5){
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
        setEnergy(getEnergy()-10);
        System.out.println(getName() + " is sleeping. Energy reduced by 10!");        
    }

    @Override
    public void eat() {
        if (getEnergy()<91){      //Max energy 100
            setEnergy(getEnergy()+10);
            System.out.println(getName() + " is eating. Energy increased by 10!");
        }
    }
}
