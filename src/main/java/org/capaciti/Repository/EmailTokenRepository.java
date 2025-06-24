package org.capaciti.Repository;

import org.capaciti.Domain.EmailToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailTokenRepository extends JpaRepository<EmailToken, String> {

    EmailToken findEmailTokenByToken(String token);
}
