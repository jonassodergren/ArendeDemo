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
public class BusinessEvent {
    
    private String type;
    
    public BusinessEvent(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
    
}
