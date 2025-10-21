package com.alibiner.interfaces.vaccine;

import java.util.*;
import com.alibiner.entities.Vaccine;

import java.time.LocalDate;

public interface IVaccineCalculateService {
    /**
     * @return if vaccine is one time, return null. if flexible vaccine, return two element in list. first element is
     * vaccine cycle date and second element is flexible cycle date.
     *
     */
    List<LocalDate> calculateCycleDate(Vaccine vaccine);
}
