package com.puzzle.model;

public enum Direction {
    N("North"){
        @Override
        public Direction turnLeft() {
            return Direction.W;
        }

        @Override
        public Direction turnRight() {
            return Direction.E;
        }
    },
    S("South") {
        @Override
        public Direction turnRight() {
            return Direction.W;
        }

        @Override
        public Direction turnLeft() {
            return Direction.E;
        }
    },

    W("West") {
        @Override
        public Direction turnLeft() {
            return Direction.S;
        }

        @Override
        public Direction turnRight() {
            return Direction.N;
        }
    },

    E("East") {
        @Override
        public Direction turnLeft() {
            return Direction.N;
        }

        @Override
        public Direction turnRight() {
            return Direction.S;
        }
    };


    private String direction;

    Direction(String direction) {
        this.direction = direction;
    }

    public abstract Direction turnLeft();


    public abstract Direction turnRight();
}
