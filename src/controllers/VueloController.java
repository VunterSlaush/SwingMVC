/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.VueloDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import models.Vuelo;
import utils.TableListener;
import views.TableView;
import views.VueloView;

/**
 *
 * @author Slaush
 */
public class VueloController implements TableListener<Vuelo> {

  private static VueloController instance;

  private VueloController()
  {
      super();
  }

  public static VueloController getInstance()
  {
      if(instance == null)
          instance = new VueloController();
      return instance;
  }

  public void initCreate()
  {
      final VueloView view = new VueloView();
      view.registrar.addActionListener(new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent e) 
          {
            if(!isFieldsEmpty(view) && validAmounts(view))
            {
                Vuelo v = fieldsToVuelo(view);
                createVuelo(v);
                view.dispose();
                // TODO Success
                System.out.println("CREATE SUCCESS");
            }
              System.out.println("CREATE NOT SUCCESS"); 
                // TODO SHOW ERROR;
          }
      });
      view.setVisible(true);
  }

  private boolean isFieldsEmpty(VueloView view)
  {
      return view.destino.getText().isEmpty() || 
             view.fecha.getText().isEmpty() ||
             view.origen.getText().isEmpty() ||
             view.hora.getText().isEmpty();
       
  }
  
  private boolean validAmounts(VueloView view)
  {
      int totales = (int)view.totales.getValue();
      int turistas = (int)view.turistas.getValue();
      return totales > turistas && totales > 0;
  }
  
  private void createVuelo(Vuelo v)
  {
      VueloDAO.getInstance().insert(v);
  }
  
  private Vuelo fieldsToVuelo(VueloView view)
  {
      Vuelo t = new Vuelo(view.fecha.getText(),
                              view.hora.getText(),
                              view.origen.getText(),
                              view.destino.getText(),
                              (int)view.totales.getValue(),
                              (int)view.turistas.getValue());
      return t;
  }
  
  public void initEdit(Vuelo vuelo)
  {
      final VueloView view = new VueloView();
      view.setVuelo(vuelo);
      view.registrar.addActionListener(new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent e) 
          {
            if(!isFieldsEmpty(view) && validAmounts(view))
            {
                Vuelo v = fieldsToVuelo(view);
                v.setId(vuelo.getId());
                VueloDAO.getInstance().update(v);
                view.dispose();
                // TODO Success
                System.out.println("CREATE SUCCESS");
            }
              System.out.println("CREATE NOT SUCCESS"); 
                // TODO SHOW ERROR;
          }
      });
      view.setVisible(true);
  }

    @Override
    public void onEdit(TableView view, Vuelo selected) {
       initEdit(selected);
    }

    @Override
    public void onDelete(TableView view, Vuelo selected) {
        VueloDAO.getInstance().delete(selected);
    }
}
