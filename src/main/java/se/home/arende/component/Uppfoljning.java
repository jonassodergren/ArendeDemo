/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.home.arende.component;

import se.home.arende.domain.BusinessEvent;

/**
 *
 * @author jonas
 */
public class Uppfoljning {
    
    public void rapporteraAvvikelse(){
        BusinessLog.avrapportera(new BusinessEvent("Avvikelse inkommen"));
    }
    
}
