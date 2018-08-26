package com.java.pamak;

import java.util.ArrayList;

public class Ship {

    //ftiaxnw ayth thn domh dedomenwn giati ena ploio perixei containers
    //vazw typou container gia na vazw mesa eite bulk eite refidgerator
    private ArrayList<Container> containers= new ArrayList<Container>();
    private int capacity;
    private String name;

    public Ship(int capacity,String name)
    {
        this.capacity=capacity;
        this.name= name;
    }

    public void addContainer(Container aContainer)
    {
        if(containers.size()<capacity)
        {
            containers.add(aContainer);
        }
        else
        {
            System.out.println("The ship is full");
        }
    }

    public  double getTotalCharge()
    {
        double totalCharge=0;
        for (Container container:containers) {

            totalCharge += container.getCharge();

        }
        return  totalCharge;
    }

    public String getName() {
        return name;
    }
}
