package com.pluralsight.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pluralsight.model.Exercise;

//Don't need this annotation when using Spring Data JPA
//@Repository("exerciseRepository")
public interface ExerciseRepository extends JpaRepository<Exercise, Long>
{
    //Don't need to manually implement this method since we're using Spring Data JPA
    //Exercise save (Exercise exercise);
}
