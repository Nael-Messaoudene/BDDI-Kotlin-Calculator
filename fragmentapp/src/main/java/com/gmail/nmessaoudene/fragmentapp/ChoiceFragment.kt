package com.gmail.nmessaoudene.fragmentapp
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.children
import androidx.fragment.app.Fragment

class ChoiceFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.choice_frag, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val parent = view.findViewById<ConstraintLayout>(R.id.operationParent)
        val buttons = parent.children.filter {
            it is Button
        }

        buttons.forEach {
            it.setOnClickListener{
                when (it.tag) {
                    "more" -> {
                        if (it is Button) {
                            activity?.change(OperationFragment.newInstance("Addition"))
                        }
                    }

                    "less" -> {
                        if (it is Button) {
                            activity?.change(OperationFragment.newInstance("Soustraction"))
                        }
                    }

                    "multip" -> {
                        if (it is Button) {
                            activity?.change(OperationFragment.newInstance("Multiplication"))
                        }
                    }

                    "divise" -> {
                        if (it is Button) {
                            activity?.change(OperationFragment.newInstance("Division"))
                        }
                    }
                }
            }
        }
    }
}