/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.HotelDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Hotel;
import utils.TableListener;
import views.HotelView;
import views.TableView;

/**
 *
 * @author Slaush
 */
public class HotelController implements TableListener<Hotel> {

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
        HotelView view = new HotelView();
        view.registrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                if(!isFieldsEmpty(view))
                {
                    Hotel t = fieldsToHotel(view);
                    createHotel(t);
                    view.dispose();
                    // TODO Success
                    System.out.println("CREATE SUCCESS");
                }
                  System.out.println("CREATE NOT SUCCESS"); 
                    // TODO SHOW ERROR;
            }
        });
        view.setVisible(true);
    }
    
    private boolean isFieldsEmpty(HotelView view)
    {
        return view.nombre.getText().isEmpty() || 
               view.ciudad.getText().isEmpty() ||
               view.direccion.getText().isEmpty() ||
               view.telefono.getText().isEmpty();
    }
  
    private Hotel fieldsToHotel(HotelView view)
    {
        Hotel t = new Hotel(view.nombre.getText(),
                                view.direccion.getText(),
                                view.ciudad.getText(),
                                view.telefono.getText(),
                                (int)view.plazas.getValue());
        return t;
    }
    
    private void createHotel(Hotel hotel)
    {
        HotelDAO.getInstance().insert(hotel);
    }
    
    public void initEdit()
    {

    }

    @Override
    public void onEdit(TableView view, Hotel selected) {
        
    }

    @Override
    public void onDelete(TableView view, Hotel selected) {
        
    }
}
