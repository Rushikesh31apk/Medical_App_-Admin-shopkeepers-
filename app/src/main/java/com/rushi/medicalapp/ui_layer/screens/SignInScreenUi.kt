package com.rushi.medicalapp.ui_layer.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.rushi.medicalapp.R
import com.rushi.medicalapp.ui_layer.navigation.HomeScreen
import com.rushi.medicalapp.ui_layer.navigation.SignUpScreen


@Preview(showBackground = true)
@Composable
fun SingInScreenUi(navController: NavHostController) {
	Box(
		modifier = Modifier
			.fillMaxWidth()
			.fillMaxHeight()
			.background(color = Color.Transparent)
	) {
		Box(modifier = Modifier.align(Alignment.Center))
		{
			Image(
				painter = painterResource(id = R.drawable.login_logo),
				contentDescription = null,
				contentScale = ContentScale.Fit,
				modifier = Modifier
					.height(180.dp)
					.fillMaxWidth()
			)
			Column(modifier = Modifier
					.padding(16.dp)
					.fillMaxWidth()
					.verticalScroll(rememberScrollState()),
				horizontalAlignment = Alignment.CenterHorizontally
			) {
				Spacer(modifier = Modifier.height(50.dp))
				SignInText()
				Spacer(modifier = Modifier.height(8.dp))
				MailTextField()
				PasswordTextField()
				val gradientColor = listOf(Color(0xFF484BF1), Color(0xFF673AB7))
				val cornerRadius = 16.dp
				Spacer(modifier = Modifier.padding(10.dp))
				GradientButton(
					gradientColors = gradientColor,
					cornerRadius = cornerRadius,
					nameButton = "Login",
					roundedCornerShape = RoundedCornerShape(topStart = 30.dp, bottomEnd = 30.dp),
					navController = navController

				)
				Spacer(modifier = Modifier.padding(5.dp))
				TwoColoredText(navController=navController)
				Spacer(modifier = Modifier.padding(5.dp))
				ResetPassword()
				Spacer(modifier = Modifier.padding(20.dp))
			}
		}
	}
}

@Composable
fun SignInText() {
	Text(
		text = "Sign In",
		textAlign = TextAlign.Center,
		modifier = Modifier
			.padding(top = 130.dp)
			.fillMaxWidth(),
		style = MaterialTheme.typography.headlineLarge,
		fontWeight = FontWeight.Bold,
		fontFamily = FontFamily.Serif,
		color = MaterialTheme.colorScheme.primary,
	)
}

@Composable
fun MailTextField() {
	OutlinedTextField(
		value = "",
		onValueChange = {  },
		shape = RoundedCornerShape(topEnd = 12.dp, bottomStart = 12.dp),
		label = {
			Text(
				"Enter Your Email",
				color = MaterialTheme.colorScheme.primary,
				style = MaterialTheme.typography.labelMedium,
			)
		},
		placeholder = { Text(text = "Enter Your Email") },
		singleLine = true,
		modifier = Modifier
			.fillMaxWidth()
			.padding(horizontal = 20.dp),
		leadingIcon = {
			Icon(
				imageVector = Icons.Default.Email,
				contentDescription = null,
				tint = MaterialTheme.colorScheme.primary
			)
		}
	)
}

@Composable
fun PasswordTextField() {
	OutlinedTextField(
		value = "",
		onValueChange = {  },
		shape = RoundedCornerShape(topEnd = 12.dp, bottomStart = 12.dp),
		label = {
			Text(
				"Enter Your Password",
				color = MaterialTheme.colorScheme.primary,
				style = MaterialTheme.typography.labelMedium,
			)
		},
		placeholder = { Text(text = "Enter Your Password") },
		singleLine = true,
		modifier = Modifier
			.fillMaxWidth()
			.padding(20.dp),
		leadingIcon = {
			Icon(
				imageVector = Icons.Default.Lock,
				contentDescription = null,
				tint = MaterialTheme.colorScheme.primary
			)
		}
	)
}

@Composable
private fun GradientButton(
	gradientColors: List<Color>,
	cornerRadius: Dp,
	nameButton: String,
	roundedCornerShape: RoundedCornerShape,
	navController: NavHostController
) {
	Button(
		modifier = Modifier
			.fillMaxWidth()
			.padding(start = 30.dp, end = 30.dp),
		onClick = {
			navController.navigate(HomeScreen)
		},
		contentPadding = PaddingValues(),
		colors = ButtonDefaults.buttonColors(
			containerColor = Color.Transparent
		),
		shape = RoundedCornerShape(cornerRadius)
	) {
		Box(
			modifier = Modifier
				.fillMaxWidth()
				.background(
					brush = Brush.horizontalGradient(colors = gradientColors),
					shape = roundedCornerShape
				)
				.clip(roundedCornerShape)
				.background(
					brush = Brush.linearGradient(colors = gradientColors),
					shape = RoundedCornerShape(cornerRadius)
				)
				.padding(horizontal = 16.dp, vertical = 8.dp),
			contentAlignment = Alignment.Center
		) {
			Text(
				text = nameButton,
				fontSize = 20.sp,
				color = Color.White,
				fontFamily = FontFamily.Serif
			)
		}
	}
}

@Composable
fun TwoColoredText(navController: NavHostController) {
	Row {
		TextButton(onClick = {
			navController.navigate(SignUpScreen)
		}) {
			Text(
				text = "You don't have an account?",
				letterSpacing = 1.sp,
				style = MaterialTheme.typography.labelLarge
			)
			Text(text=" Sign Up",
				letterSpacing = 1.sp,
				style = MaterialTheme.typography.labelMedium,
				color = Color.Black,
				fontFamily = FontFamily.Serif
			)
		}
	}
}

@Composable
fun ResetPassword() {
	TextButton(onClick = {
	}) {
		Text(
			text = "Reset Password",
			letterSpacing = 1.sp,
			style = MaterialTheme.typography.labelLarge,
		)
	}
}