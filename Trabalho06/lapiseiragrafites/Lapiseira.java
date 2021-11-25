package lapiseiragrafites;

import java.util.ArrayList;
import java.util.Objects;

public class Lapiseira {
    float calibre;
    Grafite bico;
    ArrayList<Grafite> tambor;

    Lapiseira(float calibre) {
        this.calibre = calibre;
        this.bico = null;
        this.tambor = new ArrayList<Grafite>();
    }

    public String toString() {
        return String.format("calibre: %.1f, bico: %s, tambor: %s",
                calibre, (Objects.isNull(bico) ? "[]" : bico), tambor);
    }

    public boolean inserir(Grafite grafite) {
        if(this.calibre == grafite.getCalibre()) {
            tambor.add(grafite);
            return true;
        } else {
            System.out.println("fail: calibre incompatível");
            return false;
        }
    }

    public Grafite remover() {
        if(Objects.isNull(this.bico)) {
            System.out.println("fail: não existe grafite no bico");
            return null;
        } else {
            Grafite aux = this.bico;
            this.bico = null;
            return aux;
        }
    }

    public boolean puxar() {
        if(Objects.isNull(this.bico)) {
            // Verifica se possui algum grafite no tambor
            if(tambor.isEmpty()) {
                System.out.println("fail: não existe grafite no tambor");
                return false;
            } else {
                this.bico = tambor.get(0);
                tambor.remove(0);
                return true;
            }
        } else {
            System.out.println("fail: já existe grafite no bico");
            return false;
        }
    }

    public void escrever() {
        if(Objects.isNull(bico)) {
            System.out.println("fail: não existe grafite no bico");
        } else {
            // Subtrai o quanto será utilizado do bico e modifica o tamanho do mesmo
            int gasto = bico.getTamanho() - bico.desgastePorFolha();
            if(gasto < 10)
                System.out.println("fail: folha incompleta");

            bico.setTamanho(Math.max(gasto, 10));

            if(bico.getTamanho() == 10)
                System.out.println("warning: grafite acabou");
        }
    }
}
