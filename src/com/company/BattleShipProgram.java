package com.company;

public class BattleShipProgram {
    Computer computer = new Computer();
    Human human = new Human();


    public BattleShipProgram() {
        computer.placeShips();
        human.placeShips();
    }

    public void start() {
        System.out.println("");
        System.out.println("");
        System.out.println("                ..:Battle Ships:.. ");
        System.out.println("            Start by placing your ship ");
        System.out.println("");


        do {
            Position shotCoords = human.getShotCoordinates();
            computer.shootAt(shotCoords);
            computer.renderMap();

            shotCoords = computer.getShotCoordinates();
            human.shootAt(shotCoords);
            human.renderMap();

        } while (computer.hasFloatingShips() && human.hasFloatingShips());

        if (human.hasFloatingShips()) {
            System.out.println("You have won the game!");
        } else {
            System.out.println("You lost the game!");
        }

    }
}

