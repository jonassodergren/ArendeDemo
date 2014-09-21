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
public class ArandeStartare implements Callback{

    public static void init(){
        ArandeStartare starter = new ArandeStartare();
        BusinessLog.subscribe(starter);
    }
    
    @Override
    public void receiveEvent(BusinessEvent event) {
        ArendeService.skapaNyttArande();
    }
    
}
