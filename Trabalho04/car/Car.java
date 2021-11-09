package car;

public class Car {
    private int pass; // Passageiros
    private int passMax; // limite de Passageiros
    private int gas; // tanque
    private int gasMax; // limite do tanque
    private int km; // quantidade de quilometragem

    /*
        Inicia de tanque vazio, sem passageiro e com a quilometragem zerada.
        O carro suporta até dois passageiros e o tanque 100 litros de gás.
     */
    public Car() {
        pass = 0;
        passMax = 2;
        gas = 0;
        gasMax = 100;
        km = 0;
    }

    /*
        Embarca um passageiro, caso não esteja cheio.
     */
    public void in() {
        if(pass < passMax) {
            pass++;
        } else {
            System.out.println("fail: limite de pessoas atingido");
        }
    }

    /*
        Desembarca um passageiro, caso não esteja vazio.
     */
    public void out() {
        if(pass > 0) {
            pass--;
        } else {
            System.out.println("fail: não ha ninguem no carro");
        }
    }

    /*
        Caso tente abastecer acima do limite, descarta o excedente.
     */
    public void fuel(int gas) {
        this.gas = Math.min((this.gas + gas), gasMax);
    }

    /*
        Caso haja ao menos um passageiro e combustível, gasta combustível andando e aumenta a quilometragem, respectivamente.
        Se o combustível não for suficiente para completar a viagem, dirige o possível e emite uma mensagem indicando a distância percorrida.
        O carro faz um quilômetro por litro de gás.
     */
    public void drive (int km) {
        if(pass == 0) {
            System.out.println("fail: nao ha ninguem no carro");
        } else if(gas == 0) {
            System.out.println("fail: tanque vazio");
        } else {
            if (km > gas) {
                this.km += gas;
                System.out.println("fail: tanque vazio após andar " + gas + " km");
                gas = 0;
            } else {
                gas -= km;
                this.km += km;
            }
        }
    }

    /*
        Exibe os dados do carro.
     */
    public String toString() {
        String showInfo = "pass: " + pass + ", gas: " + gas + ", km: " + km;
        return showInfo;
    }
}
