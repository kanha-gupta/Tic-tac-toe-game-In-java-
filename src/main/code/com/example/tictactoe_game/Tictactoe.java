package com.example.tictactoe_game;

import java.util.Random;
import java.util.Scanner;
//this is a experiment
//this is for checking push feature
public class Tictactoe {
    static void printboard(char[][] chart){
        System.out.println(chart[0][0] + "|" + chart[0][1]+ "|"+ chart[0][2]);
        System.out.println(chart[1][0] + "|" + chart[1][1]+ "|"+ chart[1][2]);
        System.out.println(chart[2][0] + "|" + chart[2][1]+ "|"+ chart[2][2]);
    }

    static char placemove(char [][] chart, int position, char symbol){
        switch (position){
            case 1:
                return (chart[0][0] = symbol);
            case 2:
                return(chart[0][1] = symbol);
            case 3:
                return( chart[0][2] = symbol);
            case 4:
                return( chart[1][0] = symbol);
            case 5:
                return( chart[1][1] = symbol);
            case 6:
                return( chart[1][2] = symbol);
            case 7:
                return( chart[2][0] = symbol);
            case 8:
                return( chart[2][1] = symbol);
            case 9:
                return( chart[2][2] = symbol);
            default:
                return 'a';
        }
        //return symbol;
    }

    static boolean winconditions(char [][] chart,char symbol) {
        if ((chart[0][0] == symbol && chart[0][1] == symbol && chart[0][2] == symbol) ||
                (chart[1][0] == symbol && chart[1][1] == symbol && chart[1][2] == symbol) ||
                (chart[2][0] == symbol && chart[2][1] == symbol && chart[2][2] == symbol) ||

                (chart[0][0] == symbol && chart[1][0] == symbol && chart[2][0] == symbol) ||
                (chart[0][1] == symbol && chart[1][1] == symbol && chart[2][1] == symbol) ||
                (chart[0][2] == symbol && chart[1][2] == symbol && chart[2][2] == symbol) ||

                (chart[0][0] == symbol && chart[1][1] == symbol && chart[2][2] == symbol) ||
                (chart[0][2] == symbol && chart[1][1] == symbol && chart[2][0] == symbol)) {
            return true;
        }
        return false;
    }
    static boolean validmove(char [][] chart,int position){
        switch (position){
            case 1:
                return (chart[0][0] == ' ');
            case 2:
                return (chart[0][1] == ' ');
            case 3:
                return (chart[0][2] == ' ');
            case 4:
                return (chart[1][0] == ' ');
            case 5:
                return (chart[1][1] == ' ');
            case 6:
                return (chart[1][2] == ' ');
            case 7:
                return (chart[2][0] == ' ');
            case 8:
                return (chart[2][1] == ' ');
            case 9:
                return (chart[2][2] == ' ');
            default:
                return false;
        }
    }
    static void computerTurn(char[][] board) {
        Random rand = new Random();
        int computerMove;
        while (true) {
            computerMove = rand.nextInt(9) + 1;
            if (validmove(board,computerMove)) {
                break;
            }
        }
        System.out.println("Computer chose " + computerMove);
        placemove(board, computerMove, 'O');
    }


    public static void main(String[] args) {
        System.out.println("Welcome to Tic tac toe game");
        Scanner sc=new Scanner(System.in);
        char[][]  chart1= {
                {' ',' ',' '},
                {' ', ' ',' '},
                {' ',' ',' '}
        };
        while (!winconditions(chart1,'X')){
            printboard(chart1);
            System.out.println("Your turn type 1-9 for moves");
            placemove(chart1,sc.nextInt(),'X');
            printboard(chart1);
            computerTurn(chart1);

    }
        if (winconditions(chart1,'X')){
            System.out.println("congratulations Player has won");
        }
        else {
            System.out.println("player has lost");
        }
    }
}
