package uz.gita.mavericke.ui.presintation.home

import uz.gita.mavericke.ui.data.local.GetCard
import uz.gita.mavericke.ui.data.local.MyHistory


interface HomeContract {

    interface SideEffect {
        object Massage : SideEffect
    }

    data class UIState(
        val cardList: ArrayList<GetCard>,
        val myHistory: ArrayList<MyHistory>
    )

    interface Intent {

    }

}
