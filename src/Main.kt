fun main() {
    val veterinaria = Veterinaria()

    while (true) {
        println("\n En que te podemos ayudar")
        println("1. Registrar mascota")
        println("2. Realizar consulta médica")
        println("3. Mostrar historial de las consultas de una mascota")
        println("4. Actualizar peso de una mascota")
        println("5. Incrementar edad de una mascota")
        println("6. Calcular costo total de las consultas de una mascota")
        println("7. Ver todas las mascotas registradas")
        println("8. Salir")
        print("Que deseas realizar: ")

        val opcion = readLine()?.toIntOrNull() ?: 0

        when (opcion) {
            1 -> {
                print("Nombre de la mascota: ")
                val nombre = readLine().orEmpty()
                print("Especie: ")
                val especie = readLine().orEmpty()
                print("Edad: ")
                val edad = readLine()?.toIntOrNull() ?: 0
                print("Peso: ")
                val peso = readLine()?.toDoubleOrNull() ?: 0.0
                val mascota = Mascota(nombre, especie, edad, peso)
                veterinaria.agregarMascota(mascota)
                println("Su mascota fue registrada con éxito.")
            }
            2 -> {
                print("Nombre de la mascota: ")
                val nombre = readLine().orEmpty()
                val mascota = veterinaria.obtenerMascota(nombre)
                if (mascota != null) {
                    print("Diagnóstico: ")
                    val diagnostico = readLine().orEmpty()
                    print("Costo base de la consulta: ")
                    val costoBase = readLine()?.toDoubleOrNull() ?: 0.0
                    print("¿Incluye medicación? (si/no): ")
                    val incluyeMedicacion = readLine().orEmpty().lowercase() == "si"
                    val consulta = ConsultaMedica(mascota, diagnostico, costoBase, incluyeMedicacion)
                    veterinaria.registrarConsulta(consulta)
                    println("La consulta médica de su mascota fue guardada exitosamente.")
                } else {
                    println("La mascota no está registrada.")
                }
            }
            3 -> {
                print("Nombre de la mascota: ")
                val nombre = readLine().orEmpty()
                veterinaria.mostrarHistorialConsultas(nombre)
            }
            4 -> {
                print("Nombre de la mascota: ")
                val nombre = readLine().orEmpty()
                val mascota = veterinaria.obtenerMascota(nombre)
                if (mascota != null) {
                    print("Nuevo peso: ")
                    val nuevoPeso = readLine()?.toDoubleOrNull() ?: 0.0
                    mascota.actualizarPeso(nuevoPeso)
                    println("Peso actualizado.")
                } else {
                    println("Mascota no registrada.")
                }
            }
            5 -> {
                print("Nombre de la mascota: ")
                val nombre = readLine().orEmpty()
                val mascota = veterinaria.obtenerMascota(nombre)
                if (mascota != null) {
                    mascota.incrementarEdad()
                    println("Edad incrementada.")
                } else {
                    println("Mascota no registrada.")
                }
            }
            6 -> {
                print("Nombre de la mascota: ")
                val nombre = readLine().orEmpty()
                val costoTotalFormateado = veterinaria.obtenerCostoTotalFormateado(nombre)
                if (costoTotalFormateado == "0.00") {
                    println("No hay información para mostrar.")
                } else {
                    println("Costo total de las consultas: $$costoTotalFormateado")
                }
            }
            7 -> {
                veterinaria.mostrarTodasLasMascotas()
            }
            8 -> {
                println("Has salido correctamente...")
                break
            }
            else -> println("Opción no válida. Inténtalo de nuevo.")
        }
    }
}
