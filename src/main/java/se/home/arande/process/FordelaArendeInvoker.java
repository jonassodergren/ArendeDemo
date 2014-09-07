/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.home.arande.process;

import java.util.UUID;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import se.home.arande.ArendeService;
import se.home.arande.FormedlarKomponenten;

/**
 *
 * @author jonas
 */
public class FordelaArendeInvoker implements JavaDelegate{

    @Override
    public void execute(DelegateExecution execution) throws Exception {
     UUID id = (UUID)execution.getVariable("arendeID");
     String signatur = FormedlarKomponenten.arbetsfördela("fattaBeslut", "");
     ArendeService.setHandläggareForÄrandet(id, signatur);
    }
    
}
