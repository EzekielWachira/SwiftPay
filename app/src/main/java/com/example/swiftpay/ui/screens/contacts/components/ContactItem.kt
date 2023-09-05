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


val searchContacts = listOf(
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
    Contact(name = "Lucas Clark", email = "lucas@gmail.com", isFavorite = false),
    Contact(name = "William Thomas", email = "williamthomas@gmail.com", isFavorite = true),
    Contact(name = "Sophia White", email = "sophiawhite@gmail.com", isFavorite = false),
    Contact(name = "Mason Harris", email = "masonharris@gmail.com", isFavorite = true),
    Contact(name = "Ava Walker", email = "avawalker@gmail.com", isFavorite = false),
    Contact(name = "Elijah King", email = "elijahking@gmail.com", isFavorite = true),
    Contact(name = "Mia Green", email = "miagreen@gmail.com", isFavorite = false),
    Contact(name = "James Johnson", email = "jamesjohnson@gmail.com", isFavorite = true),
    Contact(name = "Olivia Anderson", email = "oliviaanderson@gmail.com", isFavorite = false),
    Contact(name = "Lucas Martinez", email = "lucasmartinez@gmail.com", isFavorite = true),
    Contact(name = "Sophia Hernandez", email = "sophiahernandez@gmail.com", isFavorite = false),
    Contact(name = "William Moore", email = "williammoore@gmail.com", isFavorite = true),
    Contact(name = "Ella Smith", email = "ellasmith@gmail.com", isFavorite = false),
    Contact(name = "Ethan Davis", email = "ethandavis@gmail.com", isFavorite = true),
    Contact(name = "Avery Brown", email = "averybrown@gmail.com", isFavorite = false),
    Contact(name = "Madison Johnson", email = "madisonjohnson@gmail.com", isFavorite = true),
    Contact(name = "Liam Garcia", email = "liamgarcia@gmail.com", isFavorite = false),
    Contact(name = "Isabella Martinez", email = "isabellamartinez@gmail.com", isFavorite = true),
    Contact(name = "Jackson Lee", email = "jacksonlee@gmail.com", isFavorite = false),
    Contact(name = "Chloe Clark", email = "chloeclark@gmail.com", isFavorite = true),
    Contact(name = "Alexander Rodriguez", email = "alexanderrodriguez@gmail.com", isFavorite = false),
    Contact(name = "Emma Lopez", email = "emmalopez@gmail.com", isFavorite = true),
    Contact(name = "Henry Davis", email = "henrydavis@gmail.com", isFavorite = false),
    Contact(name = "Aurora Hall", email = "aurorahall@gmail.com", isFavorite = true),
    Contact(name = "Lily Smith", email = "lilysmith@gmail.com", isFavorite = false),
    Contact(name = "Matthew Johnson", email = "matthewjohnson@gmail.com", isFavorite = true),
    Contact(name = "Ella Brown", email = "ellabrown@gmail.com", isFavorite = false),
    Contact(name = "Sebastian Davis", email = "sebastiandavis@gmail.com", isFavorite = true),
    Contact(name = "Avery Wilson", email = "averywilson@gmail.com", isFavorite = false),
    Contact(name = "Daniel Moore", email = "danielmoore@gmail.com", isFavorite = true),
    Contact(name = "Scarlett Lee", email = "scarlettlee@gmail.com", isFavorite = false),
    Contact(name = "Mason Clark", email = "masonclark@gmail.com", isFavorite = true),
    Contact(name = "Sophie Hall", email = "sophiehall@gmail.com", isFavorite = false),
    Contact(name = "Jameson Garcia", email = "jamesongarcia@gmail.com", isFavorite = true),
    Contact(name = "Zoe Martinez", email = "zoemartinez@gmail.com", isFavorite = false),
    Contact(name = "Ethan Rodriguez", email = "ethanrodriguez@gmail.com", isFavorite = true),
    Contact(name = "Aria Lopez", email = "arialopez@gmail.com", isFavorite = false),
    Contact(name = "William Hernandez", email = "williamhernandez@gmail.com", isFavorite = true),
    Contact(name = "Victoria Smith", email = "victoriasmith@gmail.com", isFavorite = false),
    Contact(name = "David Johnson", email = "davidjohnson@gmail.com", isFavorite = true),
    Contact(name = "Grace Brown", email = "gracebrown@gmail.com", isFavorite = false),
    Contact(name = "Jackson Davis", email = "jacksondavis@gmail.com", isFavorite = true),
    Contact(name = "Sofia Wilson", email = "sofiawilson@gmail.com", isFavorite = false),
    Contact(name = "Logan Moore", email = "loganmoore@gmail.com", isFavorite = true),
    Contact(name = "Charlotte Lee", email = "charlottelee@gmail.com", isFavorite = false),
    Contact(name = "Lucas Clark", email = "lucasclark@gmail.com", isFavorite = true),
    Contact(name = "William Thomas", email = "williamthomas@gmail.com", isFavorite = false),
    Contact(name = "Sophia White", email = "sophiawhite@gmail.com", isFavorite = true),
    Contact(name = "Mason Harris", email = "masonharris@gmail.com", isFavorite = false),
    Contact(name = "Ava Walker", email = "avawalker@gmail.com", isFavorite = true),
    Contact(name = "Elijah King", email = "elijahking@gmail.com", isFavorite = false),
    Contact(name = "Mia Green", email = "miagreen@gmail.com", isFavorite = true),
    Contact(name = "James Johnson", email = "jamesjohnson@gmail.com", isFavorite = false),
    Contact(name = "Olivia Anderson", email = "oliviaanderson@gmail.com", isFavorite = true),
    Contact(name = "Lucas Martinez", email = "lucasmartinez@gmail.com", isFavorite = false),
    Contact(name = "Sophia Hernandez", email = "sophiahernandez@gmail.com", isFavorite = true),
    Contact(name = "William Moore", email = "williammoore@gmail.com", isFavorite = false),
    Contact(name = "Ella Smith", email = "ellasmith@gmail.com", isFavorite = true),
    Contact(name = "Ethan Davis", email = "ethandavis@gmail.com", isFavorite = false),
    Contact(name = "Avery Brown", email = "averybrown@gmail.com", isFavorite = true),
    Contact(name = "Madison Johnson", email = "madisonjohnson@gmail.com", isFavorite = false),
    Contact(name = "Liam Garcia", email = "liamgarcia@gmail.com", isFavorite = true),
    Contact(name = "Isabella Martinez", email = "isabellamartinez@gmail.com", isFavorite = false),
    Contact(name = "Jackson Lee", email = "jacksonlee@gmail.com", isFavorite = true),
    Contact(name = "Chloe Clark", email = "chloeclark@gmail.com", isFavorite = false)
)
