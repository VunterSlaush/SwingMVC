package models;
// Generated 17-sep-2017 20:56:56 by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Hospedaje generated by hbm2java
 */
@Entity
@Table(name="hospedajes"
    ,schema="dbo"
    ,catalog="Viajes"
)
public class Hospedaje  implements java.io.Serializable {


     private HospedajeId id;
     private Hotel hotel;
     private Turista turista;
     private Date llegada;
     private Date partida;

    public Hospedaje() {
    }

    public Hospedaje(Hotel hotel, Turista turista, Date llegada, Date partida) {
       this.id = new HospedajeId(turista.getId(),hotel.getId());
       this.hotel = hotel;
       this.turista = turista;
       this.llegada = llegada;
       this.partida = partida;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="turista", column=@Column(name="turista", nullable=false, length=36) ), 
        @AttributeOverride(name="hotel", column=@Column(name="hotel", nullable=false, length=36) ) } )
    public HospedajeId getId() {
        return this.id;
    }
    
    public void setId(HospedajeId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="hotel", nullable=false, insertable=false, updatable=false)
    public Hotel getHotel() {
        return this.hotel;
    }
    
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="turista", nullable=false, insertable=false, updatable=false)
    public Turista getTurista() {
        return this.turista;
    }
    
    public void setTurista(Turista turista) {
        this.turista = turista;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="llegada", nullable=false, length=10)
    public Date getLlegada() {
        return this.llegada;
    }
    
    public void setLlegada(Date llegada) {
        this.llegada = llegada;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="partida", nullable=false, length=10)
    public Date getPartida() {
        return this.partida;
    }
    
    public void setPartida(Date partida) {
        this.partida = partida;
    }




}

