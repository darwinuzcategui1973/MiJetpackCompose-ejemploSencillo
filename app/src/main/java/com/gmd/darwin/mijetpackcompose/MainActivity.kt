package com.gmd.darwin.mijetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContent es mi activity
        setContent {
            // Text(text = "hola Darwin**")
            PersonalData(name = "Darwin Uzcategui")

        }
    }
        @Composable
        private fun PersonalData(name:String){
            MaterialTheme(){
            Column(modifier= Modifier.padding(8.dp).fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
            ){
            Image(
                painter = painterResource(id = R.drawable.darwin),
                contentDescription ="Image de darwin",
                modifier = Modifier.height(100.dp))

                Spacer(modifier = Modifier.height(2.dp))

            Text(text = "Author: $name", style = MaterialTheme.typography.h6)
            Text(text = "Soy Programador")
            Text(text = "darwin.uzcategui1973@gmail.com")
                Spacer(modifier = Modifier.height(8.dp))
                Image(
                    painter = painterResource(id = R.drawable.gmd),
                    contentDescription ="Image de darwin",
                    modifier = Modifier.height(250.dp))


            }
        }
    }

    //para poder ver en tiempo real
    @Preview
    @Composable
    fun PreviewPersonalData(){
        PersonalData(name = "Darwin Uzcategui")
    }

}