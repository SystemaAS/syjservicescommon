package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

/**
 * Godslokalkod
 * 
 * @author fredrikmoller
 * @date 2019-05-20
 */
@Data
public class SvltfDao implements IDao {

	private Integer svltf_aar;
	private String svltf_igl;
	private Integer svltf_num;
	private String svltf_txt;
	
	Map<String, Object> keys = new HashMap<String, Object>();	
	
	@Override
	public Map<String, Object> getKeys() {
		keys.put("svltf_igl", svltf_igl);
		return keys;
	}

}
