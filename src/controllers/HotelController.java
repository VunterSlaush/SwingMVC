/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.Hotel;
import utils.TableListener;
import views.TableView;

/**
 *
 * @author Slaush
 */
public class HotelController implements TableListener<Hotel> {

  private static HotelController instance;

  private HotelController()
  {
      super();
  }

  public static HotelController getInstance()
  {
      if(instance == null)
          instance = new HotelController();
      return instance;
  }

  public void initCreate()
  {

  }

  public void initEdit()
  {

  }

    @Override
    public void onEdit(TableView view, Hotel selected) {
        
    }

    @Override
    public void onDelete(TableView view, Hotel selected) {
        
    }
}
