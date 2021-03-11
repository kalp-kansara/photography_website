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
@Table(name = "photograohytips")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Photograohytips.findAll", query = "SELECT p FROM Photograohytips p"),
    @NamedQuery(name = "Photograohytips.findByPhotographyTipsId", query = "SELECT p FROM Photograohytips p WHERE p.photographyTipsId = :photographyTipsId")})
public class Photograohytips implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PhotographyTipsId")
    private Integer photographyTipsId;
    @Basic(optional = false)
    @Lob
    @Column(name = "TipsPhotoPath")
    private String tipsPhotoPath;
    @Basic(optional = false)
    @Lob
    @Column(name = "TipsPhotoDescription")
    private String tipsPhotoDescription;
    @JoinColumn(name = "TipsId", referencedColumnName = "TipsTypeId")
    @ManyToOne(optional = false)
    private Tipstype tipsId;

    public Photograohytips() {
    }

    public Photograohytips(Integer photographyTipsId) {
        this.photographyTipsId = photographyTipsId;
    }

    public Photograohytips(Integer photographyTipsId, String tipsPhotoPath, String tipsPhotoDescription) {
        this.photographyTipsId = photographyTipsId;
        this.tipsPhotoPath = tipsPhotoPath;
        this.tipsPhotoDescription = tipsPhotoDescription;
    }

    public Integer getPhotographyTipsId() {
        return photographyTipsId;
    }

    public void setPhotographyTipsId(Integer photographyTipsId) {
        this.photographyTipsId = photographyTipsId;
    }

    public String getTipsPhotoPath() {
        return tipsPhotoPath;
    }

    public void setTipsPhotoPath(String tipsPhotoPath) {
        this.tipsPhotoPath = tipsPhotoPath;
    }

    public String getTipsPhotoDescription() {
        return tipsPhotoDescription;
    }

    public void setTipsPhotoDescription(String tipsPhotoDescription) {
        this.tipsPhotoDescription = tipsPhotoDescription;
    }

    public Tipstype getTipsId() {
        return tipsId;
    }

    public void setTipsId(Tipstype tipsId) {
        this.tipsId = tipsId;
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
        if (!(object instanceof Photograohytips)) {
            return false;
        }
        Photograohytips other = (Photograohytips) object;
        if ((this.photographyTipsId == null && other.photographyTipsId != null) || (this.photographyTipsId != null && !this.photographyTipsId.equals(other.photographyTipsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Photograohytips[ photographyTipsId=" + photographyTipsId + " ]";
    }
    
}
