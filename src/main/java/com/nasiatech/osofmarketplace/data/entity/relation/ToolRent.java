package com.nasiatech.osofmarketplace.data.entity.relation;

import com.nasiatech.osofmarketplace.data.entity.Farmer;
import com.nasiatech.osofmarketplace.data.entity.Tool;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity @Table(name = "osof_tool_rent")
public class ToolRent {
    @EmbeddedId
    private ToolRentKey key;

    @MapsId("toolId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "tool_id", nullable = false)
    private Tool tool;

    @MapsId("farmerId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "farmer_id", nullable = false)
    private Farmer farmer;

    @Getter
    @Setter
    @EqualsAndHashCode
    @NoArgsConstructor
    @AllArgsConstructor
    static class ToolRentKey implements Serializable {
        @Serial
        private static final long serialVersionUID = -1666079733964533222L;
        private Integer toolId;
        private Integer farmerId;
    }
}
