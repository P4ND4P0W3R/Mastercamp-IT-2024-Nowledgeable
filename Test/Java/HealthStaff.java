import java.util.ArrayList;
import java.util.List;

public abstract class HealthStaff {
    protected String name;
    protected List<Patient> patients;

    public HealthStaff(String name) {
        this.name = name;
        this.patients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void managePatient(Patient patient) {
        patients.add(patient);
    }

    public List<Patient> getPatients() {
        return patients;
    }
}
