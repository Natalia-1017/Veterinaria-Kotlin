class ConsultaMedica(
    private val mascota: Mascota,
    private val diagnostico: String,
    private val costoBase: Double,
    private val incluyeMedicacion: Boolean
) {
    fun calcularCosto(): Double {
        return if (incluyeMedicacion) costoBase * 1.15 else costoBase
    }

    fun obtenerDetalleConsulta(): String {
        val costoFormateado = String.format("%,.2f", calcularCosto())
        return "Mascota: ${mascota.nombre}, Diagnóstico: $diagnostico, Costo: $$costoFormateado"
    }
}
