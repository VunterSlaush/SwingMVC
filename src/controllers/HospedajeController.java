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
public class HospedajeController {

  private static HospedajeController instance;

  private HospedajeController()
  {
      super();
  }

  public static HospedajeController getInstance()
  {
      if(instance == null)
          instance = new HospedajeController();
      return instance;
  }

  public void initCreate()
  {

  }

  public void initEdit()
  {

  }
}
