package pl.AP.wet.service;
import java.util.List;
import pl.AP.wet.entity.Wlasciciel;

public interface WlascicielService {
List<Wlasciciel> getAllWlasciciel();
	
	int addWlasciciel(Wlasciciel w);
	
	Wlasciciel getWlascicielById(Long id);
	
	int updateWlasciciel(Wlasciciel w);
	
	int deleteWlascicielById(Long id);
}
