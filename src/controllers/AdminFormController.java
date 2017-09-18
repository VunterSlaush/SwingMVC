/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.AdminDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Admin;
import org.hibernate.exception.ConstraintViolationException;
import utils.TableListener;
import views.LoginView;
import views.TableView;

/**
 *
 * @author Slaush
 */
public class AdminFormController implements TableListener<Admin> {
  private static AdminFormController instance;

  private AdminFormController()
  {
      super();
  }

  public static AdminFormController getInstance()
  {
      if(instance == null)
          instance = new AdminFormController();
      return instance;
  }
  
  public void initCreateAdminView()
  {
     final LoginView view = new LoginView();
     view.setTitle("Registrar Administrador");
     view.setButtonTitle("Registrar");
     view.setLoginButtonAction(new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent e) 
          {
             createAdmin(view); 
          }
      });
      view.setVisible(true);
  }
  
  private void createAdmin(LoginView view)
  {
      String username = view.ciField.getText();
      String password = view.passwordField.getText();
      if (username.isEmpty() || password.isEmpty()) 
      {
          // TODO error 
          return;
      }
      
      Admin admin = new Admin(username,password);
      try
      {
        AdminDAO.getInstance().insert(admin);
        view.dispose();
      }
      catch(ConstraintViolationException ex)
      {
          // TODO Error
         return; 
      }
      
      // TODO Success 
  }

    @Override
    public void onEdit(TableView view, Admin selected) {
       
    }

    @Override
    public void onDelete(TableView view, Admin selected) {
        
    }
}
