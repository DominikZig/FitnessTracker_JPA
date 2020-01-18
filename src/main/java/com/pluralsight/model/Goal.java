package com.pluralsight.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "goals")
//Don't need these queries here since we're using Spring Data JPA
//@NamedQueries({
//		@NamedQuery(name = Goal.FIND_GOAL_REPORTS, query="Select new com.pluralsight.model.GoalReport(g.minutes, e.minutes, e.activity) " +
//				"from Goal g, Exercise e where g.id = e.goal.id"),
//		@NamedQuery(name = Goal.FIND_ALL_GOALS, query = "Select g from Goal g")
//})
public class Goal {

	public static final String FIND_GOAL_REPORTS = "findGoalReports";
	public static final String FIND_ALL_GOALS = "findAllGoals";

	@Id
	@GeneratedValue
	@Column(name = "GOAL_ID") //generally good idea to make column name match object name, but just showing it can be different
	private Long id; //good to use Long object rather than primitive as it has hashCode and equals methods built-in etc.

	@Range(min = 1, max = 120)
	@Column(name = "MINUTES")
	private int minutes;

	/*
	Cascading means that when we perform some action on the target entity, the same action will be applied to the associated entity.
	So if we delete the Goal object, it will delete its associated List of Exercises
	*/
	@OneToMany(mappedBy = "goal", cascade = CascadeType.ALL, fetch = FetchType.LAZY) //one Goal to many Exercises
	private List<Exercise> exercises = new ArrayList<Exercise>();

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public List<Exercise> getExercises()
	{
		return exercises;
	}

	public void setExercises(List<Exercise> exercises)
	{
		this.exercises = exercises;
	}
}
