package ua.edu.kibit.credit.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.edu.kibit.credit.entity.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    Optional<Card> findByEmail(String email);
}
