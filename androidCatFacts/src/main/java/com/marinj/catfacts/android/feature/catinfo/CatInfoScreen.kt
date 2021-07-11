package com.marinj.catfacts.android.feature.catinfo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.marinj.catfacts.android.R
import com.marinj.catfacts.android.feature.catinfo.viewmodel.CatInfoViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun CatInfoScreen(
    catInfoViewModel: CatInfoViewModel = getViewModel(),
) {
    val viewState by catInfoViewModel.catInfoViewState.collectAsState()

    LaunchedEffect(key1 = Unit, block = {
        catInfoViewModel.onEvent(CatInfoEvent.GetCatInfo)
    })

    Scaffold {
        Box(modifier = Modifier.fillMaxSize()) {
            when {
                viewState.isLoading -> CatLoadingIndicator(Modifier.align(Alignment.Center))
                !viewState.catInfo.isNullOrBlank() -> CatInfoCard(
                    Modifier.align(Alignment.Center),
                    viewState.catInfo!!,
                    catInfoViewModel::onEvent,
                )
                !viewState.errorMessage.isNullOrBlank() -> CatErrorCard(
                    Modifier.align(Alignment.Center),
                    viewState.errorMessage!!,
                )
            }
        }
    }
}

@Composable
fun CatLoadingIndicator(modifier: Modifier = Modifier) = CircularProgressIndicator(modifier = modifier)

@Composable
fun CatInfoCard(
    modifier: Modifier = Modifier,
    catInfo: String,
    eventHandler: (CatInfoEvent) -> Unit,
) {
    Card(modifier = modifier) {
        Column {
            Text(
                modifier = Modifier.padding(16.dp),
                text = catInfo,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally),
                onClick = { eventHandler(CatInfoEvent.GetCatInfo) }) {
                Text(
                    text = stringResource(R.string.and_another_one),
                )
            }
        }
    }
}

@Composable
fun CatErrorCard(
    modifier: Modifier = Modifier,
    errorMessage: String,
) {
    Card(modifier = modifier) {
        Text(
            modifier = Modifier.padding(16.dp),
            text = errorMessage,
        )
    }
}
