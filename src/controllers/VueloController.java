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
public class VueloController {

  private static VueloController instance;

  private VueloController()
  {
      super();
  }

  public static VueloController getInstance()
  {
      if(instance == null)
          instance = new VueloController();
      return instance;
  }

  public void initCreate()
  {

  }

  public void initEdit()
  {

  }
}
