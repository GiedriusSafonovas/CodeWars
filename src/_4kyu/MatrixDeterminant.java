package _4kyu;

//Write a function that accepts a square matrix (N x N 2D array) and returns the determinant of the matrix.
//
//        How to take the determinant of a matrix -- it is simplest to start with the smallest cases:
//
//        A 1x1 matrix |a| has determinant a.
//
//        A 2x2 matrix [ [a, b], [c, d] ] or
//
//        |a  b|
//        |c  d|
//
//        has determinant: a*d - b*c.
//
//        The determinant of an n x n sized matrix is calculated by reducing the problem to the calculation of the determinants of n matrices ofn-1 x n-1 size.
//
//        For the 3x3 case, [ [a, b, c], [d, e, f], [g, h, i] ] or
//
//        |a b c|
//        |d e f|
//        |g h i|
//
//        the determinant is: a * det(a_minor) - b * det(b_minor) + c * det(c_minor) where det(a_minor) refers to taking the determinant of the 2x2 matrix created by crossing out the row and column in which the element a occurs:
//
//        |- - -|
//        |- e f|
//        |- h i|
//
//        Note the alternation of signs.
//
//        The determinant of larger matrices are calculated analogously, e.g. if M is a 4x4 matrix with first row [a, b, c, d], then:
//
//        det(M) = a * det(a_minor) - b * det(b_minor) + c * det(c_minor) - d * det(d_minor)


import java.util.ArrayList;
import java.util.List;

public class MatrixDeterminant {
    public static int determinant(int[][] matrix) {
        int result = 0;
        if(matrix.length == 1 ) return matrix[0][0];
        if(matrix.length == 2){
            return matrix[0][0]*matrix[1][1]-matrix[0][1]*matrix[1][0];
        }

        for (int i = 0; i < matrix.length; i++) {
            int[][] subMatrix = new int[matrix.length-1][matrix.length-1];
            for (int j = 1; j < matrix.length; j++) {
                for (int k = 0; k < matrix[j].length; k++) {
                    if(k == i) continue;
                    subMatrix[j-1][k+(k>i?-1:0)] = matrix[j][k];
                }
            }
            result += (i%2==0?1:-1)*matrix[0][i]*determinant(subMatrix);
        }

        return result;
    }

//    public static int [][] getSubMatrix(int [][] matrix){
//        int[][] subMatrix = matrix;
//        while subMatrix
//        return null;
//    }

    public static void main(String[] args) {
//        System.out.println(determinant(new int[][]{{1}})); //1
//        System.out.println(determinant(new int[][]{{1, 3}, {2,5}})); //-1
        System.out.println(determinant(new int[][]{{2,5,3}, {1,-2,-1}, {1, 3, 4}})); //-20
    }
}


