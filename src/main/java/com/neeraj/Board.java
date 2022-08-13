package com.neeraj;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
public class Board {

    private static final int defaultSize = 3;
    private static final int maxSize = 26;
    public static final char defaultChar = '_';
    List<List<Character>> arr;

    public Board(){
        this(defaultSize);
    }
    public Board(int size){
        if( size > maxSize )
            throw new Error("size cannot be more than " + maxSize + "!!!");
        initBoard(size);
    }

    private Board initBoard(final int size){
        arr = new ArrayList<>(size);
        for(int i=0 ; i<size ; i++){
            List<Character> l1 = new ArrayList<>(size);
            for(int j=0 ; j<size ; j++)
                l1.add(defaultChar);
            arr.add( l1 );
        }
        return this;
    }

    public void print(){
        System.out.println("Board: ");

        // print column header
        int i=0;
        do{
            System.out.print( "\t" + (i+1) ); i++;
        }while (i < arr.get(0).size());
        System.out.println();

        // printDashLine
        for(i=0 ; i<arr.get(0).size() + 1 ; i++){
            System.out.print("----");
        }

        System.out.println();

        char r = 'A';
        for(List<Character> l : arr){
            System.out.print(r + " | ");
            for(Character c : l) {
                System.out.print(c + "\t");
            }
            r++;
            System.out.println();
        }
    }

    public int getMaxTurns(){
        if( arr == null )
            throw new Error("Something went wrong!!!");
        return arr.size() * arr.size();
    }

    private boolean validateBox(String box){
        if(box.length() != 2 && box.length() != 3){
            System.out.println("ERROR - Please enter right box!!!");
            return false;
        }
        Pair<Integer, Integer> p = getCoordinates(box);
        int row = p.getKey();
        int column = p.getValue();
        if( row < 0 || row > arr.size() || column < 0 || column >= arr.size() ){
            System.out.println("Please enter right box!!!");
            return false;
        }
        return true;
    }

    private Pair<Integer, Integer> getCoordinates(String box){
        int row = box.charAt(0) - 'A';
        int column = Integer.parseInt(box.substring(1)) - 1;
        return new Pair<>(row, column);
    }

    public boolean makeMove(String box, char ch){
        if( !validateBox(box) )
            return false;
        Pair<Integer, Integer> p = getCoordinates(box);
        int row = p.getKey();
        int column = p.getValue();
        if( arr.get(row).get(column) != defaultChar ){
            System.out.println("Please enter right box!!!");
            return false;
        }
        arr.get(row).set(column, ch);
        return true;
    }

    public boolean checkWin(char ch){
        String winningStr = getwinningStr(ch);

        //check all rows
        for(int i=0 ; i<arr.size() ; i++){
            // check ith row
            if( getRow(i).contentEquals(winningStr) )
                return true;
        }

        // check columns
        for(int i=0 ; i<arr.get(0).size() ; i++){
            // check ith row
            if( getColumn(i).contentEquals(winningStr) )
                return true;
        }

        // check diagonals
        if( getDiagonal1().contentEquals(winningStr) )
            return true;
        return getDiagonal2().contentEquals(winningStr);
    }

    private String getRow(int row){
        StringBuilder sb = new StringBuilder();
        for(Character c : arr.get(row)){
            sb.append(c);
        }
        return sb.toString();
    }

    private String getColumn(int col){
        StringBuilder sb = new StringBuilder();
        for (List<Character> characters : arr) {
            sb.append(characters.get(col));
        }
        return sb.toString();
    }

    private String getDiagonal1(){
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while( i < arr.size() ){
            sb.append( arr.get(i).get(i) );
            i++;
        }
        return sb.toString();
    }

    private String getDiagonal2(){
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while( i < arr.size() ){
            sb.append( arr.get(i).get( arr.size() - i - 1 ) );
            i++;
        }
        return sb.toString();
    }

    private String getwinningStr(char ch){
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<arr.size() ; i++){
            sb.append(ch);
        }
        return sb.toString();
    }

}
