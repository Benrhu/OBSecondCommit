package com.example.SpringForumSC.Repositories;

import com.example.SpringForumSC.Entities.Lessons;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepository extends JpaRepository<Lessons, Long> {
}
