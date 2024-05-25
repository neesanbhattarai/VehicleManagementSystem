package com.example.maintenance.test;

import com.example.maintenance.MaintenanceSystem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestMain {
    private MaintenanceSystem maintenanceSystem;
    private String vehicleId = "V123";
    private double initialMileage = 1000.0;

    @BeforeEach
    public void setUp() {
        maintenanceSystem = new MaintenanceSystem(vehicleId, initialMileage);
    }

    @Test
    public void testRecordMaintenance() {
        maintenanceSystem.recordMaintenance("Oil Change", new Date(), "Changed oil", 50.0);
        assertNotNull(maintenanceSystem);
    }

    @Test
    public void testScheduleMaintenanceTask() {
        Date scheduleDate = new Date();
        maintenanceSystem.scheduleMaintenanceTask(vehicleId, scheduleDate);
        assertEquals(scheduleDate, maintenanceSystem.maintenanceScheduleMap.get(vehicleId));
    }

    @Test
    public void testProcessRepairRequest() {
        String issueDescription = "Engine noise";
        maintenanceSystem.processRepairRequest(vehicleId, issueDescription);
        List<String> repairStatus = maintenanceSystem.repairStatusMap.get(vehicleId);
        assertNotNull(repairStatus);
        assertTrue(repairStatus.contains(issueDescription));
    }

    @Test
    public void testTrackVehicleMileage() {
        double updatedMileage = 1500.0;
        maintenanceSystem.trackVehicleMileage(vehicleId, updatedMileage);
        assertEquals(updatedMileage, maintenanceSystem.mileageMap.get(vehicleId));
    }

    @Test
    public void testGenerateMaintenanceReport() {
        String issueDescription = "Brake pad replacement";
        maintenanceSystem.processRepairRequest(vehicleId, issueDescription);
        List<String> expectedReport = new ArrayList<>();
        expectedReport.add(issueDescription);
        maintenanceSystem.generateMaintenanceReport(vehicleId);
        assertEquals(expectedReport, maintenanceSystem.repairStatusMap.get(vehicleId));
    }
}
