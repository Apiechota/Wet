package pl.AP.wet.service;
import java.util.List;
import pl.AP.wet.entity.Harmonogram;
import pl.AP.wet.entity.HarmonogramCount;
import pl.AP.wet.entity.HarmonogramDTO;

public interface HarmonogramService {
	List<HarmonogramDTO> getHarmonogram();
	
	int addTermin(Harmonogram h);
	
	Harmonogram getTerminById(Long id);
	
	int updateTermin(Harmonogram h);
	
	int deleteTerminById(Long id);

	List<HarmonogramCount> countTermin();
}
