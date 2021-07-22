package com.in.eskafka.dataaccess.rds;

import com.in.eskafka.entity.rds.OrganizationMaster;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<OrganizationMaster, Long> {

    List<OrganizationMaster> findByIsDeleted(boolean isDeleted);

    OrganizationMaster findByUniqueIdAndIsDeleted(Long uniqueId, boolean isDeleted);
}
