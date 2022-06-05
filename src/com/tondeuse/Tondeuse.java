package com.tondeuse;

import com.tondeuse.enumerations.Instruction;

public class Tondeuse {
    //abscisse maximale de la surface
    public static int xmax;

    //ordonnée maximale de la surface
    public static int ymax;

    //position courante de la tondeuse
    private int x;
    private int y;
    private Direction direction;

    public Tondeuse (int x , int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public String move(String instructions) {
        char[] instructionsChars = instructions.toCharArray();

        for (char i: instructionsChars) {
            if ('G' == i)
                this.turnLeft();
            if('D' == i)
                this.turnRight();
            if('A' == i)
                this.advance();
        }

        return x + " " + y + " " + direction.getDirection();
    }

    private void turnLeft(){
        Direction direction = getDirectionWithDetails();
        this.direction =  Direction.ALL_DIRECTIONS
                .stream()
                .filter(d-> d.getDirection() == direction.getLeft().getDirection())
                .findAny().get();
    }

    private void turnRight(){
        Direction direction = getDirectionWithDetails();
        this.direction =  Direction.ALL_DIRECTIONS
                .stream()
                .filter(d-> d.getDirection() == direction.getRight().getDirection())
                .findAny().get();
    }

    private Direction getDirectionWithDetails() {
        return Direction.ALL_DIRECTIONS
                .stream()
                .filter(d -> d.getDirection() == this.direction.getDirection())
                .findAny()
                .orElse(null);
    }

    private void advance() {
        switch (this.direction.getDirection()) {
            case E:
                if (x < xmax)
                    x++;
                break;
            case W:
                if (x > 0)
                    x--;
                break;
            case N:
                if (y < ymax)
                    y++;
                break;
            case S:
                if (y > 0)
                    y--;
                break;
            default:
                break;
        }
    }


    @Override
    public String toString() {
        return "Tondeuse{" +
                "x=" + x +
                ", y=" + y +
                ", direction=" + direction +
                '}';
    }
}
