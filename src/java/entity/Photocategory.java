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
@Table(name = "photocategory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Photocategory.findAll", query = "SELECT p FROM Photocategory p"),
    @NamedQuery(name = "Photocategory.findByCategoryId", query = "SELECT p FROM Photocategory p WHERE p.categoryId = :categoryId"),
    @NamedQuery(name = "Photocategory.findByCategoryName", query = "SELECT p FROM Photocategory p WHERE p.categoryName = :categoryName"),
    @NamedQuery(name = "Photocategory.findByDescription", query = "SELECT p FROM Photocategory p WHERE p.description = :description")})
public class Photocategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CategoryId")
    private Integer categoryId;
    @Basic(optional = false)
    @Column(name = "CategoryName")
    private String categoryName;
    @Basic(optional = false)
    @Column(name = "Description")
    private String description;
    @Basic(optional = false)
    @Lob
    @Column(name = "CategoryPhotoPath")
    private String categoryPhotoPath;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryId")
    private Collection<Useruploadphoto> useruploadphotoCollection;

    public Photocategory() {
    }

    public Photocategory(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Photocategory(Integer categoryId, String categoryName, String description, String categoryPhotoPath) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.description = description;
        this.categoryPhotoPath = categoryPhotoPath;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryPhotoPath() {
        return categoryPhotoPath;
    }

    public void setCategoryPhotoPath(String categoryPhotoPath) {
        this.categoryPhotoPath = categoryPhotoPath;
    }

    @JsonbTransient
    public Collection<Useruploadphoto> getUseruploadphotoCollection() {
        return useruploadphotoCollection;
    }

    public void setUseruploadphotoCollection(Collection<Useruploadphoto> useruploadphotoCollection) {
        this.useruploadphotoCollection = useruploadphotoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoryId != null ? categoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Photocategory)) {
            return false;
        }
        Photocategory other = (Photocategory) object;
        if ((this.categoryId == null && other.categoryId != null) || (this.categoryId != null && !this.categoryId.equals(other.categoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Photocategory[ categoryId=" + categoryId + " ]";
    }
    
}
