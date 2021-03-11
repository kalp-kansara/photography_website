/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author KALP
 */
@Entity
@Table(name = "paymentxuser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paymentxuser.findAll", query = "SELECT p FROM Paymentxuser p"),
    @NamedQuery(name = "Paymentxuser.findByPaymentXUserId", query = "SELECT p FROM Paymentxuser p WHERE p.paymentXUserId = :paymentXUserId"),
    @NamedQuery(name = "Paymentxuser.findByPayFor", query = "SELECT p FROM Paymentxuser p WHERE p.payFor = :payFor"),
    @NamedQuery(name = "Paymentxuser.findByPaymentAmount", query = "SELECT p FROM Paymentxuser p WHERE p.paymentAmount = :paymentAmount"),
    @NamedQuery(name = "Paymentxuser.findByPaymentDateTime", query = "SELECT p FROM Paymentxuser p WHERE p.paymentDateTime = :paymentDateTime")})
public class Paymentxuser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PaymentXUserId")
    private Integer paymentXUserId;
    @Basic(optional = false)
    @Column(name = "PayFor")
    private String payFor;
    @Basic(optional = false)
    @Column(name = "PaymentAmount")
    private String paymentAmount;
    @Basic(optional = false)
    @Column(name = "PaymentDateTime")
    private String paymentDateTime;
    @JoinColumn(name = "UserId", referencedColumnName = "UserId")
    @ManyToOne(optional = false)
    private Users userId;
    @JoinColumn(name = "PaymentId", referencedColumnName = "PaymentTypesId")
    @ManyToOne(optional = false)
    private Payment paymentId;

    public Paymentxuser() {
    }

    public Paymentxuser(Integer paymentXUserId) {
        this.paymentXUserId = paymentXUserId;
    }

    public Paymentxuser(Integer paymentXUserId, String payFor, String paymentAmount, String paymentDateTime) {
        this.paymentXUserId = paymentXUserId;
        this.payFor = payFor;
        this.paymentAmount = paymentAmount;
        this.paymentDateTime = paymentDateTime;
    }

    public Integer getPaymentXUserId() {
        return paymentXUserId;
    }

    public void setPaymentXUserId(Integer paymentXUserId) {
        this.paymentXUserId = paymentXUserId;
    }

    public String getPayFor() {
        return payFor;
    }

    public void setPayFor(String payFor) {
        this.payFor = payFor;
    }

    public String getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(String paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentDateTime() {
        return paymentDateTime;
    }

    public void setPaymentDateTime(String paymentDateTime) {
        this.paymentDateTime = paymentDateTime;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    public Payment getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Payment paymentId) {
        this.paymentId = paymentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentXUserId != null ? paymentXUserId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paymentxuser)) {
            return false;
        }
        Paymentxuser other = (Paymentxuser) object;
        if ((this.paymentXUserId == null && other.paymentXUserId != null) || (this.paymentXUserId != null && !this.paymentXUserId.equals(other.paymentXUserId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Paymentxuser[ paymentXUserId=" + paymentXUserId + " ]";
    }
    
}
