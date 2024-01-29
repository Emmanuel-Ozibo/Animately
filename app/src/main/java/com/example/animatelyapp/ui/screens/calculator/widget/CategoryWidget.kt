package com.example.animatelyapp.ui.screens.calculator.widget

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animatelyapp.ui.theme.AnimatelyAppTheme
import com.example.animatelyapp.utils.DummyData


@Composable
fun CategoryWidget(
    modifier: Modifier = Modifier,
    categories: List<Category> = listOf()) {

    Column (
        modifier = modifier.wrapContentHeight()
    ){
        Text(
            text = "Categories",
            style = MaterialTheme.typography.titleMedium
        )

        Text(
            modifier = Modifier.padding(top = 8.dp),
            text = "What are you sending",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Gray
        )

        LazyHorizontalStaggeredGrid(
            modifier = Modifier.height(120.dp),
            rows = StaggeredGridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalItemSpacing = 16.dp,
            contentPadding = PaddingValues(16.dp),
            state = rememberLazyStaggeredGridState()
        ) {

            items(categories.size) {index ->
                val category = categories[index]

                CategoryItem(title = category.title)
            }
        }
    }

}


@Composable
fun CategoryItem(title: String,
                 modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.wrapContentHeight(),
        border = BorderStroke(width = 1.dp, color = Color.Gray),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(
            modifier = Modifier.padding(8.dp),
            text = title,
            style = MaterialTheme.typography.bodyMedium)
    }
}


data class Category(
    val title: String
)


@Preview
@Composable
private fun CategoryWidgetPreview() {
    AnimatelyAppTheme {
        CategoryWidget(
            categories = DummyData.getCategories())
    }
}



@Preview
@Composable
private fun CategoryItemPreview() {
    CategoryItem(title = "Documents")
}
