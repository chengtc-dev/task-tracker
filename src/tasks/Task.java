package tasks;

import java.util.Date;


public class Task {
    private Long id;
    private String description;
    private Status status;
    private Date createAt;
    private Date updateAt;

    public Task() {
    }

    public Task(String description) {
        this.description = description;
        this.status = Status.TODO;
        this.createAt = new Date();
        this.updateAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}
