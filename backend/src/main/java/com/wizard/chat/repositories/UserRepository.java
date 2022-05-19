package com.wizard.chat.repositories;

import com.wizard.chat.models.Wizard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Wizard, Long> {

    @Query(
            value = "SELECT * FROM wizards WHERE house = ?1",
            nativeQuery = true
    )
    List<Wizard> findByHouse(String house);
}
