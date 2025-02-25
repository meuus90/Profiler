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

package com.goforer.profiler.presentation.ui.screen.home.notification.notifications

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.goforer.profiler.data.model.datum.response.notification.Notification
import com.goforer.profiler.presentation.ui.ext.noRippleClickable
import com.goforer.profiler.presentation.ui.theme.ProfilerTheme

@Composable
fun NotificationSection(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues,
    state: State<List<Notification>>,
    onItemClicked: (item: Notification, index: Int) -> Unit,
    onNavigateToDetailInfo: (Int) -> Unit,
) {
    BoxWithConstraints(modifier = modifier) {
        Column(
            modifier = modifier
                .padding(
                    0.dp,
                    contentPadding.calculateTopPadding(),
                    0.dp,
                    0.dp
                )
                .noRippleClickable { }
        ) {
            ListSection(
                modifier = Modifier.weight(1f),
                notifications = state.value,
                onItemClicked = onItemClicked,
                onNavigateToDetailInfo = onNavigateToDetailInfo
            )
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
fun MyNetworkSectionPreview(modifier: Modifier = Modifier) {
    ProfilerTheme {
        BoxWithConstraints(modifier = modifier) {
            Column(
                modifier = modifier
                    .padding(
                        0.dp,
                        56.dp,
                        0.dp,
                        0.dp
                    )
                    .noRippleClickable { }
            ) {
                val notifications = mutableListOf(
                    Notification(0,"LLyyiok", "Development", "Android","https://avatars.githubusercontent.com/u/18302717?v=4", "Coding Rules",0, "Scouts & Guides Participation Needed\n1st March, 2023 \n\n This is a notification sample for development and anyone can develop the app easily with the this advanced architecture.Our school has decided to send a troop of scouts and guides to the jamboree to be held at Lucknow from the 20th to the 27th of October. Those scouts and guides interested to participate in the jamboree may give their names to the undersigned by the 7th of October.\n\n\nTeam Manager"),
                    Notification(1,"Afredo", "Marketing", "Marketing","https://avatars.githubusercontent.com/u/18302717?v=4", "Marketing Policy",1, "Scouts & Guides Participation Needed\n1st March, 2023 \n\n This is a notification sample for development and anyone can develop the app easily with the this advanced architecture.Our school has decided to send a troop of scouts and guides to the jamboree to be held at Lucknow from the 20th to the 27th of October. Those scouts and guides interested to participate in the jamboree may give their names to the undersigned by the 7th of October.\n\n\nTeam Manager"),
                    Notification(2,"Aliche", "Development", "Android","https://avatars.githubusercontent.com/u/18302717?v=4", "Architecture Blueprint",2, "Scouts & Guides Participation Needed\n1st March, 2023 \n\n This is a notification sample for development and anyone can develop the app easily with the this advanced architecture.Our school has decided to send a troop of scouts and guides to the jamboree to be held at Lucknow from the 20th to the 27th of October. Those scouts and guides interested to participate in the jamboree may give their names to the undersigned by the 7th of October.\n\n\nTeam Manager"),
                    Notification(3,"Tina", "Sales", "Domestic Sales 1","https://avatars.githubusercontent.com/u/18302717?v=4","Vehicle allocation notice",3, "Scouts & Guides Participation Needed\n1st March, 2023 \n\n This is a notification sample for development and anyone can develop the app easily with the this advanced architecture.Our school has decided to send a troop of scouts and guides to the jamboree to be held at Lucknow from the 20th to the 27th of October. Those scouts and guides interested to participate in the jamboree may give their names to the undersigned by the 7th of October.\n\n\nTeam Manager"),
                    Notification(4,"Lolly", "Support", "HR","https://avatars.githubusercontent.com/u/18302717?v=4","New personnel appointments",2, "Scouts & Guides Participation Needed\n1st March, 2023 \n\n This is a notification sample for development and anyone can develop the app easily with the this advanced architecture.Our school has decided to send a troop of scouts and guides to the jamboree to be held at Lucknow from the 20th to the 27th of October. Those scouts and guides interested to participate in the jamboree may give their names to the undersigned by the 7th of October.\n\n\nTeam Manager"),
                    Notification(5,"Hassen", "Support", "People 1","https://avatars.githubusercontent.com/u/18302717?v=4","Notice of consultation",0, "Scouts & Guides Participation Needed\n1st March, 2023 \n\n This is a notification sample for development and anyone can develop the app easily with the this advanced architecture.Our school has decided to send a troop of scouts and guides to the jamboree to be held at Lucknow from the 20th to the 27th of October. Those scouts and guides interested to participate in the jamboree may give their names to the undersigned by the 7th of October.\n\n\nTeam Manager"),
                    Notification(6,"Lyll", "Support", "People 2","https://avatars.githubusercontent.com/u/18302717?v=4", "Relations",1, "Scouts & Guides Participation Needed\n1st March, 2023 \n\n This is a notification sample for development and anyone can develop the app easily with the this advanced architecture.Our school has decided to send a troop of scouts and guides to the jamboree to be held at Lucknow from the 20th to the 27th of October. Those scouts and guides interested to participate in the jamboree may give their names to the undersigned by the 7th of October.\n\n\nTeam Manager"),
                    Notification(7,"Kevin", "Sales", "Domestic Sales 2","https://avatars.githubusercontent.com/u/18302717?v=4", "Sales Policy",3, "Scouts & Guides Participation Needed\n1st March, 2023 \n\n This is a notification sample for development and anyone can develop the app easily with the this advanced architecture.Our school has decided to send a troop of scouts and guides to the jamboree to be held at Lucknow from the 20th to the 27th of October. Those scouts and guides interested to participate in the jamboree may give their names to the undersigned by the 7th of October.\n\n\nTeam Manager"),
                    Notification(8,"Tony", "Sales", "Domestic Sales 3","https://avatars.githubusercontent.com/u/18302717?v=4", "Sales Policy",0, "Scouts & Guides Participation Needed\n1st March, 2023 \n\n This is a notification sample for development and anyone can develop the app easily with the this advanced architecture.Our school has decided to send a troop of scouts and guides to the jamboree to be held at Lucknow from the 20th to the 27th of October. Those scouts and guides interested to participate in the jamboree may give their names to the undersigned by the 7th of October.\n\n\nTeam Manager"),
                    Notification(9,"Steven", "Sales", "International Sales 1","https://avatars.githubusercontent.com/u/18302717?v=4", "Sales Policy",3, "Scouts & Guides Participation Needed\n1st March, 2023 \n\n This is a notification sample for development and anyone can develop the app easily with the this advanced architecture.Our school has decided to send a troop of scouts and guides to the jamboree to be held at Lucknow from the 20th to the 27th of October. Those scouts and guides interested to participate in the jamboree may give their names to the undersigned by the 7th of October.\n\n\nTeam Manager"),
                    Notification(10,"Micle", "Marketing", "Domestic Marketing 1","https://avatars.githubusercontent.com/u/18302717?v=4", "Monthly Report for Marketing Meeting",2, "Scouts & Guides Participation Needed\n1st March, 2023 \n\n This is a notification sample for development and anyone can develop the app easily with the this advanced architecture.Our school has decided to send a troop of scouts and guides to the jamboree to be held at Lucknow from the 20th to the 27th of October. Those scouts and guides interested to participate in the jamboree may give their names to the undersigned by the 7th of October.\n\n\nTeam Manager")
                )

                ListSection(
                    modifier = Modifier.weight(1f),
                    notifications = notifications,
                    onItemClicked = { _, _ -> },
                    onNavigateToDetailInfo = { }
                )
            }
        }
    }
}