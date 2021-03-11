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
@Table(name = "winner")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Winner.findAll", query = "SELECT w FROM Winner w"),
    @NamedQuery(name = "Winner.findByWinnerId", query = "SELECT w FROM Winner w WHERE w.winnerId = :winnerId")})
public class Winner implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "WinnerId")
    private Integer winnerId;
    @Lob
    @Column(name = "Description")
    private String description;
    @JoinColumn(name = "ContestId", referencedColumnName = "ContestId")
    @ManyToOne(optional = false)
    private Contest contestId;
    @JoinColumn(name = "UserId", referencedColumnName = "UserId")
    @ManyToOne(optional = false)
    private Users userId;
    @JoinColumn(name = "ContestXUserId", referencedColumnName = "contestXUserId")
    @ManyToOne(optional = false)
    private Contestxuser contestXUserId;

    public Winner() {
    }

    public Winner(Integer winnerId) {
        this.winnerId = winnerId;
    }

    public Integer getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(Integer winnerId) {
        this.winnerId = winnerId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Contestxuser getContestXUserId() {
        return contestXUserId;
    }

    public void setContestXUserId(Contestxuser contestXUserId) {
        this.contestXUserId = contestXUserId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (winnerId != null ? winnerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Winner)) {
            return false;
        }
        Winner other = (Winner) object;
        if ((this.winnerId == null && other.winnerId != null) || (this.winnerId != null && !this.winnerId.equals(other.winnerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Winner[ winnerId=" + winnerId + " ]";
    }
    
}
