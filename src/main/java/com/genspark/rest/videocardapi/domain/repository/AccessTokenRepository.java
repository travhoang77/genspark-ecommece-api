package com.genspark.rest.videocardapi.domain.repository;

import com.genspark.rest.videocardapi.domain.entity.AccessToken;
import com.genspark.rest.videocardapi.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccessTokenRepository extends JpaRepository<AccessToken, Long> {
}
