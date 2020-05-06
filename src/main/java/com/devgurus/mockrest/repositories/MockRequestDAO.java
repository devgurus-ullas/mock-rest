package com.devgurus.mockrest.repositories;

import com.devgurus.mockrest.entities.MockRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MockRequestDAO  extends JpaRepository<MockRequestEntity, Long> {

}
