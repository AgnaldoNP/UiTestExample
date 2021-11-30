package com.example.myapplication.ui.base

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.example.myapplication.R

abstract class BaseFragment<T : ViewBinding, V : BaseViewModel> : Fragment() {

    abstract val viewModel: V
    abstract fun inflateRoot(): View
    abstract fun getViewBiding(view: View): T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().onBackPressedDispatcher
            .addCallback(this) { onBackPressed() }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflateRoot()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycle.addObserver(viewModel)
        with(getViewBiding(view)) {
            initUI(this)
            initObservers(lifecycleOwner = viewLifecycleOwner, this)
        }
        initViewModel(savedInstanceState)

        setupLoading()
    }

    open fun initViewModel(savedInstanceState: Bundle?) {}
    open fun initUI(viewBinding: T) {}
    open fun initObservers(lifecycleOwner: LifecycleOwner, viewBinding: T) {}

    open fun onBackPressed() {
        val isBackStackPopped = findNavController().popBackStack()
        if (!isBackStackPopped) {
            requireActivity().finish()
        }
    }

    private var progressDialog: ProgressDialog? = null

    private fun setupLoading() {
        progressDialog = ProgressDialog(requireContext())
        progressDialog?.setMessage(getString(R.string.title_wait))
        progressDialog?.setCancelable(false)
    }

    protected fun hideBaseLoading() {
        if (!isRemoving && progressDialog?.isShowing == true) {
            progressDialog?.dismiss()
        }
    }

    protected fun showBaseLoading() {
        if (!isRemoving && progressDialog?.isShowing == false) {
            progressDialog?.show()
        }
    }
}
