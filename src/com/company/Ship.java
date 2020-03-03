package com.company;

public class Ship {

    private Position[] positions;
    private int size;
    private int hits = 0;

    public Ship(int size, Position startPos) {
        this.size = size;
        positions = getPositions(size, startPos);
    }

    public static Position[] getPositions(int size, Position startPos) {
        Position[] calculatedPositions = new Position[size];
        calculatedPositions[0] = startPos;

        for (int i = 1; i < size; i++) {
            calculatedPositions[i] = new Position(startPos.x + i, startPos.y);
        }
        return calculatedPositions;
    }

    public boolean isFloating() {
        if (hits < size)
            return true;
        return false;
    }

    public boolean hasPosition(Position pos) {
        for (Position myPos : positions) {
            if (myPos.x == pos.x && myPos.y == pos.y) {
                return true;
            }
        }
        return false;
    }

    public void addHit() {
        hits++;
    }
}
