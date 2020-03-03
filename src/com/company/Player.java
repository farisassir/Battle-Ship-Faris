package com.company;

import java.util.Random;

public abstract class Player {

    protected Map map;
    private String name;

    public Player(String name) {
        this.name = name;
        map = new Map();
    }

    public abstract Position getShotCoordinates();

    public void placeShips() {
        Random rand = new Random();
        int[] shipSizes = {3, 4};
        Position startPos;

        for (int size : shipSizes) {

            do {
                int x = rand.nextInt(Map.GRID_SIZE - size + 1);
                int y = rand.nextInt(Map.GRID_SIZE);
                startPos = new Position(x, y);
            } while (map.addShip(startPos, size) == false);

        }
    }


    public void renderMap() {
        System.out.println(name + " map:");
        map.render();
    }

    public void shootAt(Position pos) {
        map.shootAt(pos);
    }

    public boolean hasFloatingShips() {
        return map.hasFloatingShips();
    }

}
