/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import daos.HotelDAO;
import daos.SucursalDAO;
import daos.TuristaDAO;
import daos.VueloDAO;
import java.util.List;
import javax.swing.JComboBox;
import models.Hotel;
import models.Sucursal;
import models.Turista;
import models.Vuelo;

/**
 *
 * @author Slaush
 */
public class Functions {
    
    
    public static List<Turista> loadTuristasCombo(JComboBox combo)
    {
        List<Turista> turistas = TuristaDAO.getInstance().getAll();
        for (Turista t : turistas) {
            combo.addItem(t.getNombre() + " " +t.getApellido());
        }
        return turistas;
    }

    public static List<Vuelo> loadVuelosToCombo(JComboBox combo)
    {
        List<Vuelo> vuelos = VueloDAO.getInstance().getAll();
        for (Vuelo t : vuelos) {
            combo.addItem(t.getOrigen() + " a " +t.getDestino()+" - "+t.getFecha()+" "+t.getHora());
        }
        return vuelos;
    }

    public static List<Hotel> loadHotelesCombo(JComboBox combo) {
        List<Hotel> hoteles = HotelDAO.getInstance().getAll();
        for (Hotel t : hoteles) {
            combo.addItem(t.getNombre());
        }
        return hoteles;
    }

    public static List<Sucursal> loadSucursalesCombo(JComboBox combo) {
        List<Sucursal> sucursales = SucursalDAO.getInstance().getAll();
        for (Sucursal t : sucursales) {
            combo.addItem(t.getDireccion());
        }
        return sucursales;       
    }
}
