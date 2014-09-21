/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.home.arende.domain;

/**
 *
 * @author jonas
 */
public class Handelse {
 
    private String name;
    
    public Handelse(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    private int getTypAvHandling(){
        return 0;
    }
    
    public Handling createHandling(int typAvHandling){
        return new Handling(getTypAvHandling());
    }
    
}
