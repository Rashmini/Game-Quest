import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameDemo {
    private ArrayList <Inhabitant> inhabitantList;
    
    public static void main(String[] args) {
            Grid grid=new Grid();
            Random rand=new Random();
            ArrayList <Inhabitant> inhabitantList = new ArrayList <Inhabitant>();
            TreasureChest treasureChest = new TreasureChest (Grid.getGridLocation(5,5));
            
            NormalWarrior warrior1 = new NormalWarrior("NormalWarrior1", Grid.getGridLocation(0,rand.nextInt(11)), grid, treasureChest);
            NormalWarrior warrior2 = new NormalWarrior("NormalWarrior2", Grid.getGridLocation(10,rand.nextInt(11)), grid, treasureChest);
            SuperWarrior warrior3 = new SuperWarrior("SuperWarrior1", Grid.getGridLocation(rand.nextInt(11),0), grid, treasureChest);
            SuperWarrior warrior4 = new SuperWarrior("SuperWarrior2", Grid.getGridLocation(rand.nextInt(11),10), grid, treasureChest);
            
            InnocentFish innocent1 = new InnocentFish("innocent1",Grid.getGridLocation(rand.nextInt(11),rand.nextInt(11)), grid);
            InnocentFish innocent2 = new InnocentFish("innocent2",Grid.getGridLocation(rand.nextInt(11), rand.nextInt(11)), grid);
            RubberEatFish rubber1 = new RubberEatFish("rubber1",Grid.getGridLocation(rand.nextInt(11), rand.nextInt(11)), grid);
            RubberEatFish rubber2 = new RubberEatFish("rubber2",Grid.getGridLocation(rand.nextInt(11), rand.nextInt(11)), grid);
            KillerFish killer1 = new KillerFish("killer1",Grid.getGridLocation(rand.nextInt(11), rand.nextInt(11)), grid);
            KillerFish killer2 = new KillerFish("killer2",Grid.getGridLocation(rand.nextInt(11), rand.nextInt(11)), grid);
            
            LotusFlower lotus1 = new LotusFlower("lotus1", Grid.getGridLocation(rand.nextInt(11),rand.nextInt(11)), grid);
            LotusFlower lotus2 = new LotusFlower("lotus2", Grid.getGridLocation(rand.nextInt(11),rand.nextInt(11)), grid);
            LotusFlower lotus3 = new LotusFlower("lotus3", Grid.getGridLocation(rand.nextInt(11),rand.nextInt(11)), grid);
            LotusFlower lotus4 = new LotusFlower("lotus4", Grid.getGridLocation(rand.nextInt(11),rand.nextInt(11)), grid);
            LotusFlower lotus5 = new LotusFlower("lotus5", Grid.getGridLocation(rand.nextInt(11),rand.nextInt(11)), grid);
            
            inhabitantList.add(warrior1);
            inhabitantList.add(warrior2);
            inhabitantList.add(warrior3);
            inhabitantList.add(warrior4);
            inhabitantList.add(innocent1);
            inhabitantList.add(innocent2);
            inhabitantList.add(rubber1);
            inhabitantList.add(rubber2);
            inhabitantList.add(lotus1);
            inhabitantList.add(lotus2);
            inhabitantList.add(lotus3);
            inhabitantList.add(lotus4);
            inhabitantList.add(lotus5);
                       
            System.out.println("Total no of inhabitants is 15!");
            System.out.println("\nGame was started!");
            
            Thread t1 = new Thread(warrior1);
            Thread t2 = new Thread(warrior2);
            Thread t3 = new Thread(warrior3);
            Thread t4 = new Thread(warrior4);
            
            t1.start();
            t2.start();
            t3.start();
            t4.start();
    }   
}

