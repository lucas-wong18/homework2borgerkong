package com.example.homework2borgerkong;

public class MenuItem {

    private int itemID;
    private String name;
    private String blurb;
    private double cost;
    private int imageID;


    public MenuItem(int itemID, String name, String blurb, double cost, int imageID){

        this.itemID = itemID;
        this.name = name;
        this.blurb = blurb;
        this.cost = cost;
        this.imageID = imageID;
    }



    public int getItemID(){
        return itemID;
    }

    public void setItemID(int itemID){
        this.itemID = itemID;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getBlurb(){
        return blurb;
    }

    public void setBlurb(String blurb){
        this.blurb = blurb;
    }

    public double getCost(){
        return cost;
    }

    public void setCost(double cost){
        this.cost = cost;
    }

    public int getImageID(){
        return imageID;
    }

    public void setImageID(int imageID){
        this.imageID = imageID;
    }


}
