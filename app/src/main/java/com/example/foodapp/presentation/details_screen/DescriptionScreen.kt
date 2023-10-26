package com.example.foodapp.presentation.details_screen

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.foodapp.databinding.ScreenDescriptionBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@SuppressLint("SetJavaScriptEnabled")
class DescriptionScreen : Fragment() {

    private val viewModel: DetailsScreenViewModel by activityViewModels()
    private var _binding: ScreenDescriptionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ScreenDescriptionBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.descriptionScreenState.observe(viewLifecycleOwner) {
            setData(it)
        }
    }

    private fun setData(data: DescriptionScreenState) = with(binding) {
        instruction.apply {
            loadData(
                "$INSTRUCTION $NEW_LINE ${data.instructions} $NEW_LINE" +
                        "$DESCRIPTION $NEW_LINE ${data.summary}  $NEW_LINE" +
                        (data.winePairing.takeIf { !it.isNullOrEmpty() }?.let {
                            NEW_LINE + WINE_PAIRING + NEW_LINE + it
                        } ?: EMPTY_STRING),
                TYPE,
                ENCODING
            )
            webViewClient = WebViewClient()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        private const val INSTRUCTION = "<b>Instruction</b>"
        private const val DESCRIPTION = "<b>Description</b>"
        private const val WINE_PAIRING = "<b>Good with wine</b>"
        private const val NEW_LINE = "<br>"
        private const val EMPTY_STRING = ""
        private const val ENCODING = "UTF-8"
        private const val TYPE = "text/html"
    }
}