package com.thoughtworks.twhotel.repository;

import com.thoughtworks.twhotel.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Example, Long> {
}
