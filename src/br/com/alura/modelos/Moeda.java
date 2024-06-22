package br.com.alura.modelos;

public class Moeda {

    private String moeda;
    private String escolheMoeda;
    private double taxa;

    public Moeda(APIMoeda apiMoeda) {
        this.moeda = apiMoeda.base_code();
        this.escolheMoeda = apiMoeda.target_code();
        this.taxa = apiMoeda.conversion_rate();
    }

    public String getMoeda() {
        return moeda;
    }

    public String getEscolheMoeda() {
        return escolheMoeda;
    }

    public double getTaxa() {
        return taxa;
    }

}
