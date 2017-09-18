/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import models.Hospedaje;

/**
 *
 * @author Slaush
 */
public class HospedajeDAO extends HibernateDAO<Hospedaje> {

 private static HospedajeDAO instance;

  private HospedajeDAO()
  {
    super();
  }

  public static HospedajeDAO getInstance()
  {
      if(instance == null)
          instance = new HospedajeDAO();
      return instance;
  }
}
