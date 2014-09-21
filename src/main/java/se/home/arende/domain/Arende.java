/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.home.arende.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author jonas
 */
public class Arende {

    private UUID id;
    private String handläggare;

    private List<Handling> handlingar = new ArrayList();

    public List<Handling> getHandlingar() {
        return handlingar;
    }
    private List<Handelse> handelser = new ArrayList();

    public List<Handelse> getHandelser() {
        return handelser;
    }

    public Handelse rapporteraFramsteg(int type) {
        Handelse handelse = null;
        if (type == 0) {
            handelse = new Handelse("Ärendet registrerat");
        }
        if (type == 1) {
            handelse = new Handelse("Beslut fattat");
        }
        if (type == 2) {
            handelse = new Handelse("Ärendet kommunicerat");
        }
        if (type == 3) {
            handelse = new Handelse("Ärendet avslutat");
        }

        handelser.add(handelse);
        return handelse;
    }

    public void addHandling(Handling handling) {
        handlingar.add(handling);
    }

    public String getHandläggare() {
        return handläggare;
    }

    public void setHandläggare(String handläggare) {
        this.handläggare = handläggare;
    }

    public Arende(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getBasInfo() {
        return "Kalle Andersson, 121212-13, Avvikelse rapport";
    }

}
