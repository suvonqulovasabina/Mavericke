package uz.gita.mavericke.ui.presintation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getViewModel

import uz.gita.mavericke.ui.presintation.utils.Card
import uz.gita.mavericke.ui.presintation.utils.CardItem
import uz.gita.mavericke.ui.presintation.utils.CircleWithText
import uz.gita.mavericke.ui.presintation.utils.HistoryItem
import uz.gita.mavericke.R


class HomeScreen : Screen {
    @Composable
    override fun Content() {
        val viewModel = getViewModel<HomeViewModel>()


        HomeScreenUI(viewModel)
    }


}

@Composable
fun HomeScreenUI(
    viewModel: HomeViewModel
) {
    val state = viewModel.state.collectAsState().value

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3EEEE))
    ) {


        item {

            Box {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(id = R.drawable.bacrount),
                    contentDescription = null
                )
                Row {
                    Spacer(
                        modifier = Modifier
                            .height(25.dp)
                            .padding(16.dp)
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Spacer(modifier = Modifier.size(3.dp))
                    CircleWithText()
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(bottom = 0.dp), text = "Mehmon"
                    )
                    Spacer(modifier = Modifier.weight(0.2f))
                    Image(
                        modifier = Modifier
                            .size(40.dp)
                            .align(Alignment.CenterVertically)
                            .padding(end = 16.dp),
                        painter = painterResource(id = R.drawable.ball),
                        contentDescription = null
                    )
                }

                Column {
                    Spacer(modifier = Modifier.height(100.dp))
                    Card()
                }
            }
        }


        item {
            Spacer(modifier = Modifier.height(15.dp))
        }

        item {
            LazyRow(modifier = Modifier.fillMaxWidth()) {
                items(state.myHistory) { card ->
                    CardItem(getCard = card)
                }
            }
        }
        item {
            Spacer(modifier = Modifier.height(50.dp))
        }


        items(state.myHistory) { historyItem ->
            HistoryItem(name = historyItem.name, sum = historyItem.amount.toString())
        }
    }
}

