package com.example.aluminum;

public class Customer
{
    private String Name ;

    public Customer( String Name) {
        this.Name = Name;
    }


    public String getName() {
        return Name;
    }

    @Override
    public String toString() {
        return  Name ;
    }
}
