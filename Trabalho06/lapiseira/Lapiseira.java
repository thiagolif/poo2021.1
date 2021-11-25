package lapiseira;

import java.util.Objects;

public class Lapiseira {
    private float calibre;
    private Grafite grafite;

    Lapiseira(float calibre) {
        this.calibre = calibre;
        grafite = null;
    }

    public String toString() {
        return String.format("calibre: %.1f, grafite: %s", calibre, grafite);
    }

    public boolean inserir(Grafite grafite) {
        if(Objects.isNull(this.grafite)) {
            if (calibre == grafite.getCalibre()) {
                this.grafite = grafite;
                return true;
            } else {
                System.out.println("fail: calibre incompatível");
                return false;
            }
        } else {
            System.out.println("fail: já existe grafite");
            return false;
        }
    }

    public Grafite remover() {
        if(Objects.isNull(grafite)) {
            System.out.println("fail: não existe grafite");
            return null;
        } else {
            Grafite aux = grafite;
            grafite = null;
            return aux;
        }
    }

    public void escrever() {
        if(!Objects.isNull(grafite)) {
            // Subtrai o quanto será utilizado do grafite e modifica o tamanho do mesmo
            int gasto = grafite.getTamanho() - grafite.desgastePorFolha();
            if(gasto < 10)
                System.out.println("fail: folha incompleta");

            grafite.setTamanho(Math.max(gasto, 10));

            if(grafite.getTamanho() == 10)
                System.out.println("warning: grafite acabou");
        }
    }
}
