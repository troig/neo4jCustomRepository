package com.mypackage.api.user.domain;


import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

import java.io.Serializable;

@NodeEntity
abstract class BasicNodeEntity implements Serializable {

    @GraphId
    private Long nodeId;

    public Long getNodeId() {
        return nodeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BasicNodeEntity)) return false;

        BasicNodeEntity that = (BasicNodeEntity) o;

        return nodeId != null && nodeId.equals(that.nodeId);
    }

    @Override
    public int hashCode() {
        return nodeId != null ? nodeId.hashCode() : 0;
    }
}
