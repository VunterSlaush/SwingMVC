/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.SucursalDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
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
    view.setSucursal(sucursal);
    view.registrar.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (emptyFields(view)) {
                JOptionPane.showMessageDialog(null, "Error al editar", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            Sucursal s = fieldsToSucursal(view);
            s.setId(sucursal.getId());
            SucursalDAO.getInstance().update(s);
            view.dispose();
            JOptionPane.showMessageDialog(null, "Edición de sucursal con éxito", "Registro con éxito", JOptionPane.INFORMATION_MESSAGE); 
        }
    });
    view.setVisible(true);
  }
  
  public void createSucursal(SucursalView view)
  {
      if (!emptyFields(view)) {
          JOptionPane.showMessageDialog(null, "Error al registrar", "ERROR", JOptionPane.ERROR_MESSAGE);
          return;
      }

      Sucursal s = fieldsToSucursal(view);
      SucursalDAO.getInstance().insert(s);
      view.dispose();
      JOptionPane.showMessageDialog(null, "Registro de sucursal con éxito", "Registro con éxito", JOptionPane.INFORMATION_MESSAGE); 
     
  }
  private Sucursal fieldsToSucursal(SucursalView view)
  {
    return new Sucursal(view.direccion.getText(),view.telefono.getText());
  }
  
  private boolean emptyFields(SucursalView view)
  {
      return view.direccion.getText().isEmpty() || view.telefono.getText().isEmpty();
  }
  
    @Override
    public void onEdit(TableView view, Sucursal selected) {
        initEdit(selected);
    }

    @Override
    public void onDelete(TableView view, Sucursal selected) {
       SucursalDAO.getInstance().delete(selected);
    }
}
