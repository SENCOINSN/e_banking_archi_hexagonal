package com.sid.gl.adapter.output.enums;

import lombok.Getter;

public enum TypeCompte {
    COURANT("Compte Courant"),
    EPARGNE("Compte Epargne");

    @Getter
    private final String description;

     TypeCompte(String description) {
        this.description = description;
    }


}
