package com.example.consuming_rest_apis;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CatFactRepository extends JpaRepository<CatFact, Long> {
}
