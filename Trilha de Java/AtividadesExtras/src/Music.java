public class Music {

    String title;
    String artist;
    int releaseYear;
    double avaliation;
    double numAvaliations;

    double sumOfAvaliations(double rate) {
        numAvaliations += rate;
        avaliation = numAvaliations / 3;
        return avaliation;
    }

    String showTechnicalSheet() {
        return """
                Titulo: %s
                Artista: %s
                Ano de Lançamento: %d
                Média de avaliações: %.2f
                Número de Avaliações: %.0f
                """.formatted(title, artist, releaseYear, avaliation, numAvaliations);
    }



}
