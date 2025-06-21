package com.sid.gl.adapter.input.rest;


import com.sid.gl.constants.ApiPath;
import com.sid.gl.domain.dto.DepotRequestDto;
import com.sid.gl.domain.dto.RetraitRequestDto;
import com.sid.gl.domain.dto.VirementRequestDto;
import com.sid.gl.domain.port.input.OperationUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = ApiPath.API_VERSION+ "/operations")
public class OperationController {

    private final OperationUseCase operationUseCase;

    public OperationController(OperationUseCase operationUseCase) {
        this.operationUseCase = operationUseCase;
    }

    //todo apres a change le numeroCompte sera pris des infos de l'utilisateur

    @PostMapping(value = "/depot/{numeroCompte}")
    public ResponseEntity<String> depot(@PathVariable(value = "numeroCompte") String numeroCompte, @RequestBody DepotRequestDto depotRequestDto) {
        return ResponseEntity.ok(operationUseCase.depot(numeroCompte, depotRequestDto));
    }

    //todo apres a change le numeroCompte sera pris des infos de l'utilisateur

    @PostMapping(value = "/retrait/{numeroCompte}")
    public ResponseEntity<String> retrait(@PathVariable(value = "numeroCompte") String numeroCompte, @RequestBody RetraitRequestDto retraitRequestDto) {
        return ResponseEntity.ok(operationUseCase.retrait(numeroCompte, retraitRequestDto));
    }

    //todo apres a change le numeroCompte sera pris des infos de l'utilisateur

    @PostMapping(value = "/virement/{numeroCompte}")
    public ResponseEntity<String> virement(@PathVariable(value = "numeroCompte") String numeroCompte, @RequestBody VirementRequestDto virementRequestDto) {
        return ResponseEntity.ok(operationUseCase.virement(numeroCompte, virementRequestDto));
    }
}
