package mamadaliev.sevice.deprecated.impl;

import mamadaliev.model.Cell;
import mamadaliev.sevice.deprecated.Game;
import mamadaliev.sevice.deprecated.Life;
import mamadaliev.sevice.deprecated.Transfer;

import java.io.File;
import java.io.IOException;

public class GameOfLife implements Game, Life, Transfer {

    @Override
    public void start() {

    }

    @Override
    public void update() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void delay(int milliseconds) throws InterruptedException {

    }

    @Override
    public void reset() {

    }

    @Override
    public void clear() {

    }

    @Override
    public void display() {

    }

    @Override
    public void fill() {

    }

    @Override
    public void fill(Cell[][] cells) {

    }

    @Override
    public void generate(double percent) {

    }

    @Override
    public int getNeighborsCount(int x, int y) {
        return 0;
    }

    @Override
    public void generateNextEpoch() {

    }

    @Override
    public Cell[][][] read(File file) throws IOException {
        return new Cell[0][][];
    }

    @Override
    public Cell[][][] read(String filename) throws IOException {
        return new Cell[0][][];
    }

    @Override
    public void write(File file) throws IOException {

    }

    @Override
    public void write(String filename) throws IOException {

    }
}
