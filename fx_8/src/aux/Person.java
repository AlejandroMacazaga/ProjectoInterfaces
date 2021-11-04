package aux;

import javafx.beans.property.SimpleStringProperty;

public class Person {
	private int id;
	private String name, surname;
	private Integer age;
	
	public Person(String name, String surname, Integer age) {
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.id = -1;
	}
	
	public Person(int id, String name, String surname, Integer age) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.age = age;
	}
	
	
	public SimpleStringProperty nameProperty() {
		return new SimpleStringProperty(name);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public SimpleStringProperty surnameProperty() {
		return new SimpleStringProperty(surname);
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public SimpleStringProperty ageProperty() {
		return new SimpleStringProperty(age.toString());
	}
	
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	public String toString() {
		return name + " " + surname + ", age " + age;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}
	
	
	
	
	
}
