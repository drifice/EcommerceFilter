package BlogDemoFormation.beans;

public class Article {
	private String titre;
	private String description;
	private String contenu;
	private Utilisateur auteur;
	public Article() {}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public Utilisateur getAuteur() {
		return auteur;
	}
	public void setAuteur(Utilisateur auteur) {
		this.auteur = auteur;
	}
	@Override
	public String toString() {
		return "Article [titre=" + titre + ", description=" + description + ", contenu=" + contenu + ", auteur="
				+ auteur + "]";
	}
}
