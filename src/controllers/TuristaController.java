/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.TuristaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Turista;
import utils.TableListener;
import views.TableView;
import views.TuristaView;

/**
 *
 * @author Slaush
 */
public class TuristaController implements TableListener<Turista> {

  private static TuristaController instance;

  private TuristaController()
  {
    super();
  }

  public static TuristaController getInstance()
  {
      if(instance == null)
          instance = new TuristaController();
      return instance;
  }

  public void initCreate()
  {
      final TuristaView view = new TuristaView();
      view.registrar.addActionListener(new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent e) 
          {
            if(!isFieldsEmpty(view))
            {
                Turista t = fieldsToTurista(view);
                createTurista(t);
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


  
  private boolean isFieldsEmpty(TuristaView view)
  {
      return view.nombre.getText().isEmpty() || 
             view.apellido.getText().isEmpty() ||
             view.direccion.getText().isEmpty() ||
             view.telefono.getText().isEmpty();
  }
  
  private Turista fieldsToTurista(TuristaView view)
  {
      Turista t = new Turista(view.nombre.getText(),
                              view.apellido.getText(),
                              view.direccion.getText(),
                              view.telefono.getText());
      return t;
  }
  
  private void createTurista(Turista t)
  {
      TuristaDAO.getInstance().insert(t);
  }
  
  public void initEdit(Turista turista)
  {
      TuristaView view = new TuristaView();
      view.setTurista(turista);
      view.registrar.addActionListener(new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent e) 
          {
            if(!isFieldsEmpty(view))
            {
                Turista t = fieldsToTurista(view);
                t.setId(turista.getId());
                TuristaDAO.getInstance().update(t);
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
  public void onEdit(TableView view, Turista selected) {
     initEdit(selected);
  }

    @Override
  public void onDelete(TableView view, Turista selected) 
  {
      TuristaDAO.getInstance().delete(selected);
  }

}
