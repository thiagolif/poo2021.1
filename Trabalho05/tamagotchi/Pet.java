package tamagotchi;

public class Pet{
    private int energyMax, hungryMax, cleanMax;
    private int energy, hungry, shower;
    private int diamonds;
    private int age;
    private boolean alive;

    // Atribui o valor de energia
    // Se o valor ficar abaixo de 0, o pet morre de fraqueza
    // Garanta que os valores ficarão no interalo 0 - max
    // Use esse modelo para fazer os outros métodos set
    private void setEnergy(int value){
        if(value <= 0){
            this.energy = 0;
            System.out.println("fail: pet morreu de fraqueza");
            this.alive = false;
        }
        else if(value > this.energyMax)
            this.energy = this.energyMax;
        else
            this.energy = value;
    }

    private void setHungry(int value) {
        if(value <= 0) {
            this.hungry = 0;
            System.out.println("fail: pet morreu de fome");
            this.alive = false;
        } else {
            this.hungry = Math.min(value, this.hungryMax);
        }
    }

    private void setClean(int value) {
        if(value <= 0) {
            this.shower = 0;
            System.out.println("fail: pet morreu de sujeira");
            this.alive = false;
        } else {
            this.shower = Math.min(value, this.cleanMax);
        }
    }

    private void setDiamonds(int value) {
        this.diamonds = value;
    }

    private void setAge(int value) {
        this.age = value;
    }

    public Pet(int energy, int hungry, int shower) {
        this.energyMax = energy;
        this.hungryMax = hungry;
        this.cleanMax = shower;
        this.diamonds = 0;
        this.age = 0;
        this.alive = true;
        this.energy = energy;
        this.hungry = hungry;
        this.shower = shower;
    }

    private int getClean() {
        return this.shower;
    }

    private int getHungry() {
        return this.hungry;
    }

    private int getEnergy() {
        return this.energy;
    }

    private int getEnergyMax() {
        return this.energyMax;
    }

    private int getCleanMax() {
        return this.cleanMax;
    }

    private int getHungryMax() {
        return this.hungryMax;
    }

    private int getDiamonds() {
        return this.diamonds;
    }

    private int getAge() {
        return this.age;
    }

    public String toString() {
        return String.format("E:%d/%d, S:%d/%d, L:%d/%d, D:%d, I:%d\n",
                getEnergy(), getEnergyMax(), getHungry(), getHungryMax(), getClean(), getCleanMax(), getDiamonds(), getAge());
    }

    private boolean testAlive() {
        if(this.alive) {
            return true;
        } else {
            System.out.println("fail: pet está morto");
            return false;
        }
    }

    // Invoca o método testAlive para verificar se o pet esta vivo
    // Se estiver vivo, altere os atributos utilizando os métodos set e get
    public void play() {
        if(testAlive()) {
            setEnergy(getEnergy()-2);
            setHungry(getHungry()-1);
            setClean(getClean()-3);
            setDiamonds(getDiamonds()+1);
            setAge(getAge()+1);
        }
    }

    public void shower() {
        if(testAlive()) {
            setEnergy(getEnergy()-3);
            setHungry(getHungry()-1);
            setClean(getCleanMax());
            setAge(getAge()+2);
        }
    }

    public void eat() {
        if(testAlive()) {
            setEnergy(getEnergy()-1);
            setHungry(getHungry()+4);
            setClean(getClean()-2);
            setAge(getAge()+1);
        }
    }

    public void sleep() {
        if(testAlive()) {
            if(getEnergy() <= getEnergyMax() - 5) {
                setAge(getAge() + 1);
                setEnergy(getEnergyMax());
                setHungry(getHungry() - 1);
            } else {
                System.out.println("fail: não está com sono");
            }
        }
    }
}
