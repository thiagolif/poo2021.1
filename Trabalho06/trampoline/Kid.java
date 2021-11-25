package trampoline;

public class Kid {
    private int age;
    private String name;
    private int saldo;

    Kid(String name, int age) {
        this.name = name;
        this.age = age;
        this.saldo = 0;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) { //gs
        this.name = name;
    }

    public int getSaldo() {
        return saldo;
    }

    public void aumentarSaldo(int saldo) {
        this.saldo += saldo;
    }

    public String toString() {
        return String.format("%s:%d", name, age);
    }
}
