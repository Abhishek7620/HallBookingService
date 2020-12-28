package com.test.test.respo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.test.model.HallBookingDetails;

@Repository
public interface DaoRepo extends JpaRepository<HallBookingDetails, Integer> {

	@Query("select hbd.capacity from HallBookingDetails hbd where hbd.capacity >= ?1 and hbd.bookingDate =?2 and hbd.bookingtime=?3 order by capacity desc")
    List<Integer> getStatus(int capacity ,String date,String time);
	
}
