package trampoline;

import java.util.Scanner;
import java.util.Objects;

public class Solver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Trampoline tramp = new Trampoline();
        while(true) {
            String line = scanner.nextLine();
            System.out.println("$"+ line);
            String[] ui = line.split(" ");
            if(ui[0].equals("end")) {
                break;
            } else if(ui[0].equals("arrive")) { // name age
                tramp.arrive(new Kid(ui[1], Integer.parseInt(ui[2]))) ;
            } else if(ui[0].equals("in")) {
                tramp.in();
            } else if(ui[0].equals("out")) {
                tramp.out();
            } else if(ui[0].equals("remove")) {//name
                tramp.remove(ui[1]);
            } else if(ui[0].equals("show")) {
                System.out.println(tramp);
            } else if(ui[0].equals("papaichegou")) {
                tramp.remove(ui[1]);
            } else if(ui[0].equals("init")) {
                tramp = new Trampoline(Integer.parseInt(ui[1]));
            } else if(ui[0].equals("saldo")) {
                if(ui.length == 1)
                    tramp.saldo();
                else tramp.saldo(ui[1]);
            } else if(ui[0].equals("caixa")) {
                tramp.caixa();
            } else if(ui[0].equals("entrar")) {
                tramp.entrar();
            } else if(ui[0].equals("fechar")) {
                tramp.close();
            } else {
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}