fun main(){
    val rm = ReproductorMidi("pugnodollari.mid")
    println("Cargando juego...")
    Thread.sleep(10000)
    val lista = listOf("terminator", "robocop", "rambo", "depredador", "snake", "ripley", "alien", "harry")
    val palabra = lista.random()
    var palOculta = "*".repeat(palabra.length)
    val intentosMax = 7
    var intentosAct = 0
    while (intentosAct<intentosMax && palOculta.contains("*")){
        println("Adivina el personaje clásico de cine de acción")
        println(palOculta)
        println("Llevas $intentosAct fallos de $intentosMax permitidos")
        print("Introduce una letra minúscula: ")
        var letra=readln()
        println()
        if (palabra.contains(letra)){
            var nuevaOculta= StringBuilder(palOculta)
            for (i in 0..palabra.length-1){
                if (palabra[i]==letra[0]){
                    nuevaOculta[i]=letra[0]
                }
            }
            palOculta=nuevaOculta.toString()

        } else {
            println("ERROR")
            intentosAct++
            DibujoAhorcado.dibujar(intentosAct)
            println()
        }
    }
    if (intentosAct==intentosMax){
        println("YOU DIED! GAME OVER")
        println ("La palabra secreta era $palabra")
    } else {
        println("YEAH! ERA $palabra! HAS EVITADO LA MUERTE")
    }
    rm.cerrar()
}