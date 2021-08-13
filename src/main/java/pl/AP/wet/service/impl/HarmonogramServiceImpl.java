package pl.AP.wet.service.impl;
import java.util.List;

import org.springframework.stereotype.Service;

import pl.AP.wet.entity.Harmonogram;
import pl.AP.wet.entity.HarmonogramCount;
import pl.AP.wet.entity.HarmonogramDTO;
import pl.AP.wet.entity.Wlasciciel;
import pl.AP.wet.entity.Zabieg;
import pl.AP.wet.service.HarmonogramService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

@Service
public class HarmonogramServiceImpl implements HarmonogramService{
	@Autowired
	private JdbcTemplate jdbcTemplate;  
	  
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	}

	@Override
	public List<HarmonogramDTO> getHarmonogram() {
		 String query="select harmonogram.id as id,zabieg.nazwa_zabiegu as Zabieg,zwierzak.imie as Zwierzak,harmonogram.data as data from harmonogram join zwierzak on harmonogram.id_zwierzaka=zwierzak.id join zabieg on harmonogram.id_zabiegu=zabieg.id";
		 return jdbcTemplate.query(query,
			        new BeanPropertyRowMapper<HarmonogramDTO>(HarmonogramDTO.class));
	}

	@Override
	public int addTermin(Harmonogram h) {
		   String query="insert into harmonogram values(  harmonogram_sequence.NEXTVAL,"+h.getZabieg()+","+h.getZwierzak()+",'"+h.getData()+"')";  
   	    return jdbcTemplate.update(query);
	}

	@Override
	public Harmonogram getTerminById(Long id) {
		   String query="select * from harmonogram where id="+id;  
		   List<Harmonogram> zab=jdbcTemplate.query(query,
			        new BeanPropertyRowMapper<Harmonogram>(Harmonogram.class));
		 return zab.get(0);
	}

	@Override
	public int updateTermin(Harmonogram h) {
		 String query="update Harmonogram set id_zabiegu='"+h.getZabieg()+"',id_zwierzaka='"+h.getZwierzak()+"',data='"+h.getData()+"' where id="+h.getId();  
		    return jdbcTemplate.update(query); 
	}

	@Override
	public int deleteTerminById(Long id) {
	    String query="delete from harmonogram where id='"+id+"' ";  
	    return jdbcTemplate.update(query);
	}
	
	@Override
	public List<HarmonogramCount> countTermin() {
		 String query="select count(id) as Ilosc,data as Data from harmonogram group by data";
		 return jdbcTemplate.query(query,
		        new BeanPropertyRowMapper<HarmonogramCount>(HarmonogramCount.class));
	}
	
	
}
