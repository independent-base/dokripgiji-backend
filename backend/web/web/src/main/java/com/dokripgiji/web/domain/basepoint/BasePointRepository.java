package com.dokripgiji.web.domain.basepoint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasePointRepository extends JpaRepository<BasePoint, Long> {
}
