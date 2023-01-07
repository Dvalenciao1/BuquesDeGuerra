package buquesdeguerra;

import java.awt.Color;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Player {

    private int movimientos = 5;
    private int rondas = 1;
    private int puntos = 0;
    private int errores = 0;
    private int aciertos = 0;
    private int[] barcos = {0, 0, 0, 0, 0};

    //tablero
    private JButton[][] tabla;
    private ArrayList<ArrayList<Integer>> posiciones = new ArrayList<>();
    private ArrayList<ArrayList<Integer>> listaDePosiciones = new ArrayList<>();
    private int[][] bandera = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0}, {0, 0}};

    public void Movimientos(JButton button, JLabel JLabelRonda, JLabel JLabelPuntos) {
        this.puntos = 0;
        if (movimientos > 0) {
            movimientos--;
        } else if (rondas <= 7) {
            rondas++;
            if (movimientos == 0) {
                movimientos = 5;
                movimientos--;
            }
            JLabelRonda.setText(String.valueOf(rondas));
        } else {
            movimientos = -1;
        }

        if (button.getText().equals("1") && movimientos > -1) {
            button.setBackground(Color.yellow);
            button.setEnabled(false);

            //definicion de puntaje
            setPuntosObtenidos();
            contadorDePuntos();

        } else if (button.getText().equals("~") && movimientos > -1) {
            button.setBackground(Color.red);
            button.setEnabled(false);
            errores += (-10);
        }
        puntos += errores;
        puntos += aciertos;
        JLabelPuntos.setText(String.valueOf(this.puntos));
    }

    public void setPuntosObtenidos() {
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[i].length; j++) {
                int red = tabla[i][j].getBackground().getRed();
                int green = tabla[i][j].getBackground().getGreen();
                if (red == 255 && green == 255) {
                    for (int k = 0; k < posiciones.size(); k++) {
                        if (posiciones.get(k).size() == 6) {
                            if (posiciones.get(k).get(0) == i && posiciones.get(k).get(1) == j) {
                                bandera[k][0] = 1;
                            }
                            if (posiciones.get(k).get(2) == i && posiciones.get(k).get(3) == j) {
                                bandera[k][1] = 1;
                            }
                            if (posiciones.get(k).get(4) == i && posiciones.get(k).get(5) == j) {
                                bandera[k][2] = 1;
                            }
                        } else if (posiciones.get(k).size() == 4) {
                            if (posiciones.get(k).get(0) == i && posiciones.get(k).get(1) == j) {
                                bandera[k][0] = 1;
                            }
                            if (posiciones.get(k).get(2) == i && posiciones.get(k).get(3) == j) {
                                bandera[k][1] = 1;
                            }
                        }

                    }
                }
            }
        }

// ************OTRA FORMA INCOMPLETA**************
//
//
//        for (int i = 0; i < listaDePosiciones.size(); i++) {
//            int inicioH = listaDePosiciones.get(i).get(0);
//            int finH = listaDePosiciones.get(i).get(1);
//            int inicioV = listaDePosiciones.get(i).get(2);
//            int finV = listaDePosiciones.get(i).get(3);
//
//            for (int j = inicioH; j <= finH; j++) {
//                for (int k = inicioV; k <= finV; k++) {
//                    int red = tabla[j][k].getBackground().getRed();
//                    int green = tabla[j][k].getBackground().getGreen();
//                    if (red == 255 && green == 255) {
//                        System.out.println("golpeado");
//                        System.out.println(j + "," + k);
//                    }
//
//                }
//            }
//        }
    }

    public void obtenerInicioFin() {
        int inicioH, FinH, inicioV, FinV;
        ArrayList<ArrayList<Integer>> mainlistaPosiciones = new ArrayList<>();

        for (int a = 0; a < posiciones.size(); a++) {
            ArrayList<Integer> listaPosiciones = new ArrayList<>();
            if (posiciones.get(a).size() == 6) {
                inicioH = posiciones.get(a).get(0);
                FinH = posiciones.get(a).get(1);
                inicioV = posiciones.get(a).get(4);
                FinV = posiciones.get(a).get(5);
            } else {
                inicioH = posiciones.get(a).get(0);
                FinH = posiciones.get(a).get(1);
                inicioV = posiciones.get(a).get(2);
                FinV = posiciones.get(a).get(3);
            }
            listaPosiciones.add(inicioH);
            listaPosiciones.add(FinH);
            listaPosiciones.add(inicioV);
            listaPosiciones.add(FinV);
            mainlistaPosiciones.add(listaPosiciones);
        }
        this.listaDePosiciones = mainlistaPosiciones;
    }

    public void contadorDePuntos() {
        int[][] lista = bandera;
        int contador = 0;
        int puntosBarcos = 0;
        for (int i = 0; i < lista.length; i++) {
            contador = 0;
            if (lista[i].length == 3) {
                for (int j = 0; j < lista[i].length; j++) {
                    if (lista[i][j] == 1) {
                        contador++;
                    }
                }
                if (contador == 1) {
                    barcos[i] = 10;
                } else if (contador == 2) {
                    barcos[i] = 20;
                } else if (contador == 3) {
                    barcos[i] = 45;
                }

            } else {
                for (int j = 0; j < lista[i].length; j++) {
                    if (lista[i][j] == 1) {
                        contador++;
                    }
                }
                if (contador == 1) {
                    barcos[i] = 10;
                } else if (contador == 2) {
                    barcos[i] = 30;
                }

            }
            puntosBarcos += barcos[i];
        }

        aciertos = puntosBarcos;
        if (aciertos == 195) {
            JOptionPane.showMessageDialog(null, "El juego termino hundio todos los barcos");
            rondas = 8;
            movimientos = -1;
        }
    }

    public ArrayList<ArrayList<Integer>> getPosiciones() {
        return posiciones;
    }

    public void setPosiciones(ArrayList<ArrayList<Integer>> posiciones) {
        this.posiciones = posiciones;
    }

    public JButton[][] getTabla() {
        return tabla;
    }

    public void setTabla(JButton[][] tabla) {
        this.tabla = tabla;
    }

}
