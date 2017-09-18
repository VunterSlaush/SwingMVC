/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.MainView;

/**
 *
 * @author Slaush
 */
public class MainController {
  private static MainController instance;

  private MainController()
  {
      super();
  }

  public static MainController getInstance()
  {
      if(instance == null)
          instance = new MainController();
      return instance;
  }
  
  public void initMainView()
  {
      MainView view = new MainView();
      addRegistrarActions(view);
      addAsignarActiosn(view);
      addVerActions(view);
      view.setVisible(true);
      
  }

    private void addVerActions(MainView view) {
        
    }

    private void addAsignarActiosn(MainView view) {
        
    }

    private void addRegistrarActions(MainView view) {
       
        view.admin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                AdminFormController.getInstance().initCreateAdminView();
            }
        });
        
        view.sucursal.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SucursalController.getInstance().initCreate();
            }
        });
    }
}
