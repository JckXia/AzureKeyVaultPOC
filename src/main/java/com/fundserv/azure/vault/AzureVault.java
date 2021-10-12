package com.fundserv.azure.vault;

import com.azure.core.util.polling.SyncPoller;
import com.azure.identity.DefaultAzureCredential;
import com.azure.identity.DefaultAzureCredentialBuilder;

import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import com.azure.security.keyvault.secrets.models.KeyVaultSecret;


public class AzureVault {
    
    public static void main(String[] args) {
        String keyVaultName = System.getenv("KEY_VAULT_NAME");
        String keyVaultUri = "https://" + keyVaultName + ".vault.azure.net";
        System.out.println(keyVaultUri);

        SecretClient secretClient = new SecretClientBuilder()
                        .vaultUrl(keyVaultUri)
                        .credential(new DefaultAzureCredentialBuilder().build())
                        .buildClient();
        KeyVaultSecret retrievedSecret = secretClient.getSecret("NewSecKey");
        System.out.println("Your secret is  " + retrievedSecret.getValue());
    }
}
