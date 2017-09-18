/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.AdminDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import models.Admin;
import views.LoginView;

/**
 *
 * @author Slaush
 */
public class LoginController {
  
  private static LoginController instance;

  private LoginController()
  {
      super();
  }

  public static LoginController getInstance()
  {
      if(instance == null)
          instance = new LoginController();
      return instance;
  }
  
  public boolean login(String username, String password)
  {   
      HashMap<String, Object> hash = new HashMap<>();
      hash.put("username", username);
      hash.put("password", password);
      List<Admin> admins = AdminDAO.getInstance().getAll();
      return admins.size() > 0;
  }
  
  public void putLoginView()
  {
      final LoginView view = new LoginView();
      view.setLoginButtonAction(new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent e) 
          {
            if(login(view.ciField.getText(),view.passwordField.getText()))
            {
                view.dispose();
                MainController.getInstance().initMainView();
            }
                
          }
      });
      view.setVisible(true);
  }
}
