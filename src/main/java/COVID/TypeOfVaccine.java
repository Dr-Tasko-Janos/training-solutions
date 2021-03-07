package COVID;

public enum TypeOfVaccine {

    Pfizer_BioNTech("Pfizer/BioNTech",1),
    Moderna("Moderna",1),
    AstraZeneca_Oxford("AstraZeneca/Oxford",1),
    SzputnyikV("Szputnyik-V",1),
    Sinopharm("Sinopharm",1),
    Johnson_Johnson("Johnson & Johnson",2);

    private String name;
    private int vaccinationValue;

    private TypeOfVaccine(String name, int vaccinationValue) {
        this.name = name;
        this.vaccinationValue = vaccinationValue;
    }

    public String getName() {
        return name;
    }

    public int getVaccinationValue() {
        return vaccinationValue;
    }
}
