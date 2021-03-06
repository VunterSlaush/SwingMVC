/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import ca.odell.glazedlists.BasicEventList;
import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.GlazedLists;
import ca.odell.glazedlists.gui.TableFormat;
import ca.odell.glazedlists.swing.EventTableModel;
import daos.AdminDAO;
import daos.ContratoDAO;
import daos.HospedajeDAO;
import daos.HotelDAO;
import daos.SucursalDAO;
import daos.TuristaDAO;
import daos.ViajeDAO;
import daos.VueloDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import models.Admin;
import models.Contrato;
import models.Hospedaje;
import models.Hotel;
import models.Sucursal;
import models.Turista;
import models.Viaje;
import models.Vuelo;
import utils.TableListener;
import views.MainView;
import views.TableView;

/**
 *
 * @author Slaush
 */
public class MainController {
  private static MainController instance;

  private MainController()
  {
      super();
  }

  public static MainController getInstance()
  {
      if(instance == null)
          instance = new MainController();
      return instance;
  }
  
  public void initMainView()
  {
      MainView view = new MainView();
      addRegistrarActions(view);
      addAsignarActions(view);
      addVerActions(view);
      view.setVisible(true);
  }

    private void addVerActions(MainView view) {
        
        view.turistas.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
               showTable(Turista.class,
                         Turista.properties,
                         Turista.asColumns,
                         TuristaDAO.getInstance().getAll(),
                         TuristaController.getInstance());     
            }
        });
        
        view.admins.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
               showTable(Admin.class,
                         Admin.properties,
                         Admin.asColumns,
                         AdminDAO.getInstance().getAll(),
                         AdminFormController.getInstance());     
            }
        });
        
        view.vuelos.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
               showTable(Vuelo.class,
                         Vuelo.properties,
                         Vuelo.asColumns,
                         VueloDAO.getInstance().getAll(),
                         VueloController.getInstance());     
            }
        });
        
        view.hoteles.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
               showTable(Hotel.class,
                         Hotel.properties,
                         Hotel.asColumns,
                         HotelDAO.getInstance().getAll(),
                         HotelController.getInstance());     
            }
        });
        
        view.sucursales.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
               showTable(Sucursal.class,
                         Sucursal.properties,
                         Sucursal.asColumns,
                         SucursalDAO.getInstance().getAll(),
                         SucursalController.getInstance());     
            }
        });
        
        view.hospedajes.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
               showTable(Hospedaje.class,
                         Hospedaje.properties,
                         Hospedaje.asColumns,
                         HospedajeDAO.getInstance().getAll(),
                         HospedajeController.getInstance());     
            }
        });
        
        
        view.contrataciones.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
               showTable(Contrato.class,
                         Contrato.properties,
                         Contrato.asColumns,
                         ContratoDAO.getInstance().getAll(),
                         ContratoController.getInstance());     
            }
        });
        
        view.viajes.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
               showTable(Viaje.class,
                         Viaje.properties,
                         Viaje.asColumns,
                         ViajeDAO.getInstance().getAll(),
                         ViajeController.getInstance());     
            }
        });
        
        
       
    }

    private void addAsignarActions(MainView view) {
        
        view.hospedaje.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                HospedajeController.getInstance().initCreate();
            }
        });
        
        view.contrato.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ContratoController.getInstance().initCreate();
            }
        });
        
        view.viaje.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ViajeController.getInstance().initCreate();
            }
        });
        
    }

    private void addRegistrarActions(MainView view) {
       
        view.admin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                AdminFormController.getInstance().initCreateAdminView();
            }
        });
        
        view.sucursal.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SucursalController.getInstance().initCreate();
            }
        });
        
         view.Vuelo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                VueloController.getInstance().initCreate();
            }
        });
        
        view.turista.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                TuristaController.getInstance().initCreate();
            }
        });
        
        view.hotel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                HotelController.getInstance().initCreate();
            }
        });
    }
    
    
    private void showTable(Class c, 
                           String [] properties, 
                           String [] columns, 
                           List data, 
                           TableListener listener)
    {
        
        EventList list = new BasicEventList();
        list.addAll(data);
        TableFormat tableFormat = GlazedLists.tableFormat(c,properties, columns);
        EventTableModel tableModel = new EventTableModel(list, tableFormat);
        final TableView tableView = new TableView();
        tableView.table.setModel(tableModel);
        
        tableView.editar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selected = tableView.table.getSelectedRow();
                if (selected >= 0)
                {
                    tableView.dispose();
                    listener.onEdit(tableView, list.get(selected));
                } 
                    
            }
        });
        
        tableView.eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selected = tableView.table.getSelectedRow();
                if (selected >= 0)
                {
                    listener.onDelete(tableView, list.get(selected));
                    list.remove(selected);
                } 
                    
               
            }
        });
        tableView.setVisible(true);
    }
}
