import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PersonnelDAO extends DAO <Personnel> {

	@Override
	public Personnel find(long id) {
		Personnel p = new Personnel
				.Builder("Nom", "Prenom", id)
				.build();
		try {
            ResultSet result = this .connect
                                    .createStatement(
                                            	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                ResultSet.CONCUR_UPDATABLE
                                             ).executeQuery(
                                                "SELECT * FROM personnel WHERE p_id = " + id
                                             );
            if(result.first())
            		p = new Personnel
            			.Builder("Nom", "Prenom", id)
            			.build();
            
		    } catch (SQLException e) {
		            e.printStackTrace();
		    }
		   return p;
	}
	

	@Override
	public Personnel create(Personnel obj) {
		try {
			ResultSet result = this	.connect
                    .createStatement(
                    		ResultSet.TYPE_SCROLL_INSENSITIVE, 
                    		ResultSet.CONCUR_UPDATABLE
                    ).executeQuery(
                    		"SELECT NEXTVAL('personnel_p_id_seq') as id"
                    );
			if(result.first()){
				long id = result.getLong("id");
				PreparedStatement prepare = this	.connect
					                                .prepareStatement(
					                                    	"INSERT INTO personnel (p_id, p_nom) VALUES(?, ?)"
					                                    );
					prepare.setLong(1, id);
					prepare.setString(2, obj.getLastname());
					
					prepare.executeUpdate();
					obj = this.find(id);	
					
					}
					} catch (SQLException e) {
					e.printStackTrace();
					}
					return obj;
	}

	@Override
	public Personnel update(Personnel obj) {
		
		try {
            this .connect	
                 .createStatement(
                	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE
                 ).executeUpdate(
                	"UPDATE personnel SET p_nom = '" + obj.getLastname() + "'"+
                	" WHERE p_prenom = " + obj.getFirstname()
                 );
		
		obj = this.find(obj.getId());
    } catch (SQLException e) {
            e.printStackTrace();
    }
    
    return obj;
	}

	@Override
	public void delete(Personnel obj) {
		try {
            this    .connect
                	.createStatement(
                         ResultSet.TYPE_SCROLL_INSENSITIVE, 
                         ResultSet.CONCUR_UPDATABLE
                    ).executeUpdate(
                         "DELETE FROM personnel WHERE p_id = " + obj.getId()
                    );
		
    } catch (SQLException e) {
            e.printStackTrace();
    }
		
	}
	
	

}
