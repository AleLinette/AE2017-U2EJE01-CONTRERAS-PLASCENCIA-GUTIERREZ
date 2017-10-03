/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.ittepic.aeu02eje01.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AleLinette
 */
@Entity
@Table(name = "sale")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sale.findAll", query = "SELECT s FROM Sale s")
    , @NamedQuery(name = "Sale.findBySaleid", query = "SELECT s FROM Sale s WHERE s.saleid = :saleid")
    , @NamedQuery(name = "Sale.findByDate", query = "SELECT s FROM Sale s WHERE s.date = :date")
    , @NamedQuery(name = "Sale.findByAmount", query = "SELECT s FROM Sale s WHERE s.amount = :amount")
    , @NamedQuery(name = "Sale.findByUserid", query = "SELECT s FROM Sale s WHERE s.userid = :userid")})
public class Sale implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "saleid")
    private Integer saleid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private float amount;
    @Column(name = "userid")
    private Integer userid;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "sale")
    private Salesline salesline;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "sale1")
    private Sale sale;
    @JoinColumn(name = "saleid", referencedColumnName = "saleid", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Sale sale1;

    public Sale() {
    }

    public Sale(Integer saleid) {
        this.saleid = saleid;
    }

    public Sale(Integer saleid, Date date, float amount) {
        this.saleid = saleid;
        this.date = date;
        this.amount = amount;
    }

    public Integer getSaleid() {
        return saleid;
    }

    public void setSaleid(Integer saleid) {
        this.saleid = saleid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Salesline getSalesline() {
        return salesline;
    }

    public void setSalesline(Salesline salesline) {
        this.salesline = salesline;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Sale getSale1() {
        return sale1;
    }

    public void setSale1(Sale sale1) {
        this.sale1 = sale1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (saleid != null ? saleid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sale)) {
            return false;
        }
        Sale other = (Sale) object;
        if ((this.saleid == null && other.saleid != null) || (this.saleid != null && !this.saleid.equals(other.saleid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.edu.ittepic.aeu02eje01.entities.Sale[ saleid=" + saleid + " ]";
    }
    
}
