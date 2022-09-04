package chessgame.model.service;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public abstract class ServiceManager {
	private static Map<Class<? extends Service>, Service> services = new HashMap<>();
	
	public static <T extends Service> T getInstance(Class<T> clazz) {
		var service = services.get(clazz);
		
		if(service != null)
			clazz.cast(service);
		
		try {
			service = clazz.getDeclaredConstructor().newInstance();
			services.put(clazz, service);
			service.init();
			return clazz.cast(service);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			return null;
		}
	}
}
