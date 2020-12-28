package com.test.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.test.model.HallBookingDetails;
import com.test.test.model.HallDetails;
import com.test.test.model.RequestPacket;
import com.test.test.respo.DaoRepo;
import com.test.test.respo.DaohallMaster;

@Service
public class HallService {

	@Autowired
	DaoRepo daoRepo;

	@Autowired
	DaohallMaster daoforMaster;

	public HallBookingDetails bookHall(RequestPacket hallBookRequest) {

		HallBookingDetails bookingDtl = checkStatus(hallBookRequest);

		return bookingDtl;
	}

	public HallDetails createHall(HallDetails halldtl) {

		HallDetails dtl = daoforMaster.save(halldtl);

		return dtl;

	}

	public HallBookingDetails checkStatus(RequestPacket hallBookRequest) {

		List<Integer> hallListCapacity = daoRepo.getStatus(hallBookRequest.getCapacityRequired(),
				hallBookRequest.getDate(), hallBookRequest.getTimeDuration());
		System.out.println("Booking cap size>>" + hallBookRequest.getCapacityRequired());

		HallBookingDetails bookingdetails = new HallBookingDetails();

		if (hallListCapacity.isEmpty()) {
			HallDetails hallbooking = daoforMaster.getHall(hallBookRequest.getCapacityRequired());
			if (hallbooking != null) {
				bookingdetails.setHallName(hallbooking.getHallName());
				bookingdetails.setCapacity(hallbooking.getCapacity());
				bookingdetails.setBookingDate(hallBookRequest.getDate());
				bookingdetails.setBookingtime(hallBookRequest.getTimeDuration());
				bookingdetails.setStatus("Booked");
				daoRepo.save(bookingdetails);
			} else {

				bookingdetails.setStatus("NO BOOKING AVAILABLE FOR REQUIRED REQUEST");
			}

		} else {
			List<HallDetails> hallDtl = daoforMaster.getHallDtl(hallListCapacity);

			if (!hallDtl.isEmpty()) {
				for (HallDetails hall : hallDtl) {
					if (hall.getCapacity() >= hallBookRequest.getCapacityRequired()) {
						bookingdetails.setCapacity(hall.getCapacity());
						bookingdetails.setHallName(hall.getHallName());
						break;

					}

				}
				bookingdetails.setBookingDate(hallBookRequest.getDate());
				bookingdetails.setBookingtime(hallBookRequest.getTimeDuration());
				bookingdetails.setStatus("Booked");
				daoRepo.save(bookingdetails);

			} else {
				bookingdetails.setStatus("NO BOOKING AVAILABLE FOR REQUIRED REQUEST");

			}
		}
		return bookingdetails;

	}
}
