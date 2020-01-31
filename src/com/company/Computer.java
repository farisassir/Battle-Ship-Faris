package com.company;

import java.util.Random;

public class Computer extends Player {
    public Computer() {
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
