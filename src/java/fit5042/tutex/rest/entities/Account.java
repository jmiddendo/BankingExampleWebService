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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ACCOUNT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a")
    , @NamedQuery(name = "Account.findByAccountId", query = "SELECT a FROM Account a WHERE a.accountId = :accountId")
    , @NamedQuery(name = "Account.findByAccountBalance", query = "SELECT a FROM Account a WHERE a.accountBalance = :accountBalance")
    , @NamedQuery(name = "Account.findByAccountName", query = "SELECT a FROM Account a WHERE a.accountName = :accountName")
    , @NamedQuery(name = "Account.findByAccountType", query = "SELECT a FROM Account a WHERE a.accountType = :accountType")
    , @NamedQuery(name = "Account.findByIsActive", query = "SELECT a FROM Account a WHERE a.isActive = :isActive")})
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACCOUNT_ID")
    private Integer accountId;
    @Column(name = "ACCOUNT_BALANCE")
    private Long accountBalance;
    @Size(max = 255)
    @Column(name = "ACCOUNT_NAME")
    private String accountName;
    @Size(max = 255)
    @Column(name = "ACCOUNT_TYPE")
    private String accountType;
    @Column(name = "IS_ACTIVE")
    private Short isActive;
    @JoinColumn(name = "USERID_BANK_USER_ID", referencedColumnName = "BANK_USER_ID")
    @ManyToOne
    private BankUser useridBankUserId;
    @OneToMany(mappedBy = "useraccountAccountId")
    private Collection<BankTransaction> bankTransactionCollection;
    @OneToMany(mappedBy = "relatedaccountAccountId")
    private Collection<BankTransaction> bankTransactionCollection1;

    public Account() {
    }

    public Account(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Long getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Long accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Short getIsActive() {
        return isActive;
    }

    public void setIsActive(Short isActive) {
        this.isActive = isActive;
    }

    public BankUser getUseridBankUserId() {
        return useridBankUserId;
    }

    public void setUseridBankUserId(BankUser useridBankUserId) {
        this.useridBankUserId = useridBankUserId;
    }

    @XmlTransient
    public Collection<BankTransaction> getBankTransactionCollection() {
        return bankTransactionCollection;
    }

    public void setBankTransactionCollection(Collection<BankTransaction> bankTransactionCollection) {
        this.bankTransactionCollection = bankTransactionCollection;
    }

    @XmlTransient
    public Collection<BankTransaction> getBankTransactionCollection1() {
        return bankTransactionCollection1;
    }

    public void setBankTransactionCollection1(Collection<BankTransaction> bankTransactionCollection1) {
        this.bankTransactionCollection1 = bankTransactionCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountId != null ? accountId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.accountId == null && other.accountId != null) || (this.accountId != null && !this.accountId.equals(other.accountId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fit5042.tutex.rest.entities.Account[ accountId=" + accountId + " ]";
    }
    
}
