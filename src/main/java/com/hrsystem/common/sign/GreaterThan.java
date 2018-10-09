package com.hrsystem.common.sign;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
*@项目名称: hrsystem
*@作者: HyperMuteki
**/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface GreaterThan {
}
