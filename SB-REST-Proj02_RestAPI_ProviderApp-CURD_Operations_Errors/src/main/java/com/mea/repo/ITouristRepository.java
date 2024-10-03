package com.mea.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mea.entity.Tourist;

public interface ITouristRepository extends JpaRepository<Tourist, Integer> {

}
