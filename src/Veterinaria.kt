class Veterinaria {
    private val mascotas = mutableListOf<Mascota>()
    private val consultas = mutableListOf<ConsultaMedica>()

    fun agregarMascota(mascota: Mascota) {
        mascotas.add(mascota)
    }

    fun registrarConsulta(consulta: ConsultaMedica) {
        consultas.add(consulta)
    }

    fun mostrarHistorialConsultas(nombreMascota: String) {
        val historial = consultas.filter { it.obtenerDetalleConsulta().contains(nombreMascota) }
        if (historial.isEmpty()) {
            println("No hay información para mostrar.")
        } else {
            println("Historial de consultas para $nombreMascota:")
            for (consulta in historial) {
                println(consulta.obtenerDetalleConsulta())
            }
        }
    }

    fun calcularCostoTotalConsultas(nombreMascota: String): Double {
        var total = 0.0
        for (consulta in consultas) {
            if (consulta.obtenerDetalleConsulta().contains(nombreMascota)) {
                total += consulta.calcularCosto()
            }
        }
        return total
    }

    fun obtenerMascota(nombre: String): Mascota? {
        return mascotas.find { it.nombre == nombre }
    }

    fun mostrarTodasLasMascotas() {
        if (mascotas.isEmpty()) {
            println("No hay mascotas registradas.")
        } else {
            println("Lista de todas las mascotas registradas:")
            for (mascota in mascotas) {
                println(mascota.describirMascota())
            }
        }
    }

    fun obtenerCostoTotalFormateado(nombreMascota: String): String {
        val costoTotal = calcularCostoTotalConsultas(nombreMascota)
        return String.format("%,.2f", costoTotal)
    }
}
