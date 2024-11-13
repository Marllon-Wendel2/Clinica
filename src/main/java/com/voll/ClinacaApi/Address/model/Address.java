package com.voll.ClinacaApi.Address.model;

import com.voll.ClinacaApi.Address.AddressData;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private  String complemento;
    private String cidade;
    private String uf;

    public Address(AddressData data) {
        this.logradouro = data.logradouro();
        this.bairro = data.bairro();
        this.cep = data.cep();
        this.numero = data.numero();
        this.complemento = data.complemento();
        this.cidade = data.cidade();
        this.uf = data.uf();
    }

    public void updateInfo(AddressData addressData) {
        if(addressData.logradouro() != null) {
            this.logradouro = addressData.logradouro();
        }
        if(addressData.bairro() != null) {
            this.bairro = addressData.bairro();
        }
        if(addressData.cep() != null) {
            this.cep = addressData.cep();
        }
        if(addressData.numero() != null) {
            this.numero = addressData.numero();
        }
        if(addressData.complemento() != null) {
            this.complemento = addressData.complemento();
        }
        if(addressData.cidade() != null) {
            this.cidade = addressData.cidade();
        }
        if(addressData.uf() != null) {
            this.uf = addressData.uf();
        }
    }
}
