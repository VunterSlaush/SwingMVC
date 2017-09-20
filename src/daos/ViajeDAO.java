/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import models.Viaje;

/**
 *
 * @author Slaush
 */
public class ViajeDAO extends HibernateDAO<Viaje> {
  private static ViajeDAO instance;

  private ViajeDAO()
  {
    super();
  }

  public static ViajeDAO getInstance()
  {
      if(instance == null)
          instance = new ViajeDAO();
      return instance;
  }
}
