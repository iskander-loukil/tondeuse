package com.tondeuse;

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

}
