package pl.AP.wet.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.AP.wet.entity.Wlasciciel;
import pl.AP.wet.service.WlascicielService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

@Service
public class WlascicielServiceImpl implements WlascicielService{

	@Autowired
	private JdbcTemplate jdbcTemplate;  
	  
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	} 

	@Override
	public List<Wlasciciel> getAllWlasciciel() {
		 String query="select * from wlasciciel";
		
		 return jdbcTemplate.query(query,
			        new BeanPropertyRowMapper<Wlasciciel>(Wlasciciel.class));
	}

	@Override
	public Wlasciciel getWlascicielById(Long id) {
		   String query="select * from wlasciciel where id="+id;  
		   List<Wlasciciel> zab=jdbcTemplate.query(query,
			        new BeanPropertyRowMapper<Wlasciciel>(Wlasciciel.class));
		   return zab.get(0);
	}

	@Override
	public int updateWlasciciel(Wlasciciel s) {
		   String query="update wlasciciel set imie='"+s.getImie()+"',nazwisko='"+s.getNazwisko()+"',telefon='"+s.getTelefon()+"' where id="+s.getId();  
				    return jdbcTemplate.update(query); 
	}

	@Override
	public int deleteWlascicielById(Long id) {
	    String query="delete from wlasciciel where id='"+id+"' ";  
	    return jdbcTemplate.update(query); 	
	}

	@Override
	public int addWlasciciel(Wlasciciel w) {
	    String query="insert into wlasciciel values(  wlasciciel_sequence.NEXTVAL,'"+w.getImie()+"','"+w.getNazwisko()+"','"+w.getTelefon()+"')";  
	    return jdbcTemplate.update(query);
	}
}
