package com.example.maintenance;

import java.util.Date;

public interface MaintenanceScheduler {
    void scheduleMaintenanceTask(String vehicleId, Date date);
}
