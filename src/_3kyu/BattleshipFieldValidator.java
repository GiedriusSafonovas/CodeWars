package _3kyu;

//Write a method that takes a field for well-known board game "Battleship" as an argument and returns true if it has a valid disposition of ships, false otherwise. Argument is guaranteed to be 10*10 two-dimension array. Elements in the array are numbers, 0 if the cell is free and 1 if occupied by ship.
//
//        Battleship (also Battleships or Sea Battle) is a guessing game for two players. Each player has a 10x10 grid containing several "ships" and objective is to destroy enemy's forces by targetting individual cells on his field. The ship occupies one or more cells in the grid. Size and number of ships may differ from version to version. In this kata we will use Soviet/Russian version of the game.
//
//        Before the game begins, players set up the board and place the ships accordingly to the following rules:
//
//        There must be single battleship (size of 4 cells), 2 cruisers (size 3), 3 destroyers (size 2) and 4 submarines (size 1). Any additional ships are not allowed, as well as missing ships.
//        Each ship must be a straight line, except for submarines, which are just single cell.
//        The ship cannot overlap or be in contact with any other ship, neither by edge nor by corner.
//
//        This is all you need to solve this kata.

public class BattleshipFieldValidator {
    public static boolean fieldValidator(int[][] field) {

        int battleships = 0;
        int cruisers = 0;
        int destroyers = 0;
        int submarines = 0;
        int[][] expandedField = new int[12][12];
        boolean[][] checkedFields = new boolean[12][12];

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                expandedField[i+1][j+1] = field[i][j];
            }
        }

        for (int i = 0; i < expandedField.length; i++) {
            for (int j = 0; j < expandedField[i].length; j++) {
                System.out.print(expandedField[i][j] + ", ");
            }
            System.out.println();
        }

        for (int i = 0; i < expandedField.length; i++) {
            for (int j = 0; j < expandedField[i].length; j++) {
                if(!checkedFields[i][j]){
                    if(expandedField[i][j] == 1){
                        int shipLength = 0;
                        if(expandedField[i][j+1] == 1) {
                            if(j != 0){
                                if(expandedField[i+1][j-1] == 1){
                                    return false;
                                }
                            }
                            for (int k = j; k < expandedField[i].length; k++) {
                                if (expandedField[i][k] == 1) {
                                    if(expandedField[i+1][k] == 1) return false;
                                    checkedFields[i][k] = true;
                                    shipLength++;
                                } else {
                                    if(expandedField[i+1][k] == 1) return false;
                                    checkedFields[i][k] = true;
                                    break;
                                }
                            }
                        }else if(expandedField[i+1][j] == 1){
                            if(i != 0){
                                if(expandedField[i-1][j+1] == 1){
                                    return false;
                                }
                            }
                            for (int k = i; k < expandedField.length; k++) {
                                if(expandedField[k][j] ==1){
                                    if(expandedField[k][j+1] == 1) return false;
                                    checkedFields[k][j] = true;
                                    shipLength++;
                                }else {
                                    if(expandedField[k][j+1] == 1) return false;
                                    checkedFields[k][j] = true;
                                    break;
                                }
                            }
                        }else {
                            if(i != 0 && j !=9){
                                if(expandedField[i-1][j+1] == 1) return false;
                            }
                            if(i != 9 && j != 0){
                                if(expandedField[i+1][j-1] == 1) return false;
                            }
                            if(i != 9 && j != 9) {
                                if (expandedField[i + 1][j + 1] == 1) return false;
                            }
                            shipLength++;
                            checkedFields[i][j] = true;
                        }

                        switch (shipLength){
                            case 1:
                                submarines++;
                                break;
                            case 2:
                                destroyers++;
                                break;
                            case 3:
                                cruisers++;
                                break;
                            case 4:
                                battleships++;
                                break;
                            default:
                                return false;
                        }
                    }else {
                        checkedFields[i][j] = true;
                    }
                }
            }
        }

        System.out.println("Battleships: " + battleships);
        System.out.println("cruisers: " + cruisers);
        System.out.println("destroyers: " + destroyers);
        System.out.println("submarines: " + submarines);

        if(battleships == 1 && cruisers == 2 && destroyers == 3 && submarines == 4){
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
//        System.out.println(fieldValidator(new int[][]{
//                {1, 0, 0, 0, 0, 1, 1, 0, 0, 0},
//                {1, 0, 1, 0, 0, 0, 0, 0, 1, 0},
//                {1, 0, 1, 0, 1, 1, 1, 0, 1, 0},
//                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
//                {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
//                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}}));

//        System.out.println(fieldValidator(new int[][]{
//                {1, 0, 0, 0, 0, 1, 1, 0, 0, 1},
//                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
//                {1, 0, 1, 0, 1, 1, 1, 0, 1, 0},
//                {1, 0, 0, 0, 0, 0, 0, 0, 1, 0},
//                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {1, 0, 0, 0, 1, 1, 1, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1}}));

        System.out.println(fieldValidator(new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 1, 1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}}));
    }
}
