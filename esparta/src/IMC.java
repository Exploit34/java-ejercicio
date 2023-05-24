import javax.swing.JOptionPane;
import java.util.ArrayList;

public class IMC{

public void menu() {
    ArrayList<String> nombre = new ArrayList<>();
    ArrayList<String> resultado = new ArrayList<>();

    String menu;
    menu = " <<<<<-- IMC PACIENTES -->>>>> \n";
    menu += "1. Ingresar paciente\n";
    menu += "2. Buscar paciente\n";
    menu += "3. Imprimir\n";
    menu += "4. Actualizar datos\n";
    menu += "5. Eliminar lista\n";
    menu += "6. Salir del programa\n";
    menu += "Ingrese una opcion\n";
    
    int opc = 0;
    boolean salir = false;
    do {
        opc=Integer.parseInt(JOptionPane.showInputDialog(menu));
        inicio(opc, salir,nombre,resultado);
    } while (opc!=6);
}

public void inicio(int opc, boolean salir, ArrayList<String> nombre, ArrayList<String> resultado){
    
    switch (opc) {
        case 1:
            paciente(nombre, resultado);
            break;

        case 2:
            buscar(nombre);
            break;

        case 3:
            imprimir(resultado,nombre);
            break;

        case 4:
            actualizar(nombre, resultado);
            break;

        case 5:

            break;

        case 6:
            salir = true;
            int res;
            res = JOptionPane.showConfirmDialog(null, "veo que quires salir", "confirmar", JOptionPane.YES_OPTION);
            if (res == JOptionPane.YES_OPTION) {
                System.exit(0);
            }else{
                menu();
            }
            break;
    
        default:
            if(opc > 6){
                JOptionPane.showMessageDialog(null, "Estas ingresando un valor no valido el numero va entre 1 hasta 6");
            }else if(opc == 0){
                JOptionPane.showMessageDialog(null, "No has ingresado ninguna opcion");
            }
            break;
    }
}

public void paciente(ArrayList<String>nombre, ArrayList<String>resultado) {
    int n;
    n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de pacientes..."));
    for (int i = 1; i <= n; i++) {
        nombre.add(JOptionPane.showInputDialog("Ingrese nombre del paciente : " + i));
        Double peso, talla, IMC;
        peso = Double.parseDouble(JOptionPane.showInputDialog("Ingrese peso del paciente:"));
        talla = Double.parseDouble(JOptionPane.showInputDialog("Ingrese talla del paciente:"));
        IMC = 0.0;
        validar(IMC, peso, talla, resultado);
    }
}

public void validar(Double IMC, Double peso, Double talla, ArrayList<String>resultado) {
    IMC = peso / (talla * talla);
        if(IMC < 18){
            String msj = "anorexia";
            resultado.add(/* "El paciente " + nombre.get(i-1) + " tiene un IMC de " +*/ msj);
        }else if(IMC >= 18 || IMC < 20 ){
            String msj = "delgadez";
            resultado.add(/*"El paciente " + nombre.get(i-1) + " tiene un IMC de " +*/ msj);
        }else if(IMC >= 20 || IMC < 27){
            String msj = "normalidad";
            resultado.add(/*"El paciente " + nombre.get(i-1) + " tiene un IMC de " +*/ msj);
        }else if(IMC >= 27 || IMC < 30){
            String msj = "obesidad(grado 1)";
            resultado.add(/* " El paciente " + nombre.get(i-1) + " tiene un IMC de " +*/ msj);
        }else if(IMC >= 30 || IMC < 35){
            String msj = "obesidad(grado 2)";
            resultado.add(/* "El paciente " + nombre.get(i-1) + " tiene un IMC de " +*/ msj);
        }else if(IMC >= 35 || IMC < 40){
            String msj = "obesidad(grado 3)";
            resultado.add(/* "El paciente " + nombre.get(i-1) + " tiene un IMC de " +*/ msj);
        }else if(IMC >= 40){
            String msj = "obesidad morvida";
            resultado.add(/*"El paciente " + nombre.get(i-1) + " tiene un IMC de " +*/ msj);
        }
}

public void buscar(ArrayList<String>nombre){
    String nom = JOptionPane.showInputDialog("Ingrese nombre del paciente");

    if(nombre.contains(nom)){
        for (int i = 0; i < nombre.size(); i++) {
            if(nombre.get(i).equalsIgnoreCase(nom)){
                JOptionPane.showMessageDialog(null, " ---------------------------BUSCAR--------------------------- " + "\n" +
                "El nombre " + nombre.get(i)+ " si existe en la lista");
            }else if(nombre.get(i) == nom) {
                JOptionPane.showMessageDialog(null, "El nombre "+nom+" no se encuentra en la lista");
            }
        }
    }
}

public void imprimir(ArrayList<String>resultado,ArrayList<String>nombre) {
    String list = "";
    for (int i = 0; i < resultado.size(); i++) {
        
        JOptionPane.showMessageDialog(null, "------------------------------IMPRIMIR------------------------------"+
        "\n"+ (list += "El paciente " + nombre.get(i) + " tiene un IMC de " + resultado.get(i) + "\n"));          
    }
}

public void actualizar(ArrayList<String>nombre,ArrayList<String>resultado) {
    String nom = JOptionPane.showInputDialog("Ingrese el nombre a actualizar");
    for (int i = 0; i < nombre.size(); i++) {
        if(nombre.get(i).equalsIgnoreCase(nom)){
            String nomm = JOptionPane.showInputDialog(null, "Ingrese el nombre por el cual a actualizar ");
            nombre.set(i,nomm);
            for (String elemente : nombre){
                nombre.get(i);
            }
        }else{
            JOptionPane.showMessageDialog(null, "El nombre "+nom+" no se encuentra en la lista");
            actualizar(nombre, resultado);
        }
    }
}
}