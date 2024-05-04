package Components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lmct_taller.practica.R

@SuppressLint("ResourceAsColor")
@Composable
fun ToDoComponent(){
    Column(modifier= Modifier
        .fillMaxHeight()
        .background(color = Color.DarkGray)
        .fillMaxWidth()
        , horizontalAlignment = Alignment.CenterHorizontally
        ){
       Box(modifier = Modifier
           .background(color = Color(R.color.teal_700))
           .fillMaxWidth()
           .align(alignment = Alignment.CenterHorizontally)
           .padding(10.dp)
           ,
           contentAlignment = Alignment.Center){
            Text(
                "ToDo App",
                color = Color.White
                )
       }

        ToDoList()
    }
}

@Composable
@Preview
fun PreviewToDoComponent(){
    ToDoComponent()
}