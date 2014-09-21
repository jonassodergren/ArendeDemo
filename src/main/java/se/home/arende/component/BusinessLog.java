/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.home.arende.component;

import se.home.arende.domain.BusinessEvent;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jonas
 */
public class BusinessLog {
    
    private static List<BusinessEvent> log = new ArrayList();
    
    private static List<Callback> listeners = new ArrayList();
    
    public static void avrapportera(BusinessEvent event){
        log.add(event); 
        notifyConsumers(event);
    }
    
    private static void notifyConsumers(BusinessEvent event){
        for(Callback listener:listeners)
            listener.receiveEvent(event);
    }
    
    public static void subscribe(Callback listener){
        listeners.add(listener);
    }
    
}
