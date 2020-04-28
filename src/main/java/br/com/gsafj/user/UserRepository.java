package br.com.gsafj.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

//  @Query("SELECT u FROM UserModel u WHERE u.username =: username")
  UserModel findByUsername(final String username);
}
