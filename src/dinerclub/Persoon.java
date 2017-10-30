/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dinerclub;

/**
 *
 * @author Saskia77
 */
public class Persoon {
    private String Naam;
    private int[] data;

    public Persoon(String Naam, int... data) {
        this.Naam = Naam;
        this.data = data;
    }
    
    public int[] getData(){
        return data;
    }
    public String getNaam(){
        return Naam;
    }
      
    
}