package com.tondeuse;

import com.tondeuse.enumerations.CardinalDirections;

import java.util.List;

public class Direction {
    private CardinalDirections direction;
    private Direction left;
    private Direction right;

    public Direction() {
    }

    public Direction(CardinalDirections direction) {
        this.direction = direction;
    }

    public Direction(CardinalDirections direction, Direction left, Direction right) {
        this.direction = direction;
        this.left = left;
        this.right = right;
    }

    public CardinalDirections getDirection() {
        return this.direction;
    }

    public Direction getLeft() {
        return this.left;
    }

    public Direction getRight() {
        return this.right;
    }

    public static final List<Direction> ALL_DIRECTIONS = List.of(new Direction[]{
            new Direction(CardinalDirections.N, new Direction(CardinalDirections.W), new Direction(CardinalDirections.E)),
            new Direction(CardinalDirections.E, new Direction(CardinalDirections.N), new Direction(CardinalDirections.S)),
            new Direction(CardinalDirections.S, new Direction(CardinalDirections.E), new Direction(CardinalDirections.W)),
            new Direction(CardinalDirections.W, new Direction(CardinalDirections.S), new Direction(CardinalDirections.N)),
    });
}
