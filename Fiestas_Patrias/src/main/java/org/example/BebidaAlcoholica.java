package org.example;

public class BebidaAlcoholica extends Bebida implements ConsumoResponsable {
    public static final int LIMITE_UNIDADES_POR_CLIENTE = 3;

    private double gradosAlcohol;
    private boolean certificada;
    private boolean ventaRestringida;

    public BebidaAlcoholica(
            String nombre,
            int volumenML,
            int stock,
            double gradosAlcohol,
            boolean certificada){
        super(nombre, volumenML, stock);

        setGradosAlcohol(gradosAlcohol);
        setCertificada(certificada);
        ventaRestringida = false;
    }
    public double getGradosAlcohol() {
                return gradosAlcohol;
    }
    public void setGradosAlcohol(double gradosAlcohol) {
                if (gradosAlcohol <0.5){
                    throw new IllegalArgumentException("Los grados de alcohol deben ser mayores a 0.5");
                }
                if (gradosAlcohol > 45){
                    throw new IllegalArgumentException("Los grados de alcohol no pueden superar los 45");
                }
                this.gradosAlcohol = gradosAlcohol;
    }
    public boolean isCertificada() {
                return certificada;
    }
    public void setCertificada(boolean certificada) {
                this.certificada = certificada;
    }

    @Override
    public double calcularPrecio() {
                double precio = 3500;
                if (certificada == false) {
                    precio = precio * 1.20;
                }
                return precio;
    }

    @Override
    public String obtenerDetalle(){
                String certificacin = "No";
                if (certificada) {
                    certificacin = "Si";
                }
                String restringida = "No";
                if (ventaRestringida) {
                    restringida = "Si";
                }
                return "Tipo: Bebida Alcoholica" + " | Nombre: " + getNombre() + " | Volumen: " + getVolumenML() + " ml" + " | Stock: " + getStock() + " | Grados: " + gradosAlcohol + " | Certificada: " + certificacin + " | VentaRestringida: " + restringida + " | Precio: $" + (int) calcularPrecio();
    }

    @Override
    public boolean tieneVentaRestringida() {
                return ventaRestringida;
    }

    @Override
    public void restringirVenta() {
                ventaRestringida = true;
    }

    @Override
    public boolean superaLimite(int unidades) {
                 if (unidades > LIMITE_UNIDADES_POR_CLIENTE) {
                     return true;
                 }
                 return false;
    }
}
