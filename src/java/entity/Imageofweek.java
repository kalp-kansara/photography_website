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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author KALP
 */
@Entity
@Table(name = "imageofweek")
//@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Imageofweek.findAll", query = "SELECT i FROM Imageofweek i"),
    @NamedQuery(name = "Imageofweek.findByImageOfWeekId", query = "SELECT i FROM Imageofweek i WHERE i.imageOfWeekId = :imageOfWeekId"),
    @NamedQuery(name = "Imageofweek.findByImageOfWeekPhotoPath", query = "SELECT i FROM Imageofweek i WHERE i.imageOfWeekPhotoPath = :imageOfWeekPhotoPath"),
    @NamedQuery(name = "Imageofweek.findBySocialProfileUrl", query = "SELECT i FROM Imageofweek i WHERE i.socialProfileUrl = :socialProfileUrl"),
    @NamedQuery(name = "Imageofweek.findBySocialPhotoUrl", query = "SELECT i FROM Imageofweek i WHERE i.socialPhotoUrl = :socialPhotoUrl"),
    @NamedQuery(name = "Imageofweek.findByDeclarationDate", query = "SELECT i FROM Imageofweek i WHERE i.declarationDate = :declarationDate"),
    @NamedQuery(name = "Imageofweek.findByImageDescription", query = "SELECT i FROM Imageofweek i WHERE i.imageDescription = :imageDescription")})
public class Imageofweek implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ImageOfWeekId")
    private Integer imageOfWeekId;
    @Basic(optional = false)
    @Column(name = "ImageOfWeekPhotoPath")
    private String imageOfWeekPhotoPath;
    @Basic(optional = false)
    @Column(name = "SocialProfileUrl")
    private String socialProfileUrl;
    @Basic(optional = false)
    @Column(name = "SocialPhotoUrl")
    private String socialPhotoUrl;
    @Basic(optional = false)
    @Column(name = "DeclarationDate")
    private String declarationDate;
    @Column(name = "ImageDescription")
    private String imageDescription;

    public Imageofweek() {
    }

    public Imageofweek(Integer imageOfWeekId) {
        this.imageOfWeekId = imageOfWeekId;
    }

    public Imageofweek(Integer imageOfWeekId, String imageOfWeekPhotoPath, String socialProfileUrl, String socialPhotoUrl, String declarationDate) {
        this.imageOfWeekId = imageOfWeekId;
        this.imageOfWeekPhotoPath = imageOfWeekPhotoPath;
        this.socialProfileUrl = socialProfileUrl;
        this.socialPhotoUrl = socialPhotoUrl;
        this.declarationDate = declarationDate;
    }

    public Integer getImageOfWeekId() {
        return imageOfWeekId;
    }

    public void setImageOfWeekId(Integer imageOfWeekId) {
        this.imageOfWeekId = imageOfWeekId;
    }

    public String getImageOfWeekPhotoPath() {
        return imageOfWeekPhotoPath;
    }

    public void setImageOfWeekPhotoPath(String imageOfWeekPhotoPath) {
        this.imageOfWeekPhotoPath = imageOfWeekPhotoPath;
    }

    public String getSocialProfileUrl() {
        return socialProfileUrl;
    }

    public void setSocialProfileUrl(String socialProfileUrl) {
        this.socialProfileUrl = socialProfileUrl;
    }

    public String getSocialPhotoUrl() {
        return socialPhotoUrl;
    }

    public void setSocialPhotoUrl(String socialPhotoUrl) {
        this.socialPhotoUrl = socialPhotoUrl;
    }

    public String getDeclarationDate() {
        return declarationDate;
    }

    public void setDeclarationDate(String declarationDate) {
        this.declarationDate = declarationDate;
    }

    public String getImageDescription() {
        return imageDescription;
    }

    public void setImageDescription(String imageDescription) {
        this.imageDescription = imageDescription;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (imageOfWeekId != null ? imageOfWeekId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Imageofweek)) {
            return false;
        }
        Imageofweek other = (Imageofweek) object;
        if ((this.imageOfWeekId == null && other.imageOfWeekId != null) || (this.imageOfWeekId != null && !this.imageOfWeekId.equals(other.imageOfWeekId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Imageofweek[ imageOfWeekId=" + imageOfWeekId + " ]";
    }
    
}
