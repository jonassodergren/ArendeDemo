/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.home.arande;

/**
 *
 * @author jonas
 */
public class Uppfoljning {
    
    public void rapporteraAvvikelse(){
        BusinessLog.avrapportera(new BusinessEvent("Avvikelse inkommen"));
    }
    
}
