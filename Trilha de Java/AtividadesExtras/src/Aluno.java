public class Aluno {

    String name;
    String age;

    String firstStudent () {
        Aluno student = new Aluno();
        student.name = "Lucas";
        student.age = "20";
        return "Nome: " + student.name + "\nIdade: " + student.age;
    }

}
