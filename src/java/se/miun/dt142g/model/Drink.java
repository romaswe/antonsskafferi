/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.miun.dt142g.model;


import java.io.Serializable;
import java.nio.charset.Charset;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author oskar
 */
@Named
@RequestScoped
@Entity
@Table(name = "DRINK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Drink.findAll", query = "SELECT d FROM Drink d"),
    @NamedQuery(name = "Drink.findByDrinkid", query = "SELECT d FROM Drink d WHERE d.drinkid = :drinkid"),
    @NamedQuery(name = "Drink.findByDrinkname", query = "SELECT d FROM Drink d WHERE d.drinkname = :drinkname"),
    @NamedQuery(name = "Drink.findByDrinkprice", query = "SELECT d FROM Drink d WHERE d.drinkprice = :drinkprice"),
    @NamedQuery(name = "Drink.findByDrinktype", query = "SELECT d FROM Drink d WHERE d.drinktype = :drinktype")})
public class Drink implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DRINKID")
    private Integer drinkid;
    @Size(max = 100)
    @Column(name = "DRINKNAME")
    private String drinkname;
    @Size(max = 15)
    @Column(name = "DRINKPRICE")
    private String drinkprice;
    @Size(max = 25)
    @Column(name = "DRINKTYPE")
    private String drinktype;

    public Drink() {
    }

    public Drink(Integer drinkid) {
        this.drinkid = drinkid;
    }

    public Drink(String drinkname, String drinkprice, String drinktype) {
        this.drinkname = drinkname;
        this.drinkprice = drinkprice;
        this.drinktype = drinktype;
    }

    public Integer getDrinkid() {
        return drinkid;
    }

    public void setDrinkid(Integer drinkid) {
        this.drinkid = drinkid;
    }

    public String getDrinkname() {
        return drinkname;
    }

    public void setDrinkname(String drinkname){
        
        Charset windows1252 = Charset.forName("ISO-8859-1");
        Charset utf8charset = Charset.forName("UTF-8");

        byte[] bytes = drinkname.getBytes(windows1252);
        String z = new String(bytes, utf8charset);
        this.drinkname=z;
    }
    
    public String getDrinkprice() {
        return drinkprice;
    }

    public void setDrinkprice(String drinkprice) {
        this.drinkprice = drinkprice;
    }

    public String getDrinktype() {
        return drinktype;
    }

    public void setDrinktype(String drinktype) {
        Charset windows1252 = Charset.forName("ISO-8859-1");
        Charset utf8charset = Charset.forName("UTF-8");

        byte[] bytes = drinktype.getBytes(windows1252);
        String z = new String(bytes, utf8charset);
        this.drinktype=z;    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (drinkid != null ? drinkid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Drink)) {
            return false;
        }
        Drink other = (Drink) object;
        if ((this.drinkid == null && other.drinkid != null) || (this.drinkid != null && !this.drinkid.equals(other.drinkid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return drinkname + ", " + drinkprice;
    }
    
}
