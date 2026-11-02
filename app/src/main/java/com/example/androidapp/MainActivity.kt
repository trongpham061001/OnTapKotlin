package com.example.androidapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidapp.ui.theme.AndroidAppTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TipCaculation(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        Text(
            text = "Xin Chao $name!",
            modifier = modifier
        )
    }
}

@Composable
fun HappyBirthday(name: String, modifier: Modifier = Modifier){
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier){
    var result by remember { mutableStateOf(1) }
    val imageResource = when(result){
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    Column(modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Image(
            painter = painterResource(imageResource),
            contentDescription = ""
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                result = (1..6).random()
            },
            shape = RoundedCornerShape(8.dp),
        ){
            Text(
                text = "Roll Dice"
            )
        }
    }
}
@Composable
fun EditNumberField(value: String, @StringRes label: Int, @DrawableRes trailingIcon: Int, onValueChange: (String) -> Unit, modifier: Modifier = Modifier){
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.fillMaxWidth(),
        label = {
            Text(
                text = stringResource(label)
            )
        },
        trailingIcon = {
            Icon(
                painter = painterResource(trailingIcon),
                contentDescription = null
            )
        }
    )
}

@Composable
fun TipCaculation(modifier: Modifier = Modifier){
    var amountInput = remember {mutableStateOf("0")}

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
    ){
        EditNumberField(
            value = amountInput.value,
            onValueChange = {amountInput.value = it},
            label = R.string.total_bill,
            trailingIcon = R.drawable.cash,
            modifier = modifier
        )

        Spacer(modifier = Modifier.height(16.dp))

        EditNumberField(
            value = amountInput.value,
            onValueChange = {amountInput.value = it},
            label = R.string.tip_percent,
            trailingIcon = R.drawable.percent,
            modifier = modifier
        )

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Tip Caculation: ${amountInput.value.toDouble() * 0.15}$",
            fontSize = 32.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TipCaculationPreview(){
    TipCaculation()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidAppTheme {
        Greeting("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun DiceRollerPreview()
{
    DiceWithButtonAndImage()
}