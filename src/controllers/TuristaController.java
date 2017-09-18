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
public class TuristaController {

  private static TuristaController instance;

  private TuristaController()
  {
      super();
  }

  public static TuristaController getInstance()
  {
      if(instance == null)
          instance = new TuristaController();
      return instance;
  }

  public void initCreate()
  {

  }

  public void initEdit()
  {

  }
}
