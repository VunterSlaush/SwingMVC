/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.TuristaDAO;
import daos.ViajeDAO;
import daos.VueloDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import models.Turista;
import models.Viaje;
import models.Vuelo;
import utils.Functions;
import utils.TableListener;
import views.TableView;
import views.ViajeView;

/**
 *
 * @author Slaush
 */
public class ViajeController implements TableListener<Viaje> {

    private static ViajeController instance;

    private ViajeController()
    {
        super();
    }

    public static ViajeController getInstance()
    {
        if(instance == null)
            instance = new ViajeController();
        return instance;
    }

    public void initCreate()
    {
        ViajeView view = new ViajeView();
        view.turista.removeAllItems();
        view.vuelo.removeAllItems();
        view.clase_primera.setSelected(true);
        final List<Turista> turistas = Functions.loadTuristasCombo(view.turista);
        final List<Vuelo> vuelos = Functions.loadVuelosToCombo(view.vuelo);
        view.registrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Viaje v = fieldsToViaje(view,turistas,vuelos);
                ViajeDAO.getInstance().insert(v);
                view.dispose();
                //TODO success
            }
        });
        view.setVisible(true);
    }
    
    private Viaje fieldsToViaje(ViajeView view, List<Turista> turistas, 
                                List<Vuelo> vuelos)
    {
        String clase = view.clase_primera.isSelected() ? "primera" : "turista";
        return new Viaje(turistas.get(view.turista.getSelectedIndex()),
                         vuelos.get(view.vuelo.getSelectedIndex()),
                         clase);
    }
    

    public void initEdit()
    {

    }

    @Override
    public void onEdit(TableView view, Viaje selected) {
       
    }

    @Override
    public void onDelete(TableView view, Viaje selected) {
        ViajeDAO.getInstance().delete(selected);
    }
}
