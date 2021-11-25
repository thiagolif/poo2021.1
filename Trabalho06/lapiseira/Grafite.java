package lapiseira;

public class Grafite {
    private float calibre;
    private String dureza;
    private int tamanho;

    Grafite(float calibre, String dureza, int tamanho) {
        this.calibre = calibre;
        this.dureza = dureza;
        this.tamanho = tamanho;
    }

    public float getCalibre() {
        return calibre;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public String toString() {
        return String.format("[%.1f:%s:%d]", calibre, dureza, tamanho);
    }

    public int desgastePorFolha() {
        return switch (dureza) {
            case "HB" -> 1;
            case "2B" -> 2;
            case "4B" -> 4;
            case "6B" -> 6;
            default -> 0;
        };
    }
}
