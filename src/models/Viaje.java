package models;
// Generated 17-sep-2017 20:56:56 by Hibernate Tools 4.3.1


import java.io.Serializable;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Viaje generated by hbm2java
 */
@Entity
@Table(name="viajes"
    ,schema="dbo"
    ,catalog="Viajes"
)
public class Viaje  implements java.io.Serializable {


     private ViajesId id;
     private Turista turistas;
     private Vuelo vuelo;
     private Serializable clase;

    public Viaje() {
    }

    public Viaje(ViajesId id, Turista turistas, Vuelo vuelo, Serializable clase) {
       this.id = id;
       this.turistas = turistas;
       this.vuelo = vuelo;
       this.clase = clase;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="turista", column=@Column(name="turista", nullable=false, length=36) ), 
        @AttributeOverride(name="vuelo", column=@Column(name="vuelo", nullable=false, length=36) ) } )
    public ViajesId getId() {
        return this.id;
    }
    
    public void setId(ViajesId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="turista", nullable=false, insertable=false, updatable=false)
    public Turista getTuristas() {
        return this.turistas;
    }
    
    public void setTuristas(Turista turistas) {
        this.turistas = turistas;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="vuelo", nullable=false, insertable=false, updatable=false)
    public Vuelo getVuelos() {
        return this.vuelo;
    }
    
    public void setVuelos(Vuelo vuelos) {
        this.vuelo = vuelos;
    }

    
    @Column(name="clase", nullable=false)
    public Serializable getClase() {
        return this.clase;
    }
    
    public void setClase(Serializable clase) {
        this.clase = clase;
    }




}


