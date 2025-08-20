package com.sid.gl.adapter.input.rest;

import com.sid.gl.adapter.input.response.ApiResponse;
import com.sid.gl.constants.ApiPath;
import com.sid.gl.domain.dto.CompteRequestDto;
import com.sid.gl.domain.port.input.CompteServiceUseCase;
import com.sid.gl.exceptions.BadArgumentException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = ApiPath.API_VERSION+"/comptes")
public class CompteController extends AbstractController {

    private final CompteServiceUseCase compteServiceUseCase;

    public CompteController(CompteServiceUseCase compteServiceUseCase) {
        this.compteServiceUseCase = compteServiceUseCase;
    }


    @PreAuthorize("hasRole('role_admin')")
    @PostMapping(value = "/create")
    public ResponseEntity<ApiResponse> createCompte(@RequestBody final @Valid CompteRequestDto requestDto) throws BadArgumentException {
        return getResponseEntity(compteServiceUseCase.createCompte(requestDto));

    }

    @PreAuthorize("hasRole('role_admin')")
    @GetMapping(value = "/all")
    public ResponseEntity<ApiResponse> getAllComptes(@RequestParam(value = "page", defaultValue = "0") int page,
                                                      @RequestParam(value = "size", defaultValue = "10") int size) {
        return getResponseEntity(compteServiceUseCase.getAllComptes(page, size));
    }
}
