package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Autowired


	@Test
	public void contextLoads() {
	}

	@Test
	public void findAllWhiskysByYear(){
		List<Whisky> foundWhiskys = whiskyRepository.findAllWhiskysByYear(1995);
		assertEquals(1995, foundWhiskys.get(0).getYear());
	}

	@Test
	public void findAllDistilleriesByRegion(){
		List<Distillery> foundDistilleries = distilleryRepository.getAllDistilleriesByRegion("Speyside");
		assertEquals("Speyside", foundDistilleries.get(0).getRegion());
	}

	@Test
	public void findAllWhiskyByDistilleriesByAge(){
		List<Whisky> foundWhiskys = whiskyRepository.getAllWhiskysByDistilleryIdAndAge(1L, 15);
		assertEquals("The Glendronach Revival", foundWhiskys.get(0).getName());
	}

	@Test
	public void findAllWhiskysByRegion(){
		List<Whisky> foundWhiskys = whiskyRepository.findAllWhiskysByDistilleryRegion("Speyside");
		assertEquals(1, foundWhiskys.size());
	}

	@Test
	public void getAllDistilleriesByWhiskyAge(){
		List<Distillery> foundDistilleries = distilleryRepository.findAllDistilleriesByWhiskiesAge(12);
		assertEquals(2, foundDistilleries.size());
	}
}
