package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Music {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	private String name;
	private String fileURL;
	private boolean forPublic;
	
	
	
	
	
	

	public Music() {
		
	}
	public Music( Long id , String name , String fileURL ) {
		this( name , fileURL );
		this.id = id;		
	}
	public Music( String name , String fileURL ) {
		
		this.name = name;
		this.fileURL = fileURL;
	}
	public Music( Long id , String name , String fileURL, boolean isPublic) 
	{
		this( id,name,fileURL);
		
		this.forPublic = isPublic ;
	}
	public boolean getForPublic() {
		return forPublic;
	}
	public void setForPublic(boolean isForPublic) {
		this.forPublic = isForPublic;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFileURL() {
		return fileURL;
	}
	public void setFileURL(String fileURL) {
		this.fileURL = fileURL;
	}
	@Override
	public String toString() {
		return "Music [id=" + id + ", name=" + name + ", fileURL=" + fileURL + ", forPublic=" + forPublic + "]";
	}
	
	
}
