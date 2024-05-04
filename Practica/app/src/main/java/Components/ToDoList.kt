package Components

import Data.ListData
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lmct_taller.practica.R

@Composable
fun ToDoList() {
    var showMenu: MutableState<Boolean> = remember {
        mutableStateOf(false)
    }

    var showModify: MutableState<Boolean> = remember {
        mutableStateOf(false)
    }

    var activeTaskIndex: MutableState<Int?> = remember {
        mutableStateOf(null)
    }

    val toDoList: MutableList<ListData> = remember {
        mutableStateListOf<ListData>()
    }
    var textFieldValue by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            showMenu.value = !showMenu.value
        }) {
            Text("Agregar Tarea")
        }

        if (showMenu.value) {
            PopupMenu(toDoList, showMenu)
        }

        LazyColumn(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            itemsIndexed(toDoList.toList()) { index, item ->
                Box(
                    modifier = Modifier
                        .background(
                            colorResource(id = R.color.teal_200),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(10.dp)
                        .width(200.dp)
                        .height(50.dp)
                        .clickable {
                            activeTaskIndex.value = index
                            showModify.value = true
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(item.titulo.value)
                }
                Spacer(modifier = Modifier.height(15.dp))
            }
        }

        // Mostrar TextField para modificar la tarea seleccionada
        if (showModify.value && activeTaskIndex.value != null) {
            val selectedTask = toDoList[activeTaskIndex.value!!]
            TextField(
                value = textFieldValue,
                onValueChange = { newValue ->
                    textFieldValue = newValue
                }
            )
            Button(onClick = {
                // Verificar si el TextField no está vacío antes de actualizar el título
                if (textFieldValue.isNotBlank()) {
                    // Actualizar el valor de la tarea seleccionada solo si el TextField no está vacío
                    selectedTask.titulo.value = if (selectedTask.titulo.value.isEmpty()) textFieldValue else "${selectedTask.titulo.value} $textFieldValue"
                    // Limpiar el valor del TextField
                    textFieldValue = ""
                }
                // Ocultar el TextField
                showModify.value = false
            }) {
                Text("Guardar")
            }
        }

    }
}

@Composable
@Preview
fun ListPreview() {
    ToDoList()
}



