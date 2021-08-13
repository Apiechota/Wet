package pl.AP.wet.service;

import java.util.List;

import pl.AP.wet.entity.Zwierzak;
import pl.AP.wet.entity.ZwierzakDTO;

public interface ZwierzakService {
List<ZwierzakDTO> getAllZwierzak();
	
	int addZwierzak(Zwierzak z);
	
	Zwierzak getZwierzakById(Long id);
	
	int updateZwierzak(Zwierzak z);
	
	int deleteZwierzakById(Long id);
}
