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
public class ContratoController {

  private static ContratoController instance;

  private ContratoController()
  {
      super();
  }

  public static ContratoController getInstance()
  {
      if(instance == null)
          instance = new ContratoController();
      return instance;
  }

  public void initCreate()
  {

  }

  public void initEdit()
  {

  }
}
