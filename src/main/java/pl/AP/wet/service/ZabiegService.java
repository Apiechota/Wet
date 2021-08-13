package pl.AP.wet.service;

import java.util.List;

import pl.AP.wet.entity.Zabieg;

public interface ZabiegService {
List<Zabieg> getAllZabieg();
	
	int addZabieg(Zabieg z);
	
	Zabieg getZabiegById(Long id);
	
	int updateZabieg(Zabieg z);
	
	int deleteZabiegById(Long id);
}
