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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author KALP
 */
@Entity
@Table(name = "contest")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contest.findAll", query = "SELECT c FROM Contest c"),
    @NamedQuery(name = "Contest.findByContestId", query = "SELECT c FROM Contest c WHERE c.contestId = :contestId"),
    @NamedQuery(name = "Contest.findByContestName", query = "SELECT c FROM Contest c WHERE c.contestName = :contestName"),
    @NamedQuery(name = "Contest.findByContestType", query = "SELECT c FROM Contest c WHERE c.contestType = :contestType"),
    @NamedQuery(name = "Contest.findByStartDate", query = "SELECT c FROM Contest c WHERE c.startDate = :startDate"),
    @NamedQuery(name = "Contest.findByEndDate", query = "SELECT c FROM Contest c WHERE c.endDate = :endDate"),
    @NamedQuery(name = "Contest.findByContestStatus", query = "SELECT c FROM Contest c WHERE c.contestStatus = :contestStatus")})
public class Contest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ContestId")
    private Integer contestId;
    @Basic(optional = false)
    @Column(name = "ContestName")
    private String contestName;
    @Basic(optional = false)
    @Column(name = "ContestType")
    private String contestType;
    @Basic(optional = false)
    @Column(name = "StartDate")
    private String startDate;
    @Basic(optional = false)
    @Column(name = "EndDate")
    private String endDate;
    @Basic(optional = false)
    @Lob
    @Column(name = "ContestDescription")
    private String contestDescription;
    @Basic(optional = false)
    @Column(name = "ContestStatus")
    private String contestStatus;
    @Basic(optional = false)
    @Lob
    @Column(name = "ContestPhotoPath")
    private String contestPhotoPath;

    public Contest() {
    }

    public Contest(Integer contestId) {
        this.contestId = contestId;
    }

    public Contest(Integer contestId, String contestName, String contestType, String startDate, String endDate, String contestDescription, String contestStatus, String contestPhotoPath) {
        this.contestId = contestId;
        this.contestName = contestName;
        this.contestType = contestType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.contestDescription = contestDescription;
        this.contestStatus = contestStatus;
        this.contestPhotoPath = contestPhotoPath;
    }

    public Integer getContestId() {
        return contestId;
    }

    public void setContestId(Integer contestId) {
        this.contestId = contestId;
    }

    public String getContestName() {
        return contestName;
    }

    public void setContestName(String contestName) {
        this.contestName = contestName;
    }

    public String getContestType() {
        return contestType;
    }

    public void setContestType(String contestType) {
        this.contestType = contestType;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getContestDescription() {
        return contestDescription;
    }

    public void setContestDescription(String contestDescription) {
        this.contestDescription = contestDescription;
    }

    public String getContestStatus() {
        return contestStatus;
    }

    public void setContestStatus(String contestStatus) {
        this.contestStatus = contestStatus;
    }

    public String getContestPhotoPath() {
        return contestPhotoPath;
    }

    public void setContestPhotoPath(String contestPhotoPath) {
        this.contestPhotoPath = contestPhotoPath;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contestId != null ? contestId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contest)) {
            return false;
        }
        Contest other = (Contest) object;
        if ((this.contestId == null && other.contestId != null) || (this.contestId != null && !this.contestId.equals(other.contestId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Contest[ contestId=" + contestId + " ]";
    }
    
}
