package Entities;

import Auxiliares.Input;

public class Engine {
    public Engine(boolean control){
        this.Action(control);
    }
    private void Action(boolean control){
        if(control){
            String name="grafo01.txt";
            Database dataBase= new Database();
            Input input = new Input();
            dataBase = input.getInput(name);
            Graph graph = new Graph();
            graph.setDataBase(dataBase);
            graph.engine(control);
        }
        else{
            String name="grafo02.txt";
            Database dataBase= new Database();
            Input input = new Input();
            dataBase = input.getInput(name);
            Graph graph = new Graph();
            graph.setDataBase(dataBase);
            graph.engine(control);
        }
    }

}
