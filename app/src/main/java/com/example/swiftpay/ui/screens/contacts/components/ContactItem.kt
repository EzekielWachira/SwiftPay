package com.example.swiftpay.ui.screens.contacts.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.swiftpay.R
import com.example.swiftpay.ui.theme.SwiftPayTheme

@Composable
fun ContactItem(
    modifier: Modifier = Modifier,
    contact: Contact,
    onContactClick: (Contact) -> Unit
) {
    Surface(
        onClick = { onContactClick(contact) },
        color = MaterialTheme.colorScheme.background,
        modifier = modifier,
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(
                start = 16.dp,
                end = 16.dp,
                top = 10.dp,
                bottom = 10.dp
            )
        ) {
            Image(
                painter = painterResource(id = contact.picture),
                contentDescription = contact.name + " picture",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(50.dp)
            )

            Column(
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
                    .weight(1f)
            ) {
                Text(
                    text = contact.name,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.inversePrimary
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = contact.email,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onTertiary
                )
            }

            IconButton(onClick = { }) {
                Image(
                    painter = painterResource(
                        id = if (contact.isFavorite) R.drawable.favorite else R.drawable.not_favorite
                    ),
                    contentDescription = null,
                    modifier = Modifier.size(25.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun ContactItemPreview() {
    SwiftPayTheme {
        ContactItem(
            contact = contacts[10], onContactClick = {},
            modifier = Modifier.fillMaxWidth()
        )
    }
}


data class Contact(
    val name: String,
    val email: String,
    val isFavorite: Boolean,
    @DrawableRes val picture: Int = listOf(
        R.drawable.person_1,
        R.drawable.person_2,
        R.drawable.person_3,
        R.drawable.person_4,
        R.drawable.person_5,
    ).random()
)

val contacts = listOf(
    Contact(name = "Alexia Hershey", email = "alex001@gmail.com", isFavorite = true),
    Contact(name = "Alfonzo Scheussler", email = "afonzo@gmail.com", isFavorite = false),
    Contact(name = "Charote Hershey", email = "charote@gmail.com", isFavorite = true),
    Contact(name = "John Doe ", email = "doejohn@gmail.com", isFavorite = true),
    Contact(name = "Maryland Winkles", email = "winkes@gmail.com", isFavorite = true),
    Contact(name = "Hannah Ramsey", email = "hannah@gmail.com", isFavorite = false),
    Contact(name = "Theresa Webb", email = "theresa@gmail.com", isFavorite = false),
    Contact(name = "Anderson Jackson", email = "anderson@gmail.com", isFavorite = true),
    Contact(name = "Maria Fernanda", email = "maria@gmail.com", isFavorite = false),
    Contact(name = "Aurora Mendoza", email = "mendoza@gmail.com", isFavorite = true),
    Contact(name = "James Smith", email = "james@gmail.com", isFavorite = false),
    Contact(name = "Emily Johnson", email = "emily@gmail.com", isFavorite = true),
    Contact(name = "Michael Williams", email = "michael@gmail.com", isFavorite = false),
    Contact(name = "Olivia Brown", email = "olivia@gmail.com", isFavorite = true),
    Contact(name = "William Jones", email = "william@gmail.com", isFavorite = false),
    Contact(name = "Emma Davis", email = "emma@gmail.com", isFavorite = true),
    Contact(name = "Benjamin Miller", email = "benjamin@gmail.com", isFavorite = false),
    Contact(name = "Ava Wilson", email = "ava@gmail.com", isFavorite = true),
    Contact(name = "Liam Moore", email = "liam@gmail.com", isFavorite = false),
    Contact(name = "Isabella Lee", email = "isabella@gmail.com", isFavorite = true),
    Contact(name = "Lucas Clark", email = "lucas@gmail.com", isFavorite = false),
    Contact(name = "Sophia Hall", email = "sophia@gmail.com", isFavorite = true),
    Contact(name = "Henry Garcia", email = "henry@gmail.com", isFavorite = false),
    Contact(name = "Chloe Martinez", email = "chloe@gmail.com", isFavorite = true),
    Contact(name = "Alexander Rodriguez", email = "alexander@gmail.com", isFavorite = false),
    Contact(name = "Madison Lopez", email = "madison@gmail.com", isFavorite = true),
    Contact(name = "Daniel Hernandez", email = "daniel@gmail.com", isFavorite = false),
    Contact(name = "Lily Smith", email = "lily@gmail.com", isFavorite = true),
    Contact(name = "Matthew Johnson", email = "matthew@gmail.com", isFavorite = false),
    Contact(name = "Ella Brown", email = "ella@gmail.com", isFavorite = true),
    Contact(name = "Sebastian Davis", email = "sebastian@gmail.com", isFavorite = false),
    Contact(name = "Avery Wilson", email = "avery@gmail.com", isFavorite = true),
    Contact(name = "Daniel Moore", email = "daniel@gmail.com", isFavorite = false),
    Contact(name = "Scarlett Lee", email = "scarlett@gmail.com", isFavorite = true),
    Contact(name = "Mason Clark", email = "mason@gmail.com", isFavorite = false),
    Contact(name = "Sophie Hall", email = "sophie@gmail.com", isFavorite = true),
    Contact(name = "Jameson Garcia", email = "jameson@gmail.com", isFavorite = false),
    Contact(name = "Zoe Martinez", email = "zoe@gmail.com", isFavorite = true),
    Contact(name = "Ethan Rodriguez", email = "ethan@gmail.com", isFavorite = false),
    Contact(name = "Aria Lopez", email = "aria@gmail.com", isFavorite = true),
    Contact(name = "William Hernandez", email = "william@gmail.com", isFavorite = false),
    Contact(name = "Victoria Smith", email = "victoria@gmail.com", isFavorite = true),
    Contact(name = "David Johnson", email = "david@gmail.com", isFavorite = false),
    Contact(name = "Grace Brown", email = "grace@gmail.com", isFavorite = true),
    Contact(name = "Jackson Davis", email = "jackson@gmail.com", isFavorite = false),
    Contact(name = "Sofia Wilson", email = "sofia@gmail.com", isFavorite = true),
    Contact(name = "Logan Moore", email = "logan@gmail.com", isFavorite = false),
    Contact(name = "Charlotte Lee", email = "charlotte@gmail.com", isFavorite = true),
    Contact(name = "Lucas Clark", email = "lucas@gmail.com", isFavorite = false)
)


val favoriteContacts = listOf(
    Contact(name = "Liam Smith", email = "liam@gmail.com", isFavorite = true),
    Contact(name = "Emma Johnson", email = "emma@gmail.com", isFavorite = true),
    Contact(name = "Noah Williams", email = "noah@gmail.com", isFavorite = true),
    Contact(name = "Olivia Brown", email = "olivia@gmail.com", isFavorite = true),
    Contact(name = "Sophia Davis", email = "sophia@gmail.com", isFavorite = true),
    Contact(name = "Lucas Wilson", email = "lucas@gmail.com", isFavorite = true),
    Contact(name = "Isabella Moore", email = "isabella@gmail.com", isFavorite = true),
    Contact(name = "Mason Lee", email = "mason@gmail.com", isFavorite = true),
    Contact(name = "Amelia Clark", email = "amelia@gmail.com", isFavorite = true),
    Contact(name = "Evelyn Hall", email = "evelyn@gmail.com", isFavorite = true),
    Contact(name = "Ethan Garcia", email = "ethan@gmail.com", isFavorite = true),
    Contact(name = "Abigail Martinez", email = "abigail@gmail.com", isFavorite = true),
    Contact(name = "Elijah Lopez", email = "elijah@gmail.com", isFavorite = true),
    Contact(name = "Ava Hernandez", email = "ava@gmail.com", isFavorite = true),
    Contact(name = "Logan Smith", email = "logan@gmail.com", isFavorite = true),
    Contact(name = "Mia Johnson", email = "mia@gmail.com", isFavorite = true),
    Contact(name = "James Williams", email = "james@gmail.com", isFavorite = true),
    Contact(name = "Sophia Brown", email = "sophia@gmail.com", isFavorite = true),
    Contact(name = "William Davis", email = "william@gmail.com", isFavorite = true),
    Contact(name = "Scarlett Wilson", email = "scarlett@gmail.com", isFavorite = true)
)