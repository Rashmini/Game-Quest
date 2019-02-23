public class Grid {
    private static GridLocation grid[][];
    
    Grid(){
        grid = new GridLocation[11][11];
        for (int x=0; x<11; x++)
            for (int y=0; y<11; y++)
                grid[x][y] = new GridLocation(x,y); 
    }

    public static GridLocation getGridLocation(int x, int y) {
        return grid[x][y];
    }  
}