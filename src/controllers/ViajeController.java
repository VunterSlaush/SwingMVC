/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.Viaje;
import utils.TableListener;
import views.TableView;

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
