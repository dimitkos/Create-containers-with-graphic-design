package com.java.pamak;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ContainerFrame extends JFrame {

    private JTextField codeField;
    private JTextField destinationField;
    private JTextField weightField;
    private JTextField powerField;
    private JButton createBulk;
    private JButton createRefridgerator;
    private JList shipList;
    private JPanel containerPanel;
    private JPanel centralPanel;
    private ArrayList<Ship> ships;





    public ContainerFrame(ArrayList<Ship> someShips)
    {
        ships= someShips;
        //ftiaxnw ta text
        codeField= new JTextField("code");
        destinationField = new JTextField("destination");
        weightField = new JTextField("weight");
        powerField = new JTextField("power");

        //ftiaxnw ta koumpia
        createBulk = new JButton("Create Bulk");
        createRefridgerator= new JButton("Create Refridgerator");

        shipList= new JList();

        containerPanel= new JPanel();
        //tha ftiaksoume ena deytero panel opou tha valoume to prwto panel kai apo panw thn lista me ta ploia
        centralPanel= new JPanel();


        //tha allaksoume ton vasiko diaxeiristh me ayton edw opou tha exei 3 grammes kai 2 sthles
        GridLayout grid = new GridLayout(3,2);

        containerPanel.setLayout(grid);

        //prosthetw ta text kai ta koumpia

        containerPanel.add(codeField);
        containerPanel.add(destinationField);
        containerPanel.add(weightField);
        containerPanel.add(powerField);
        containerPanel.add(createBulk);
        containerPanel.add(createRefridgerator);


        //einai enas diaxeirisths diatakshs pou mas epitrepei na vazoume panw katw deksia aristera kai kentro
        BorderLayout border = new BorderLayout();
        centralPanel.setLayout(border);

        //vazw thn lista na mpei panw-voreia
        centralPanel.add(shipList,BorderLayout.NORTH);

        //vazoume to panel sto kentro ekei einai ta koumpia kai ta text
        centralPanel.add(containerPanel,BorderLayout.CENTER);


        DefaultListModel model = new DefaultListModel();

        //me ayton ton tropo emfanizontai ta oomata twn ploiwn sthl lista ths grafikhs diasyndeshs
        for (Ship ship:ships) {
            model.addElement(ship.getName());

        }

        //syndesh tou montelou me to grafiko
        shipList.setModel(model);



        //prosarmozoume to kentriko panel sthn othonh
        this.setContentPane(centralPanel);


        ButtonListener listener = new ButtonListener();
        createBulk.addActionListener(listener);
        createRefridgerator.addActionListener(listener);

        //kanw orato to parathyro
        this.setVisible(true);
        //dinw diastaseis sto megethos
        this.setSize(400,400);
        //dinw titlo sto parathyro
        this.setTitle("Charge Clculator");
        //otan patame to x na klinie to programma
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    class  ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String code = codeField.getText();
            String destination = destinationField.getText();

            //epeidh epistrefei object kai thelw string tha kanw casting
            String selectedShipName =(String) shipList.getSelectedValue();

            Ship selectedShip=null;

            for (Ship ship:ships) {
                if(ship.getName().equals(selectedShipName))
                {
                    selectedShip=ship;
                }

            }

            //elegxoume pio koumpi patithike
            if(e.getSource()== createBulk)
            {
                String weightText= weightField.getText();
                int weight = Integer.parseInt(weightText);
                Bulk newContainer = new Bulk(code,destination, weight) ;
                //kataxwroume to container sto ploio
                selectedShip.addContainer(newContainer);
            }
            else
            {
                String poewrText = powerField.getText();
                double power = Double.parseDouble(poewrText);

                Refridgerator newContainer= new Refridgerator(code,destination,power);
                selectedShip.addContainer(newContainer);
            }

            System.out.println("Selected Ship Charged : "+ selectedShip.getTotalCharge());


        }
    }

}
