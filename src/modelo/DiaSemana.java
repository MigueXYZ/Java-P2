package modelo;

public enum DiaSemana {
        DOMINGO("Domingo"),
        SEGUNDA_FEIRA("2ª Feira"),
        TERCA_FEIRA("3ª Feira"),
        QUARTA_FEIRA("4ª Feira"),
        QUINTA_FEIRA("5ª Feira"),
        SEXTA_FEIRA("6ª Feira"),
        SABADO("Sábado");
        private final String descricao;
        DiaSemana(String descricao){
            this.descricao=descricao;
        }

        @Override
        public String toString() {
            return this.descricao;
        }

}
