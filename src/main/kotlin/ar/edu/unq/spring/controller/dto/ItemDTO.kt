package ar.edu.unq.spring.controller.dto

import ar.edu.unq.spring.modelo.Item
import ar.edu.unq.spring.modelo.Personaje

class ItemDTO (val id: Long?,
               val nombre : String?,
               val peso: Int,
               val ownerId: Long?){

    companion object {
        fun desdeModelo(item: Item) =
            ItemDTO (
                id = item.id,
                nombre = item.nombre,
                peso = item.peso,
                ownerId = if (item.owner != null) item.owner?.id else null
            )
    }


    fun aModelo(personaje: Personaje): Item {
        val item = aModelo()
        item.owner = personaje
        return item
    }

    fun aModelo(): Item {
        val item = Item(this.nombre!!, this.peso)
        item.id = this.id
        return item
    }
}