package com.example.myapplication.ui.login

import android.content.Intent
import android.view.View
import androidx.lifecycle.LifecycleOwner
import com.example.myapplication.commom.showError
import com.example.myapplication.databinding.ActivityLoginBinding
import com.example.myapplication.ui.base.BaseActivity
import com.example.myapplication.ui.login.LoginViewModel.LoginState
import com.example.myapplication.ui.main.MainActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>() {
    override val viewModel: LoginViewModel by viewModel()
    override fun inflateRoot(): View = ActivityLoginBinding.inflate(layoutInflater).root
    override fun getViewBiding(view: View) = ActivityLoginBinding.bind(view)

    override fun initUI(viewBinding: ActivityLoginBinding, hasBackNavigation: Boolean) {
        super.initUI(viewBinding, hasBackNavigation)
        with(viewBinding) {
            btLogin.setOnClickListener {
                viewModel.login(
                    etEmail.text.toString(),
                    etPassword.text.toString(),
                    cbRememberMe.isChecked
                )
            }
        }
    }

    override fun initObservers(lifecycleOwner: LifecycleOwner, viewBinding: ActivityLoginBinding) {
        super.initObservers(lifecycleOwner, viewBinding)
        viewModel.loginState.observe(lifecycleOwner) { state ->
            when (state) {
                is LoginState.Error -> showError(getString(state.message))
                is LoginState.EmailError -> viewBinding.etEmail.apply {
                    error = getString(state.message)
                    requestFocus()
                }
                is LoginState.PasswordError -> viewBinding.etPassword.apply {
                    error = getString(state.message)
                    requestFocus()
                }
                is LoginState.Success -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
            }
        }
    }
}
