package com.Major.majorProject.repository;

import com.Major.majorProject.entity.UserBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserBookingRepository extends JpaRepository<UserBooking,Long> {
}
