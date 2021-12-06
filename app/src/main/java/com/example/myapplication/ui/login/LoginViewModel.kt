package com.example.myapplication.ui.login

import androidx.annotation.StringRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.R
import com.example.myapplication.commom.SingleLiveEvent
import com.example.myapplication.domain.usecase.LoginUseCase
import com.example.myapplication.domain.usecase.LoginUseCase.LoginStatus
import com.example.myapplication.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginUseCase: LoginUseCase
) : BaseViewModel() {

    private val _loginState = SingleLiveEvent<Event>()
    val loginState: LiveData<Event> = _loginState

    fun login(email: String, password: String, rememberEmail: Boolean) {
        viewModelScope.launch {
            val state = when (loginUseCase.login(email, password, rememberEmail)) {
                LoginStatus.NO_EMAIL -> LoginState.EmailError(R.string.login_validation_no_email)
                LoginStatus.EMPTY_EMAIL -> LoginState.EmailError(R.string.login_validation_empty_email)
                LoginStatus.EMPTY_PASSWORD -> LoginState.PasswordError(R.string.login_validation_empty_password)
                LoginStatus.LOGIN_REQUEST_FAIL -> LoginState.Error(R.string.login_request_error)
                LoginStatus.SUCCESS -> LoginState.Success
            }

            _loginState.postValue(state)
        }
    }

    sealed class LoginState : Event {
        object Success : LoginState()
        data class EmailError(@StringRes val message: Int) : LoginState()
        data class PasswordError(@StringRes val message: Int) : LoginState()
        data class Error(@StringRes val message: Int) : LoginState()
    }
}
