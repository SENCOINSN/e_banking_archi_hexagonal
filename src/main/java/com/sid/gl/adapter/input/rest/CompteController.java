package com.sid.gl.adapter.input.rest;

import com.sid.gl.constants.ApiPath;
import com.sid.gl.domain.dto.CompteRequestDto;
import com.sid.gl.domain.dto.DataResponse;
import com.sid.gl.domain.port.input.CompteServiceUseCase;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = ApiPath.API_VERSION+"/comptes")
public class CompteController {

    private final CompteServiceUseCase compteServiceUseCase;

    public CompteController(CompteServiceUseCase compteServiceUseCase) {
        this.compteServiceUseCase = compteServiceUseCase;
    }


    @PostMapping(value = "/create")
    public ResponseEntity<String> createCompte(@RequestBody final @Valid CompteRequestDto requestDto) {
        return ResponseEntity.ok(compteServiceUseCase.createCompte(requestDto));
    }

    @GetMapping(value = "/all")
    public ResponseEntity<DataResponse> getAllComptes(@RequestParam(value = "page", defaultValue = "0") int page,
                                                      @RequestParam(value = "size", defaultValue = "10") int size) {
        DataResponse dataResponse = compteServiceUseCase.getAllComptes(page, size);
        return ResponseEntity.ok(dataResponse);
    }
}
