package com.aerospike.assignment.entity;

import com.aerospike.client.query.IndexType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.aerospike.annotation.Indexed;
import org.springframework.data.aerospike.mapping.Document;
import org.springframework.data.annotation.Id;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceInfo {
    @Id
    @NonNull
    private String deviceId;
    @Indexed(name = "osName_idx" ,type = IndexType.STRING)
    private String osName;
    private String osVersion;
    private String browserName;
    private String browserVersion;
    private int hitCount;
}
