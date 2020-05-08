package com.devgurus.mockrest.repositories;

import com.devgurus.mockrest.entities.MockRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MockRequestDAO  extends JpaRepository<MockRequestEntity, Long> {

    List<MockRequestEntity> findAllByUrlAndRequestMethod(String url,String requestMethod);

}
