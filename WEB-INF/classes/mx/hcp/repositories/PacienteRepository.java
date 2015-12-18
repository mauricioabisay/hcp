package mx.hcp.repositories;

import mx.hcp.entities.Paciente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends PagingAndSortingRepository<Paciente, Long> {
	
	public Page<Paciente> findByNombreLikeIgnoreCaseOrApellidoPaternoLikeIgnoreCaseOrApellidoMaternoLikeIgnoreCase(
			String nombre, 
			String apellidoPaterno, 
			String apellidoMaterno,
			Pageable pageable);
	
}
