package Entities;

import java.util.ArrayList;

public class Database {
    private Integer n_vertices = 0;
    private Integer n_arestas = 0;
    private ArrayList<Data> dados = new ArrayList<>();

    public void addVerticesArestas(Integer n_vertices, Integer n_arestas){
        this.n_vertices = n_vertices;
        this.n_arestas = n_arestas;
    }

    public Integer getN_vertices() {
        return n_vertices;
    }
    public Integer getN_arestas() {
        return n_arestas;
    }

    public void setN_vertices(Integer n_vertices) {
        this.n_vertices = n_vertices;
    }
    public void setN_arestas(Integer n_arestas) {
        this.n_arestas = n_arestas;
    }

    public ArrayList<Data> getDados() {
        return dados;
    }

    public void addDates(String linha){
        int vertice_inicial = this.defineNumber(linha, 1);
        int vertice_final = this.defineNumber(linha, 2);
        int custo = this.defineNumber(linha, 3);
        this.dados.add(new Data(vertice_inicial, vertice_final, custo));
    }

    private Integer defineNumber(String linha, Integer control){
        int n = 0;
        if(control == 1){
            linha = linha.substring(0,2);
            linha = linha.trim();
            n = Integer.parseInt(linha);
        }
        else if(control == 2){
            linha = linha.substring(2, 6);
            linha = linha.trim();
            n = Integer.parseInt(linha);
        }
        else if(control == 3){
            if(linha.length()==10){
                linha = linha.substring(6, 10);                
            }
            else{
                linha = linha.substring(6, 9);
            }
            linha = linha.trim();
            n = Integer.parseInt(linha);
        }
        return n; 
    }
}
