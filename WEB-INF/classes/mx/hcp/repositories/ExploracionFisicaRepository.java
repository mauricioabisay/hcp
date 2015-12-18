package mx.hcp.repositories;

import mx.hcp.entities.ExploracionFisica;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExploracionFisicaRepository extends PagingAndSortingRepository<ExploracionFisica, Long> {
	
	public Page<ExploracionFisica> findByPacienteOrderByFechaDescIdDesc(long paciente, Pageable pageable);
	
	public ExploracionFisica findFirstByPacienteOrderByFechaDescIdDesc(long paciente);
	
	public ExploracionFisica findFirstByPacienteAndFecha(long paciente, String fecha);
}
