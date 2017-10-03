/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.ittepic.aeu02eje01.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AleLinette
 */
@Entity
@Table(name = "salesline")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salesline.findAll", query = "SELECT s FROM Salesline s")
    , @NamedQuery(name = "Salesline.findBySaleslineid", query = "SELECT s FROM Salesline s WHERE s.saleslineid = :saleslineid")
    , @NamedQuery(name = "Salesline.findByQuantity", query = "SELECT s FROM Salesline s WHERE s.quantity = :quantity")
    , @NamedQuery(name = "Salesline.findBySaleprice", query = "SELECT s FROM Salesline s WHERE s.saleprice = :saleprice")
    , @NamedQuery(name = "Salesline.findByPurchprice", query = "SELECT s FROM Salesline s WHERE s.purchprice = :purchprice")
    , @NamedQuery(name = "Salesline.findBySaleid", query = "SELECT s FROM Salesline s WHERE s.saleid = :saleid")})
public class Salesline implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "saleslineid")
    private Integer saleslineid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saleprice")
    private float saleprice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "purchprice")
    private float purchprice;
    @Column(name = "saleid")
    private Integer saleid;
    @JoinColumn(name = "productid", referencedColumnName = "productid")
    @ManyToOne
    private Product productid;
    @JoinColumn(name = "saleslineid", referencedColumnName = "saleid", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Sale sale;

    public Salesline() {
    }

    public Salesline(Integer saleslineid) {
        this.saleslineid = saleslineid;
    }

    public Salesline(Integer saleslineid, int quantity, float saleprice, float purchprice) {
        this.saleslineid = saleslineid;
        this.quantity = quantity;
        this.saleprice = saleprice;
        this.purchprice = purchprice;
    }

    public Integer getSaleslineid() {
        return saleslineid;
    }

    public void setSaleslineid(Integer saleslineid) {
        this.saleslineid = saleslineid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(float saleprice) {
        this.saleprice = saleprice;
    }

    public float getPurchprice() {
        return purchprice;
    }

    public void setPurchprice(float purchprice) {
        this.purchprice = purchprice;
    }

    public Integer getSaleid() {
        return saleid;
    }

    public void setSaleid(Integer saleid) {
        this.saleid = saleid;
    }

    public Product getProductid() {
        return productid;
    }

    public void setProductid(Product productid) {
        this.productid = productid;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (saleslineid != null ? saleslineid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salesline)) {
            return false;
        }
        Salesline other = (Salesline) object;
        if ((this.saleslineid == null && other.saleslineid != null) || (this.saleslineid != null && !this.saleslineid.equals(other.saleslineid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.edu.ittepic.aeu02eje01.entities.Salesline[ saleslineid=" + saleslineid + " ]";
    }
    
}
