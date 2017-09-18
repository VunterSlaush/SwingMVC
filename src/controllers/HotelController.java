/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author Slaush
 */
public class HotelController {

  private static HotelController instance;

  private HotelController()
  {
      super();
  }

  public static HotelController getInstance()
  {
      if(instance == null)
          instance = new HotelController();
      return instance;
  }

  public void initCreate()
  {

  }

  public void initEdit()
  {

  }
}
