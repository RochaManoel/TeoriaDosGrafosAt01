package Auxiliares;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Entities.Database;

public class Input {
    public Database getInput(String name){
        Database dataInput = new Database();
        try {
            FileReader file = new FileReader(name);
            BufferedReader readFile = new BufferedReader(file);
            String line = readFile.readLine(); 
            int n_vertices = Integer.parseInt(line.substring(0, 2));
            int n_edges = Integer.parseInt(line.substring(4, 6));
            dataInput.addVerticesArestas(n_vertices, n_edges);
            for(int count = 0; count<n_edges;count++){
                line = readFile.readLine();
                dataInput.addDates(line);
            }
            file.close();
        } 
        catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
            e.getMessage());
        }
        return dataInput;
    }
}
