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
public interface Callback {
    
    public void receiveEvent(BusinessEvent event);
    
}
