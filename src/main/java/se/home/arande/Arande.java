/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.home.arande;

import java.util.UUID;

/**
 *
 * @author jonas
 */
public class Arande {
    
    private UUID id;
    private String handläggare;

    public String getHandläggare() {
        return handläggare;
    }

    public void setHandläggare(String handläggare) {
        this.handläggare = handläggare;
    }
    
    public Arande(UUID id){
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
    
}
