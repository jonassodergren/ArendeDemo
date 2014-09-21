/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.home.arende.component;

import java.util.UUID;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 *
 * @author jonas
 */
public class AssignmentHandler implements TaskListener{

    @Override
    public void notify(DelegateTask dt) {
        UUID arendeID = (UUID)dt.getExecution().getVariable("arendeID");
        String signatur = ArendeService.getHandläggareFörÄrendet(arendeID);
        dt.setOwner(signatur);
      //  dt.setAssignee(signatur);
    }
    
}
