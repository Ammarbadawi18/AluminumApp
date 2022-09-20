package com.example.aluminum;

public class Pay {
    private String spname;
    private int TID;
    private String Paymentmethod;
    private String  Date;

    public  Pay(String spname, int TID, String Paymentmethod, String Date){
        this.spname=spname;
        this.TID=TID;
        this.Paymentmethod=Paymentmethod;
        this.Date=Date;
    }

    @Override
    public String toString() {
        return "** Customer name: " + spname +"\n"+
                "Payment method: " + Paymentmethod  + "\n"+
                "Date: " + Date
                ;
    }
}
