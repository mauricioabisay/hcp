package mx.hcp.repositories;

import mx.hcp.entities.Estudio;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudioRepository extends PagingAndSortingRepository<Estudio, Long> {
	
	public Page<Estudio> findByPacienteOrderByFechaDescIdDesc(long paciente, Pageable pageable);
	
	public Estudio findFirstByPacienteOrderByFechaDescIdDesc(long paciente);
}
