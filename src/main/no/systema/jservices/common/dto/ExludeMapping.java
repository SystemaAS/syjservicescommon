package no.systema.jservices.common.dto;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import no.systema.jservices.common.dao.GenericObjectMapper;
/**
 * Use on attributes that should not be a part of mapping to sql.
 * Typically used in Dto's going into {@link GenericObjectMapper}
 * 
 * @author Fredrik Möller
 * @date Aug 10, 2017
 * */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD) 
public @interface ExludeMapping {}
