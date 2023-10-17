package br.com.danielvazmartins.labpadroesprojetospring.model;

public enum TYPE_PERSON {
    PF("PF"),
    PJ("PJ");

    private String description;

    private TYPE_PERSON(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}