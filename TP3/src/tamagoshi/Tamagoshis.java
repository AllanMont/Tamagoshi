package tamagoshi;

import java.util.Random;

public class Tamagoshis {

    private int age;
    private int maxEnergy;
    private int energy;
    private String name;

    private static int lifeTime = 10;
    private Random random = new Random();

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public int getMaxEnergy() {
        return maxEnergy;
    }

    public int getEnergy() {
        return energy;
    }

    public String getName() {
        return name;
    }

    public static int getLifeTime() {
        return lifeTime;
    }

    public Tamagoshis(String name){
        if (!name.isEmpty()) {
            this.name = name;
        }
        this.age = 0;
        this.maxEnergy = this.random.nextInt(5,9);
        this.energy = this.random.nextInt(3,7);

    }

    public boolean parle() {
//        System.out.println("Nom : " + this.name +
//                "\nEtat de forme : " + (this.energy>4?"heureux.":"affamé."));

        return this.energy>4;
    }

    public boolean mange() {
        if (this.energy < this.maxEnergy) {
            this.energy+= this.random.nextInt(1,3);
//            System.out.println("Merci !");
            return true;
        }
        System.out.println(this.name + ": J'ai faim !");
        return false;
    }

    public boolean consommeEnergie() {
        this.energy--;
        if (this.energy <= 0) {
//            System.out.println("Je suis KO");
            return  false;
        }

        return true;
    }

    public boolean consommeEnergie(int nbEnergie) {
        this.energy = this.energy - nbEnergie;
        if (this.energy <= 0) {
            System.out.println(this.name + "Je suis KO");
            return  false;
        }

        return true;
    }
    
    public String toString(){
        return "Nom : " + this.name +
                "\nAge : " + this.age +
                "\nmaxEnergy : " + this.maxEnergy +
                "\nEnergy : " + this.energy +
                "\nlifeTime : " + this.lifeTime;
    }

    public static void main(String[] args) {
        Tamagoshis tex = new Tamagoshis("Tex");
        tex.parle();
        tex.mange();
        tex.consommeEnergie();
        System.out.println(tex.toString());
    }


}
