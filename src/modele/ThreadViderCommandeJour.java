package modele;

import java.util.Calendar;

public class ThreadViderCommandeJour extends Thread{
    BDCommande bdCommande = BDCommande.getInstance();
     private boolean continuerBoucle=true;
     private int jourReference;


    public ThreadViderCommandeJour(){
        Calendar calendar=Calendar.getInstance();
        //jourReference = calendar.get(Calendar.DAY_OF_MONTH);
        jourReference=calendar.get(Calendar.MINUTE);// pour tester en tp
    }

    public void arret(){
        continuerBoucle = false;
    }


    public void run(){
        do{
            try{
                Thread.sleep(30000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            if(testSuppression()){
                System.out.println("vider commande");
                bdCommande.viderCommandeJour();
            }

        }while (continuerBoucle);

    }

    public boolean testSuppression(){
        Calendar calendar = Calendar.getInstance();
        int minuteActuelle = calendar.get(Calendar.MINUTE);
        if (minuteActuelle > jourReference){
            jourReference=minuteActuelle;
            return true;
        }
        else
            return false;
    }
}
