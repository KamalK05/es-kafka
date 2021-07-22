package com.in.eskafka.entity.rds;

import com.in.eskafka.entity.enums.OrgStatus;
import com.in.eskafka.entity.enums.OrgType;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "organization_master")
public class OrganizationMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "unique_id")
    private Long uniqueId;

    @Column(name = "name")
    private String name;

    @Column(name = "type", columnDefinition = "enum('ENTERPRISE', 'STANDALONE')")
    @Enumerated(EnumType.STRING)
    private OrgType type;

    @Column(name = "established_date", updatable = false)
    private LocalDateTime establishedDate;

    @Column(name = "status", columnDefinition = "enum('PENDING', 'CONFIRMED', 'CLOSED')")
    @Enumerated(EnumType.STRING)
    private OrgStatus status;

    @Column(name = "is_deleted", columnDefinition = "TINYINT", length = 1)
    private Boolean isDeleted;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
