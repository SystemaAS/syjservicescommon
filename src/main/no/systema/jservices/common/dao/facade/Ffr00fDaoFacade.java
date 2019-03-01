package no.systema.jservices.common.dao.facade;
import java.util.HashMap;
import java.util.Map;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import lombok.Data;

import org.modelmapper.ModelMapper;
import no.systema.jservices.common.dao.modelmapper.converter.DaoConverter;
import no.systema.jservices.common.dto.Ffr00fDto;
import no.systema.jservices.common.dao.Ffr00fDao;
import no.systema.jservices.common.dao.Ffr03fDao;
import no.systema.jservices.common.dao.Ffr04fDao;
import no.systema.jservices.common.dao.Ffr08fDao;
import no.systema.jservices.common.dao.Ffr10fDao;
import no.systema.jservices.common.dao.Ffr11fDao;



/**
 * Tradevision Facade for DTO-DAOs conversion towards service with multi-daos
 * This class deals with all the ModelMapper conversions.
 * 
 * @author oscardelatorre
 * @date Mar, 2019
 *
 */
@Data
public class Ffr00fDaoFacade {
	private ModelMapper modelMapper = new ModelMapper();
	private DaoConverter daoConverter = new DaoConverter();
	private Ffr00fDto dto;
	//
	private Ffr00fDao ffr00fDao;
	private Ffr03fDao ffr03fDao;
	private Ffr04fDao ffr04fDao;
	private Ffr08fDao ffr08fDao;
	private Ffr10fDao ffr10fDao;
	private Ffr11fDao ffr11fDao;
	
	/**
	 * 
	 */
	public Ffr00fDaoFacade(Ffr00fDto dto){
		modelMapper.addConverter(daoConverter.doBigDecimal());
		modelMapper.addConverter(daoConverter.doInteger());
		this.dto = dto;
		//populate all child-tables' foreign keys
		this.dto.setF03rec(this.dto.getF00rec());
		this.dto.setF04rec(this.dto.getF00rec());
		this.dto.setF08rec(this.dto.getF00rec());
		this.dto.setF10rec(this.dto.getF00rec());
		this.dto.setF11rec(this.dto.getF00rec());

	}

	/**
	 * 
	 * @param dto
	 * @param dao
	 * @return
	 */
	public Object getDao(Class<?> dao){
		Object resultDao = modelMapper.map(this.dto, dao);
		return resultDao;
	}
	
}
