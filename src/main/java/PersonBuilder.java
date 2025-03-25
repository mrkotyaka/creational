public class PersonBuilder {

    protected String name;
    protected String surname;
    protected int age;
    protected String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if  (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным!");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null) {
            throw new IllegalStateException("Не указано имя!");
        }
        if (surname == null) {
            throw new IllegalStateException("Не указана фамилия!");
        }

        Person person;
        if (age != 0) {
            person = new Person(name, surname, age);
        } else {
            person = new Person(name, surname);
        }
        person.setAddress(address);
        return person;
    }
}
