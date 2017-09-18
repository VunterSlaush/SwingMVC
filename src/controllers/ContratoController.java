/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.Contrato;
import utils.TableListener;
import views.TableView;

/**
 *
 * @author Slaush
 */
public class ContratoController implements TableListener<Contrato> {

  private static ContratoController instance;

  private ContratoController()
  {
      super();
  }

  public static ContratoController getInstance()
  {
      if(instance == null)
          instance = new ContratoController();
      return instance;
  }

  public void initCreate()
  {

  }

  public void initEdit()
  {

  }

    @Override
    public void onEdit(TableView view, Contrato selected) {
        
    }

    @Override
    public void onDelete(TableView view, Contrato selected) {
        
    }
}
