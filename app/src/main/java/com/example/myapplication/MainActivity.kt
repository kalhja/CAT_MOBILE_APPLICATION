import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme

data class FoodItem(
    val id: Int,
    val name: String,
    val description: String,
    val imageResId: Int // Change imageUrl to imageResId
)

val foodItems = listOf(
    FoodItem(
        id = 1,
        name = "Pizza",
        description = "Delicious Italian pizza with a variety of toppings.",
        imageResId = R.drawable.pizza_image // Use the actual resource ID of the image
    ),
    FoodItem(
        id = 2,
        name = "Burger",
        description = "Juicy burger with lettuce, cheese, and special sauce.",
        imageResId = R.drawable.burger_image // Use the actual resource ID of the image
    ),
    // Add more food items here as needed
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FoodList(foodItems)
                }
            }
        }
    }
}

@Composable
fun FoodList(foodItems: List<FoodItem>) {
    LazyColumn {
        items(foodItems) { food ->
            FoodItemCard(food)
        }
    }
}

@Composable
fun FoodItemCard(food: FoodItem) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),

        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(food.imageResId),
                contentDescription = "Food Image",
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.width(16.dp))

        }
    }
}

@Preview(showBackground = true)
@Composable
fun FoodListPreview() {
    MyApplicationTheme {
        FoodList(foodItems)
    }
}
