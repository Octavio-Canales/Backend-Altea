package Altea.Controllers;

import Altea.Models.Empresa;
import Altea.Repositories.EmpresaRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="*")
@RestController
public class EmpresaController {
    @Autowired
    EmpresaRepository empresaRepository;

    @GetMapping("/empresas")
    public List<Empresa> getAllEmpresas(){
        return empresaRepository.getAllEmpresa();
    }

    @GetMapping("/empresas/{correo}")
    public Empresa getEmpresa(@PathVariable(value="correo") String correo){
        return empresaRepository.getEmpresa(correo);
    }

    @GetMapping("/empresas/{Correo}/{Contrasenia}")
    public Empresa Login2(@PathVariable (value = "Correo") String corr, @PathVariable (value = "Contrasenia") String contra){
        return empresaRepository.Login2(corr, contra);
    }

    @PostMapping("/empresas")
    public Empresa createEmpresa(@RequestBody Empresa empresa){
        return empresaRepository.createEmpresa(empresa);
    }

    @DeleteMapping("/empresa/{id}")
    public ResponseEntity<Empresa> deleteEmpresa(@PathVariable (value = "id") Long id){
        empresaRepository.deleteEmpresa(id);
        return ResponseEntity.ok().build();
    }
}