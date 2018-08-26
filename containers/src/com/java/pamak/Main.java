package com.java.pamak;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        Ship ship1= new Ship(450,"Hercules");
        Ship ship2= new Ship(900,"Hefestos");
        Ship ship3= new Ship(300,"Hermes");
        Ship ship4= new Ship(600,"Zeus");


        //ftiaxnw mia arrayylist opoy vazw ola ta ploia poy exw ftiaksei
        ArrayList<Ship> ships = new ArrayList<Ship>();

        ships.add(ship1);
        ships.add(ship2);
        ships.add(ship3);
        ships.add(ship4);


        // thn arraylist thn pernaw ston kataskeyasth etsi wste h class containerframe na gnwrizei ta ploia
        ContainerFrame cf = new ContainerFrame(ships);




    }
}
