package nello.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import javafx.scene.paint.Color;
import nello.observable.ExperimentObservable;
import nello.observer.ExperimentObserver;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class Experiment implements ExperimentObservable {

    public void setCategory(Category category) {
        this.category = category;
        this.notifyObservers();
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

        public int getValue() {
            return phase;
        }

    }

    /**
     * This Enum is for the status colors, green, orange and red
     *
     * @author Valerie Timmerman
     */

    public enum StatusColor {

        GROEN(Color.web("#61c949")), ORANJE(Color.web("#c99d49")), ROOD(Color.web("#c94949"));

        private Color color;

        StatusColor(Color color) {
            this.color = color;
        }

        public Color getAsColor() {
            return color;
        }

    }

    private long id;
    private Category category;
    private Phase phase;
    private String businessOwner;
    private String description;
    private String name;
    private StatusColor statusColor;
    private Date createDate;
    private Date endDate;
    private String status;
    private List<Log> logs;
    private List<Attachment> attachments;
    private List<String> incomes;
    private List<String> costs;
    private boolean isLocked;
    private Date lastModified;

    private List<ExperimentObserver> observerList = new ArrayList<>();

    public Experiment(Category category, Phase phase) {
        this(category, "", phase, "geen", "", "", StatusColor.GROEN);
    }


    public Experiment() {
        this(Category.INWERKING, "", Phase.IDEE, "geen", "", "", StatusColor.GROEN);
    }

    public Experiment(Category category, String name, Phase phase, String businessOwner, String status, String description, StatusColor statusColor) {
        this(category, phase, businessOwner, description, name, statusColor, Date.from(Instant.now()), null,
                status, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                false, Date.from(Instant.now()));
    }

    public Experiment(Category category, Phase phase, String businessOwner, String description, String name,
                      StatusColor statusColor, Date createDate, Date endDate, String status, List<Log> logs,
                      List<Attachment> attachments, List<String> incomes, List<String> costs, boolean isLocked, Date lastModified) {

        this.category = category;
        this.phase = phase;
        this.businessOwner = businessOwner;
        this.description = description;
        this.name = name;
        this.statusColor = statusColor;
        this.createDate = createDate;
        this.endDate = endDate;
        this.status = status;
        this.logs = logs;
        this.attachments = attachments;
        this.incomes = incomes;
        this.costs = costs;
        this.isLocked = isLocked;
        this.lastModified = lastModified;
        this.observerList = new ArrayList<>();
    }

    @Override
    public void notifyObservers() {
        for (ExperimentObserver o : observerList) {
            o.update(this);
        }
    }

    @Override
    public void registerObserver(ExperimentObserver observer) {
        // register observer
        observerList.add(observer);

        // notify him on latest updates
        observer.update(this);
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @JsonProperty
    public Category getCategory() {
        return category;
    }

    public void setPhase(Phase phase) {
        this.phase = phase;
        notifyObservers();
    }

    @JsonProperty
    public Phase getPhase() {
        return phase;
    }

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

        public int getValue() {
            return category;
        }
    }

    @JsonProperty
    public String getBusinessOwner() {
        return businessOwner;
    }

    public void setBusinessOwner(String businessOwner) {
        this.businessOwner = businessOwner;
    }

    @JsonProperty
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.notifyObservers();
    }

    @JsonProperty
    public StatusColor getStatusColor() {
        return statusColor;
    }

    public void setStatusColor(StatusColor statusColor) {
        this.statusColor = statusColor;
        this.notifyObservers();
    }

    @JsonProperty
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-YYY HH:mm:ss")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @JsonProperty
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-YYY HH:mm:ss")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @JsonProperty
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty
    public List<Log> getLogs() {
        return logs;
    }

    public void setLogs(Log[] logs) {
        this.logs = Arrays.asList(logs);
        notifyObservers();
    }

    @JsonProperty
    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    @JsonProperty
    public List<String> getIncomes() {
        return incomes;
    }

    public void setIncomes(List<String> incomes) {
        this.incomes = incomes;
    }

    @JsonProperty
    public List<String> getCosts() {
        return costs;
    }

    public void setCosts(List<String> costs) {
        this.costs = costs;
    }

    @JsonProperty
    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean isLocked) {
        this.isLocked = isLocked;
    }

    @JsonProperty
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-YYY HH:mm:ss")
    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public void addCost(String costItem) {
        costs.add(costItem);
        notifyObservers();
    }


    public void addIncome(String income) {
        incomes.add(income);
        notifyObservers();
    }

}
