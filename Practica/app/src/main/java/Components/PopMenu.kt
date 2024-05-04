package Components

import Data.ListData
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.lmct_taller.practica.R


@Composable
fun PopupMenu(todoList: MutableList<ListData>, showMenu: MutableState<Boolean>) {
    val title : MutableState<String> = remember {
        mutableStateOf("")
    }
    val desc : MutableState<String> = remember {
        mutableStateOf("")
    }

    DropdownMenu(
        expanded = showMenu.value,
        onDismissRequest = { showMenu.value = false },
        modifier= Modifier
            .padding(20.dp)
            .background(colorResource(id = R.color.purple_200), shape = RoundedCornerShape(15.dp))


    ) {

        Column(modifier=Modifier.padding(20.dp)

        ) {
            TextField(value = title.value, onValueChange ={title.value=it},modifier =Modifier
                .background(color= Color.Transparent), shape = RoundedCornerShape(15.dp) )

            Spacer(modifier= Modifier.height(10.dp))

            TextField(value = desc.value, onValueChange ={desc.value=it},modifier =Modifier
                .background(color= Color.Transparent), shape = RoundedCornerShape(15.dp) )

            Spacer(modifier= Modifier.height(10.dp))

            Button(onClick = {
                val item =ListData(titulo = title, desc = desc)
                todoList.add(item)
                showMenu.value=false;

            }){
                Text("Agregar Tarea")
            }
        }

    }}


