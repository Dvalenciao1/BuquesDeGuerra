package buquesdeguerra;


import javax.swing.JButton;

public class Barco {

    private int barcos[][] = {{3, 3}, {2, 2}};
    private JButton[][] tablero;

    public Barco(JButton[][] tablero) {
        this.tablero = tablero;
    }

    public boolean setBarco(int inicioH, int inicioV, int finH, int finV) {
        // Revisamos si existe un barco en esa posicion o en sus alrededores
        if (existeBarco(inicioH, inicioV, finH, finV) == false) {

            // guardamos el barco
            for (int i = inicioH; i <= finH; i++) {
                for (int j = inicioV; j <= finV; j++) {
                    tablero[i][j].setText("1");

                }
            }
            return true;
        } else {
            return false;
        }
    }

    public void crearBarcosAleatorio() {
        int inicioH = 0, inicioV = 0, finH = 0, finV = 0;
        // definimos las posiciones de los barcos [barcos,posiciones]

        for (int i = 0; i < barcos.length; i++) {
            for (int j = 0; j < barcos[i][0]; j++) {
                inicioH = (int) (Math.random() * 7);
                inicioV = (int) (Math.random() * 6);
                int direccion = (int) (Math.random() * 2);

                if (direccion == 0) {
                    // derecha

                    finH = inicioH + barcos[i][1] - 1;
                    finV = inicioV;

                } else if (direccion == 1) {
                    // abajo
                    finH = inicioH;
                    finV = inicioV + barcos[i][1] - 1;

                }

                if (setBarco(inicioH, inicioV, finH, finV) == false) {
                    j--;
                }
            }

        }
    }

    public boolean existeBarco(int inicioH, int inicioV, int finH, int finV) {
        if (finH > 6 || finV > 5) {
            return true;
        }

        inicioH = inicioH > 0 ? inicioH - 1 : inicioH;
        inicioV = inicioV > 0 ? inicioV - 1 : inicioV;
        finH = finH < 6 ? finH + 1 : finH;
        finV = finV < 5 ? finV + 1 : finV;

        for (int i = inicioH; i <= finH; i++) {
            for (int j = inicioV; j <= finV; j++) {
                if (tablero[i][j].getText().equals("1")) {
                    return true;
                }
            }
        }
        return false;
    }

    public JButton[][] getTablero() {
        return tablero;
    }
}
