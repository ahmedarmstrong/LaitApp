package com.mabrouk.laitapp.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.mabrouk.laitapp.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {

    @Query(value = """
      select t from Token t inner join User u\s
      on t.user.id = u.id\s
      where u.id = :id and (t.expired = false or t.revoked = false)\s
      """)
    List<Token> findAllValidTokenByUser(Long id);

    Optional<Token> findByToken(String token);

    @Query("SELECT t.user.email FROM Token t WHERE t.user.id = :userId")
    String findUserEmailByUserId(@Param("userId") Long userId);

    @Query("SELECT u.email FROM Token t JOIN t.user u WHERE t.token = :tokenValue")
    String findUserEmailByToken(@Param("tokenValue") String tokenValue);

    @Query("SELECT t FROM Token t WHERE t.user.id = :userId")
    List<Token> findTokensForUser(@Param("userId") Long userId);
    @Transactional
    @Modifying
    @Query("UPDATE Token c " +
            "SET c.confirmedAt = ?2 " +
            "WHERE c.token = ?1")
    int updateConfirmedAt(String token,
                          LocalDateTime confirmedAt);
}
