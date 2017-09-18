/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import models.Hotel;

/**
 *
 * @author Slaush
 */
public class HotelDAO extends HibernateDAO<Hotel>{
  private static HotelDAO instance;

  private HotelDAO()
  {
    super();
  }

  public static HotelDAO getInstance()
  {
      if(instance == null)
          instance = new HotelDAO();
      return instance;
  }
}
