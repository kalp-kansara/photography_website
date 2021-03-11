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
@Table(name = "plansxuser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plansxuser.findAll", query = "SELECT p FROM Plansxuser p"),
    @NamedQuery(name = "Plansxuser.findByPlansXUserId", query = "SELECT p FROM Plansxuser p WHERE p.plansXUserId = :plansXUserId")})
public class Plansxuser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PlansXUserId")
    private Integer plansXUserId;
    @JoinColumn(name = "PlansId", referencedColumnName = "PlansId")
    @ManyToOne(optional = false)
    private Plans plansId;
    @JoinColumn(name = "UserId", referencedColumnName = "UserId")
    @ManyToOne(optional = false)
    private Users userId;

    public Plansxuser() {
    }

    public Plansxuser(Integer plansXUserId) {
        this.plansXUserId = plansXUserId;
    }

    public Integer getPlansXUserId() {
        return plansXUserId;
    }

    public void setPlansXUserId(Integer plansXUserId) {
        this.plansXUserId = plansXUserId;
    }

    public Plans getPlansId() {
        return plansId;
    }

    public void setPlansId(Plans plansId) {
        this.plansId = plansId;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (plansXUserId != null ? plansXUserId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plansxuser)) {
            return false;
        }
        Plansxuser other = (Plansxuser) object;
        if ((this.plansXUserId == null && other.plansXUserId != null) || (this.plansXUserId != null && !this.plansXUserId.equals(other.plansXUserId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Plansxuser[ plansXUserId=" + plansXUserId + " ]";
    }
    
}
