package com.example.aluminum;


public class Orders {
    private int CID;
    private int OID;
    private String Date;
    private int Price;
    private String Type;
    private String Design;
    private String Color;


    public  Orders(int CID, int OID, String Date,int Price,String Type,String Design,String Color){
        this.CID=CID;
        this.OID=OID;
        this.Date=Date;
        this.Price=Price;
        this.Type=Type;
        this.Design=Design;
        this.Color=Color;
    }

    @Override
    public String toString() {
        return "** Customer ID: " + CID +"\n"+
                " Order ID: " + OID +"\n"+
                " Date: " + Date + "\n"+
                " Price : $" +Price+ "\n"+
                " Type: " + Type + " \n" +
                " Design: " + Design + " \n"+
                " Color: "   +Color ;

    }
}