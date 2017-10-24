/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.rest.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author jmid3
 */
@Entity
@Table(name = "BANK_TRANSACTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BankTransaction.findAll", query = "SELECT b FROM BankTransaction b")
    , @NamedQuery(name = "BankTransaction.findByBankTransactionId", query = "SELECT b FROM BankTransaction b WHERE b.bankTransactionId = :bankTransactionId")
    , @NamedQuery(name = "BankTransaction.findByDtype", query = "SELECT b FROM BankTransaction b WHERE b.dtype = :dtype")
    , @NamedQuery(name = "BankTransaction.findByBankTransactionName", query = "SELECT b FROM BankTransaction b WHERE b.bankTransactionName = :bankTransactionName")
    , @NamedQuery(name = "BankTransaction.findByDescription", query = "SELECT b FROM BankTransaction b WHERE b.description = :description")
    , @NamedQuery(name = "BankTransaction.findByTransactionAmount", query = "SELECT b FROM BankTransaction b WHERE b.transactionAmount = :transactionAmount")
    , @NamedQuery(name = "BankTransaction.findByTransactionDate", query = "SELECT b FROM BankTransaction b WHERE b.transactionDate = :transactionDate")})
public class BankTransaction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "BANK_TRANSACTION_ID")
    private Integer bankTransactionId;
    @Size(max = 31)
    @Column(name = "DTYPE")
    private String dtype;
    @Size(max = 255)
    @Column(name = "BANK_TRANSACTION_NAME")
    private String bankTransactionName;
    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TRANSACTION_AMOUNT")
    private Double transactionAmount;
    @Column(name = "TRANSACTION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionDate;
    @JoinColumn(name = "USERACCOUNT_ACCOUNT_ID", referencedColumnName = "ACCOUNT_ID")
    @ManyToOne
    private Account useraccountAccountId;
    @JoinColumn(name = "RELATEDACCOUNT_ACCOUNT_ID", referencedColumnName = "ACCOUNT_ID")
    @ManyToOne
    private Account relatedaccountAccountId;
    @JoinColumn(name = "TYPE_TRANSACTION_TYPE_ID", referencedColumnName = "TRANSACTION_TYPE_ID")
    @ManyToOne
    private TransactionType typeTransactionTypeId;

    public BankTransaction() {
    }

    public BankTransaction(Integer bankTransactionId) {
        this.bankTransactionId = bankTransactionId;
    }

    public Integer getBankTransactionId() {
        return bankTransactionId;
    }

    public void setBankTransactionId(Integer bankTransactionId) {
        this.bankTransactionId = bankTransactionId;
    }

    public String getDtype() {
        return dtype;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }

    public String getBankTransactionName() {
        return bankTransactionName;
    }

    public void setBankTransactionName(String bankTransactionName) {
        this.bankTransactionName = bankTransactionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Account getUseraccountAccountId() {
        return useraccountAccountId;
    }

    public void setUseraccountAccountId(Account useraccountAccountId) {
        this.useraccountAccountId = useraccountAccountId;
    }

    public Account getRelatedaccountAccountId() {
        return relatedaccountAccountId;
    }

    public void setRelatedaccountAccountId(Account relatedaccountAccountId) {
        this.relatedaccountAccountId = relatedaccountAccountId;
    }

    public TransactionType getTypeTransactionTypeId() {
        return typeTransactionTypeId;
    }

    public void setTypeTransactionTypeId(TransactionType typeTransactionTypeId) {
        this.typeTransactionTypeId = typeTransactionTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bankTransactionId != null ? bankTransactionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BankTransaction)) {
            return false;
        }
        BankTransaction other = (BankTransaction) object;
        if ((this.bankTransactionId == null && other.bankTransactionId != null) || (this.bankTransactionId != null && !this.bankTransactionId.equals(other.bankTransactionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fit5042.tutex.rest.entities.BankTransaction[ bankTransactionId=" + bankTransactionId + " ]";
    }
    
}
