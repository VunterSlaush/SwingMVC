/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import models.Admin;

/**
 *
 * @author Slaush
 */
public class AdminDAO extends HibernateDAO<Admin> {
    
 private static AdminDAO instance;

  private AdminDAO()
  {
    super();
  }

  public static AdminDAO getInstance()
  {
      if(instance == null)
          instance = new AdminDAO();
      return instance;
  }
}
