package nello.model;

import com.sun.istack.internal.NotNull;

import java.sql.Date;
import java.util.ArrayList;

public class Experiment {

    public enum Category {
        INWERKING(1), AFGEROND(2), VASTEDIENST(3);
        private int category;

        Category(int category) {
            this.category = category;
        }

        public static Category getById(int categoryId) {
            for (Category category : values()) {
                if (category.getValue() == categoryId) {
                    return category;
                }
            }
            // If no phase is defined the standard is "INWERKING"
            return Category.INWERKING;
        }

        public int getValue(){
            return category;
        }
    }

    public enum Phase {
        IDEE(1), LABIN(2), LABUIT(3), AFGEROND(4), VASTEDIENST(5);

        private int phase;

        Phase(int phase) {
            this.phase = phase;
        }

        public static Phase getById(int phaseId) {
            for (Phase phase : values()) {
                if (phase.getValue() == phaseId) {
                    return phase;
                }
            }
            // If no phase is defined the standard is "IDEE"
            return Phase.IDEE;
        }

        public int getValue(){
            return phase;
        }

    }

    public long id;
    public Category category;
    public Phase phase;
    public String businessOwner;
    public String description;
    public String name;
    public String statusColor;
    public Date createDate;
    public Date endDate;
    public String status;
    public ArrayList<Log> logs;
    public ArrayList<Attachment> attachments;
    public boolean isLocked;

    public Experiment(long id, Category category, Phase phase, String businessOwner, String description, String name,
                      String statusColor, Date createDate, String status, ArrayList<Log> logs,
                      ArrayList<Attachment> attachments, boolean isLocked) {

        this.id = id;
        this.category = category;
        this.phase = phase;
        this.businessOwner = businessOwner;
        this.description = description;
        this.name = name;
        this.statusColor = statusColor;
        this.createDate = createDate;
        this.endDate = null;
        this.status = status;
        this.logs = logs;
        this.attachments = attachments;
        this.isLocked = isLocked;

    }

    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    public Category getCategory() {return category;}
    public void setCategory(Category category) {this.category = category;}

    public Phase getPhase() {return phase;};
    public void setPhase(Phase phase) {this.phase = phase;}

    public String getBusinessOwner() {return businessOwner;}
    public void setBusinessOwner(String businessOwner) {this.businessOwner = businessOwner;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getStatusColor() {return statusColor;}
    public void setStatusColor(String statusColor) {this.statusColor = statusColor;}

    public Date getCreateDate() {return createDate;}
    public void setCreateDate(Date createDate) {this.createDate = createDate;}

    public Date getEndDate() {return endDate;}
    public void setEndDate(Date endDate) {this.endDate = endDate;}

    public String getStatus() {return status;}
    public void setStatus(String status) {this.status = status;}

    //TODO: fix
//    public String getLog() {return log;}
//    public void setLog(String log) {this.log = log;}

    public boolean isLocked() {return isLocked;}
    public void setLocked(boolean isLocked) {this.isLocked = isLocked;}

}
