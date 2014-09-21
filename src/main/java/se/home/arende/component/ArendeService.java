/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.home.arende.component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import se.home.arende.domain.Arende;
import se.home.arende.domain.Handelse;
import se.home.arende.domain.Handling;

/**
 *
 * @author jonas
 */
public class ArendeService {

    private static List<Arende> aranden = new ArrayList();

    
    public static UUID registrera(String dokument,int typAvHandling){
        UUID id = UUID.randomUUID();
        Arende arende = new Arende(id);
        Handelse handelse = arende.rapporteraFramsteg(0);        
        
        Handling handling = handelse.createHandling(typAvHandling);
        handling.setDokument(dokument);
        arende.addHandling(handling);
        
        aranden.add(arende);
        
        return arende.getId();
    }
    
        public static void besluta(UUID id, String beslut){
        Arende arende = getArende(id);
        Handelse handelse = arende.rapporteraFramsteg(1);                
        
        Handling handling = handelse.createHandling(0);
        handling.setDokument(beslut);
        arende.addHandling(handling);       
        
        return;
    }
    
    public static UUID skapaNyttArande() {
        UUID id = UUID.randomUUID();
        Arende arande = new Arende(id);
        aranden.add(arande);
        return arande.getId();
    }

    public static List<String> listaAranden() {
        List<String> idn = new ArrayList();
        for (Arende arande : aranden) {
            idn.add(arande.getId().toString());
        }
        return idn;
    }

    public static void setHandläggareForÄrandet(UUID id, String signatur) {
        for (Arende arende : aranden) {
            if (arende.getId().equals(id)) {
                arende.setHandläggare(signatur);
            }
        }
    }

    public static String getHandläggareFörÄrendet(UUID id) {
        for (Arende arende : aranden) {
            if (arende.getId().equals(id)) {
                return arende.getHandläggare();
            }
        }
        return null;
    }

    public static String getgrundInfo(UUID id) {
        for (Arende arende : aranden) {
            if (arende.getId().equals(id)) {
                return arende.getBasInfo();
            }
        }
        return null;
    }
        public static Arende getArende(UUID id) {
        for (Arende arende : aranden) {
            if (arende.getId().equals(id)) {
                return arende;
            }
        }
        return null;
    }
    

}
