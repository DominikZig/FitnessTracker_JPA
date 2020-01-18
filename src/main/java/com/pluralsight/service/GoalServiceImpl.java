package com.pluralsight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pluralsight.model.Goal;
import com.pluralsight.model.GoalReport;
import com.pluralsight.repository.GoalRepository;

@Service("goalService")
public class GoalServiceImpl implements GoalService
{
    @Autowired
    private GoalRepository goalRepository;

    @Transactional
    public Goal save(Goal goal)
    {
        //business logic can go here e.g. check if they've reached their goal

        return goalRepository.save(goal);
    }

    public List<Goal> findAllGoals()
    {
        //Using our custom method (i.e. without using Spring Data JPA):
        //return goalRepository.loadAll();

        //Using Spring Data JPA method:
        return goalRepository.findAll();
    }

    public List<GoalReport> findAllGoalReports()
    {
        return goalRepository.findAllGoalReports();
    }
}
