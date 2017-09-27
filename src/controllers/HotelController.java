/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.HotelDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
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
                    JOptionPane.showMessageDialog(null, "Registro de hotel con éxito", "Registro con éxito", JOptionPane.INFORMATION_MESSAGE); 
                    System.out.println("CREATE SUCCESS");
                }
                  System.out.println("CREATE NOT SUCCESS"); 
                  JOptionPane.showMessageDialog(null, "Error al registrar", "ERROR", JOptionPane.ERROR_MESSAGE);
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
    
    public void initEdit(Hotel hotel)
    {
        HotelView view = new HotelView();
        view.setHotel(hotel);
        view.registrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                if(!isFieldsEmpty(view))
                {
                    Hotel t = fieldsToHotel(view);
                    t.setId(hotel.getId());
                    HotelDAO.getInstance().update(t);
                    view.dispose();
                    JOptionPane.showMessageDialog(null, "Edición con éxito", "Edición con éxito", JOptionPane.INFORMATION_MESSAGE); 
                    System.out.println("CREATE SUCCESS");
                }
                  System.out.println("CREATE NOT SUCCESS"); 
                  JOptionPane.showMessageDialog(null, "Error al editar", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });
        view.setVisible(true);
    }

    @Override
    public void onEdit(TableView view, Hotel selected) {
        initEdit(selected);
    }

    @Override
    public void onDelete(TableView view, Hotel selected) {
        HotelDAO.getInstance().delete(selected);
    }
}
