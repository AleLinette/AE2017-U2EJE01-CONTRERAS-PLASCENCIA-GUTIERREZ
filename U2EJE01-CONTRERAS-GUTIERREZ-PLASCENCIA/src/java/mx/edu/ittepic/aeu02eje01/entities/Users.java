/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.ittepic.aeu02eje01.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AleLinette
 */
@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
    , @NamedQuery(name = "Users.findByUserid", query = "SELECT u FROM Users u WHERE u.userid = :userid")
    , @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email")
    , @NamedQuery(name = "Users.findByBirthday", query = "SELECT u FROM Users u WHERE u.birthday = :birthday")
    , @NamedQuery(name = "Users.findByUsername", query = "SELECT u FROM Users u WHERE u.username = :username")
    , @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password")
    , @NamedQuery(name = "Users.findByEnable", query = "SELECT u FROM Users u WHERE u.enable = :enable")
    , @NamedQuery(name = "Users.findByHeight", query = "SELECT u FROM Users u WHERE u.height = :height")
    , @NamedQuery(name = "Users.findByPhone", query = "SELECT u FROM Users u WHERE u.phone = :phone")
    , @NamedQuery(name = "Users.findByNeigborthood", query = "SELECT u FROM Users u WHERE u.neigborthood = :neigborthood")
    , @NamedQuery(name = "Users.findByZipcode", query = "SELECT u FROM Users u WHERE u.zipcode = :zipcode")
    , @NamedQuery(name = "Users.findByCity", query = "SELECT u FROM Users u WHERE u.city = :city")
    , @NamedQuery(name = "Users.findByCountry", query = "SELECT u FROM Users u WHERE u.country = :country")
    , @NamedQuery(name = "Users.findByState", query = "SELECT u FROM Users u WHERE u.state = :state")
    , @NamedQuery(name = "Users.findByRegion", query = "SELECT u FROM Users u WHERE u.region = :region")
    , @NamedQuery(name = "Users.findByStreet", query = "SELECT u FROM Users u WHERE u.street = :street")
    , @NamedQuery(name = "Users.findByStreetnumber", query = "SELECT u FROM Users u WHERE u.streetnumber = :streetnumber")
    , @NamedQuery(name = "Users.findByPhoto", query = "SELECT u FROM Users u WHERE u.photo = :photo")
    , @NamedQuery(name = "Users.findByCellphone", query = "SELECT u FROM Users u WHERE u.cellphone = :cellphone")
    , @NamedQuery(name = "Users.findByGender", query = "SELECT u FROM Users u WHERE u.gender = :gender")
    , @NamedQuery(name = "Users.findByCompanyid", query = "SELECT u FROM Users u WHERE u.companyid = :companyid")
    , @NamedQuery(name = "Users.findByRoleid", query = "SELECT u FROM Users u WHERE u.roleid = :roleid")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "userid")
    private Integer userid;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email")
    private String email;
    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "username")
    private String username;
    @Size(max = 40)
    @Column(name = "password")
    private String password;
    @Column(name = "enable")
    private Boolean enable;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "height")
    private Double height;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "phone")
    private String phone;
    @Size(max = 50)
    @Column(name = "neigborthood")
    private String neigborthood;
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
    @Size(max = 255)
    @Column(name = "photo")
    private String photo;
    @Size(max = 15)
    @Column(name = "cellphone")
    private String cellphone;
    @Column(name = "gender")
    private Character gender;
    @Column(name = "companyid")
    private Integer companyid;
    @Column(name = "roleid")
    private Integer roleid;
    @JoinColumn(name = "rolid", referencedColumnName = "roleid")
    @ManyToOne
    private Role rolid;

    public Users() {
    }

    public Users(Integer userid) {
        this.userid = userid;
    }

    public Users(Integer userid, String email, String username) {
        this.userid = userid;
        this.email = email;
        this.username = username;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNeigborthood() {
        return neigborthood;
    }

    public void setNeigborthood(String neigborthood) {
        this.neigborthood = neigborthood;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Role getRolid() {
        return rolid;
    }

    public void setRolid(Role rolid) {
        this.rolid = rolid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.edu.ittepic.aeu02eje01.entities.Users[ userid=" + userid + " ]";
    }
    
}
