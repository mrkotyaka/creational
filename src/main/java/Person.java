import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age;
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public boolean hasAge() {
        return getAge().isPresent();
    }

    public boolean hasAddress() {
        if (address == null || address.isEmpty()) {
            return false;
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        if (age == 0) {
            return OptionalInt.empty();
        }
        return OptionalInt.of(age);
    }

    public String getAddress() {
        if (address == null) {
            return "";
        }
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        age++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (hasAge()) {
            sb.append(" возраст: ").append(getAge().getAsInt()).append(" г.");
        }
        if (hasAddress()) {
            sb.append(" место жительства: ").append(getAddress());
        }
        return getName() + " " + getSurname() + sb;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.surname);
        hash = 97 * hash + this.age;
        hash = 97 * hash + Objects.hashCode(this.address);
        return hash;
    }

    public PersonBuilder newChildBuilder() {
        try {
            return new PersonBuilder()
                    .setSurname(this.getSurname())
                    .setAddress(this.getAddress());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
