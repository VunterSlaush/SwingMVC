/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.TuristaDAO;
import daos.VueloDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import models.Turista;
import models.Viaje;
import models.Vuelo;
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
      final List<Turista> turistas = loadTuristasToView(view);
      final List<Vuelo> vuelos = loadVuelosToView(view);
      view.registrar.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              // TODO !! 
          }
      });
  }
  
  private List<Turista> loadTuristasToView(ViajeView view)
  {
      List<Turista> turistas = TuristaDAO.getInstance().getAll();
      for (Turista t : turistas) {
          view.turista.addItem(t.getNombre() + " " +t.getApellido());
      }
      return turistas;
  }
  
  private List<Vuelo> loadVuelosToView(ViajeView view)
  {
      List<Vuelo> vuelos = VueloDAO.getInstance().getAll();
      for (Vuelo t : vuelos) {
          view.turista.addItem(t.getOrigen() + " a " +t.getDestino()+" - "+t.getFecha()+" "+t.getHora());
      }
      return vuelos;
  }
  
  public void initEdit()
  {

  }

    @Override
    public void onEdit(TableView view, Viaje selected) {
       
    }

    @Override
    public void onDelete(TableView view, Viaje selected) {
        
    }
}
