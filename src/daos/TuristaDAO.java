/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import models.Turista;

/**
 *
 * @author Slaush
 */
public class TuristaDAO extends HibernateDAO<Turista>{
     private static TuristaDAO instance;

  private TuristaDAO()
  {
    super();
  }

  public static TuristaDAO getInstance()
  {
      if(instance == null)
          instance = new TuristaDAO();
      return instance;
  }
}
