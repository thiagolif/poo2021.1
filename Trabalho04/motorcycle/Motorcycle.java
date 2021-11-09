package motorcycle;

import java.util.Objects;

public class Motorcycle {
    private Person person; //agregacao
    private int power;
    private int time;

    //Inicia o atributo power, time com zero e person com null
    public Motorcycle(int power) {
        this.power = power;
        time = 0;
        person = null;
    }

    //Comprar mais tempo
    public void buy(int time) {
        this.time += time;
    }

    //Se estiver vazio, coloca a pessoa na moto e retorna true
    public boolean in(Person person) {
        if(Objects.isNull(this.person)) {
            this.person = person;
            return true;
        } else {
            System.out.println("fail: moto ocupada");
            return false;
        }
    }

    //Se houver uma person, retira e retorna
    //Se não, retorna null
    public Person out() {
        if(Objects.isNull(this.person)) {
            System.out.println("fail: moto vazia");
            return null;
        } else {
            Person aux = person;
            person = null;
            return aux;
        }
    }

    public void drive(int time) {
        if(Objects.isNull(person)) {
            System.out.println("fail: moto sem minutos");
        } else if(person.getAge() > 10) {
            System.out.println("fail: muito grande para andar de moto");
        } else if(this.time == 0) {
            System.out.println("fail: time zerado");
        } else {
            if(time > this.time) {
                System.out.println("fail: andou " + this.time + " min e acabou o tempo");
                this.time = 0;
            } else {
                this.time -= time;
            }
        }
    }

    //buzinar
    public void honk() {
        if(Objects.isNull(person)) {
            System.out.println("fail: moto vazia");
        } else {
            System.out.print("P");
            for (int i = 0; i < power; i++)
                System.out.print("e");
            System.out.println("m");
        }
    }

    public String toString() {
        return String.format("power: %d, minutos: %d, person: %s", power, time, person);
    }
}
