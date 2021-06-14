package com.tracker.repository;

import com.tracker.domain.Tracker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackerRepo extends JpaRepository<Tracker,Integer> {
}
