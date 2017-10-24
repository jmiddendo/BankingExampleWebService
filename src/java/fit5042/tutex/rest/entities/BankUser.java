/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.rest.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jmid3
 */
@Entity
@Table(name = "BANK_USER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BankUser.findAll", query = "SELECT b FROM BankUser b")
    , @NamedQuery(name = "BankUser.findByBankUserId", query = "SELECT b FROM BankUser b WHERE b.bankUserId = :bankUserId")
    , @NamedQuery(name = "BankUser.findByEmail", query = "SELECT b FROM BankUser b WHERE b.email = :email")
    , @NamedQuery(name = "BankUser.findByFirstName", query = "SELECT b FROM BankUser b WHERE b.firstName = :firstName")
    , @NamedQuery(name = "BankUser.findByLastName", query = "SELECT b FROM BankUser b WHERE b.lastName = :lastName")
    , @NamedQuery(name = "BankUser.findByPassword", query = "SELECT b FROM BankUser b WHERE b.password = :password")
    , @NamedQuery(name = "BankUser.findByPhoneNumber", query = "SELECT b FROM BankUser b WHERE b.phoneNumber = :phoneNumber")
    , @NamedQuery(name = "BankUser.findByType", query = "SELECT b FROM BankUser b WHERE b.type = :type")
    , @NamedQuery(name = "BankUser.findByPostCode", query = "SELECT b FROM BankUser b WHERE b.postCode = :postCode")
    , @NamedQuery(name = "BankUser.findByState", query = "SELECT b FROM BankUser b WHERE b.state = :state")
    , @NamedQuery(name = "BankUser.findByStreetAddress", query = "SELECT b FROM BankUser b WHERE b.streetAddress = :streetAddress")
    , @NamedQuery(name = "BankUser.findByStreetNumber", query = "SELECT b FROM BankUser b WHERE b.streetNumber = :streetNumber")
    , @NamedQuery(name = "BankUser.findBySuburb", query = "SELECT b FROM BankUser b WHERE b.suburb = :suburb")})
public class BankUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "BANK_USER_ID")
    private Integer bankUserId;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 255)
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "LAST_NAME")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "TYPE")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "POST_CODE")
    private String postCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "STATE")
    private String state;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "STREET_ADDRESS")
    private String streetAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "STREET_NUMBER")
    private String streetNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "SUBURB")
    private String suburb;
    @OneToMany(mappedBy = "useridBankUserId")
    private Collection<Account> accountCollection;

    public BankUser() {
    }

    public BankUser(Integer bankUserId) {
        this.bankUserId = bankUserId;
    }

    public BankUser(Integer bankUserId, String email, String lastName, String password, String phoneNumber, String type, String postCode, String state, String streetAddress, String streetNumber, String suburb) {
        this.bankUserId = bankUserId;
        this.email = email;
        this.lastName = lastName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.type = type;
        this.postCode = postCode;
        this.state = state;
        this.streetAddress = streetAddress;
        this.streetNumber = streetNumber;
        this.suburb = suburb;
    }

    public Integer getBankUserId() {
        return bankUserId;
    }

    public void setBankUserId(Integer bankUserId) {
        this.bankUserId = bankUserId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    @XmlTransient
    public Collection<Account> getAccountCollection() {
        return accountCollection;
    }

    public void setAccountCollection(Collection<Account> accountCollection) {
        this.accountCollection = accountCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bankUserId != null ? bankUserId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BankUser)) {
            return false;
        }
        BankUser other = (BankUser) object;
        if ((this.bankUserId == null && other.bankUserId != null) || (this.bankUserId != null && !this.bankUserId.equals(other.bankUserId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fit5042.tutex.rest.entities.BankUser[ bankUserId=" + bankUserId + " ]";
    }
    
}
