package com.tondeuse;

import com.tondeuse.helper.InstructionsFileHandler;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.print("Entrer le chemin du fichier d'instructions: ");
        Scanner in = new Scanner(System.in);
        String path = in.nextLine();
        InstructionsFileHandler instructionsFileHandler = new InstructionsFileHandler(new File(path));
        System.out.println(instructionsFileHandler.executeInstructions());
    }
}
