/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "plans")
//@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plans.findAll", query = "SELECT p FROM Plans p"),
    @NamedQuery(name = "Plans.findByPlansId", query = "SELECT p FROM Plans p WHERE p.plansId = :plansId"),
    @NamedQuery(name = "Plans.findByPlansName", query = "SELECT p FROM Plans p WHERE p.plansName = :plansName"),
    @NamedQuery(name = "Plans.findByPlansPrice", query = "SELECT p FROM Plans p WHERE p.plansPrice = :plansPrice")})
public class Plans implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PlansId")
    private Integer plansId;
    @Basic(optional = false)
    @Column(name = "PlansName")
    private String plansName;
    @Basic(optional = false)
    @Column(name = "PlansPrice")
    private String plansPrice;
    @Basic(optional = false)
    @Lob
    @Column(name = "Description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plansId")
    private Collection<Plansxuser> plansxuserCollection;

    public Plans() {
    }

    public Plans(Integer plansId) {
        this.plansId = plansId;
    }

    public Plans(Integer plansId, String plansName, String plansPrice, String description) {
        this.plansId = plansId;
        this.plansName = plansName;
        this.plansPrice = plansPrice;
        this.description = description;
    }

    public Integer getPlansId() {
        return plansId;
    }

    public void setPlansId(Integer plansId) {
        this.plansId = plansId;
    }

    public String getPlansName() {
        return plansName;
    }

    public void setPlansName(String plansName) {
        this.plansName = plansName;
    }

    public String getPlansPrice() {
        return plansPrice;
    }

    public void setPlansPrice(String plansPrice) {
        this.plansPrice = plansPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonbTransient
    public Collection<Plansxuser> getPlansxuserCollection() {
        return plansxuserCollection;
    }

    public void setPlansxuserCollection(Collection<Plansxuser> plansxuserCollection) {
        this.plansxuserCollection = plansxuserCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (plansId != null ? plansId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plans)) {
            return false;
        }
        Plans other = (Plans) object;
        if ((this.plansId == null && other.plansId != null) || (this.plansId != null && !this.plansId.equals(other.plansId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Plans[ plansId=" + plansId + " ]";
    }
    
}
