package com.test.test.respo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.test.test.model.HallDetails;

public interface DaohallMaster extends JpaRepository<HallDetails, Integer> {
	
	
	//checkBookingDetails(String capacity,)

	
	@Query(value="SELECT * FROM Hall_Details  where capacity not in ?1  order by CAST(capacity AS int) asc;", nativeQuery=true)
	public List<HallDetails> getHallDtl(List<Integer> capacity);
	
	@Query(value="SELECT * FROM Hall_Details  where capacity >= ?1  order by CAST(capacity AS int) asc limit 1", nativeQuery=true)
	public HallDetails getHall(int capacity);
	
	
}

