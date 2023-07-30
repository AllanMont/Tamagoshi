	package tamagoshi.jeu;
	
	import tamagoshi.Tamagoshis;
	import tamagoshi.util.Utilisateur;
	
	import java.util.ArrayList;
	import java.util.Iterator;
	import java.util.List;
	
	import java.util.Random;

	public class TamaGame {
	    private List <Tamagoshis> ensembleDepart;
	    private List <Tamagoshis> encoreCourse;
	    private Random rand;

	    public TamaGame(){
	        ensembleDepart = new ArrayList<>();
	        encoreCourse = new ArrayList<>();
	        rand = new Random();
	    }

	    public void initialisation() {

	        int nbTamagoshis =0;

	        while (nbTamagoshis <= 0) {
	            System.out.println("Combien voulez vous de tamagoshis ?");
	            nbTamagoshis = Integer.parseInt(Utilisateur.saisieClavier());
	        }

	        for (int i = 0; i < nbTamagoshis; i++) {
	            System.out.println("Entrez le nom du tamagoshis numéro " + (i+1) + " : ");
	            ensembleDepart.add(new Tamagoshis(Utilisateur.saisieClavier()));
	        }
	    }

	    public void play() {
	    	encoreCourse = new ArrayList<>(ensembleDepart);
	        int tour = 0;
	        boolean aNourri = false;
	        while (encoreCourse.size() > 0) {
	            System.out.println("------------Tour n°" + (tour + 1) + "-------------");
	            Iterator<Tamagoshis> i = ensembleDepart.iterator();

	            while (i.hasNext()) {
	            	System.out.println("       while");
	                Tamagoshis tama = i.next();
	                if (tama.getEnergy() <= 0 || tama.getAge() >= 10) {
		            	System.out.println("       if 1");
	                    i.remove();
	                } else {
		            	System.out.println("       else");
	                    tama.parle();
	                    if(!aNourri){
	    	            	System.out.println("       if2");
	    	            	System.out.println("       encoreCourse " + ensembleDepart.size());
	                        for (int j = 0; j < ensembleDepart.size(); j++) {
	        	            	System.out.println("       for " + j);
	        	            	if(ensembleDepart.get(j).getEnergy()<= 0) {
	        	            		System.out.println("if 3");
	        	            		System.out.println("Numéro " + j + " : " + ensembleDepart.get(j).getName() + "  -  Énergie : MORT  -  Age : " + ensembleDepart.get(j).getAge());
	        	            	}
	        	            	else {
	        	            		System.out.println("else 3");
	        	            		System.out.println("Numéro " + j + " : " + ensembleDepart.get(j).getName() + "  -  Énergie : " + ensembleDepart.get(j).getEnergy() + "  -  Age : " + ensembleDepart.get(j).getAge());
	        	            	}
	        	            }
	                        System.out.println("Nourrir quel tamagoshi ? Entrez un choix : ");
	                        int o = Integer.parseInt(Utilisateur.saisieClavier());
	                        encoreCourse.get(o).mange();
	                        aNourri = true;
	                    }
	                    tama.setAge(tama.getAge() + 1);
	                    tama.consommeEnergie(rand.nextInt(5));
	                }
	            }
	            aNourri = false;
	            if(encoreCourse.isEmpty()){
	                System.out.println("Le jeu est terminé");
	                break;
	            }
	            try {
	                Thread.sleep(1000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	            tour++;
	        }
	    }

	    
	    
	    public int score() {
	        Iterator<Tamagoshis> i = ensembleDepart.iterator();
	        int score = 0;

	        while (i.hasNext()) {
	            Tamagoshis tama = i.next();
	            if (tama.getEnergy() == 0 || tama.getAge() >= 10) {
	                score++;
	            }
	        }
	        return score;
	    }

	    public static void main(String[] args) {
	        TamaGame tamaGame = new TamaGame();
	        tamaGame.initialisation();
	        tamaGame.play();
	        System.out.println(tamaGame.score());
	    }
	}
