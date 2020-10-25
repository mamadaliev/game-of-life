package mamadaliev.service;

import mamadaliev.model.Cell;

import java.io.File;
import java.io.IOException;

public interface Transfer {

    Cell[][][] read(File file) throws IOException;

    Cell[][][] read(String filename) throws IOException;

    void write(File file) throws IOException;

    void write(String filename) throws IOException;
}
