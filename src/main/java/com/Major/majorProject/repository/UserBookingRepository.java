package com.Major.majorProject.repository;

import com.Major.majorProject.entity.PC;
import com.Major.majorProject.entity.UserBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface UserBookingRepository extends JpaRepository<UserBooking,Long> {

//    @Query("SELECT u FROM UserBooking u WHERE u.bookingDate=:date AND u.pc=:pc")
//    List<UserBooking> getAllBooking(@Param("date")LocalDate date, @Param("pc") PC pc);


    List<UserBooking> findByBookingDateAndPc(LocalDate date, PC pc);
}
