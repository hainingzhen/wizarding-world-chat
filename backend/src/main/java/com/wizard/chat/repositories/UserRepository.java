package com.wizard.chat.repositories;

import com.wizard.chat.models.Wizard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Wizard, Long> {

}
