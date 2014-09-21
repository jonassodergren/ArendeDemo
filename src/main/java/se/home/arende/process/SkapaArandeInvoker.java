/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.home.arende.process;

import java.util.Map;
import java.util.UUID;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import se.home.arende.component.ArendeService;
import se.home.arende.component.AvvikelseKomponent;
import se.home.arende.domain.Arende;

/**
 *
 * @author jonas
 */
public class SkapaArandeInvoker implements JavaDelegate{

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        int messageId = (Integer)execution.getVariable("id");
        //int messageId = (Integer)vars.get("id");
        String avvikelse = AvvikelseKomponent.getAvvikelse(messageId);
        UUID id = ArendeService.registrera(avvikelse, 2);
        //UUID id = ArendeService.skapaNyttArande();
        execution.setVariable("arendeID", id);
    }
    
}
