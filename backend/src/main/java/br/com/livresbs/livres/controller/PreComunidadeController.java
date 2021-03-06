package br.com.livresbs.livres.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.livresbs.livres.model.PreComunidade;
import br.com.livresbs.livres.service.PreComunidadeService;

@RestController
@RequestMapping(value = "precomunidade")
public class PreComunidadeController {
    @Autowired
    private PreComunidadeService pcr;

    @CrossOrigin
    @GetMapping
    //@PreAuthorize("hasAnyRole('ADMIN')")
    public List<PreComunidade> listaPreComunidades() {
        return pcr.listaPreComunidades();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public PreComunidade listaPreComunidadeUnica(@PathVariable(value = "id") long id) {
        return pcr.listaPreComunidadeUnica(id);
    }

    @CrossOrigin
    @PostMapping
    public PreComunidade cadastraPreComunidade(@RequestBody PreComunidade pc) {
        return pcr.cadastraPreComunidade(pc);
    }
    
    @CrossOrigin
    @PutMapping
    public PreComunidade editaPreComunidade(@RequestBody PreComunidade pc) {
    	return pcr.editaPreComunidade(pc);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluiPreComunidade(@PathVariable(value = "id") long id) { return pcr.excluiPreComunidade(id); }
}
