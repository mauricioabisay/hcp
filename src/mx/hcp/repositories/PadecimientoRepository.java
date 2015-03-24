package mx.hcp.repositories;

import javax.transaction.Transactional;

import mx.hcp.entities.Padecimiento;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PadecimientoRepository extends PagingAndSortingRepository<Padecimiento, Long> {
	
	public Page<Padecimiento> findByPacienteOrderByFechaDescIdDesc(long paciente, Pageable pageable);
	
	public Padecimiento findFirstByPacienteOrderByFechaDescIdDesc(long paciente);
	
	public Padecimiento findFirstByPacienteAndFecha(long paciente, String fecha);
	
	@Transactional
	public void deleteByPaciente(long paciente);
}
