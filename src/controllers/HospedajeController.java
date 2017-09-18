/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.Hospedaje;
import utils.TableListener;
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

  }

  public void initEdit()
  {

  }

    @Override
    public void onEdit(TableView view, Hospedaje selected) {
        
    }

    @Override
    public void onDelete(TableView view, Hospedaje selected) {
        
    }
}
