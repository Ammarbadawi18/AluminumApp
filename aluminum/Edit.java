package com.example.aluminum;



public class Edit {
    private String Name;
    private int  Quantity;


    public  Edit( String Name ,int Quantity){
        this.Name=Name;
        this.Quantity=Quantity;

    }

    @Override
    public String toString() {
        return "Found in " + Name + " with quantity of " +Quantity
                ;
    }
}
