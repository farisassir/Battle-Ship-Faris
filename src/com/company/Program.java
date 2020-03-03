package com.company;

public class Program {

    ComputerPlayer computerPlayer = new ComputerPlayer();
    HumanPlayer humanPlayer = new HumanPlayer();


    public Program() {
        computerPlayer.placeShips();
        humanPlayer.placeShips();
    }

    public void start() {
        System.out.println("");
        System.out.println("");
        System.out.println("                ..:Battle Ships:.. ");
        System.out.println("- Place your ship in a new position (horizontal/vertical) ");
        System.out.println("             to hide/shoot your enemy.. ");
        System.out.println("");
        computerPlayer.renderMap();
        humanPlayer.renderMap();

        do {
            Position shotCoords = humanPlayer.getShotCoordinates();
            computerPlayer.shootAt(shotCoords);
            computerPlayer.renderMap();

            shotCoords = computerPlayer.getShotCoordinates();
            humanPlayer.shootAt(shotCoords);
            humanPlayer.renderMap();

        } while (computerPlayer.hasFloatingShips() && humanPlayer.hasFloatingShips());

        if (humanPlayer.hasFloatingShips()) {
            System.out.println("You have won the game!");
        } else {
            System.out.println("You lost the game!");
        }

    }

}
