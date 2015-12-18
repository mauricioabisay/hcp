package mx.hcp.repositories;

import mx.hcp.entities.Prescripcion;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescripcionRepository extends PagingAndSortingRepository<Prescripcion, Long> {
	
	public Page<Prescripcion> findByPacienteOrderByFechaDescIdDesc(long paciente, Pageable pageable);
}
