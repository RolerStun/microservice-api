package challenge.support.persistence.service.intf;

import org.springframework.data.jpa.repository.JpaRepository;

import challenge.support.persistence.model.Pelicula;

public interface SupportDataServiceInterface extends JpaRepository<Pelicula, Long> {

}
