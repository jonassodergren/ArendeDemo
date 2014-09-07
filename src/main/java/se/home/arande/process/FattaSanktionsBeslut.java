/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.home.arande.process;

import org.activiti.engine.RuntimeService;
import se.home.arande.BusinessEvent;
import se.home.arande.Callback;

/**
 *
 * @author jonas
 */
public class FattaSanktionsBeslut implements Callback{
 
    private final RuntimeService runtimeService;
    
    public FattaSanktionsBeslut(RuntimeService runtimeService){
        this.runtimeService = runtimeService;
    }

    @Override
    public void receiveEvent(BusinessEvent event) {
        String procId = runtimeService.startProcessInstanceByKey("fattaSanktionsBeslut").getId();
    }
}
