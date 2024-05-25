package com.example.maintenance;

import java.util.Date;

public interface MaintenanceActivity {
    void recordMaintenance(String kind, Date date, String description, double cost);
}

