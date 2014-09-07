/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.home.arande;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author jonas
 */
public class ArendeService {

    private static List<Arande> aranden = new ArrayList();

    public static UUID skapaNyttArande() {
        UUID id = UUID.randomUUID();
        Arande arande = new Arande(id);
        aranden.add(arande);
        return arande.getId();
    }

    public static List<String> listaAranden() {
        List<String> idn = new ArrayList();
        for (Arande arande : aranden) {
            idn.add(arande.getId().toString());
        }
        return idn;
    }

    public static void setHandläggareForÄrandet(UUID id, String signatur) {
        for (Arande arende : aranden) {
            if (arende.getId().equals(id)) {
                arende.setHandläggare(signatur);
            }
        }
    }

    public static String getHandläggareFörÄrendet(UUID id) {
        for (Arande arende : aranden) {
            if (arende.getId().equals(id)) {
                return arende.getHandläggare();
            }
        }
        return null;
    }

}
