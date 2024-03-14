package pojo;


public class edituri  implements java.io.Serializable {

	private Long ideditura;
	private carti carti;
	private autori autori;
	private String nume_editura;
	private String data_publicarii;
	private int copii_vandute;
	private String tara;

	public edituri() {
	}

	public edituri(autori autori, carti carti, String nume_editura, String data_publicarii, int copii_vandute, String tara) {
		this.autori = autori;
		this.carti = carti;
		this.nume_editura = nume_editura;
		this.data_publicarii = data_publicarii;
		this.copii_vandute = copii_vandute;
		this.tara = tara;
	}

	public Long getIdeditura() {
		return this.ideditura;
	}

	public void setIdeditura(Long ideditura) {
		this.ideditura = ideditura;
	}
	public carti getCarti() {
		return this.carti;
	}

	public void setCarti(carti carti) {
		this.carti = carti;
	}
	public autori getAutori() {
		return this.autori;
	}

	public void setAutori(autori autori) {
		this.autori = autori;
	}
	public String getNume_editura() {
		return this.nume_editura;
	}

	public void setNume_editura(String nume_editura) {
		this.nume_editura = nume_editura;
	}
	public String getData_publicarii() {
		return this.data_publicarii;
	}

	public void setData_publicarii(String data_publicarii) {
		this.data_publicarii = data_publicarii;
	}
	public int getCopii_vandute() {
		return this.copii_vandute;
	}

	public void setCopii_vandute(int copii_vandute) {
		this.copii_vandute = copii_vandute;
	}
	public String getTara() {
		return this.tara;
	}

	public void setTara(String tara) {
		this.tara = tara;
	}
}




