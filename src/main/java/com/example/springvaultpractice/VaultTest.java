package com.example.springvaultpractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponseSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VaultTest {

    @Autowired
    VaultTemplate vaultTemplate;

    @GetMapping("/")
    public Credentials getVaultUsername() {
        VaultResponseSupport<Credentials> response = this.vaultTemplate
                .read("dbsetup/dbcred", Credentials.class);
        return response.getData();
    }
}
