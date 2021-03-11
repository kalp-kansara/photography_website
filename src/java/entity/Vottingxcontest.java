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
@Table(name = "vottingxcontest")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vottingxcontest.findAll", query = "SELECT v FROM Vottingxcontest v"),
    @NamedQuery(name = "Vottingxcontest.findByVottingXContestId", query = "SELECT v FROM Vottingxcontest v WHERE v.vottingXContestId = :vottingXContestId"),
    @NamedQuery(name = "Vottingxcontest.findByVottingCount", query = "SELECT v FROM Vottingxcontest v WHERE v.vottingCount = :vottingCount")})
public class Vottingxcontest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "VottingXContestId")
    private Integer vottingXContestId;
    @Basic(optional = false)
    @Column(name = "VottingCount")
    private int vottingCount;
    @JoinColumn(name = "ContestId", referencedColumnName = "ContestId")
    @ManyToOne(optional = false)
    private Contest contestId;
    @JoinColumn(name = "ContestXUserId", referencedColumnName = "contestXUserId")
    @ManyToOne(optional = false)
    private Contestxuser contestXUserId;
    @JoinColumn(name = "UserId", referencedColumnName = "UserId")
    @ManyToOne(optional = false)
    private Users userId;

    public Vottingxcontest() {
    }

    public Vottingxcontest(Integer vottingXContestId) {
        this.vottingXContestId = vottingXContestId;
    }

    public Vottingxcontest(Integer vottingXContestId, int vottingCount) {
        this.vottingXContestId = vottingXContestId;
        this.vottingCount = vottingCount;
    }

    public Integer getVottingXContestId() {
        return vottingXContestId;
    }

    public void setVottingXContestId(Integer vottingXContestId) {
        this.vottingXContestId = vottingXContestId;
    }

    public int getVottingCount() {
        return vottingCount;
    }

    public void setVottingCount(int vottingCount) {
        this.vottingCount = vottingCount;
    }

    public Contest getContestId() {
        return contestId;
    }

    public void setContestId(Contest contestId) {
        this.contestId = contestId;
    }

    public Contestxuser getContestXUserId() {
        return contestXUserId;
    }

    public void setContestXUserId(Contestxuser contestXUserId) {
        this.contestXUserId = contestXUserId;
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
        hash += (vottingXContestId != null ? vottingXContestId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vottingxcontest)) {
            return false;
        }
        Vottingxcontest other = (Vottingxcontest) object;
        if ((this.vottingXContestId == null && other.vottingXContestId != null) || (this.vottingXContestId != null && !this.vottingXContestId.equals(other.vottingXContestId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Vottingxcontest[ vottingXContestId=" + vottingXContestId + " ]";
    }
    
}
