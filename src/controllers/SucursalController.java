/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.SucursalDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Sucursal;
import utils.TableListener;
import views.SucursalView;
import views.TableView;

/**
 *
 * @author Slaush
 */
public class SucursalController implements TableListener<Sucursal>{
  
  private static SucursalController instance;

  private SucursalController()
  {
      super();
  }

  public static SucursalController getInstance()
  {
      if(instance == null)
          instance = new SucursalController();
      return instance;
  }
  
  public void initCreate()
  {
    final SucursalView view = new SucursalView();
    view.title.setText("Registrar Sucursal");
    view.registrar.setText("Registrar");
    view.registrar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           createSucursal(view);
        }
    });
    view.setVisible(true);
  }
  
  public void initEdit(Sucursal sucursal)
  {
    final SucursalView view = new SucursalView();
    view.title.setText("Editar Sucursal");
    view.registrar.setText("Editar");
  }
  
  public void createSucursal(SucursalView view)
  {
      String dir = view.direccion.getText();
      String tlf = view.telefono.getText();
      if (dir.isEmpty() || tlf.isEmpty()) {
          //TODO ERROR
          return;
      }
      Sucursal s = new Sucursal(dir,tlf);

      SucursalDAO.getInstance().insert(s);
      view.dispose();
      // TODO SUCCESS
     
  }

    @Override
    public void onEdit(TableView view, Sucursal selected) {
        
    }

    @Override
    public void onDelete(TableView view, Sucursal selected) {
       
    }
}
