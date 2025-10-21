package com.alibiner.interfaces.appointment;

import java.util.*;
import com.alibiner.entities.Appointment;

public interface IAppointmentVerificationService {
    void verify(UUID id);

    Appointment verifyAndGet(UUID id);
}
