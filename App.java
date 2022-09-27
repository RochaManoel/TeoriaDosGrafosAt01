import java.util.Scanner;

import Entities.Engine;
//import Grafos.CenarioOne;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean control = true;
        while(control){
            //System.out.println("Digite o Cenário desejado:\n[0] - Fechar Programa\n[1] - Cenário 1\n[2] - Cenário 2");
            //int option = sc.nextInt();
            int option;
            option = 2;
            switch(option){
                case 0:
                    control = false;
                    break;
                case 1:
                    new Engine(true);
                    control = false;
                    break;
                case 2:
                    new Engine(false);
                    control = false;
                    break;
                default:
                    System.out.println("Comando Invalido");
                    break;
            }
        }
        sc.close();
    }
}
