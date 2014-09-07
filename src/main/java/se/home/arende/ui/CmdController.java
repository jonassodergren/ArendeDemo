/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.home.arende.ui;

import asg.cliche.Command;
import asg.cliche.Param;
import java.util.ArrayList;
import java.util.List;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import se.home.arande.ArendeService;
import se.home.arande.BusinessEvent;
import se.home.arande.BusinessLog;

/**
 *
 * @author jonas
 */
public class CmdController {
    
    private ProcessEngine engine;
    private TaskService taskService;
    
    private String currentUser = "kermit";
    
    public CmdController(ProcessEngine engine){
        this.engine = engine;
        this.taskService = engine.getTaskService();
    }
    
    @Command(name="Uppföljning sökande",abbrev="ra", description="Rapportera avvikelse från överenskommelse i uppföljningen")
    public String rapporteraAvvikelse(@Param(name="pnr", description="Personnummer")String orgNummer,@Param(name="Meddelande", description="Beskrivning av avvikelsen")String beskrivning) {
       BusinessLog.avrapportera(new BusinessEvent("Avvikelse inkommen"));
       return "Avvikelse rapporterad";
    }   
    
    @Command(name="Mina pågående ärenden",abbrev="mpa", description="Översikt över mina pågående ärenden")
    public List<String> minaArenden(){
        List<String> arenden = ArendeService.listaAranden();
        if(arenden.isEmpty())
            arenden.add("Inga pågående ärenden");
        return arenden;
    }
    
    @Command(name="Min inkorg",abbrev="inkorg", description="Arbetsuppgifter som jag är ansvarig för")
    public List<String> minInkorg(){
        List<Task> tasks = taskService.createTaskQuery().taskOwner(currentUser).list();
       tasks.addAll(taskService.createTaskQuery().taskAssignee(currentUser).list());
        List<String> arbetsuppgifter = new ArrayList();
        for (Task task : tasks) {
            arbetsuppgifter.add("ID:"+task.getId()+", "+task.getDescription());
       }
        if(arbetsuppgifter.isEmpty())
            arbetsuppgifter.add("Inga arbetsuppgifter är tilldelade dig");
        return arbetsuppgifter;
    }
    
    @Command(name="slutför arbetsuppgift",abbrev="klar", description="Klarmarkera arbetsuppgift")
    public String klarmarkeraArbetsuppgift(@Param(name="id", description="id på arbetsuppgift som är klar")String id){
       taskService.complete(id);
       return "Arbetsuppgift klarmarkerad";
    } 
    
     @Command(name="byt användare",abbrev="user", description="Ny användare")
    public String changeUser(@Param(name="user", description="namnet på den nya användaren")String user){
       currentUser = user;
       return "Inloggad användare bytt till: "+currentUser;
    }    
    
}
