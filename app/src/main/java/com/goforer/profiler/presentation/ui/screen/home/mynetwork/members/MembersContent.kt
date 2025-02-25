/*
 * Copyright (C) 2023 The Android Open Source Project by Lukoh Nam, goForer
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2 of the License,
 * or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License along with this program.
 * If not, see <http://www.gnu.org/licenses/>.
 */

package com.goforer.profiler.presentation.ui.screen.home.mynetwork.members

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.goforer.profiler.data.model.datum.response.mynetwork.Person
import com.goforer.profiler.presentation.stateholder.ui.mynetwork.common.rememberListSectionState
import com.goforer.profiler.presentation.stateholder.ui.mynetwork.members.MembersContentState
import com.goforer.profiler.presentation.ui.screen.home.mynetwork.common.ListSection
import com.goforer.profiler.presentation.ui.theme.ProfilerTheme

@Composable
fun MembersContent(
    modifier: Modifier = Modifier,
    state: MembersContentState,
    contentPadding: PaddingValues = PaddingValues(4.dp),
    onItemClicked: (item: Person, index: Int) -> Unit,
    onFollowed: (Person, Boolean) -> Unit
) {
    when {
        state.data != null -> {
            val numbersState = state.data.collectAsStateWithLifecycle()

            state.membersState = remember(numbersState.value) {
                derivedStateOf {
                    if (state.sexState.value.isEmpty()) {
                        numbersState.value
                    } else {
                        state.onGetMembers(state.sexState.value)
                    }
                }
            }

            BoxWithConstraints(modifier = modifier.padding(
                0.dp,
                contentPadding.calculateTopPadding(),
                0.dp,
                28.dp
            )) {
                ListSection(
                    modifier = Modifier,
                    state = rememberListSectionState(
                        visibleSexButtonState = remember {
                            mutableStateOf(true)
                        },
                        membersState = state.membersState,
                        followedState = state.followedState
                    ),
                    onItemClicked = onItemClicked,
                    onFollowed = onFollowed,
                    onSexViewed = { sex ->
                        state.onGetMember(sex)?.let { state.sexState.value = sex }
                    },
                    onMemberDeleted = {
                    },
                    onEstimated = { id, favor ->
                        state.onEstimated(id, favor)
                    },
                    onNavigateToDetailInfo = {
                    }
                )
            }
        }
        state.isLoading -> {
            // To Do : run the loading animation or shimmer
        }
        state.throwError -> {
            // To Do : handle the error
        }
    }
}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode",
    showSystemUi = true
)
@Composable
fun SMembersContentPreview(modifier: Modifier = Modifier) {
    ProfilerTheme {
        val followedState = rememberSaveable { mutableStateOf(false) }
        val members = listOf(
            Person(0,"LLyyiok", "남성", true,true,"https://avatars.githubusercontent.com/u/18302717?v=4", "sociable & gregarious", "+820101111-1111","", "Mar, 04, 1999","Lukoh is a tremendously capable and dedicated mobile SW professional. He has strong analytical and innovative skills which are further boosted by his solid technical background and his enthusiasm for technology. Lukoh works extremely well with colleagues, associates, and executives, adapting the analysis and communication techniques in order to accomplish the business objective.", false),
            Person(1,"Afredo", "남성", true,true,"https://avatars.githubusercontent.com/u/18302717?v=4", "gregarious & friendly", "+820101111-1111","", "Mar, 04, 1999","Lukoh is a tremendously capable and dedicated mobile SW professional. He has strong analytical and innovative skills which are further boosted by his solid technical background and his enthusiasm for technology. Lukoh works extremely well with colleagues, associates, and executives, adapting the analysis and communication techniques in order to accomplish the business objective.", false),
            Person(2,"Aliche", "여성", false,true,"https://avatars.githubusercontent.com/u/18302717?v=4", "affable & convivial", "+820101111-1111","", "Mar, 04, 1999","Lukoh is a tremendously capable and dedicated mobile SW professional. He has strong analytical and innovative skills which are further boosted by his solid technical background and his enthusiasm for technology. Lukoh works extremely well with colleagues, associates, and executives, adapting the analysis and communication techniques in order to accomplish the business objective.", false),
            Person(3,"Tina", "여성", false,true,"https://avatars.githubusercontent.com/u/18302717?v=4","affable & convivial", "+820101111-1111","", "Mar, 04, 1999","Lukoh is a tremendously capable and dedicated mobile SW professional. He has strong analytical and innovative skills which are further boosted by his solid technical background and his enthusiasm for technology. Lukoh works extremely well with colleagues, associates, and executives, adapting the analysis and communication techniques in order to accomplish the business objective.", false),
            Person(4,"Lolly", "여성", true,true,"https://avatars.githubusercontent.com/u/18302717?v=4","affable & convivial", "+820101111-1111","", "Mar, 04, 1999","Lukoh is a tremendously capable and dedicated mobile SW professional. He has strong analytical and innovative skills which are further boosted by his solid technical background and his enthusiasm for technology. Lukoh works extremely well with colleagues, associates, and executives, adapting the analysis and communication techniques in order to accomplish the business objective.", false),
            Person(5,"Hassen", "남성", true,true,"https://avatars.githubusercontent.com/u/18302717?v=4","affable & convivial", "+820101111-1111","", "Mar, 04, 1999","Lukoh is a tremendously capable and dedicated mobile SW professional. He has strong analytical and innovative skills which are further boosted by his solid technical background and his enthusiasm for technology. Lukoh works extremely well with colleagues, associates, and executives, adapting the analysis and communication techniques in order to accomplish the business objective.", false),
            Person(6,"Lyll", "여성", true,true,"https://avatars.githubusercontent.com/u/18302717?v=4", "sociable & gregarious", "+820101111-1111","", "Mar, 04, 1999","Lukoh is a tremendously capable and dedicated mobile SW professional. He has strong analytical and innovative skills which are further boosted by his solid technical background and his enthusiasm for technology. Lukoh works extremely well with colleagues, associates, and executives, adapting the analysis and communication techniques in order to accomplish the business objective.", false),
            Person(7,"Kevin", "남성", false,true,"https://avatars.githubusercontent.com/u/18302717?v=4", "affable & convivial", "+820101111-1111","", "Mar, 04, 1999","Lukoh is a tremendously capable and dedicated mobile SW professional. He has strong analytical and innovative skills which are further boosted by his solid technical background and his enthusiasm for technology. Lukoh works extremely well with colleagues, associates, and executives, adapting the analysis and communication techniques in order to accomplish the business objective.", false),
            Person(8,"Tony", "남성", false,true,"https://avatars.githubusercontent.com/u/18302717?v=4", "affable & convivial", "+820101111-1111","", "Mar, 04, 1999","Lukoh is a tremendously capable and dedicated mobile SW professional. He has strong analytical and innovative skills which are further boosted by his solid technical background and his enthusiasm for technology. Lukoh works extremely well with colleagues, associates, and executives, adapting the analysis and communication techniques in order to accomplish the business objective.", false),
            Person(9,"Steven", "남성", true,false,"https://avatars.githubusercontent.com/u/18302717?v=4", "affable & convivial", "+820101111-1111","", "Mar, 04, 1999","Lukoh is a tremendously capable and dedicated mobile SW professional. He has strong analytical and innovative skills which are further boosted by his solid technical background and his enthusiasm for technology. Lukoh works extremely well with colleagues, associates, and executives, adapting the analysis and communication techniques in order to accomplish the business objective.", false),
            Person(10,"Micle", "남성", true,false,"https://avatars.githubusercontent.com/u/18302717?v=4", "affable & convivial", "+820101111-1111","", "Mar, 04, 1999","Lukoh is a tremendously capable and dedicated mobile SW professional. He has strong analytical and innovative skills which are further boosted by his solid technical background and his enthusiasm for technology. Lukoh works extremely well with colleagues, associates, and executives, adapting the analysis and communication techniques in order to accomplish the business objective.", false)
        )

        val myNetworksState = remember { mutableStateOf(members) }

        ListSection(
            modifier = Modifier,
            state = rememberListSectionState(
                membersState =  myNetworksState,
                followedState = followedState
            ),
            onItemClicked = { _, _ -> },
            onFollowed = { _, _ -> },
            onSexViewed = {},
            onMemberDeleted = {},
            onEstimated = { _, _ -> },
            onNavigateToDetailInfo = {}
        )
    }
}