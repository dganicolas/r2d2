fun main() {
    var R2D2Pos: List<Int>
    var texto = "we"
    var salir = false
            do{
                try {
            println("dame una lista con comas, numeros separados por comas")
            var lista= mutableListOf<Int>()
            texto = readln()
            var listas=texto.split(",")
            for(elementos in listas)
                lista.add(elementos.toInt())
            R2D2Pos =moverrobot(lista)
            println("x: ${R2D2Pos[0]} y: ${R2D2Pos[1]} dir: ${orientacion(R2D2Pos[2])}")
                }catch (e:Exception){

                    if (texto == ""){
                        salir = true
                    }else{
                        println("master ta mal")
                    }
                }
        } while(salir != true)




}
fun orientacion(dir:Any) = when (dir){
        0-> "POSITIVEY"
        1-> "NEGATIVEX"
        2-> "NEGATIVEY"
        3-> "POSITIVEX"
        else-> ""
    }

fun moverrobot(movs:MutableList<Int>): List<Int>{
    var posX = 0
    var posY = 0
    var dir = 0 //0 => arriba 1 => izquierda 2 => abajo 3 => derecha
    for (pasos in movs){
        when (dir){
            0-> posY += pasos
            1-> posX -= pasos
            2-> posY -= pasos
            3-> posX += pasos

        }
        if (dir== 3) dir = 0 else dir++
    }
    return listOf(posX, posY, dir)
}