
package com.goforer.profiler.presentation.ui.screen.compose.home.mynetwork.networks

import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.goforer.profiler.data.repository.Repository.Companion.replyCount
import com.goforer.profiler.R
import com.goforer.profiler.presentation.stateholder.ui.mynetwork.networks.MyNetworkContentState
import kotlinx.coroutines.launch
import timber.log.Timber

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MyNetworkContent(
    modifier: Modifier = Modifier,
    state: MyNetworkContentState,
    snackbarHostState: SnackbarHostState,
    contentPadding: PaddingValues = PaddingValues(4.dp),
    onNavigateToDetailInfo: (Int) -> Unit
) {
    val uiState = state.uiState.collectAsStateWithLifecycle()
    val hint =  stringResource(id = R.string.placeholder_search)

    /*
    * Just open & trigger the below code to take data from the Backend server.
    */
    /*
     profileViewModel.trigger(2, Params("uud1234213"))
     */

    replyCount = 5
    LaunchedEffect(state.selectedIndex, state.lifecycle) {
        if (state.selectedIndex.value != -1)
            Toast.makeText(state.context, "Show the detailed profile!", Toast.LENGTH_SHORT).show()
    }

    when {
        state.data != null -> {
            MyNetworkSection(
                modifier = modifier,
                contentPadding = contentPadding,
                myNetworksState = state.data.collectAsStateWithLifecycle(),
                followed = state.followed,
                onItemClicked = { _, index ->
                    state.selectedIndex.value = index
                },
                onFollowed =  { person, changed ->
                    state.scope.launch {
                        state.onFollowStatusChanged(person.id, person.name, changed)
                        if (changed) {
                            state.keyboardController?.hide()
                            snackbarHostState.showSnackbar("${person.name} has been our member")
                        } else
                            snackbarHostState.showSnackbar("${person.name} is not our member")
                    }
                },
                onSearched = { name, byClicked ->
                    uiState.value.find { it.name == name }?.let {
                        state.keyboardController?.hide()
                    }

                    uiState.value.find { it.name == name } ?: if (byClicked) {
                        state.keyboardController?.hide()
                        if (name != hint)
                            Toast.makeText(
                                state.context,
                                "$name is not our member.",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            Timber.d("is texted by typing")
                        }
                },
                onNavigateToDetailInfo = onNavigateToDetailInfo
            )
        }
        state.isLoading -> { }
        state.throwError -> { }
    }
}