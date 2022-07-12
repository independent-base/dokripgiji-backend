package com.dokripgiji.web.domain.basepoint;

import com.dokripgiji.web.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BasePointRepository extends JpaRepository<BasePoint, Long> {
    BasePoint getByUser(User user);
}
