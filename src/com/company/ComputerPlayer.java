package com.company;

import java.util.Random;

public class ComputerPlayer extends Player {

    public ComputerPlayer() {
        super("Computer");
    }

    public Position getShotCoordinates() {
        Random rand = new Random();
        Position position = new Position(
                rand.nextInt(Map.GRID_SIZE),
                rand.nextInt(Map.GRID_SIZE));
        System.out.printf("Computer shoots at: (%d,%d) \n",
                position.x, position.y);
        return position;
    }

}
