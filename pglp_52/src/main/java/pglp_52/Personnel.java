import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Personnel extends OrganizationElement implements Serializable {

	private static final long serialVersionUID = 1L;

	public static LocalDate DEFAULT_DATE = LocalDate.of(2000, 1, 1);

	  private String firstname;
	  private String lastname;
	  private List<String> functions;
	  private LocalDate dateOfBirth;
	  private long id;

	  private Personnel(Builder builder) {
	    firstname = builder.firstname;
	    lastname = builder.lastname;
	    functions = builder.functions;
	    dateOfBirth = builder.dateOfBirth;
	    id = builder.id;
	  }

	  public String getFirstname() {
	    return firstname;
	  }

	  public String getLastname() {
	    return lastname;
	  }

	  public List<String> getFunctions() {
	    return functions;
	  }

	  public LocalDate getDoB() {
	    return dateOfBirth;
	  }
	  
	  public long getId() {
			return id;
	  }

	  public void setId(long id) {
			this.id = id;
	  }

	  @Override
	  public String toString() {
	    return "Personnel{" +
	            "lastname='" + lastname + '\'' +
	            ", firstname='" + firstname + '\'' +
	            '}';
	  }

	  @Override
	  protected void addSubElementsDFS(List<OrganizationElement> list) {}

	  @Override
	  protected void addSubElementsBFS(List<OrganizationElement> list) {}

	  @Override
	  public String getDescription() {
	    return firstname + " " + lastname;
	  }

	  public static class Builder {
	    private String lastname;
	    private String firstname;
	    private List<String> functions;
	    private LocalDate dateOfBirth;
	    private long id;

	    public Builder(String firstname, String lastname, long id) {
	      this.firstname = firstname;
	      this.lastname = lastname;
	      functions = new ArrayList<>();
	      dateOfBirth = DEFAULT_DATE;
	      this.id = id;
	      
	    }

	    public Personnel build() {
	      return new Personnel(this);
	    }

	    public Builder addFunction(String function) {
	      functions.add(function);
	      return this;
	    }

	    public Builder dateOfBirth(int year, int month, int dayOfMonth) {
	      dateOfBirth = LocalDate.of(year, month, dayOfMonth);
	      return this;
	    }
	    
	  }
}