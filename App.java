import java.util.Scanner;

import Entities.Engine;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean control = true;
        while(control){
            System.out.println("Digite o Cenário desejado:\n[0] - Fechar Programa\n[1] - Cenário 1\n[2] - Cenário 2");
            int option = sc.nextInt();
            switch(option){
                case 0:
                    control = false;
                    break;
                case 1:
                    new Engine(true);
                    break;
                case 2:
                    new Engine(false);
                    break;
                default:
                    System.out.println("Comando Invalido");
                    break;
            }
        }
        sc.close();
    }
}
