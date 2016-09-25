package com.ccsi;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	    char[][] board={{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(isValidSudoku1(board));
    }
    //Determine if a Sudoku is valid.
    //The Sudoku board could be partially filled, where empty cells are filled with the character '.'
    //1.利用set来做，容易理解。
    public static boolean isValidSudoku(char[][] board){
        if(board==null||board.length!=9||board[0].length!=9)return false;
        int len=board.length;

        for (int row = 0; row < len; row++) {
            Set<Character> rowSet=new HashSet<>();
            for (int col = 0; col < len; col++) {
                if(board[row][col]!='.'){
                    if(board[row][col]<'0'||board[row][col]>'9')return false;    //要判断是否是0~9的数
                    if(!rowSet.add(board[row][col])){
                        return false;
                    }
                }
            }
        }

        for (int col = 0; col < len; col++) {
            Set<Character> colSet=new HashSet<>();
            for (int row = 0; row < len; row++) {
                if(board[row][col]!='.'){
                    if(board[row][col]<'0'||board[row][col]>'9')return false;
                    if(!colSet.add(board[row][col])){
                        return false;
                    }
                }
            }
        }

        for (int i = 0; i < len; i+=3) {
            for (int j = 0; j < len; j+=3) {
                Set<Character> subBoard=new HashSet<>();
                for (int row = i; row <i+3 ; row++) {
                    for (int col = j; col < j+3; col++) {
                        if(board[row][col]!='.'){
                            if(board[row][col]<'0'||board[row][col]>'9')return false;
                            if(!subBoard.add(board[row][col]))return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    //2.利用数组来做
    public static boolean isValidSudoku1(char[][] board){
        if(board==null||board.length!=9||board[0].length!=9)return false;
        int len=board.length;

        for (int row = 0; row < 9; row++) {
            int[] arr=new int[10];
            for (int col = 0; col < 9; col++) {
                if(board[row][col]=='.')continue;
                if(board[row][col]<'0'||board[row][col]>'9')return false;
                else{
                    int num=board[row][col]-'0';
                    if(arr[num]==1)return false;
                    arr[num]=1;
                }
            }
        }
        for (int col = 0; col < 9; col++) {
            int[] arr=new int[10];
            for (int row = 0; row < 9; row++) {
                if(board[row][col]=='.')continue;
                if(board[row][col]<'0'||board[row][col]>'9')return false;
                else{
                    int num=board[row][col]-'0';
                    if(arr[num]==1)return false;
                    arr[num]=1;
                }
            }
        }
        for (int i = 0; i < 9; i+=3) {
            for (int j = 0; j < 9; j+=3) {
                int[] arr=new int[10];
                for (int row = i; row < i+3; row++) {
                    for (int col = j; col < j+3; col++) {
                        if(board[row][col]=='.')continue;
                        if(board[row][col]<'0'||board[row][col]>'9')return false;
                        else{
                            int num=board[row][col]-'0';
                            if(arr[num]==1)return false;
                            arr[num]=1;
                        }
                    }
                }
            }
        }
        return true;
    }
}
