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
import java.util.UUID;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import se.home.arende.component.ArendeService;
import se.home.arende.component.BusinessLog;
import se.home.arende.domain.Arende;
import se.home.arende.domain.BusinessEvent;
import se.home.arende.domain.Handelse;
import se.home.arende.domain.Handling;

/**
 *
 * @author jonas
 */
public class CmdController {

    private ProcessEngine engine;
    private TaskService taskService;

    private String currentUser = "kermit";

    public CmdController(ProcessEngine engine) {
        this.engine = engine;
        this.taskService = engine.getTaskService();
    }

    @Command(name = "Uppföljning sökande", abbrev = "rapport", description = "Rapportera avvikelse från överenskommelse i uppföljningen")
    public String rapporteraAvvikelse(@Param(name = "pnr", description = "Personnummer") String orgNummer, @Param(name = "Meddelande", description = "Beskrivning av avvikelsen") String beskrivning) {
        BusinessLog.avrapportera(new BusinessEvent("Avvikelse inkommen"));
        return "Avvikelse rapporterad";
    }

    @Command(name = "Mina pågående ärenden", abbrev = "arenden", description = "Översikt över mina pågående ärenden")
    public List<String> minaArenden() {
        List<String> arenden = ArendeService.listaAranden();
        List<String> arendeBeskrivningar = new ArrayList();
        for (String arende : arenden) {
            String arendeText = "ArendeId:" + arende + " Ärendemening: Sanktionsutredning";
            arendeBeskrivningar.add(arendeText);
        }
        if (arendeBeskrivningar.isEmpty()) {
            arendeBeskrivningar.add("Inga pågående ärenden");
        }
        return arendeBeskrivningar;
    }

    @Command(name = "Min inkorg", abbrev = "inkorg", description = "Arbetsuppgifter som jag är ansvarig för")
    public List<String> minInkorg() {
        List<Task> tasks = taskService.createTaskQuery().taskOwner(currentUser).list();
        tasks.addAll(taskService.createTaskQuery().taskAssignee(currentUser).list());
        List<String> arbetsuppgifter = new ArrayList();
        for (Task task : tasks) {
            arbetsuppgifter.add("ID:" + task.getId() + ", " + task.getDescription());
        }
        if (arbetsuppgifter.isEmpty()) {
            arbetsuppgifter.add("Inga arbetsuppgifter är tilldelade dig");
        }
        return arbetsuppgifter;
    }

    @Command(name = "slutför arbetsuppgift", abbrev = "klar", description = "Klarmarkera arbetsuppgift")
    public String klarmarkeraArbetsuppgift(@Param(name = "id", description = "id på arbetsuppgift som är klar") String id) {
        taskService.complete(id);
        return "Arbetsuppgift klarmarkerad";
    }

    @Command(name = "Fatta beslut", abbrev = "beslut", description = "Fatta beslut")
    public String besluta(@Param(name = "id", description = "id på arbetsuppgift som beslutet avser") String id, @Param(name = "beslut", description = "Det fattade beslutet") String beslut) {
        ArendeService.besluta(UUID.fromString(ArendeService.listaAranden().get(0)), beslut);

        taskService.complete(id);
        return "Beslutet är registrerat";
    }

    @Command(name = "Avsluta ärendet", abbrev = "avslut", description = "Avsluta ärendet")
    public String avsluta(@Param(name = "id", description = "id på arbetsuppgift som beslutet avser") String id) {
        ArendeService.avsluta(UUID.fromString(ArendeService.listaAranden().get(0)));
        return "Ärendet är avslutat";
    }

    @Command(name = "byt användare", abbrev = "user", description = "Ny användare")
    public String changeUser(@Param(name = "user", description = "namnet på den nya användaren") String user) {
        currentUser = user;
        return "Inloggad användare bytt till: " + currentUser;
    }

    @Command(name = "Grundinformation i ärendet", abbrev = "grund", description = "Visa grundinformation i ärendet")
    public String getGrundInfoIArende(@Param(name = "id", description = "ÄrendeId") String id) {
        return ArendeService.getgrundInfo(UUID.fromString(ArendeService.listaAranden().get(Integer.parseInt(id))));

        //return ArendeService.getgrundInfo(UUID.fromString(id));
    }

    @Command(name = "Händelser i ärendet", abbrev = "event", description = "Visa händelser som inträffat i ärendet")
    public List<String> getHandelserIArende(@Param(name = "id", description = "ÄrendeId") String id) {
        Arende arende = ArendeService.getArende(UUID.fromString(ArendeService.listaAranden().get(Integer.parseInt(id))));
        List<Handelse> handelser = arende.getHandelser();
        List<String> handelserText = new ArrayList<String>();
        for (Handelse handelse : handelser) {
            handelserText.add("Handelse :" + handelse.getName());
        }
        return handelserText;
    }

    @Command(name = "Handlingar i ärendet", abbrev = "handl", description = "Visa handlingar kopplade till ärendet")
    public List<String> getHandlingarIArende(@Param(name = "id", description = "ÄrendeId") String id) {
        Arende arende = ArendeService.getArende(UUID.fromString(ArendeService.listaAranden().get(Integer.parseInt(id))));
        List<Handling> handlingar = arende.getHandlingar();
        List<String> handlingarText = new ArrayList<String>();
        for (Handling handling : handlingar) {
            handlingarText.add("Handling :" + handling.getDokument());
        }
        return handlingarText;
    }

}
