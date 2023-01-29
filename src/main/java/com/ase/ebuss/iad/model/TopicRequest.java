package com.ase.ebuss.iad.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TopicRequest {
    private String name;
    private int numPartitions;
    private short replicationFactor;
}
