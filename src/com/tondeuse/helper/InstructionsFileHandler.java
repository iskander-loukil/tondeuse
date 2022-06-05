package com.tondeuse.helper;

import com.tondeuse.Direction;
import com.tondeuse.Tondeuse;
import com.tondeuse.enumerations.CardinalDirections;

import java.io.*;

public class InstructionsFileHandler {
    private File file;

    public InstructionsFileHandler(File file) {
        this.file = file;
    }

    public String executeInstructions() throws IOException {
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;

        // First line for xmax and ymax
        line = br.readLine();
        String[] dimensions = line.split(" ");
        Tondeuse.xmax = Integer.parseInt(dimensions[0]);
        Tondeuse.ymax = Integer.parseInt(dimensions[1]);

        // positionLine indicates whether the currently read line is a position or a set of instructions
        boolean positionLine = true;
        Tondeuse tondeuse = null;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null){
            if (positionLine) {
                String[] position = line.split(" ");
                tondeuse = new Tondeuse(Integer.parseInt(position[0]),
                        Integer.parseInt(position[1]),
                        new Direction(CardinalDirections.valueOf(position[2])));
            }
            else {
                sb.append(tondeuse.move(line));
                sb.append(" ");
            }
            positionLine = !positionLine;
        }
        return sb.toString();
    }
}
