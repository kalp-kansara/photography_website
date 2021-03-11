/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import clients.contestCLIENT;
import ejb.AdminBeanLocal;
import ejb.UserBeanLocal;
import entity.Contest;
import entity.Photocategory;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import org.primefaces.model.file.UploadedFile;

@Named(value = "contestBEAN")
@ViewScoped
public class contestBEAN implements Serializable {

    public contestBEAN() {
    }

    @EJB
    UserBeanLocal ubl;
    @EJB
    AdminBeanLocal abl;
    contestCLIENT cclient = new contestCLIENT();

    UploadedFile file;
    int ContestId;
    String ContestName, Status, ContestType, ContestDescription, ContestPath;
    Date StartDate, EndDate;
    Collection<Contest> list;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public int getContestId() {
        return ContestId;
    }

    public void setContestId(int ContestId) {
        this.ContestId = ContestId;
    }

    public String getContestName() {
        return ContestName;
    }

    public void setContestName(String ContestName) {
        this.ContestName = ContestName;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getContestType() {
        return ContestType;
    }

    public void setContestType(String ContestType) {
        this.ContestType = ContestType;
    }

    public String getContestDescription() {
        return ContestDescription;
    }

    public void setContestDescription(String ContestDescription) {
        this.ContestDescription = ContestDescription;
    }

    public String getContestPath() {
        return ContestPath;
    }

    public void setContestPath(String ContestPath) {
        this.ContestPath = ContestPath;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date StartDate) {
        this.StartDate = StartDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date EndDate) {
        this.EndDate = EndDate;
    }

    public Collection<Contest> getList() {
        return list;
    }

    public void setList(Collection<Contest> list) {
        this.list = list;
    }

    public Collection<Contest> getContestbyStatus(String Status) {
//        
        System.out.println(Status);
        try {
            list = ubl.getContestbyStatus(Status);
        } catch (Exception e) {
            System.out.println(e);
        }
//        for (Contest contest : list) {
////            System.out.println("ContestName - " + contest.getContestName() + "ContestStatus - " + contest.getStatus());
//        }
//        return ubl.getContestByStatus(Status);
        return list;
    }

    public void getcontestbystatus(String Status) throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("contest.xhtml?Status=" + Status);
    }

    public Collection<Contest> getContestByContestType(String ContestType) {
//        System.out.println(ContestType);
        try {
            list = ubl.getContestbyContestType(ContestType);
        } catch (Exception e) {
            System.out.println(e);
        }
        for (Contest contest : list) {
//            System.out.println("ContestName - " + contest.getContestName() + "ContestStatus - " + contest.getContestType());
        }
//        return ubl.getContestByStatus(Status);
        return list;
    }

    public void contestbystatusandtype(String Status, String ContestType) throws IOException {
//        System.out.println("Status :" + Status);
        System.out.println("ContestType :" + ContestType);
        FacesContext.getCurrentInstance().getExternalContext().redirect("contest.xhtml?Status=" + Status + "&ContestType=" + ContestType);
    }

    public Collection<Contest> getcontestbystatusandtype(String Status, String ContestType) {
        System.out.println("Status := " + Status);
        System.out.println("contestType := " + ContestType);
        try {
            System.out.println("in try");
            list = ubl.getContestbyStatusAndContestType(Status, ContestType);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Contest contest : list) {
            System.out.println("in for");
            System.out.println("ContestName :- " + contest.getContestName() + "ContestStatus :- " + contest.getContestType());
        }
        return list;
    }

    public Collection<Contest> getallcontestdata() {
        Response response = cclient.getallContestData(Response.class);
        ArrayList<Contest> arrayList = new ArrayList<Contest>();
        GenericType<Collection<Contest>> genericType = new GenericType<Collection<Contest>>() {
        };
        arrayList = (ArrayList<Contest>) response.readEntity(genericType);
        return arrayList;
    }

    public String addContest() {
        try (InputStream i = file.getInputStream()) {
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
            String startdate = sd.format(StartDate);
            String enddate = sd.format(EndDate);
            String path = "E:\\Mcs(IT)\\8th sem\\JAVA EE\\Project\\web proect\\photographyProject\\web\\User\\Upload\\Contest";
            ContestPath = file.getFileName();
            Files.copy(i, new File(path, ContestPath).toPath());
            System.out.println("Description = " + ContestDescription);
            cclient.addContest(ContestName, ContestType, startdate, enddate, ContestDescription, Status, ContestPath);
//            abl.addContest(ContestName, startdate, enddate, Status, ContestType, ContestDescription, ContestPath);
        } catch (Exception e) {
            System.out.println(e);
        }
        return "contest.xhtml?faces-redirect=true";
    }

    public void getDescriptionById(int contestid) {
        Response response = cclient.getContestById(Response.class, contestid);
        GenericType<Contest> genericType = new GenericType<Contest>() {
        };
        Contest contest = response.readEntity(genericType);
        this.ContestId = contest.getContestId();
        ContestDescription = contest.getContestDescription();

        System.out.println("Description = " + ContestDescription);
    }

    public void getDataById(int contestid) throws ParseException {
        Response response = cclient.getContestById(Response.class, contestid);
        GenericType<Contest> genericType = new GenericType<Contest>() {
        };
        Contest contest = response.readEntity(genericType);
        this.ContestId = contest.getContestId();
        ContestName = contest.getContestName();
        ContestType = contest.getContestType();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        String startdate = contest.getStartDate();
        String enddate = contest.getEndDate();
        Date sdate = sd.parse(startdate);
//                new SimpleDateFormat("dd/MM/yyyy").parse(startdate);
        Date edate = sd.parse(enddate);
//                new SimpleDateFormat("dd/MM/yyyy").parse(enddate);
        StartDate = sdate;
        EndDate = edate;
        ContestDescription = contest.getContestDescription();
        Status = contest.getContestStatus();
        ContestPath = contest.getContestPhotoPath();
    }

    public void updateContestData() {
        System.out.println(file.getFileName());
        if (file.getFileName() == null) {
            System.out.println("int update if");
            System.out.println(file.getFileName());
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
            String startdate = sd.format(StartDate);
            String enddate = sd.format(EndDate);
//            cclient.UpdateContest(ContestId, ContestName, ContestType, startdate, enddate, ContestDescription, Status, ContestPath);
            abl.updateContest(ContestId, ContestName, startdate, enddate, Status, ContestType, ContestDescription, ContestPath);
            getallcontestdata();
        } else {
            try (InputStream i = file.getInputStream()) {
                SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
                String startdate = sd.format(StartDate);
                String enddate = sd.format(EndDate);
                String path = "E:\\Mcs(IT)\\8th sem\\JAVA EE\\Project\\web proect\\photographyProject\\web\\User\\Upload\\Contest";
                ContestPath = file.getFileName();
                Files.copy(i, new File(path, ContestPath).toPath());
                System.out.println("Description = " + ContestDescription);
                cclient.UpdateContest(ContestId, ContestName, ContestType, startdate, enddate, ContestDescription, Status, ContestPath);
                getallcontestdata();
            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }

    public void deletecontestData(int contestId)
    {
        cclient.DeleteContest(Response.class, contestId);
        getallcontestdata();
    }
    
    public void reset() {
        setContestId(0);
        setContestName("");
        setContestDescription("");
        setContestPath("");
        setContestType("");
        setEndDate(null);
        setStartDate(null);
        setStatus("");
    }
    
    public String redirect()
    {
        return "addeditcontest.xhtml?faces-redirect=true";
    }
}
