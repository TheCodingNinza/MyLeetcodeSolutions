import javafx.util.Pair;

import java.util.*;

public class SudokuSolver {

    private static Map<Pair,Integer> boxMapping;
    private static final int baseValue = 10;
    private static char[][] ansBoard;

    private static boolean ansFound;
    public static void solveSudoku(char[][] board) {
        boolean[][] row = new boolean[10][10];
        boolean[][] column = new boolean[10][10];
        boolean[][] box = new boolean[10][10];
        ansBoard = new char[9][9];
        boxMapping = new HashMap<>();
        ansFound = false;
        for (int i = 1; i <= 9 ; i++) {
            for (int j = 1; j <= 9; j++) {
                if(i == 1 || i == 2 || i == 3){
                    if(j == 1 || j == 2 || j == 3){
                        boxMapping.put(new Pair<>(i,j),1);
                    } else if (j == 4 || j == 5 || j == 6) {
                        boxMapping.put(new Pair<>(i,j),2);
                    }else{
                        boxMapping.put(new Pair<>(i,j),3);
                    }
                }else if (i == 4 || i == 5 || i == 6) {
                    if(j == 1 || j == 2 || j == 3){
                        boxMapping.put(new Pair<>(i,j),4);
                    } else if (j == 4 || j == 5 || j == 6) {
                        boxMapping.put(new Pair<>(i,j),5);
                    }else{
                        boxMapping.put(new Pair<>(i,j),6);
                    }
                }else{
                    if(j == 1 || j == 2 || j == 3){
                        boxMapping.put(new Pair<>(i,j),7);
                    } else if (j == 4 || j == 5 || j == 6) {
                        boxMapping.put(new Pair<>(i,j),8);
                    }else{
                        boxMapping.put(new Pair<>(i,j),9);
                    }
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] != '.'){
                   row[i+1][board[i][j] - '0'] = true;
                   column[j+1][board[i][j] - '0'] = true;
                   box[boxMapping.get(new Pair<>(i+1,j+1))][board[i][j] - '0'] = true;
                }
            }
        }

        recursiveAnalysis(board,row,column,box,0,0);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = ansBoard[i][j];
            }
        }
        return;
    }

    private static void recursiveAnalysis(char[][] board,boolean[][] row,boolean[][] column,boolean[][] box, int rowValue, int columnValue) {
        if(ansFound)
            return;
        if(rowValue == 9){
            int count = 0;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if(board[i][j] == '.')
                        count++;
                }
            }
            if(count == 0){
                ansFound = true;
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        ansBoard[i][j] = board[i][j];
                    }
                }
            }
            return;
        }
        int flag = 0;
        for (int i = 1; i <= 9; i++) {
          if(board[rowValue][columnValue] == '.'){
              if(row[rowValue+1][i] == false && column[columnValue+1][i] == false && box[boxMapping.get(new Pair(rowValue+1,columnValue+1))][i] == false){
                  board[rowValue][columnValue] = Character.forDigit(i,baseValue);
                  row[rowValue+1][i] = true;
                  column[columnValue+1][i] = true;
                  box[boxMapping.get(new Pair(rowValue+1,columnValue+1))][i] = true;
                  if(columnValue < 8 ){
                      recursiveAnalysis(board,row,column,box,rowValue,columnValue+1);
                  }else{
                      recursiveAnalysis(board,row,column,box,rowValue+1,0);
                  }
                  board[rowValue][columnValue] = '.';
                  row[rowValue+1][i] = false;
                  column[columnValue+1][i] = false;
                  box[boxMapping.get(new Pair(rowValue+1,columnValue+1))][i] = false;
              }
          }else{
              flag = 1;
              break;
          }
        }
        if(flag == 1){
            if(columnValue < 8 ){
                recursiveAnalysis(board,row,column,box,rowValue,columnValue+1);
            }else{
                recursiveAnalysis(board,row,column,box,rowValue+1,0);
            }
        }
        return;
    }




    public static void main(String[] args) {

        char[][] board =  {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        solveSudoku(board);
        System.out.println(ansFound);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j]+"\t");
            }
            System.out.println("");
        }
    }
}
