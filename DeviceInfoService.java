package com.aerospike.assignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aerospike.assignment.entity.DeviceInfo;
import com.aerospike.assignment.exception.NotFoundException;
import com.aerospike.assignment.repo.DeviceInfoRepository;

@Service
public class DeviceInfoService {
    @Autowired
    private DeviceInfoRepository deviceInfoRepository;

    public DeviceInfo getDeviceInfoByDeviceId(String pDeviceId) {
        return deviceInfoRepository.findById(pDeviceId).
                orElseThrow(() -> new NotFoundException("Device not found with id "+ pDeviceId));
    }

    public List<DeviceInfo> getAllDeviceInfosByOsName(String pOsName) {
        return deviceInfoRepository.findByOsName(pOsName);
    }

    public void deleteDeviceInfo(String pDeviceId) {
        DeviceInfo deviceInfo = getDeviceInfoByDeviceId(pDeviceId);
        deviceInfoRepository.delete(deviceInfo);
    }

    public ResponseEntity<DeviceInfo> createOrUpdateDeviceInfo(DeviceInfo pDeviceInfo) {
        Optional<DeviceInfo> existingDevice = deviceInfoRepository.findById(pDeviceInfo.getDeviceId());
        HttpStatus status = null;
        if (existingDevice.isPresent()) {
            pDeviceInfo = existingDevice.get();
            pDeviceInfo.setHitCount(pDeviceInfo.getHitCount() + 1);
            status = HttpStatus.OK;
        }
        else {
            pDeviceInfo.setHitCount(1);
            status = HttpStatus.CREATED;
        }
        return new ResponseEntity<>(deviceInfoRepository.save(pDeviceInfo), status);
    }
}
