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

/**
 *
 * @author jonas
 */
public class SkapaArandeInvoker implements JavaDelegate{

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        UUID id = ArendeService.skapaNyttArande();
        execution.setVariable("arendeID", id);
    }
    
}
