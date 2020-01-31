package com.company;

import java.util.Scanner;

public class Human extends Player{
    public Human(String name) {
        super("Human");
    }
    public Human() {
        super("Human");
    }

    public Position getShotCoordinates() {
        System.out.println("Enter x and y coordinates, e.g. 1,3");
        Scanner scanner = new Scanner(System.in);
        String coords = scanner.nextLine();
        String[] coordParts = coords.split(",");

        return new Position(
                Integer.parseInt(coordParts[0]),
                Integer.parseInt(coordParts[1]));
    }

}
