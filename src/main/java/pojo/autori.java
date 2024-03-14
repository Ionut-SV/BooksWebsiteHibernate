package pojo;


import java.util.HashSet;
import java.util.Set;

public class autori implements java.io.Serializable {

	private Long idautor;
	private String nume; 
	private String prenume;
	private Float varsta;
	private String gen;
	private Set edituri = new HashSet(0);

	public autori() {
	}

	public autori(Long idautor, String nume, String prenume,Float varsta, String gen, Set edituri) {
		this.idautor = idautor;
		this.nume = nume;
		this.prenume = prenume;
		this.varsta = varsta;
		this.gen = gen;
		this.edituri = edituri;
	}

	public Long getIdautor() {
		return this.idautor;
	}

	public void setIdautor(Long idautor) {
		this.idautor = idautor;
	}
	public String getNume() {
		return this.nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getPrenume() {
		return this.prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}
	public Float getVarsta() {
		return this.varsta;
	}

	public void setVarsta(Float varsta) {
		this.varsta = varsta;
	}
	
	public String getGen() {
		return this.gen;
	}

	public void setGen(String gen) {
		this.gen = gen;
	}
	public Set getEdituri() {
		return this.edituri;
	}

	public void setEdituri(Set edituri) {
		this.edituri = edituri;
	}
}




