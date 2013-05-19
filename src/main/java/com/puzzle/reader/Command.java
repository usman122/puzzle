package com.puzzle.reader;

public enum Command {

    L("Left"),
    R("Right"),
    M("Move straight");
    private String command;

    Command(String command) {
        this.command = command;
    }
}
