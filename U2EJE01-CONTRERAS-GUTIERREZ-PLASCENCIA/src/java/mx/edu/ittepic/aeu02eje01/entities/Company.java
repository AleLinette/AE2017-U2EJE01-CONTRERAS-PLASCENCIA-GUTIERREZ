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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AleLinette
 */
@Entity
@Table(name = "company")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Company.findAll", query = "SELECT c FROM Company c")
    , @NamedQuery(name = "Company.findByCompanyid", query = "SELECT c FROM Company c WHERE c.companyid = :companyid")
    , @NamedQuery(name = "Company.findByCompanyname", query = "SELECT c FROM Company c WHERE c.companyname = :companyname")
    , @NamedQuery(name = "Company.findByNeighborhood", query = "SELECT c FROM Company c WHERE c.neighborhood = :neighborhood")
    , @NamedQuery(name = "Company.findByZipcode", query = "SELECT c FROM Company c WHERE c.zipcode = :zipcode")
    , @NamedQuery(name = "Company.findByCity", query = "SELECT c FROM Company c WHERE c.city = :city")
    , @NamedQuery(name = "Company.findByCountry", query = "SELECT c FROM Company c WHERE c.country = :country")
    , @NamedQuery(name = "Company.findByState", query = "SELECT c FROM Company c WHERE c.state = :state")
    , @NamedQuery(name = "Company.findByRegion", query = "SELECT c FROM Company c WHERE c.region = :region")
    , @NamedQuery(name = "Company.findByStreet", query = "SELECT c FROM Company c WHERE c.street = :street")
    , @NamedQuery(name = "Company.findByStreetnumber", query = "SELECT c FROM Company c WHERE c.streetnumber = :streetnumber")
    , @NamedQuery(name = "Company.findByPhone", query = "SELECT c FROM Company c WHERE c.phone = :phone")
    , @NamedQuery(name = "Company.findByRfc", query = "SELECT c FROM Company c WHERE c.rfc = :rfc")
    , @NamedQuery(name = "Company.findByLogo", query = "SELECT c FROM Company c WHERE c.logo = :logo")})
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "companyid")
    private Integer companyid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "companyname")
    private String companyname;
    @Size(max = 50)
    @Column(name = "neighborhood")
    private String neighborhood;
    @Size(max = 10)
    @Column(name = "zipcode")
    private String zipcode;
    @Size(max = 50)
    @Column(name = "city")
    private String city;
    @Size(max = 50)
    @Column(name = "country")
    private String country;
    @Size(max = 50)
    @Column(name = "state")
    private String state;
    @Size(max = 50)
    @Column(name = "region")
    private String region;
    @Size(max = 50)
    @Column(name = "street")
    private String street;
    @Size(max = 7)
    @Column(name = "streetnumber")
    private String streetnumber;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 15)
    @Column(name = "phone")
    private String phone;
    @Size(max = 13)
    @Column(name = "rfc")
    private String rfc;
    @Size(max = 255)
    @Column(name = "logo")
    private String logo;

    public Company() {
    }

    public Company(Integer companyid) {
        this.companyid = companyid;
    }

    public Company(Integer companyid, String companyname) {
        this.companyid = companyid;
        this.companyname = companyname;
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetnumber() {
        return streetnumber;
    }

    public void setStreetnumber(String streetnumber) {
        this.streetnumber = streetnumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (companyid != null ? companyid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Company)) {
            return false;
        }
        Company other = (Company) object;
        if ((this.companyid == null && other.companyid != null) || (this.companyid != null && !this.companyid.equals(other.companyid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.edu.ittepic.aeu02eje01.entities.Company[ companyid=" + companyid + " ]";
    }
    
}
