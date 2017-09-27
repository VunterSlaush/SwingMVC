package models;
// Generated 17-sep-2017 20:56:56 by Hibernate Tools 4.3.1


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Vuelos generated by hbm2java
 */
@Entity
@Table(name="vuelos"
    ,schema="dbo"
    ,catalog="Viajes"
)
public class Vuelo  implements java.io.Serializable {


     private String id;

     private String fecha;
     private String hora;
     private String origen;
     private String destino;
     private int puestos;
     private int puestosTuristas;
     
     public static final String [] properties = {"fecha","hora","origen","destino","puestos","puestosTuristas"};
     public static final String [] asColumns = {"Fecha","Hora","Origen","Destino","Puestos Totales","Puestos de Turista"};

    public Vuelo() {
    }

	
    public Vuelo( String fecha, String hora, String origen, String destino, int puestos, int puestosTuristas) {
        this.id = UUID.randomUUID().toString();
        this.fecha = fecha;
        this.hora = hora;
        this.origen = origen;
        this.destino = destino;
        this.puestos = puestos;
        this.puestosTuristas = puestosTuristas;
    }

   
     @GenericGenerator(name="generator", strategy="foreign", parameters=@Parameter(name="property", value="vuelos"))@Id @GeneratedValue(generator="generator")

    @Column(name="id", unique=true, nullable=false, length=36)
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fecha", nullable=false, length=10)
    public String getFecha() {
        return this.fecha.trim();
    }
    
    public void setFecha(String fecha) {
        Date date = new Date(fecha);
        String newstring = new SimpleDateFormat("dd/MM/yyyy").format(date);
        this.fecha = newstring;
    }

    
    @Column(name="hora", nullable=false, length=10)
    public String getHora() {
        return this.hora.trim();
    }
    
    public void setHora(String hora) {
        this.hora = hora;
    }

    
    @Column(name="origen", nullable=false)
    public String getOrigen() {
        return this.origen.trim();
    }
    
    public void setOrigen(String origen) {
        this.origen = origen;
    }

    
    @Column(name="destino", nullable=false)
    public String getDestino() {
        return this.destino.trim();
    }
    
    public void setDestino(String destino) {
        this.destino = destino;
    }

    
    @Column(name="puestos", nullable=false)
    public int getPuestos() {
        return this.puestos;
    }
    
    public void setPuestos(int puestos) {
        this.puestos = puestos;
    }

    
    @Column(name="puestos_turistas", nullable=false)
    public int getPuestosTuristas() {
        return this.puestosTuristas;
    }
    
    public void setPuestosTuristas(int puestosTuristas) {
        this.puestosTuristas = puestosTuristas;
    }


}


