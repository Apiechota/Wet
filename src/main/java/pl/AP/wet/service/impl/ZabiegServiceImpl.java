package pl.AP.wet.service.impl;
import java.util.List;

	import org.springframework.stereotype.Service;

import pl.AP.wet.entity.Zabieg;
import pl.AP.wet.service.ZabiegService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
	@Service	
public class ZabiegServiceImpl implements ZabiegService{

		@Autowired
		private JdbcTemplate jdbcTemplate;  
		  
		public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
		    this.jdbcTemplate = jdbcTemplate;  
		}

		@Override
		public List<Zabieg> getAllZabieg() {
			 String query="select * from zabieg";
				return jdbcTemplate.query(query,
				        new BeanPropertyRowMapper<Zabieg>(Zabieg.class));
		}

		@Override
		public int addZabieg(Zabieg z) {
		    String query="insert into zabieg(id,nazwa_zabiegu,opis) values (  zabieg_sequence.NEXTVAL, '"+z.getNazwaZabiegu()+"', '"+z.getOpis()+"')";  
    	    return jdbcTemplate.update(query);
		}

		@Override
		public Zabieg getZabiegById(Long id) {
			 String query="select * from zabieg where id="+id;  
			
			 List<Zabieg> zab=jdbcTemplate.query(query,
				        new BeanPropertyRowMapper<Zabieg>(Zabieg.class));
			 return zab.get(0);
		}

		@Override
		public int updateZabieg(Zabieg z) {
			  String query="update zabieg set nazwa_zabiegu='"+z.getNazwaZabiegu()+"',opis='"+z.getOpis()+"' where id="+z.getId();  
			    return jdbcTemplate.update(query);
		}

		@Override
		public int deleteZabiegById(Long id) {
			 String query="delete from zabieg where id='"+id+"' ";  
			    return jdbcTemplate.update(query); 	
		} 

}
