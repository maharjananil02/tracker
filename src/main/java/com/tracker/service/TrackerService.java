package com.tracker.service;

import com.tracker.domain.Tracker;
import com.tracker.repository.TrackerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("TrackerRepo")
public class TrackerService {

    @Autowired
    private TrackerRepo trackerRepo;

    public void save(Tracker tracker){
        trackerRepo.save(tracker);
    }
}
