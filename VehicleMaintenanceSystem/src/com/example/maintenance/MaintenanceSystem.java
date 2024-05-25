package com.example.maintenance;

import java.util.*;

public class MaintenanceSystem extends Vehicle implements MaintenanceActivity, MaintenanceScheduler,
        RepairRequestHandler, MaintenanceReminderGenerator, SparePartsInventoryManager, MileageMonitor,
        MaintenanceReportGenerator, MaintenanceScheduleManager, WarrantyTracker, RepairStatusTracker {
    public Map<String, List<String>> repairStatusMap;
    public Map<String, Date> maintenanceScheduleMap;
    public Map<String, Double> mileageMap;

    public MaintenanceSystem(String vehicleId, double mileage) {
        super(vehicleId, mileage);
        this.repairStatusMap = new HashMap<>();
        this.maintenanceScheduleMap = new HashMap<>();
        this.mileageMap = new HashMap<>();
        this.mileage = mileage;
    }

    @Override
    public void recordMaintenance(String kind, Date date, String description, double cost) {
        System.out.println("Maintenance recorded for vehicle " + vehicleId + ": " + description);
    }

    @Override
    public void scheduleMaintenanceTask(String vehicleId, Date date) {
        maintenanceScheduleMap.put(vehicleId, date);
        System.out.println("Maintenance scheduled for vehicle " + vehicleId + " on " + date);
    }

    @Override
    public void processRepairRequest(String vehicleId, String issueDescription) {
        List<String> repairStatus = repairStatusMap.getOrDefault(vehicleId, new ArrayList<>());
        repairStatus.add(issueDescription);
        repairStatusMap.put(vehicleId, repairStatus);
        System.out.println("Repair request processed for vehicle " + vehicleId + ": " + issueDescription);
    }

    @Override
    public void generateMaintenanceReminder(String vehicleId) {
        System.out.println("Maintenance reminder generated for vehicle " + vehicleId);
    }

    @Override
    public void monitorSparePartsAvailability() {
        System.out.println("Monitoring spare parts availability...");
    }

    @Override
    public void trackVehicleMileage(String vehicleId, double mileage) {
        mileageMap.put(vehicleId, mileage);
        System.out.println("Vehicle mileage tracked for " + vehicleId + ": " + mileage);
    }

    @Override
    public void generateMaintenanceReport(String vehicleId) {
        List<String> repairStatus = repairStatusMap.getOrDefault(vehicleId, new ArrayList<>());
        System.out.println("Maintenance report for vehicle " + vehicleId + ":");
        System.out.println("Repair Status: " + repairStatus);
    }

    @Override
    public void manageMaintenanceSchedule(String vehicleId, Date scheduleDate) {
        maintenanceScheduleMap.put(vehicleId, scheduleDate);
        double initialMileage = mileageMap.getOrDefault(vehicleId, 0.0);
        double nextMaintenanceMileage = initialMileage + 3000.0;
        System.out.println("Next maintenance for vehicle " + vehicleId + " should be scheduled when the mileage reaches: " + nextMaintenanceMileage);
    }

    @Override
    public void trackWarrantyInformation(String vehicleId) {
        System.out.println("Tracking warranty information for vehicle " + vehicleId);
    }

    @Override
    public void trackRepairStatus(String vehicleId) {
        List<String> repairStatus = repairStatusMap.getOrDefault(vehicleId, new ArrayList<>());
        System.out.println("Repair status for vehicle " + vehicleId + ": " + repairStatus);
    }
}
