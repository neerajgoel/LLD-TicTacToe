package com.neeraj;

public class Player {

    private String name;
    private char ch;

    private Player(){
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void setCh(char ch) {
        if(ch == Board.defaultChar){
            throw new Error("com.neeraj.Player cannot use \"" + Board.defaultChar + "\" character!!");
        }
        this.ch = ch;
    }

    public char getCh() {
        return ch;
    }

    public static class PlayerBuilder{

        Player player ;

        public PlayerBuilder(){
            player = new Player();
        }

        public PlayerBuilder setName(String name){
            player.setName(name);
            return this;
        }

        public PlayerBuilder setCh(char ch){
            player.setCh(ch);
            return this;
        }

        public Player build(){
            return player;
        }
    }

}
