package nello.model;

import javafx.scene.paint.Color;
import nello.observable.ExperimentObservable;
import nello.observer.ExperimentObserver;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Experiment implements ExperimentObservable {

    public enum Category {
        INWERKING(1), HALLOFFAME(2), CEMENTARY(3), VASTEDIENST(4);
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

        public Color getValue() {
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
    private LocalDate createDate;
    private LocalDate endDate;
    private String status;
    private List<Log> logs;
    private List<Attachment> attachments;
    private List<String> incomes;
    private List<String> costs;
    private boolean isLocked;
    private LocalDateTime lastModified;

    private List<ExperimentObserver> observerList;

    public Experiment(Category category, Phase phase, String businessOwner, String description, String name,
                      StatusColor statusColor, LocalDate createDate, LocalDate endDate, String status, List<Log> logs,
                      List<Attachment> attachments, List<String> incomes, List<String> costs, boolean isLocked, LocalDateTime lastModified) {

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

    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
        notifyObservers();
    }

    public Phase getPhase() {
        return phase;
    }

    public void setPhase(Phase phase) {
        this.phase = phase;
        notifyObservers();
    }

    public String getBusinessOwner() {
        return businessOwner;
    }

    public void setBusinessOwner(String businessOwner) {
        this.businessOwner = businessOwner;
        notifyObservers();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        notifyObservers();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyObservers();
    }

    public StatusColor getStatusColor() {
        return statusColor;
    }

    public void setStatusColor(StatusColor statusColor) {
        this.statusColor = statusColor;
        notifyObservers();
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        notifyObservers();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        notifyObservers();
    }

    public List<Log> getLogs() {
        return logs;
    }

    public void setLogs(List<Log> logs) {
        this.logs = logs;
        notifyObservers();
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
        notifyObservers();
    }

    public List<String> getIncomes() {
        return incomes;
    }

    public void setIncomes(List<String> incomes) {
        this.incomes = incomes;
        notifyObservers();
    }

    public List<String> getCosts() {
        return costs;
    }

    public void setCosts(List<String> costs) {
        this.costs = costs;
        notifyObservers();
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean isLocked) {
        this.isLocked = isLocked;
        notifyObservers();
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
        notifyObservers();
    }

}
