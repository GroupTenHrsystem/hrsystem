package com.hrsystem.common.specificationBuilder;

import org.apache.commons.collections.CollectionUtils;

import java.util.Collection;
import java.util.Optional;
/**
*@项目名称: hrsystem
*@作者: HyperMuteki
**/
public final class Nullable {

    private Nullable() {
    }

    public static <T> Optional<T> of(T value) {
        return value instanceof Collection
                ? CollectionUtils.isEmpty((Collection) value) ? Optional.empty() : Optional.of(value)
                : Optional.ofNullable(value);
    }
}
