package com.alibiner.interfaces.vaccine;

import java.util.*;
import com.alibiner.entities.Vaccine;

public interface IVaccineVerificationService {
    Vaccine verify(UUID id);
}
