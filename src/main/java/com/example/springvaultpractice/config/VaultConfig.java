package com.example.springvaultpractice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.vault.authentication.ClientAuthentication;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.config.AbstractVaultConfiguration;
import org.springframework.vault.core.VaultTemplate;

import java.net.URI;
import java.net.URISyntaxException;


@Configuration
public class VaultConfig extends AbstractVaultConfiguration {

    @Override
    public ClientAuthentication clientAuthentication() {
        return new TokenAuthentication("s.uf03va1lEZyZdkYZpaiwtSKL");
    }

    @Override
    public VaultEndpoint vaultEndpoint() {
         var vaultEndpoint = new VaultEndpoint();
         vaultEndpoint.setScheme("http");
         return vaultEndpoint;
    }
}
