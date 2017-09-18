/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import models.Vuelo;

/**
 *
 * @author Slaush
 */
public class VueloDAO extends HibernateDAO<Vuelo> {
  private static VueloDAO instance;

  private VueloDAO()
  {
    super();
  }

  public static VueloDAO getInstance()
  {
      if(instance == null)
          instance = new VueloDAO();
      return instance;
  }
}
