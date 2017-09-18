package models;
// Generated 17-sep-2017 20:56:56 by Hibernate Tools 4.3.1


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Hotel generated by hbm2java
 */
@Entity
@Table(name="hoteles"
    ,schema="dbo"
    ,catalog="Viajes"
)
public class Hotel  implements java.io.Serializable {


     private String id;
     private String nombre;
     private String direccion;
     private String ciudad;
     private String telefono;
     private Integer disponibilidad;
     
     public Hotel() {
        }

	
    public Hotel(String id) {
        this.id = id;
    }
    public Hotel(String id, String nombre, String direccion, String ciudad, String telefono, Integer disponibilidad) {
       this.id = id;
       this.nombre = nombre;
       this.direccion = direccion;
       this.ciudad = ciudad;
       this.telefono = telefono;
       this.disponibilidad = disponibilidad;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false, length=36)
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    
    @Column(name="nombre")
    public Serializable getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="direccion")
    public Serializable getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
    @Column(name="ciudad")
    public Serializable getCiudad() {
        return this.ciudad;
    }
    
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    
    @Column(name="telefono")
    public Serializable getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
    @Column(name="disponibilidad")
    public Integer getDisponibilidad() {
        return this.disponibilidad;
    }
    
    public void setDisponibilidad(Integer disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

}


