package Entities;

public class Data {
    private Integer vertice_inicial;
    private Integer vertice_final;
    private Integer custo;

    public Data(Integer vertice_inicial, Integer vertice_final, Integer custo){
        this.vertice_inicial = vertice_inicial;
        this.vertice_final = vertice_final;
        this.custo = custo;
    }
    
    public Integer getVertice_inicial() {
        return vertice_inicial - 1;
    }
    public Integer getVertice_final() {
        return vertice_final - 1;
    }
    public Integer getCusto() {
        return custo;
    }
}
