/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.home.arende.process;

import java.util.HashMap;
import java.util.Map;
import org.activiti.engine.RuntimeService;
import se.home.arende.component.Callback;
import se.home.arende.domain.BusinessEvent;

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
      //  String procId = runtimeService.startProcessInstanceByKey("fattaSanktionsBeslut").getId();
        Map<String,Object> processVars = new HashMap();
        processVars.put("id", 17);
        runtimeService.startProcessInstanceByMessage("avvikelseIntraffadMessage", "startMessage",processVars);        
    }
}
