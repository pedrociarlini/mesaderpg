package pedrociarlini.mesaderpg.net.trabalho;

import java.util.HashMap;
import java.util.Map;

import trabalho.IConnLayer;

/**
 * Factory de factories de conexão.
 * @author pedro
 *
 */
public class ConnectionLayerFactory {

	private static Map<String, Class<IConnLayer>> conns = new HashMap<String, Class<IConnLayer>>();

	/**
	 * Registra uma classe que pode servir como conexão pela aplicação.
	 * 
	 * @param connName
	 * @param classe
	 */
	@SuppressWarnings("unchecked")
	public static void registerConnection(String connName,
			Class classe) {
		conns.put(connName, (Class<IConnLayer>) classe);
	}

	/**
	 * Cria uma nova instância de uma Factory de conexão.
	 * 
	 * @param connName
	 *            Nome da classe, registrada previamente.
	 * @return nova instância de uma conexão.
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public static IConnLayer createConnLayerInstance(String connName) {
		IConnLayer result = null;
		try {
			if (conns.containsKey(connName)) {
				result = conns.get(connName).newInstance();
			}
			else {
				throw new Exception("A conexão cujo nome de registro é \"" + connName + "\" não existe.");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return result;
	}
}
