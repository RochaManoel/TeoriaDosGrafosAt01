package Entities;

public class Graph {
    private Database dataBase = new Database();
    private int [][]Grafo = new int[this.q_vertices()][this.q_vertices()];
    private int [][]Distancia = new int[this.q_vertices()][this.q_vertices()];
    private int [][][]Caminho = new int[this.q_vertices()][this.q_vertices()][this.q_vertices()];
    private int []vetorSoma = new int[this.q_vertices()];
    private int []vetorMaximo = new int[this.q_vertices()];

    public void setDataBase(Database dataBase) {
        this.dataBase = dataBase;
    }

    //Engine of Graph Not Oriented
    public void engine(boolean control){
        if(control){
            this.editGraph();
        }
        else{
            this.setGraph();
        }
        this.newDistancia();
        this.newCaminho();

        //Impressão do Grafo Construido
        System.out.println("\nGrafo Gerado:");
        this.printGraph();

        //Cálculo do Caminho Mínimo
        this.caminhoMinimo();

        //Impressão da Tabela de Distância
        System.out.println("\nTabela de Distância");
        this.printDistancia();

        //Construção  e Impressão do Vetor de Somatórios de Distâncias
        this.newVetorSoma();
        System.out.println("\nO vetor de Somatórios de Distâncias é:");
        this.printVetorSoma();

        //Construção e Impressão do Vetor de Distâncias Máximas
        this.newVetorMaximo();
        System.out.println("\nO vetor de Distâncias Máximas é:");
        this.printVetorMaximo();

        //Construção e Impressão do Nó Central
        System.out.println("\nNó Central: "+ this.getCentralNode());

    }

    public Database getDataBase() {
        return dataBase;
    }
    
    public int[][] getGrafo() {
        return Grafo;
    }
    
    public int[][] getDistancia() {
        return Distancia;
    }
    
    public int[][][] getCaminho() {
        return Caminho;
    }

    private int q_vertices(){
        return dataBase.getN_vertices();
    }

    private void setGraph(){
        this.newGraph();
        int [][]Grafo = this.Grafo;
        for(Data db: this.dataBase.getDados()){
            Grafo[db.getVertice_inicial()][db.getVertice_final()] = db.getCusto();
        }
        this.Grafo = Grafo;
    }

    private void editGraph(){
        this.setGraph();
        int [][]Grafo = this.Grafo;
        for(int i = 0; i<q_vertices();i++){
            for(int j = 0; j <q_vertices();j++){
                if(Grafo[i][j] != 999){Grafo[j][i] = Grafo[i][j];}
            }
        }
        this.Grafo = Grafo;
    }

    private void newGraph(){
        int [][]Grafo = new int[q_vertices()][q_vertices()];
        for(int i = 0; i<q_vertices();i++){
            for(int j = 0; j <q_vertices();j++){
                if(i==j){Grafo[i][j] = 0;}
                else{Grafo[i][j] = 999;}
            }
        }
        this.Grafo = Grafo;
    }
    
    private void newDistancia(){
        int [][]Distancia = new int[q_vertices()][q_vertices()];
        for(int i = 0; i<q_vertices();i++){
            for(int j = 0; j <q_vertices();j++){
                if(i==j){Distancia[i][j] = 0;}
                else{Distancia[i][j] = 999;}
            }
        }
        this.Distancia = Distancia;
    }
    
    private void newCaminho(){
        int [][][]Caminho = new int[q_vertices()][q_vertices()][q_vertices()];
        for(int i = 0; i<q_vertices();i++){
            for(int j = 0; j <q_vertices();j++){
                for(int k = 0; k < q_vertices(); k++){
                    Caminho[i][j][k] = -1;
                }
            }
        }
        this.Caminho = Caminho;
    }
    
    private void newVetorSoma(){
        int []vetorSoma = new int[q_vertices()];
        for(int i = 0;i<q_vertices();i++){
            int soma = 0;
            for(int j = 0; j<q_vertices(); j++){
                soma+=this.Distancia[i][j];
            }
            vetorSoma[i] = soma;
        }
        this.vetorSoma = vetorSoma;
    }
    
    private void newVetorMaximo(){
        int []vetorMaximo = new int[q_vertices()];
        for(int i = 0;i<q_vertices();i++){
            int max = 0;
            int control = i;
            for(int j = 0;j<q_vertices();j++){
                int k = 0;
                while(this.Caminho[i][j][k]!=-1){
                    k++;
                }
                if(max<k){
                    max = k;
                    control = j;
                }
                if(max==k && this.Distancia[i][j]>this.Distancia[i][control]){
                    control = j;
                }

            }
            vetorMaximo[i] = this.Distancia[i][control];
        }
        this.vetorMaximo = vetorMaximo;
    }

    private void printGraph(){
        System.out.printf("     ");
        for(int i = 0; i<q_vertices();i++){
            if(i<10){System.out.printf("  %d  ", i+1);}
            else{System.out.printf(" %d  ", i+1);}
        }
        System.out.println();
        for(int i = 0; i<q_vertices();i++){
            if(i<9){System.out.printf(" %d | ",i+1);}
            else{System.out.printf("%d | ",i+1);}
            for(int j = 0; j <q_vertices();j++){
                if(this.Grafo[i][j]<10){System.out.printf("  "+this.Grafo[i][j]+"  ");}
                else if(this.Grafo[i][j] < 100){System.out.printf("  "+this.Grafo[i][j]+" ");}
                else if(this.Grafo[i][j] < 999){System.out.printf(" "+this.Grafo[i][j]+" ");}
                else{System.out.printf(" --- ");}
            }
            System.out.println();
        }
    }

    private void caminhoMinimo(){
        for(int i = 0;i<q_vertices();i++){
            for(int j = 0;j<q_vertices();j++){
                if(this.Grafo[i][j]!=999){
                    this.Distancia[i][j] = this.Grafo[i][j];
                    if(i != j){
                        this.Caminho[i][j][0] = j;
                    }
                }
            }
        }

        for(int i = 0; i < q_vertices() ; i++){
            for(int j = 0; j < q_vertices(); j++){
                for(int k = 0; k < q_vertices(); k++){
                    if(this.Distancia[j][i]!=999 && this.Distancia[i][k]!=999 && (this.Distancia[j][k] > this.Distancia[j][i] + this.Distancia[i][k])){
                        this.Distancia[j][k] = this.Distancia[j][i] + this.Distancia[i][k];
                        int a = 0;
                        while(this.Caminho[j][i][a] != -1){
                            this.Caminho[j][k][a] = this.Caminho[j][i][a];
                            a++;
                        }
                        int b = a;
                        a = 0;
                        while(this.Caminho[i][k][a] != -1){
                            this.Caminho[j][k][b] = this.Caminho[i][k][a];
                            a++;
                            b++;
                        }
                        this.Caminho[j][k][b]=-1;
                    }
                }
            }
        }
    } 

    private void printDistancia(){
        //Codigo para imprimir a distância mínima
        System.out.printf("     ");
        for(int i = 0; i<q_vertices();i++){
            if(i<10){System.out.printf("  %d  ", i+1);}
            else{System.out.printf(" %d  ", i+1);}
        }
        System.out.println();
        for(int i = 0; i<q_vertices();i++){
            if(i<9){System.out.printf(" %d | ",i+1);}
            else{System.out.printf("%d | ",i+1);}
            for(int j = 0; j <q_vertices();j++){
                if(this.Distancia[i][j]<10){System.out.printf("  "+this.Distancia[i][j]+"  ");}
                else if(this.Distancia[i][j] < 100){System.out.printf("  "+this.Distancia[i][j]+" ");}
                else if(this.Distancia[i][j] < 999){System.out.printf(" "+this.Distancia[i][j]+" ");}
                else{System.out.printf(" --- ");}
            }
            System.out.println();
        }
    }

    private void printVetorSoma(){
        for(int i = 0; i<this.vetorSoma.length;i++){
            if(i<9){
                System.out.printf(" %d : %d\n", i+1, this.vetorSoma[i]);                
            }
            else{
                System.out.printf("%d : %d\n", i+1, this.vetorSoma[i]);
            }
        }
    }

    private void printVetorMaximo(){
        for(int i = 0; i<this.vetorMaximo.length;i++){
            if(i<9){
                System.out.printf(" %d : %d\n", i+1, this.vetorMaximo[i]);                
            }
            else{
                System.out.printf("%d : %d\n", i+1, this.vetorMaximo[i]);
            }
        }
    }

    private int getCentralNode(){
        int node = 0;
        int min = this.vetorSoma[0];
        for(int i=1;i<vetorMaximo.length;i++){
            if(this.vetorSoma[i]<min){
                min = this.vetorSoma[i];
                node = i;
            }
            else if(this.vetorSoma[i] == min && this.vetorMaximo[i]<this.vetorMaximo[node]){
                node = i;
            }
        }
        return node+1;
    }

}
