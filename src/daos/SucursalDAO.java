/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import models.Sucursal;

/**
 *
 * @author Slaush
 */
public class SucursalDAO extends HibernateDAO<Sucursal> {

 private static SucursalDAO instance;

  private SucursalDAO()
  {
    super();
  }

  public static SucursalDAO getInstance()
  {
      if(instance == null)
          instance = new SucursalDAO();
      return instance;
  }
}
