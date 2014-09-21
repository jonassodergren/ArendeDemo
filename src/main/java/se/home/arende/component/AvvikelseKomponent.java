/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.home.arende.component;

/**
 *
 * @author jonas
 */
public class AvvikelseKomponent {
   
    public static String getAvvikelse(int id){
        if(id == 17){
            return "A-rapport ej inkommen den 12/9-2015";
        }
        return null;
    }
    
    
}
