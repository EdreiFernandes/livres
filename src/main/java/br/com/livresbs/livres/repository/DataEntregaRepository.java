package br.com.livresbs.livres.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.livresbs.livres.model.DataEntrega;
import br.com.livresbs.livres.model.StatusDataEntrega;

@Repository
public interface DataEntregaRepository extends JpaRepository<DataEntrega, Long> {

    @Query(
            "select de from DataEntrega de " +
            "join de.precomunidade pre " +
            "join pre.consumidores cons " +
            "where cons.cpf = :cpf " +
            "and   de.status = br.com.livresbs.livres.model.StatusDataEntrega.ATIVA"
    )
    DataEntrega encontrarDataEntregaAtivaConsumidor(@Param("cpf") String cpf);

    List<DataEntrega> findByStatus(StatusDataEntrega status);

}
