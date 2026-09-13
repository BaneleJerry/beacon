package com.banelethabede.beacon.target;

import com.banelethabede.beacon.check.CheckStatus;
import jakarta.persistence.*;
import org.apache.catalina.User;
import org.hibernate.tool.schema.TargetType;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "targets")
public class Target {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    @Enumerated(EnumType.STRING)
    private CheckType type;
    private String description;

    private String Host;
    private Integer port;
    private Integer checkIntervalSeconds;
    private Integer timeoutSeconds;

    //
    private Integer failureThreshold = 2;
    private Integer successThreshold = 2;

    private Boolean enabled = true;
    @Enumerated(EnumType.STRING)
    private CheckStatus status = CheckStatus.UP;

    private Instant createdAt = Instant.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by")
    private User createdBy;

    protected Target() {}

    public Target(String name, CheckType type, String description, String host, Integer port, Integer checkIntervalSeconds, Integer timeoutSeconds, User createdBy) {
        this.name = name;
        this.type = type;
        this.description = description;
        Host = host;
        this.port = port;
        this.checkIntervalSeconds = checkIntervalSeconds;
        this.timeoutSeconds = timeoutSeconds;
        this.createdBy = createdBy;
    }

    public Integer getPort() {
        return port;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CheckType getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getHost() {
        return Host;
    }

    public Integer getCheckIntervalSeconds() {
        return checkIntervalSeconds;
    }

    public Integer getTimeoutSeconds() {
        return timeoutSeconds;
    }

    public Integer getFailureThreshold() {
        return failureThreshold;
    }

    public Integer getSuccessThreshold() {
        return successThreshold;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public CheckStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public User getCreatedBy() {
        return createdBy;
    }
}
