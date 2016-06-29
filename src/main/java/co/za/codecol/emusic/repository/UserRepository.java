package co.za.codecol.emusic.repository;


import co.za.codecol.emusic.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
