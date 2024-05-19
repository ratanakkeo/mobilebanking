package com.mobilebanking.base.repository;

import com.mobilebanking.base.model.BaseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseRepository<T extends BaseModel> extends JpaRepository<T, Long> {
}

