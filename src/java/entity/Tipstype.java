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
@Table(name = "tipstype")
//@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipstype.findAll", query = "SELECT t FROM Tipstype t"),
    @NamedQuery(name = "Tipstype.findByTipsTypeId", query = "SELECT t FROM Tipstype t WHERE t.tipsTypeId = :tipsTypeId"),
    @NamedQuery(name = "Tipstype.findByTipsTypeName", query = "SELECT t FROM Tipstype t WHERE t.tipsTypeName = :tipsTypeName"),
    @NamedQuery(name = "Tipstype.findByTipsTypeDescription", query = "SELECT t FROM Tipstype t WHERE t.tipsTypeDescription = :tipsTypeDescription"),
    @NamedQuery(name = "Tipstype.findByTipsTypePhotoPath", query = "SELECT t FROM Tipstype t WHERE t.tipsTypePhotoPath = :tipsTypePhotoPath")})
public class Tipstype implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TipsTypeId")
    private Integer tipsTypeId;
    @Basic(optional = false)
    @Column(name = "TipsTypeName")
    private String tipsTypeName;
    @Column(name = "TipsTypeDescription")
    private String tipsTypeDescription;
    @Basic(optional = false)
    @Column(name = "TipsTypePhotoPath")
    private String tipsTypePhotoPath;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipsTypeId")
    private Collection<Photographytips> photographytipsCollection;

    public Tipstype() {
    }

    public Tipstype(Integer tipsTypeId) {
        this.tipsTypeId = tipsTypeId;
    }

    public Tipstype(Integer tipsTypeId, String tipsTypeName, String tipsTypePhotoPath) {
        this.tipsTypeId = tipsTypeId;
        this.tipsTypeName = tipsTypeName;
        this.tipsTypePhotoPath = tipsTypePhotoPath;
    }

    public Integer getTipsTypeId() {
        return tipsTypeId;
    }

    public void setTipsTypeId(Integer tipsTypeId) {
        this.tipsTypeId = tipsTypeId;
    }

    public String getTipsTypeName() {
        return tipsTypeName;
    }

    public void setTipsTypeName(String tipsTypeName) {
        this.tipsTypeName = tipsTypeName;
    }

    public String getTipsTypeDescription() {
        return tipsTypeDescription;
    }

    public void setTipsTypeDescription(String tipsTypeDescription) {
        this.tipsTypeDescription = tipsTypeDescription;
    }

    public String getTipsTypePhotoPath() {
        return tipsTypePhotoPath;
    }

    public void setTipsTypePhotoPath(String tipsTypePhotoPath) {
        this.tipsTypePhotoPath = tipsTypePhotoPath;
    }

    @JsonbTransient
    public Collection<Photographytips> getPhotographytipsCollection() {
        return photographytipsCollection;
    }

    public void setPhotographytipsCollection(Collection<Photographytips> photographytipsCollection) {
        this.photographytipsCollection = photographytipsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipsTypeId != null ? tipsTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipstype)) {
            return false;
        }
        Tipstype other = (Tipstype) object;
        if ((this.tipsTypeId == null && other.tipsTypeId != null) || (this.tipsTypeId != null && !this.tipsTypeId.equals(other.tipsTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tipstype[ tipsTypeId=" + tipsTypeId + " ]";
    }
    
}
