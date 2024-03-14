package pojo;



import java.util.HashSet;
import java.util.Set;

public class carti  implements java.io.Serializable {


	private Long idcarte;
	private String titlu;
	private String categorie;
	private Float rating;
	private Set edituri = new HashSet(0);

	public carti() {
	}

	public carti(Long idcarte,String titlu, String categorie, Float rating, Set edituri) {
		this.idcarte = idcarte;
		this.titlu = titlu;
		this.categorie = categorie;
		this.rating = rating;
		this.edituri = edituri;
	}

	public Long getIdcarte() {
		return this.idcarte;
	}

	public void setIdcarte(Long idcarte) {
		this.idcarte = idcarte;
	}
	public String getTitlu() {
		return this.titlu;
	}

	public void setTitlu(String titlu) {
		this.titlu = titlu;
	}
	public String getCategorie() {
		return this.categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	
	public Float getRating() {
		return this.rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}
	public Set getEdituri() {
		return this.edituri;
	}

	public void setEdituri(Set edituri) {
		this.edituri = edituri;
	}
}




