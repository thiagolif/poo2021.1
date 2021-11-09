package calculator;

public class Calculator {
    private int batteryMax;
    private int battery;
    private float display;

    //Inicia os atributos, battery e display começam com o zero.
    public Calculator(int batteryMax) {
        this.batteryMax = batteryMax;
        battery = 0;
        display = 0;
    }

    //Aumenta a bateria, porém não além do máximo.
    public void chargeBattery(int value) {
        battery = Math.min(battery + value, batteryMax);
    }

    //Tenta gastar uma unidade da bateria e emite um erro se não conseguir.
    public boolean useBattery() {
        if(battery == 0) {
            System.out.println("fail: bateria insuficiente");
            return false;
        } else {
            battery--;
            return true;
        }
    }

    //Se conseguir gastar bateria, armazene a soma no atributo display.
    public void sum(int a, int b) {
        if(useBattery()) {
            display = a + b;
        }
    }

    //Se conseguir gastar bateria e não for divisão por 0.
    public void division(int num, int den) {
        if(useBattery()) {
            if(den == 0) {
                System.out.println("fail: divisao por zero");
                return;
            }

            display = ((float) num) / den;
        }
    }

    //Se conseguir gastar bateria, armazena a multiplicação no atributo display
    public void multiply(int a, int b) {
        if(useBattery()) {
            display = a * b;
        }
    }

    //Se conseguir gastar bateria, armazena a subtração no atributo display
    public void subtract(int a, int b) {
        if(useBattery()) {
            display = a - b;
        }
    }

    //Retorna o conteúdo do display com duas casas decimais.
    public String toString() {
        return String.format("display = %.2f, battery = %d", display, battery);
    }
}
