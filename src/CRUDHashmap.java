import java.util.HashMap;
import javax.swing.JOptionPane;

public class CRUDHashmap {

	public static void main(String[] args) {
		String menu="PROCESOS \n\n";
		menu+="1.Registrar Personas\n";
		menu+="2.Consultar Por Documento\n";
		menu+="3.Consultar Todo\n";
		menu+="4.Actualizar Persona\n";
		menu+="5.Eliminar Personas\n";
		menu+="6.Consultar Por Nombres\n";
		menu+="¿Que Desea Realizar?\n\n";
		
		String iter="SI";
		String nombre;
		String documento;
		
		HashMap<String,String> mapRegister=new HashMap<String,String>();
		
		while (iter.toUpperCase().equals("SI")){
			int n=Integer.parseInt(JOptionPane.showInputDialog(menu));
			switch (n) {
			case 1:
				documento=JOptionPane.showInputDialog("Registro!!!\n\n\nIngrese el documento");
				nombre=JOptionPane.showInputDialog("Registro!!!\\n\\n\\nIngrese su nombre");
				registrarPersona(nombre,documento,mapRegister);
				break;
			case 2:
				documento=JOptionPane.showInputDialog("Consultar por documento!!\n\n\nIngrese el documento");
				consultarDocumento(documento,mapRegister);
				break;
			case 3:
				consultarTodo(mapRegister);
				break;
			case 4:
				documento=JOptionPane.showInputDialog("Actualizar persona!!!\n\n\nIngrese el documento");
				actualizarPersona(documento,mapRegister);
				break;
			case 5:
				documento=JOptionPane.showInputDialog("Eliminar persona!!!\n\n\nIngrese el documento");
				eliminarPersona(documento,mapRegister);
				break;
			case 6:
				nombre=JOptionPane.showInputDialog("Consultar por nombre\n\n\nIngrese el nombre");
				consultarNombre(nombre,mapRegister);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Esa opcion no es valida!!!");
				break;
				
			}
			iter=JOptionPane.showInputDialog("¿Desea seguir con el programa?\nSi o No");
		}
		JOptionPane.showMessageDialog(null, "Programa Terminó!!!");	
	}

	private static void eliminarPersona(String documento, HashMap<String, String> mapRegister) {
		if (mapRegister.get(documento)==null) {
			JOptionPane.showMessageDialog(null,"La persona con el documento "+documento+" no se encuentra registrada!!");
		}else {
			String e=JOptionPane.showInputDialog("¿Esta seguro que desea eliminar al usuario "+mapRegister.get(documento)+" ?\n\n(SI o NO)");
			if (e.toUpperCase().equals("SI")) {
				mapRegister.remove(documento);
				JOptionPane.showMessageDialog(null,"Se ha eliminado");
			}
		}
	}

	private static void actualizarPersona(String documento, HashMap<String, String> mapRegister) {
		if (mapRegister.get(documento)== null) {
			JOptionPane.showMessageDialog(null,"El usuario con documento "+documento+" no existe!!");
		}else {
			String u=JOptionPane.showInputDialog("Ingrese el nuevo nombre que desea insertar:");
			String i=JOptionPane.showInputDialog("¿Desea ingresar el nuevo nombre?\n\n(Si o No)");
			String o=mapRegister.get(documento);
			if (i.toUpperCase().equals("SI")) {
				mapRegister.replace(documento, u.toUpperCase());
				JOptionPane.showMessageDialog(null, "El usuario a actualizado su nombre de "+o+" a "+mapRegister.get(documento)+"!!");
			}
		}
	}

	private static void consultarTodo(HashMap<String, String> mapRegister) {
		for (HashMap.Entry<String,String> entry : mapRegister.entrySet()) {
		    System.out.println((entry.getKey() + " - " + entry.getValue()));
		}
	}

	private static void consultarDocumento(String documento, HashMap<String, String> mapRegister) {
		if(mapRegister.get(documento) == null) {
			JOptionPane.showMessageDialog(null, "El usuario no existe!!!");
		}else {
			JOptionPane.showMessageDialog(null, "El usuario corresponde a "+mapRegister.get(documento));
		}
	}

	private static void consultarNombre(String nombre, HashMap<String, String> mapRegister) {
		if(mapRegister.containsValue(nombre)) {
			JOptionPane.showMessageDialog(null, "El usuario "+nombre+ " si esta registrado!!");
		}else {
			JOptionPane.showMessageDialog(null, "El usuario "+nombre+" no existe!!");
		}
	}

	private static void registrarPersona(String nombre, String documento, HashMap<String,String> mapRegister) {
		if(mapRegister.containsKey(documento)) {
			JOptionPane.showMessageDialog(null,"La persona ya existe!!");
		}else {
			mapRegister.put(documento, nombre.toUpperCase());
			JOptionPane.showMessageDialog(null, "Persona "+mapRegister.get(documento)+" Registrada con Exito!!");
		}
	}

}
