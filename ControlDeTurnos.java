import java.util.ArrayList;
import java.util.Scanner;

public class ControlDeTurnos {

    static class Turno {
        String turno;
        String operario;

        public Turno(String turno, String operario) {
            this.turno = turno;
            this.operario = operario;
        }
    }

    static ArrayList<Turno> listaDeTurnos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sistema de Control de Turnos");

        boolean seguir = true;

        while (seguir) {
            System.out.println("\nOpciones:");
            System.out.println("1. Asignar turno");
            System.out.println("2. Eliminar turno");
            System.out.println("3. Ver turnos");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    // Asignar turno
                    System.out.print("Ingrese el número de turno: ");
                    String turno = scanner.nextLine();
                    System.out.print("Ingrese el nombre del operario: ");
                    String operario = scanner.nextLine();
                    listaDeTurnos.add(new Turno(turno, operario));
                    System.out.println("Turno asignado: " + turno + " a " + operario);
                    break;

                case 2:
                    // Eliminar turno
                    System.out.print("Ingrese el número de turno a eliminar: ");
                    String turnoEliminar = scanner.nextLine();
                    boolean encontrado = false;
                    for (Turno t : listaDeTurnos) {
                        if (t.turno.equals(turnoEliminar)) {
                            listaDeTurnos.remove(t);
                            System.out.println("Turno " + turnoEliminar + " eliminado.");
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Turno no encontrado.");
                    }
                    break;

                case 3:
                    // Ver turnos
                    if (listaDeTurnos.isEmpty()) {
                        System.out.println("No hay turnos asignados.");
                    } else {
                        System.out.println("Turnos asignados:");
                        for (Turno t : listaDeTurnos) {
                            System.out.println(t.turno + " asignado a " + t.operario);
                        }
                    }
                    break;

                case 4:
                    // Salir
                    seguir = false;
                    System.out.println("Sistema cerrado.");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }

        scanner.close();
    }
}

