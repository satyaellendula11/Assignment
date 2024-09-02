package com.aerospike.assignment.repo;

import com.aerospike.assignment.entity.DeviceInfo;
import org.springframework.data.aerospike.repository.AerospikeRepository;

import java.util.List;

public interface DeviceInfoRepository extends AerospikeRepository<DeviceInfo, String> {

    List<DeviceInfo> findByOsName(String osName);
}
