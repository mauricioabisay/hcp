package mx.hcp.repositories;

import javax.transaction.Transactional;

import mx.hcp.entities.HistoriaClinica;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoriaClinicaRepository extends PagingAndSortingRepository<HistoriaClinica, Long> {
	
	public Page<HistoriaClinica> findByPacienteOrderByFechaDescIdDesc(long paciente, Pageable pageable);
	
	public HistoriaClinica findFirstByPacienteOrderByFechaDescIdDesc(long paciente);
	
	@Transactional
	public void deleteByPaciente(long paciente);
}
