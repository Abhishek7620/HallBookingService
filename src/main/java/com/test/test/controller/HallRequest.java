package com.test.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.test.model.HallBookingDetails;
import com.test.test.model.HallDetails;
import com.test.test.model.RequestPacket;
import com.test.test.service.HallService;

@RestController
public class HallRequest {

	@Autowired
	HallService hallService;

	// Hand the request as to book the hall
	@PostMapping("/bookHall")
	public ResponseEntity<HallBookingDetails> bookHall(@RequestBody RequestPacket hallBookRequest) {
		HallBookingDetails bookHall =new HallBookingDetails ();
		
		String status = validateRequestFormat(hallBookRequest);
		if(status!=null && status.equals("invalid")) {
			return new ResponseEntity<HallBookingDetails>(bookHall, HttpStatus.BAD_REQUEST);

		}else {
			 bookHall = hallService.bookHall(hallBookRequest);
			if (bookHall != null) {
				return new ResponseEntity<HallBookingDetails>(bookHall, HttpStatus.OK);

			} else {
				return new ResponseEntity<HallBookingDetails>(bookHall, HttpStatus.ACCEPTED);

			}
		}
		

	}

	private String validateRequestFormat(RequestPacket hallBookRequest) {
		String flag = null;
		String time = hallBookRequest.getTimeDuration();
		String date = hallBookRequest.getDate();

		if (time != null) {
			String[] toandfrom = time.split("-");
			if (toandfrom != null) {
				if ((Integer.parseInt(toandfrom[0]) < 0 || Integer.parseInt(toandfrom[0]) > 2400)
						&& Integer.parseInt(toandfrom[0]) < 0 || Integer.parseInt(toandfrom[0]) > 2400) {
					flag = "invalid";

				}

			}
		}
		if (!date.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})")) {
			flag = "invalid";
		}
		return flag;
	}

	// Create for maintaing and adding the HallMASTER
	@PostMapping("/createNewHall")
	public ResponseEntity<HallDetails> createHall(@RequestBody HallDetails hallDtl) {

		HallDetails statusDtl = hallService.createHall(hallDtl);
		if (statusDtl != null) {
			return new ResponseEntity<HallDetails>(statusDtl, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<HallDetails>(statusDtl, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
