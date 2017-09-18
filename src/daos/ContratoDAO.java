/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import models.Contrato;

/**
 *
 * @author Slaush
 */
public class ContratoDAO extends HibernateDAO<Contrato> {

 private static ContratoDAO instance;

  private ContratoDAO()
  {
    super();
  }

  public static ContratoDAO getInstance()
  {
      if(instance == null)
          instance = new ContratoDAO();
      return instance;
  }
}
