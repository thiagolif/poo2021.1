package trampoline;

import java.util.LinkedList;
import java.util.Objects;

public class Trampoline{
    private LinkedList<Kid> waiting;
    private LinkedList<Kid> playing;
    private int ageLimit;
    private int caixa;

    Trampoline() {
        this(100);
    }

    Trampoline(int age) {
        this.waiting = new LinkedList<Kid>();
        this.playing = new LinkedList<Kid>();
        this.ageLimit = age;
        this.caixa = 0;
    }

    public Kid searchKid(String name, LinkedList<Kid> list) {
        for(Kid kid : list) {
            if(kid.getName().equals(name))
                return kid;
        }

        return null;
    }

    //remove and return the Kid with this name or null
    public Kid remove_kid(String name, LinkedList<Kid> list) {
        Kid aux = searchKid(name, list);

        if(!Objects.isNull(aux))
            this.caixa += aux.getSaldo();

        list.remove(aux);
        return aux;
    }

    //retira todas as criancas do pula pula e da fila
    public void close() {
        waiting.clear();
        playing.clear();
    }

    //insere na lista de espera
    public void arrive(Kid kid) {
        if(kid.getAge() > this.ageLimit) {
            System.out.println("fail: criança grande demais para brincar");
        } else {
            waiting.addFirst(kid);
        }
    }

    //remove da lista de espera e insere na lista playing
    public void in() {
        if(waiting.isEmpty()) {
            System.out.println("fail: não existem crianças na fila de espera");
        } else {
            playing.addFirst(waiting.getLast());
            waiting.removeLast();
        }
    }

    //remove de playing para waiting
    public void out() {
        if(playing.isEmpty()) {
            System.out.println("fail: não existem crianças brincando");
        } else {
            playing.getLast().aumentarSaldo(1);
            waiting.addFirst(playing.getLast());
            playing.removeLast();
        }
    }

    //remove do parquinho
    public Kid remove(String name) {
        Kid aux = remove_kid(name, waiting);
        if(Objects.isNull(aux))
            aux = remove_kid(name,playing);
        return aux;
    }

    // mostra o caixa do pula pula
    public void caixa() {
        System.out.printf("caixa do pula pula: %d\n", caixa);
    }

    // mostra o saldo de todas as crianças no pula pula
    public void saldo() {
        if(!waiting.isEmpty()) {
            for(Kid kid : waiting)
                System.out.printf("saldo %s: %d\n", kid.getName(), kid.getSaldo());
        }

        if(!playing.isEmpty()) {
            for(Kid kid : playing)
                System.out.printf("saldo %s: %d\n", kid.getName(), kid.getSaldo());
        }
    }

    // mostra o saldo da criança com nome "name"
    public void saldo(String name) {
        Kid aux = searchKid(name, waiting);

        if(Objects.isNull(aux))
            aux = searchKid(name, playing);

    }

    // procura na fila de espera a primeira criança com idade compatível com a que está brincando
    // a idade máxima é a idade da criança que está brincando + 1
    public void entrar() {
        // caso não tenha nenhuma criança brincando, o método não faz nada
        if(!playing.isEmpty()) {
            int maisNova = ageLimit;
            for (Kid kid : playing) {
                if (kid.getAge() < maisNova)
                    maisNova = kid.getAge();
            }

            // procura a primeira criança com idade compatível, e coloca no pula pula
            for(int i = waiting.size()-1;i >= 0;i--) {
                if(waiting.get(i).getAge() <= maisNova+1) {
                    playing.addFirst(waiting.get(i));
                    waiting.remove(i);
                    break;
                }
            }
        }
    }

    public String toString() {
        return String.format("=> %s => %s", waiting, playing);
    }
}