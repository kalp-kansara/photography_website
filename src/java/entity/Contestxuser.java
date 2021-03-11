/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author KALP
 */
@Entity
@Table(name = "contestxuser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contestxuser.findAll", query = "SELECT c FROM Contestxuser c"),
    @NamedQuery(name = "Contestxuser.findByContestXUserId", query = "SELECT c FROM Contestxuser c WHERE c.contestXUserId = :contestXUserId"),
    @NamedQuery(name = "Contestxuser.findByContestImagePath", query = "SELECT c FROM Contestxuser c WHERE c.contestImagePath = :contestImagePath"),
    @NamedQuery(name = "Contestxuser.findByUploadDateTime", query = "SELECT c FROM Contestxuser c WHERE c.uploadDateTime = :uploadDateTime"),
    @NamedQuery(name = "Contestxuser.findBySocialProfileUrl", query = "SELECT c FROM Contestxuser c WHERE c.socialProfileUrl = :socialProfileUrl")})
public class Contestxuser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "contestXUserId")
    private Integer contestXUserId;
    @Basic(optional = false)
    @Column(name = "ContestImagePath")
    private String contestImagePath;
    @Basic(optional = false)
    @Column(name = "UploadDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uploadDateTime;
    @Column(name = "SocialProfileUrl")
    private String socialProfileUrl;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contestXUserId")
    private Collection<Vottingxcontest> vottingxcontestCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contestXUserId")
    private Collection<Winner> winnerCollection;
    @JoinColumn(name = "ContestId", referencedColumnName = "ContestId")
    @ManyToOne(optional = false)
    private Contest contestId;
    @JoinColumn(name = "UserId", referencedColumnName = "UserId")
    @ManyToOne(optional = false)
    private Users userId;

    public Contestxuser() {
    }

    public Contestxuser(Integer contestXUserId) {
        this.contestXUserId = contestXUserId;
    }

    public Contestxuser(Integer contestXUserId, String contestImagePath, Date uploadDateTime) {
        this.contestXUserId = contestXUserId;
        this.contestImagePath = contestImagePath;
        this.uploadDateTime = uploadDateTime;
    }

    public Integer getContestXUserId() {
        return contestXUserId;
    }

    public void setContestXUserId(Integer contestXUserId) {
        this.contestXUserId = contestXUserId;
    }

    public String getContestImagePath() {
        return contestImagePath;
    }

    public void setContestImagePath(String contestImagePath) {
        this.contestImagePath = contestImagePath;
    }

    public Date getUploadDateTime() {
        return uploadDateTime;
    }

    public void setUploadDateTime(Date uploadDateTime) {
        this.uploadDateTime = uploadDateTime;
    }

    public String getSocialProfileUrl() {
        return socialProfileUrl;
    }

    public void setSocialProfileUrl(String socialProfileUrl) {
        this.socialProfileUrl = socialProfileUrl;
    }

    @XmlTransient
    public Collection<Vottingxcontest> getVottingxcontestCollection() {
        return vottingxcontestCollection;
    }

    public void setVottingxcontestCollection(Collection<Vottingxcontest> vottingxcontestCollection) {
        this.vottingxcontestCollection = vottingxcontestCollection;
    }

    @XmlTransient
    public Collection<Winner> getWinnerCollection() {
        return winnerCollection;
    }

    public void setWinnerCollection(Collection<Winner> winnerCollection) {
        this.winnerCollection = winnerCollection;
    }

    public Contest getContestId() {
        return contestId;
    }

    public void setContestId(Contest contestId) {
        this.contestId = contestId;
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
        hash += (contestXUserId != null ? contestXUserId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contestxuser)) {
            return false;
        }
        Contestxuser other = (Contestxuser) object;
        if ((this.contestXUserId == null && other.contestXUserId != null) || (this.contestXUserId != null && !this.contestXUserId.equals(other.contestXUserId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Contestxuser[ contestXUserId=" + contestXUserId + " ]";
    }
    
}
