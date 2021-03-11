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
import javax.persistence.Lob;
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
@Table(name = "photographytips")
//@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Photographytips.findAll", query = "SELECT p FROM Photographytips p"),
    @NamedQuery(name = "Photographytips.findByPhotographyTipsId", query = "SELECT p FROM Photographytips p WHERE p.photographyTipsId = :photographyTipsId"),
    @NamedQuery(name = "Photographytips.findByPhtographyTipsPhotoPath", query = "SELECT p FROM Photographytips p WHERE p.phtographyTipsPhotoPath = :phtographyTipsPhotoPath")})
public class Photographytips implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PhotographyTipsId")
    private Integer photographyTipsId;
    @Basic(optional = false)
    @Column(name = "PhtographyTipsPhotoPath")
    private String phtographyTipsPhotoPath;
    @Lob
    @Column(name = "PhotographyTipsDescription")
    private String photographyTipsDescription;
    @JoinColumn(name = "TipsTypeId", referencedColumnName = "TipsTypeId")
    @ManyToOne(optional = false)
    private Tipstype tipsTypeId;

    public Photographytips() {
    }

    public Photographytips(Integer photographyTipsId) {
        this.photographyTipsId = photographyTipsId;
    }

    public Photographytips(Integer photographyTipsId, String phtographyTipsPhotoPath) {
        this.photographyTipsId = photographyTipsId;
        this.phtographyTipsPhotoPath = phtographyTipsPhotoPath;
    }

    public Integer getPhotographyTipsId() {
        return photographyTipsId;
    }

    public void setPhotographyTipsId(Integer photographyTipsId) {
        this.photographyTipsId = photographyTipsId;
    }

    public String getPhtographyTipsPhotoPath() {
        return phtographyTipsPhotoPath;
    }

    public void setPhtographyTipsPhotoPath(String phtographyTipsPhotoPath) {
        this.phtographyTipsPhotoPath = phtographyTipsPhotoPath;
    }

    public String getPhotographyTipsDescription() {
        return photographyTipsDescription;
    }

    public void setPhotographyTipsDescription(String photographyTipsDescription) {
        this.photographyTipsDescription = photographyTipsDescription;
    }

    public Tipstype getTipsTypeId() {
        return tipsTypeId;
    }

    public void setTipsTypeId(Tipstype tipsTypeId) {
        this.tipsTypeId = tipsTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (photographyTipsId != null ? photographyTipsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Photographytips)) {
            return false;
        }
        Photographytips other = (Photographytips) object;
        if ((this.photographyTipsId == null && other.photographyTipsId != null) || (this.photographyTipsId != null && !this.photographyTipsId.equals(other.photographyTipsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Photographytips[ photographyTipsId=" + photographyTipsId + " ]";
    }
    
}
