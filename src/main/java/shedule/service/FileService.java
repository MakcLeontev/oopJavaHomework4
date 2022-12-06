package shedule.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface FileService {
    List<String> readAllLines() throws IOException;

    void saveAllLines(List<String> lines) throws IOException;

}
