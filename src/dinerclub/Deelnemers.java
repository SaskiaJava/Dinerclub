/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dinerclub;
import java.util.ArrayList;

/**
 *
 * @author Saskia77
 */
public class Deelnemers {
 
    ArrayList<Persoon> personen;
    String maand;
    ArrayList<Persoon> mogelijkeKoks;
    
    public Deelnemers() {
        personen = new ArrayList<>();
        mogelijkeKoks = new ArrayList<>();
        maand = "default";
    }
    public Deelnemers(String maand){
        personen = new ArrayList<>();
        mogelijkeKoks = new ArrayList<>();
        this.maand = maand; 
    }
    public void voegToe(String naam, int... data){
        personen.add(new Persoon(naam, data));
    }
    public void setMaand(String maand){
        this.maand = maand;
    }
    public String getMaand(){
        return maand;
    }
    public String Deelnemers(){
        
        StringBuilder sb1 = new StringBuilder();
        for (Persoon p : personen) {
            sb1.append(p.getNaam());
            sb1.append(", ");
        }
        return sb1.toString();
    }
    
    public String date(){
        String s;
        int hoogste = 0;
        int meestvoorkomendedatum=0;
        int datum[] = new int[32];//zodat datum[x]=x van 1-31 mogelijk is
        int[] aantal = new int[32];
        datum[0]=aantal[0]=0;//eerste positie wordt niet gebruikt
        for (int x=1; x<datum.length; x++) aantal[x]=0; //zet aantallen op startwaarde 0
        for (Persoon p: personen){
            for (int x=1; x<datum.length; x++) {
                datum[x]=x;//start bij datum[1] = 1; tot 32
                int[] data = p.getData();// haal data van deze persoon
                for (int y=0; y<data.length; y++) { // voor iedere datum in data
                    if (data[y] == x) aantal[x]++;  // verhoog aantal van betreffende datum
                    if (aantal[x]>hoogste) {
                        hoogste=aantal[x]; //zoek hoogste aantal
                        meestvoorkomendedatum=x; // datum met hoogste aantal
                        mogelijkeKoks.add(p);
                    } 
                }
            }
        }
       
        if (meestvoorkomendedatum==0) s="Geen data doorgegeven!";
        else s = meestvoorkomendedatum + " " + maand;      
        return s;
    }
    
    public String kiesKok(){
        int i = mogelijkeKoks.size();
        int random = (int)(i*Math.random());
        String s = mogelijkeKoks.get(random).getNaam();
        return s;
    }
    
    public String kiesThema(){
        String[] thema = new String[]{"Italiaans", "Ijspret", "Pompoen enzo", "Stoofpot", "Indiaas", "Rijsttafel", "Fondue", "Taarten", "Ovenschotel"};
        int i = thema.length;
        int random = (int)(i*Math.random());
        String s = thema[random];
        return s;
    }
}

    

 
