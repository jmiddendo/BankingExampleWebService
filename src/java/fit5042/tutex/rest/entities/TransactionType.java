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
@Table(name = "TRANSACTION_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransactionType.findAll", query = "SELECT t FROM TransactionType t")
    , @NamedQuery(name = "TransactionType.findByTransactionTypeId", query = "SELECT t FROM TransactionType t WHERE t.transactionTypeId = :transactionTypeId")
    , @NamedQuery(name = "TransactionType.findByTransactionTypeDescription", query = "SELECT t FROM TransactionType t WHERE t.transactionTypeDescription = :transactionTypeDescription")
    , @NamedQuery(name = "TransactionType.findByTransactionTypeName", query = "SELECT t FROM TransactionType t WHERE t.transactionTypeName = :transactionTypeName")})
public class TransactionType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRANSACTION_TYPE_ID")
    private Integer transactionTypeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "TRANSACTION_TYPE_DESCRIPTION")
    private String transactionTypeDescription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "TRANSACTION_TYPE_NAME")
    private String transactionTypeName;
    @OneToMany(mappedBy = "typeTransactionTypeId")
    private Collection<BankTransaction> bankTransactionCollection;

    public TransactionType() {
    }

    public TransactionType(Integer transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    public TransactionType(Integer transactionTypeId, String transactionTypeDescription, String transactionTypeName) {
        this.transactionTypeId = transactionTypeId;
        this.transactionTypeDescription = transactionTypeDescription;
        this.transactionTypeName = transactionTypeName;
    }

    public Integer getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(Integer transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    public String getTransactionTypeDescription() {
        return transactionTypeDescription;
    }

    public void setTransactionTypeDescription(String transactionTypeDescription) {
        this.transactionTypeDescription = transactionTypeDescription;
    }

    public String getTransactionTypeName() {
        return transactionTypeName;
    }

    public void setTransactionTypeName(String transactionTypeName) {
        this.transactionTypeName = transactionTypeName;
    }

    @XmlTransient
    public Collection<BankTransaction> getBankTransactionCollection() {
        return bankTransactionCollection;
    }

    public void setBankTransactionCollection(Collection<BankTransaction> bankTransactionCollection) {
        this.bankTransactionCollection = bankTransactionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transactionTypeId != null ? transactionTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransactionType)) {
            return false;
        }
        TransactionType other = (TransactionType) object;
        if ((this.transactionTypeId == null && other.transactionTypeId != null) || (this.transactionTypeId != null && !this.transactionTypeId.equals(other.transactionTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fit5042.tutex.rest.entities.TransactionType[ transactionTypeId=" + transactionTypeId + " ]";
    }
    
}
