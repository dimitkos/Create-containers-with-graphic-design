package com.java.pamak;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChargeCalculator extends JFrame {

    private JButton calculateChargeButton;
    private JPanel panel;
    private Ship ship;

    public ChargeCalculator(Ship aship)
    {
        //etsi loipon h otnnh tha gnwrizei thn dieythinsh tou ploioy
        ship=aship;
        //dhmioyrgoume to panel
        panel= new JPanel();

        //dhmioyrgia tou koumpiou
        calculateChargeButton= new JButton("Calculate Charge");

        //topothetw to koumpi panw sto panel
        panel.add(calculateChargeButton);

        //topothetw to panel panw sto jframe
        this.setContentPane(panel);


        ButtonListener listener= new ButtonListener();

        calculateChargeButton.addActionListener(listener);

        //kanw orato to parathyro
        this.setVisible(true);
        //dinw diastaseis sto megethos
        this.setSize(400,400);
        //dinw titlo sto parathyro
        this.setTitle("Charge Clculator");
        //otan patame to x na klinie to programma
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Total Charge "+ ship.getTotalCharge());
        }
    }
}
