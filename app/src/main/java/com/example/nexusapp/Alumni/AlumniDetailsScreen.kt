import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlumniDetailsScreen(navController: NavHostController) {
    val focusManager = LocalFocusManager.current

    var name by remember { mutableStateOf("") }
    var contactNo by remember { mutableStateOf("") }
    var currentStatus by remember { mutableStateOf("") }
    var currentCompany by remember { mutableStateOf("") }
    var passoutCollege by remember { mutableStateOf("") }
    var passingYear by remember { mutableStateOf("") }
    var linkedInAccount by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }

    val statusOptions = listOf("Job", "Startup", "Looking for Job", "Business Owner")

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Enter details for Alumni",
                style = MaterialTheme.typography.titleLarge,
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Card(
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                modifier = Modifier.fillMaxWidth(),
                // Replace elevation with shadowElevation in Material3
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    OutlinedTextField(
                        value = name,
                        onValueChange = { name = it },
                        label = { Text("Name") },
                        placeholder = { Text("Name") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = contactNo,
                        onValueChange = { contactNo = it },
                        label = { Text("Contact No") },
                        placeholder = { Text("Contact No") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    // Dropdown Menu for Current Status
                    OutlinedTextField(
                        value = currentStatus,
                        onValueChange = { currentStatus = it },
                        label = { Text("Current Status") },
                        placeholder = { Text("Select Current Status") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(),
                        readOnly = true,
                        trailingIcon = {
                            androidx.compose.material3.IconButton(onClick = { expanded = true }) {
                                Icon(
                                    imageVector = Icons.Default.ArrowDropDown,
                                    contentDescription = null
                                )
                            }
                        }
                    )
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        statusOptions.forEach { status ->
                            DropdownMenuItem(
                                text = { Text(text = status) },
                                onClick = {
                                    currentStatus = status
                                    expanded = false
                                }
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = currentCompany,
                        onValueChange = { currentCompany = it },
                        label = { Text("Current Company") },
                        placeholder = { Text("Current Company (otherwise N/A)") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = passoutCollege,
                        onValueChange = { passoutCollege = it },
                        label = { Text("Passout College") },
                        placeholder = { Text("Passout College") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = passingYear,
                        onValueChange = { passingYear = it },
                        label = { Text("Passing Year") },
                        placeholder = { Text("20__") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = linkedInAccount,
                        onValueChange = { linkedInAccount = it },
                        label = { Text("LinkedIn Account") },
                        placeholder = { Text("LinkedIn Account") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = {
                            // Handle the submit action here
                            focusManager.clearFocus()
                            navController.navigate("details_submitted") // Navigate to the new screen
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = "Submit")
                    }
                }
            }
        }
    }
}

//@Preview(showBackground = true, device = Devices.PIXEL_4)
//@Composable
//fun AlumniDetailsScreenPreview() {
//    AlumniDetailsScreen(navController = navController)
//}
