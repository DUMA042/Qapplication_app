

package com.example.qapplication_app.UIScreens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.qapplication_app.Domain.OutlineUIData



@ExperimentalComposeUiApi
@Composable
fun  AuthScreen(EmailOutlineinfo:OutlineUIData,PasswordOutlineinfo:OutlineUIData) {
    val (emailoutlinename, emailHint) = EmailOutlineinfo
    val (passwordoutlinename, passwordHint) = PasswordOutlineinfo

    var emailText by remember { mutableStateOf("") }
    var passwordtext by remember { mutableStateOf("") }

    val keyboardController = LocalSoftwareKeyboardController.current
    val (focusPassword) = remember { FocusRequester.createRefs() }

    Column() {

        OutlinedTextField(
            value = emailText,
            modifier = Modifier
                .padding(top = 7.dp)
                .align(Alignment.CenterHorizontally),
            onValueChange = { emailText = it },
            label = { Text(emailoutlinename, fontSize = 20.sp) },
            placeholder = { Text(emailHint) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(onNext = { focusPassword.requestFocus() }),
        )

        OutlinedTextField(
            value = passwordtext,
            modifier = Modifier
                .padding(top = 7.dp)
                .align(Alignment.CenterHorizontally)
                .focusRequester(focusPassword),
            onValueChange = { passwordtext = it },
            label = { Text(passwordoutlinename, fontSize = 20.sp) },
            visualTransformation = PasswordVisualTransformation(),
            placeholder = { Text(passwordHint) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(onDone = { keyboardController?.hide() }),
        )

        Spacer(modifier = Modifier.padding(3.dp))

        Button(
            onClick = {

            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            shape = RoundedCornerShape(6.dp),
            colors = ButtonDefaults.buttonColors(
            )
        ) {
            Text(text = "Sign in with Google", modifier = Modifier.padding(6.dp))

        }
    }



}

@ExperimentalComposeUiApi
@Preview(showBackground = true)
@Composable
fun AuthPreview() {
        AuthScreen(OutlineUIData("Email","Your email"), OutlineUIData("Password","*****"))
}




