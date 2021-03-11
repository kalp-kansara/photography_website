/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author KALP
 */
@Entity
@Table(name = "payment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Payment.findAll", query = "SELECT p FROM Payment p"),
    @NamedQuery(name = "Payment.findByPaymentTypesId", query = "SELECT p FROM Payment p WHERE p.paymentTypesId = :paymentTypesId"),
    @NamedQuery(name = "Payment.findByPaymentTypeName", query = "SELECT p FROM Payment p WHERE p.paymentTypeName = :paymentTypeName"),
    @NamedQuery(name = "Payment.findByPaymentTypeDescrption", query = "SELECT p FROM Payment p WHERE p.paymentTypeDescrption = :paymentTypeDescrption")})
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PaymentTypesId")
    private Integer paymentTypesId;
    @Basic(optional = false)
    @Column(name = "PaymentTypeName")
    private String paymentTypeName;
    @Column(name = "PaymentTypeDescrption")
    private String paymentTypeDescrption;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paymentId")
    private Collection<Paymentxuser> paymentxuserCollection;

    public Payment() {
    }

    public Payment(Integer paymentTypesId) {
        this.paymentTypesId = paymentTypesId;
    }

    public Payment(Integer paymentTypesId, String paymentTypeName) {
        this.paymentTypesId = paymentTypesId;
        this.paymentTypeName = paymentTypeName;
    }

    public Integer getPaymentTypesId() {
        return paymentTypesId;
    }

    public void setPaymentTypesId(Integer paymentTypesId) {
        this.paymentTypesId = paymentTypesId;
    }

    public String getPaymentTypeName() {
        return paymentTypeName;
    }

    public void setPaymentTypeName(String paymentTypeName) {
        this.paymentTypeName = paymentTypeName;
    }

    public String getPaymentTypeDescrption() {
        return paymentTypeDescrption;
    }

    public void setPaymentTypeDescrption(String paymentTypeDescrption) {
        this.paymentTypeDescrption = paymentTypeDescrption;
    }

    @XmlTransient
    public Collection<Paymentxuser> getPaymentxuserCollection() {
        return paymentxuserCollection;
    }

    public void setPaymentxuserCollection(Collection<Paymentxuser> paymentxuserCollection) {
        this.paymentxuserCollection = paymentxuserCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentTypesId != null ? paymentTypesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payment)) {
            return false;
        }
        Payment other = (Payment) object;
        if ((this.paymentTypesId == null && other.paymentTypesId != null) || (this.paymentTypesId != null && !this.paymentTypesId.equals(other.paymentTypesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Payment[ paymentTypesId=" + paymentTypesId + " ]";
    }
    
}
