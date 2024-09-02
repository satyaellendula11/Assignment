package com.aerospike.assignment.controller;

import com.aerospike.assignment.entity.DeviceInfo;
import com.aerospike.assignment.service.DeviceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deviceInfo")
public class DeviceInfoController {

    @Autowired
    private DeviceInfoService deviceInfoService;

    @PutMapping
    public ResponseEntity<DeviceInfo> createOrUpdateDeviceInfo(@RequestBody DeviceInfo pDeviceInfo) {
        return  deviceInfoService.createOrUpdateDeviceInfo(pDeviceInfo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDeviceInfoById(@PathVariable(name = "id")  String deviceId) {
        deviceInfoService.deleteDeviceInfo(deviceId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeviceInfo> getDeviceInfoById(@PathVariable(name = "id") String deviceId) {
        return ResponseEntity.ok(deviceInfoService.getDeviceInfoByDeviceId(deviceId));
    }

    @GetMapping
    public ResponseEntity<List<DeviceInfo>> getDeviceInfoByOsName(@RequestParam(name = "osName") String osName) {
        return ResponseEntity.ok(deviceInfoService.getAllDeviceInfosByOsName(osName));
    }
}
