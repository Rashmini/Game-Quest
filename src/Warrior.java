import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Warrior extends Inhabitant implements Runnable{
    private String name;
    private GridLocation gridLocation;
    private boolean mobility;
    private boolean immortal;
    private boolean alive;
    private static int noOfWarriors=0;
    private int energy=50;
    private Grid grid;
    private long startTime;
    private long endTime;
    private long totalTime;
    private TreasureChest treasure;

    public Warrior(String name, GridLocation gridLocation, Grid grid, TreasureChest t) {
        super(name, gridLocation, grid);
        treasure =t;
        noOfWarriors++;
        gridLocation=gridLocation;
        gridLocation.setWarrior(this);
        this.setLocation(gridLocation);
        mobility=true;
        immortal=false;
        alive=true;
        notifyChest();
        setStartTime(System.currentTimeMillis());
    }  
    
    public boolean getMobility() {
        return mobility;
    }

    public void setMobility(boolean hasSwimFins) {
        this.mobility = hasSwimFins;
    }

    public boolean isImmortal() {
        return immortal;
    }

    public void setImmortal(boolean immortal) {
        this.immortal = immortal;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public static int getNoOfWarriors() {
        return noOfWarriors;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }    
    
    public void pluckLotusPetal(LotusFlower lotus){
        if (!(getLocation().getxCoordinate()==5 && getLocation().getyCoordinate()==5)){
            setImmortal(true);
            System.out.println(getName() + " plucked a lotus petal! He is immortal now!");
        }
    }    

    public abstract void swim();
    
    public abstract void sleep();
    
    public abstract void eat();
    

    @Override
    public void run(){   
        while((mobility && alive)&&(!(Grid.getGridLocation(5, 5).getHasWarrior()))){
            swim(); 
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Warrior.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }   

    public static void setNoOfWarriors() {
        noOfWarriors--;
    }
        
    public void notifyChest(){
        treasure.addW(this);
    }          

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
    
    public long calculateTime(){
        totalTime= getEndTime()-getStartTime();
        return totalTime;
    }
    
    public void updateWinner(){
        this.setMobility(false);
    }

    public TreasureChest getTreasure() {
        return treasure;
    }
    
    public void WriteToFile(String data, String fileName){
        
      try{  
        FileWriter fileWriter = new FileWriter(fileName);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(data);
        bufferedWriter.newLine();
        bufferedWriter.close();
      }
      catch(IOException e){
          System.out.println("Error while writing!");
      }
    }
}