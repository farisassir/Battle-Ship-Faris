package com.company;

import java.util.ArrayList;

public class Map {

    private enum SquareState {
        NONE,
        MISS,
        HIT,
    }

    public final static int GRID_SIZE = 5;

    private ArrayList<Ship> ships = new ArrayList<>();

    SquareState[][] grid = new SquareState[GRID_SIZE][GRID_SIZE];

    public Map() {

        for (int y = 0; y < GRID_SIZE; y++) {
            for (int x = 0; x < GRID_SIZE; x++) {
                grid[y][x] = SquareState.NONE;
            }
        }

    }


    private String getSymbol(SquareState squareState) {
        switch (squareState) {
            case HIT:
                return "[*]";
            case MISS:
                return "[x]";
            default:
                return "[ ]";
        }
    }

    private boolean isAnyShipHit(Position pos) {
        for (Ship ship : ships) {
            if (ship.hasPosition(pos))
                return true;
        }
        return false;
    }

    //Draw the map on the screen
    public void render() {
        String xValues = " ";
        for (int i = 0; i < GRID_SIZE; i++) {
            xValues += " " + i + " ";
        }
        System.out.println(xValues + " = x");

        for (int y = 0; y < GRID_SIZE; y++) {
            String row = "" + y;
            for (int x = 0; x < GRID_SIZE; x++) {
                if (false && !ships.isEmpty() &&
                        isAnyShipHit(new Position(x, y))) {
                    row += "[B]";
                } else {
                    row += getSymbol(grid[y][x]);
                }
            }
            System.out.println(row);
        }
    }

    public boolean addShip(Position pos, int size) {
        Position[] positions = Ship.getPositions(size, pos);
        for (Position shipPosition : positions) {
            for (Ship alreadyAddedShip : ships) {
                if (alreadyAddedShip.hasPosition(shipPosition)) {
                    return false;
                }
            }
        }
        ships.add(new Ship(size, pos));
        return true;
    }

    public void shootAt(Position pos) {
        if (grid[pos.y][pos.x] == SquareState.NONE) {
            for (Ship ship : ships) {
                if (ship.hasPosition(pos)) {
                    ship.addHit();
                    grid[pos.y][pos.x] = SquareState.HIT;
                    System.out.println("You HIT!");
                    break;
                }
            }

            if (grid[pos.y][pos.x] != SquareState.HIT) {
                grid[pos.y][pos.x] = SquareState.MISS;
                System.out.println("You missed!");
            }
        } else {
            System.out.println("You have already shot at this square!!");
        }
    }

    public boolean hasFloatingShips() {
        for (Ship ship : ships) {
            if (ship.isFloating())
                return true;
        }
        return false;
    }

}
