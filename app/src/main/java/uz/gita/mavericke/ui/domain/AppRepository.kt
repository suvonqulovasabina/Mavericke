package uz.gita.mavericke.ui.domain

import uz.gita.mavericke.ui.data.local.GetCard
import uz.gita.mavericke.ui.data.local.MyHistory

interface AppRepository {


    fun getCard(): ArrayList<GetCard>


    fun myHistory(): ArrayList<MyHistory>
}