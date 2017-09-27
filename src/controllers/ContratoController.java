/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.ContratoDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import models.Contrato;
import models.Sucursal;
import models.Turista;
import utils.Functions;
import utils.TableListener;
import views.ContratoView;
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
      ContratoView view = new ContratoView();
      view.turista.removeAllItems();
      view.sucursal.removeAllItems();
      List<Turista> turistas = Functions.loadTuristasCombo(view.turista);
      List<Sucursal> sucursales = Functions.loadSucursalesCombo(view.sucursal);
      view.registrar.addActionListener(new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent e) 
          {
              Contrato c = fieldsToContrato(view, turistas, sucursales);
              ContratoDAO.getInstance().insert(c);// Todo add Try and Catch
              view.dispose();
          }
      });
      view.setVisible(true);
  }
  
  private Contrato fieldsToContrato(ContratoView view, List<Turista> turistas, 
                           List<Sucursal> sucursales)
  {
      return new Contrato(sucursales.get(view.sucursal.getSelectedIndex()),
                          turistas.get(view.turista.getSelectedIndex()));
  }
  
  
  public void initEdit()
  {

  }

    @Override
    public void onEdit(TableView view, Contrato selected) {
        
    }

    @Override
    public void onDelete(TableView view, Contrato selected) {
        ContratoDAO.getInstance().delete(selected);
      
        JOptionPane.showMessageDialog(null, "Se eliminó con éxito el contrato", "Eliminado con éxito", JOptionPane.INFORMATION_MESSAGE); 
    }
}
