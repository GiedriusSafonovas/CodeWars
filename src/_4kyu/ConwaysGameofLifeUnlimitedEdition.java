package _4kyu;

//Given a 2D array and a number of generations, compute n timesteps of Conway's Game of Life.
//
//        The rules of the game are:
//
//        Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
//        Any live cell with more than three live neighbours dies, as if by overcrowding.
//        Any live cell with two or three live neighbours lives on to the next generation.
//        Any dead cell with exactly three live neighbours becomes a live cell.
//
//        Each cell's neighborhood is the 8 cells immediately around it (i.e. Moore Neighborhood). The universe is infinite in both the x and y dimensions and all cells are initially dead - except for those specified in the arguments. The return value should be a 2d array cropped around all of the living cells. (If there are no living cells, then return [[]].)
//
//        For illustration purposes, 0 and 1 will be represented as ░░ and ▓▓ blocks respectively (PHP, C: plain black and white squares). You can take advantage of the htmlize function to get a text representation of the universe, e.g.:
//
//        System.out.println(LifeDebug.htmlize(cells));


import java.util.Arrays;

public class ConwaysGameofLifeUnlimitedEdition {
    public static int[][] getGeneration(int[][] cells, int generations) {
        if(generations == 0){
            return cells;
        }
        int[][] grid = new int[cells.length + 2][cells[0].length+2];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(i == 0 || i == grid.length-1 || j==0 || j == grid[i].length-1) {
                    grid[i][j] = 0;
                }else{
                    grid[i][j] = cells[i-1][j-1];
                }
            }
        }

        int [][]liveOrDead = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int [] activecell = {i,j};
                int numOfAdjCells = 0;
                for (int k = 0; k < grid.length; k++) {
                    for (int l = 0; l < grid[k].length; l++) {
//                        System.out.println("Active cell " + i + "," + j);
//                        System.out.println("comparing cell " + k + "," + l);
//                        System.out.println("not same cell " + !(i == k && j == l));
//                        System.out.println("adjacent row " + (i-k<=1 && i-k>=-1));
//                        System.out.println("adjacent column " +(j-l<=1 && j-l>=-1));
//                        System.out.println("overall result " + (!(i == k && j == l) && ((i-k<=1 && i-k>=-1) && (j-l<=1 && j-l>=-1))));
                        if((grid[k][l] == 1) && (!(i == k && j == l) && ((i-k<=1 && i-k>=-1) && (j-l<=1 && j-l>=-1)))){
                            numOfAdjCells++;
                        }
//                        System.out.println("num of adjacent cells " + numOfAdjCells);
                    }
                }
//                System.out.println(numOfAdjCells);
                if(grid[i][j] == 1 && numOfAdjCells<2) {
                    liveOrDead[i][j] = -1;
                }else if(grid[i][j] == 1 && numOfAdjCells>3){
                    liveOrDead[i][j] = -1;
                }else if(grid[i][j] == 1 && (numOfAdjCells == 2 || numOfAdjCells == 3)){
                    liveOrDead[i][j] = 0;
                }else if(grid[i][j] == 0 && numOfAdjCells == 3){
                    liveOrDead[i][j] = 1;
                }else {
                    liveOrDead[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] += liveOrDead[i][j];
            }
        }

        int cropTop = 0;
        int cropBottom = 0;
        int cropLeft = 0;
        int cropRight = 0;

        for (int i = 0; i < grid.length; i++) {
            int sum = 0;
            for (int j = 0; j < grid[i].length; j++) {
                sum += grid[i][j];
            }
            cropTop += sum > 0 ? 0 : 1;
            if(sum>0){
                break;
            }
        }

        for (int i = grid.length-1; i >= 0; i--) {
            int sum = 0;
            for (int j = 0; j < grid[i].length; j++) {
                sum += grid[i][j];
            }
            cropBottom += sum > 0 ? 0 : 1;
            if(sum>0){
                break;
            }
        }

        for (int i = 0; i < grid[0].length; i++) {
            int sum = 0;
            for (int j = 0; j < grid.length; j++) {
                sum += grid[j][i];
            }
            cropLeft += sum > 0 ? 0 : 1;
            if(sum>0){
                break;
            }
        }

        for (int i = grid[0].length-1; i >= 0; i--) {
            int sum = 0;
            for (int j = 0; j < grid.length; j++) {
                sum += grid[j][i];
            }
            cropRight += sum > 0 ? 0 : 1;
            if(sum>0){
                break;
            }
        }




        int[][]croppedGrid = new int[grid.length-cropTop-cropBottom][grid[0].length - cropLeft - cropRight];

        for (int i = 0; i < croppedGrid.length; i++) {
            for (int j = 0; j < croppedGrid[i].length; j++) {
                croppedGrid[i][j] = grid[i+cropTop][j+cropLeft];
            }
        }
        generations--;
        if(generations>0){
            croppedGrid = getGeneration(croppedGrid,generations);
        }
        return croppedGrid;
    }

    public static void main(String[] args) {
        int[][][] gliders = {
                {{1,0,0},
                 {0,1,1},
                 {1,1,0}},
                {{0,1,0},
                 {0,0,1},
                 {1,1,1}}
        };

        int[][] res = getGeneration(gliders[0], 4);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j]+",");
            }
            System.out.println("\b");
        }
    }
}
