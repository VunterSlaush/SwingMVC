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
public class ViajeController {

  private static ViajeController instance;

  private ViajeController()
  {
      super();
  }

  public static ViajeController getInstance()
  {
      if(instance == null)
          instance = new ViajeController();
      return instance;
  }

  public void initCreate()
  {

  }

  public void initEdit()
  {

  }
}
