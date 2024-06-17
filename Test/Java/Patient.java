public class Patient {
    private List<String> drugs;

    public Patient() {
        this.drugs = new ArrayList<>();
    }

    public void drugWasPrescribed(String name) {
        drugs.add(name);
    }

    public boolean isDrugPrescribed(String drug) {
        return drugs.contains(drug);
    }
}

public class Physician extends HealthStaff {
    public Physician(String name) {
        super(name);
    }

    public void prescribeDrugTo(Patient patient, String name) {
        patient.drugWasPrescribed(name);
    }