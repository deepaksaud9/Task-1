package com.sms.pojo.user_management;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RelationPojo {

    private Long relationId;

    private Long authoritiesId;

    private Long roleId;
}
