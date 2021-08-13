package pl.AP.wet.service.impl;
import java.util.List;

import org.springframework.stereotype.Service;

import pl.AP.wet.entity.HarmonogramDTO;
import pl.AP.wet.entity.Wlasciciel;
import pl.AP.wet.entity.Zwierzak;
import pl.AP.wet.entity.ZwierzakDTO;
import pl.AP.wet.service.ZwierzakService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

@Service
public class ZwierzakServiceImpl implements ZwierzakService{
	@Autowired
	private JdbcTemplate jdbcTemplate;  
	  
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	} 

	@Override
	public List<ZwierzakDTO> getAllZwierzak() {
		 String query="select zwierzak.id as id,zwierzak.imie as Imie,wlasciciel.imie as Wlascicielid,zwierzak.gatunek as Gatunek from zwierzak join wlasciciel on zwierzak.wlasciciel=wlasciciel.id";
		 return jdbcTemplate.query(query,
			        new BeanPropertyRowMapper<ZwierzakDTO>(ZwierzakDTO.class));
	}

	@Override
	public int addZwierzak(Zwierzak z) {
	    String query="insert into zwierzak values(  zwierzak_sequence.NEXTVAL,'"+z.getImie()+"',"+z.getWlasciciel()+",'"+z.getGatunek()+"')";  
	    return jdbcTemplate.update(query);
	}

	@Override
	public Zwierzak getZwierzakById(Long id) {
		   String query="select * from zwierzak where id="+id;  
		   List<Zwierzak> zab=jdbcTemplate.query(query,
			        new BeanPropertyRowMapper<Zwierzak>(Zwierzak.class));
		 return zab.get(0);
	}

	@Override
	public int updateZwierzak(Zwierzak z) {
		  String query="update zwierzak set imie='"+z.getImie()+"',wlasciciel='"+z.getWlasciciel()+"',gatunek='"+z.getGatunek()+"' where id="+z.getId();  
		    return jdbcTemplate.update(query); 
	}

	@Override
	public int deleteZwierzakById(Long id) {
		String query="delete from zwierzak where id='"+id+"' ";  
	    return jdbcTemplate.update(query); 
	}

}
