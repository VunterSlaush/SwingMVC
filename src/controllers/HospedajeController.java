/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.HospedajeDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import models.Hospedaje;
import models.Hotel;
import models.Turista;
import utils.Functions;
import utils.TableListener;
import views.HospedajeView;
import views.TableView;

/**
 *
 * @author Slaush
 */
public class HospedajeController implements TableListener<Hospedaje> {

  private static HospedajeController instance;

  private HospedajeController()
  {
      super();
  }

  public static HospedajeController getInstance()
  {
      if(instance == null)
          instance = new HospedajeController();
      return instance;
  }

  public void initCreate()
  {
      HospedajeView view = new HospedajeView();
      view.hotel.removeAllItems();
      view.turista.removeAllItems();
      List<Turista> turistas = Functions.loadTuristasCombo(view.turista);
      List<Hotel> hoteles = Functions.loadHotelesCombo(view.hotel);
      
      view.registrar.addActionListener(new ActionListener() 
      {

          @Override
          public void actionPerformed(ActionEvent e) 
          {
              if(!emptyFieldOrInvalid(view))
              {
                  Hospedaje h = fieldsToHospedaje(view, turistas, hoteles);
                  HospedajeDAO.getInstance().insert(h); // TODO TRY + CATCH
                  view.dispose();
                  //TODO Success
              }
              // TODO ERROR
          }

      });
      view.setVisible(true);
  }
  
  private boolean emptyFieldOrInvalid(HospedajeView view) // Todo validar que llegada no sea mayor que salida? 
  {
        return view.llegada.getText().isEmpty() ||
               view.partida.getText().isEmpty() ||
               view.hotel.getItemCount() == 0 ||
               view.turista.getItemCount() == 0;
  }
  
  private Hospedaje fieldsToHospedaje(HospedajeView view, List<Turista> turistas, 
                                      List<Hotel> hoteles)
  {
      return new Hospedaje(hoteles.get(view.hotel.getSelectedIndex()),
                            turistas.get(view.turista.getSelectedIndex()),
                           view.llegada.getText(),
                           view.partida.getText()
                        );
  }
  
  
  public void initEdit()
  {

  }

    @Override
    public void onEdit(TableView view, Hospedaje selected) {
        
    }

    @Override
    public void onDelete(TableView view, Hospedaje selected) {
        HospedajeDAO.getInstance().delete(selected);
    }
}
