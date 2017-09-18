/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import views.TableView;

/**
 *
 * @author user
 */
public interface TableListener<T> {
    void onEdit(TableView view, T selected);
    void onDelete(TableView view, T selected);
}
