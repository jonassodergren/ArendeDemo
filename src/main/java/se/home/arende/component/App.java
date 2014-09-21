/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.home.arende.component;

import java.util.List;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.identity.User;
import org.activiti.engine.task.Task;
import se.home.arende.process.FattaSanktionsBeslut;
import se.home.arende.ui.CLI;

/**
 *
 * @author jonas
 */
public class App {

    public static void main(String args[]) throws Exception{

        ProcessEngine processEngine = ProcessEngineConfiguration.createStandaloneInMemProcessEngineConfiguration().buildProcessEngine();

        RepositoryService repositoryService = processEngine.getRepositoryService();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        // Deploy the process definition
        repositoryService.createDeployment()
                .addClasspathResource("fattaBeslutProcess.bpmn20.xml")
                .deploy();
        processEngine.getIdentityService().saveUser( processEngine.getIdentityService().newUser("kalle") );
        
       // User user = processEngine.getIdentityService().createUserQuery().userId("kalle").singleResult();
        
        
        BusinessLog.subscribe(new FattaSanktionsBeslut(runtimeService));
        //ArandeStartare.init();
        //new Uppfoljning().rapporteraAvvikelse();

 //       TaskService taskService = processEngine.getTaskService();
 //       List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup("accountancy").list();
        //      List<Task> tasks = taskService.createTaskQuery().taskCandidateUser("kermit").list();
 //       List<Task> tasks = taskService.createTaskQuery().taskOwner("kermit").list();
 //       for (Task task : tasks) {
 //           System.out.println("Aktuella arbetsuppgifter: " + task.getDescription());
 //       }
 //       for (String id : ArendeService.listaAranden()) {
 //           System.out.println("Pågående ärenden: " + id);
 //       }
     CLI.run(processEngine);

    }

}
