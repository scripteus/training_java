public class Car {

    String model;
    String color;
    int release;

    int year = 2025;
    int old = (year - this.release);

    String showTechnicalSheet() {
        return "Modelo: " + model + "\n" +
               "Ano: " + release + "\n" +
               "Cor: " + color;
    }

    String releasedYears() {

        if (release == 0) {
            return "2025";
        }
        else {
            return year - release + " anos";
        }
    }
}
