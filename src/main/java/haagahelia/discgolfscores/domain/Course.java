package haagahelia.discgolfscores.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	private String person;
	private String name;
	private int par;
	private String date;
	private int result;
	
	public Course() {};
	
	public Course(String person, String name, int par, String date, int result) {
		super();
		this.person = person;
		this.name = name;
		this.par = par;
		this.date = date;
		this.result = result;
	}

	public Long getId() {
		return Id;
	}
	

	public String getPerson() {
		return person;
	}

	public String getName() {
		return name;
	}
	
	
	public int getPar() {
		return par;
	}

	public String getDate() {
		return date;
	}

	public int getResult() {
		return result;
	}

	public void setId(Long id) {
		Id = id;
	}
	
	
	public void setPerson(String person) {
		this.person = person;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public void setPar(int par) {
		this.par = par;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setResult(int result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Course [Id=" + Id + ", person=" + person + ", name=" + name + ", par=" + par + ", date=" + date
				+ ", result=" + result + "]";
	}

}
