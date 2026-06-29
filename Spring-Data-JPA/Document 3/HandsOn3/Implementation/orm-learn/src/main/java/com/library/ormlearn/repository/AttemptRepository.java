package com.library.ormlearn.repository;

import com.library.ormlearn.model.Attempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AttemptRepository extends JpaRepository<Attempt, Integer> {

    @Query("""
        SELECT DISTINCT a
        FROM Attempt a
        JOIN FETCH a.user
        JOIN FETCH a.attemptQuestions aq
        JOIN FETCH aq.question
        WHERE a.user.id = :userId
        AND a.id = :attemptId
        """)
    Attempt getAttempt(@Param("userId") int userId,
                       @Param("attemptId") int attemptId);

}