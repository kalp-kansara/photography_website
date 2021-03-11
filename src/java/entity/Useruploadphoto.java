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
@Table(name = "useruploadphoto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Useruploadphoto.findAll", query = "SELECT u FROM Useruploadphoto u"),
    @NamedQuery(name = "Useruploadphoto.findByUserUploadPhotoId", query = "SELECT u FROM Useruploadphoto u WHERE u.userUploadPhotoId = :userUploadPhotoId"),
    @NamedQuery(name = "Useruploadphoto.findByPhotoDescription", query = "SELECT u FROM Useruploadphoto u WHERE u.photoDescription = :photoDescription"),
    @NamedQuery(name = "Useruploadphoto.findByIsApprove", query = "SELECT u FROM Useruploadphoto u WHERE u.isApprove = :isApprove"),
    @NamedQuery(name = "Useruploadphoto.findByCateId", query = "SELECT u FROM Useruploadphoto u WHERE u.categoryId=:CategoryId")
})
public class Useruploadphoto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "UserUploadPhotoId")
    private Integer userUploadPhotoId;
    @Column(name = "PhotoDescription")
    private String photoDescription;
    @Basic(optional = false)
    @Column(name = "IsApprove")
    private boolean isApprove;
    @Basic(optional = false)
    @Lob
    @Column(name = "PhotoPathOriginal")
    private String photoPathOriginal;
    @Basic(optional = false)
    @Lob
    @Column(name = "PhotoPathwithWM")
    private String photoPathwithWM;
    @JoinColumn(name = "CategoryId", referencedColumnName = "CategoryId")
    @ManyToOne(optional = false)
    private Photocategory categoryId;
    @JoinColumn(name = "UserId", referencedColumnName = "UserId")
    @ManyToOne(optional = false)
    private Users userId;

    public Useruploadphoto() {
    }

    public Useruploadphoto(Integer userUploadPhotoId) {
        this.userUploadPhotoId = userUploadPhotoId;
    }

    public Useruploadphoto(Integer userUploadPhotoId, boolean isApprove, String photoPathOriginal, String photoPathwithWM) {
        this.userUploadPhotoId = userUploadPhotoId;
        this.isApprove = isApprove;
        this.photoPathOriginal = photoPathOriginal;
        this.photoPathwithWM = photoPathwithWM;
    }

    public Integer getUserUploadPhotoId() {
        return userUploadPhotoId;
    }

    public void setUserUploadPhotoId(Integer userUploadPhotoId) {
        this.userUploadPhotoId = userUploadPhotoId;
    }

    public String getPhotoDescription() {
        return photoDescription;
    }

    public void setPhotoDescription(String photoDescription) {
        this.photoDescription = photoDescription;
    }

    public boolean getIsApprove() {
        return isApprove;
    }

    public void setIsApprove(boolean isApprove) {
        this.isApprove = isApprove;
    }

    public String getPhotoPathOriginal() {
        return photoPathOriginal;
    }

    public void setPhotoPathOriginal(String photoPathOriginal) {
        this.photoPathOriginal = photoPathOriginal;
    }

    public String getPhotoPathwithWM() {
        return photoPathwithWM;
    }

    public void setPhotoPathwithWM(String photoPathwithWM) {
        this.photoPathwithWM = photoPathwithWM;
    }

    public Photocategory getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Photocategory categoryId) {
        this.categoryId = categoryId;
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
        hash += (userUploadPhotoId != null ? userUploadPhotoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Useruploadphoto)) {
            return false;
        }
        Useruploadphoto other = (Useruploadphoto) object;
        if ((this.userUploadPhotoId == null && other.userUploadPhotoId != null) || (this.userUploadPhotoId != null && !this.userUploadPhotoId.equals(other.userUploadPhotoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Useruploadphoto[ userUploadPhotoId=" + userUploadPhotoId + " ]";
    }
    
}
