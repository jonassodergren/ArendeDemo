/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.home.arende.ui;

import asg.cliche.ShellFactory;
import org.activiti.engine.ProcessEngine;

/**
 *
 * @author jonas
 */
public class CLI {
     public static void run(ProcessEngine engine) throws Exception{
 
        ShellFactory.createConsoleShell("Förmedlar-plattform", "", new CmdController(engine))
            .commandLoop();
    }   
}
