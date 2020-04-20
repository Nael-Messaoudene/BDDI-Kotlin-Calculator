package com.gmail.nmessaoudene.calculatorwithkotlin

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.children
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder




class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        var str: String? = null
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val parent = findViewById<ConstraintLayout>(R.id.touches)

        var result = findViewById<TextView>(R.id.result)

        parent.children.forEach {

            if (it is AppCompatButton) {
                it.setOnClickListener {

                    result = findViewById(R.id.result)
                    str = result.text.toString()

                    when (it.tag) {
                        "number" -> {

                            if (it is AppCompatButton) {
                                result.text = (str + it.text)
                            }

                        }
                        "soustract" -> {

                            if (it is AppCompatButton) {
                                result.text = (str + it.text)
                            }
                        }
                        "add" -> {

                            if (it is AppCompatButton) {
                                result.text = (str + it.text)
                            }
                        }
                        "divide" -> {

                            if (it is AppCompatButton) {
                                result.text = (str + it.text)
                            }
                        }
                        "multiply" -> {

                            if (it is AppCompatButton) {
                                result.text = (str + it.text)
                            }
                        }
                        "dot" -> {

                            if (it is AppCompatButton) {
                                result.text = (str + it.text)
                            }
                        }
                        "clean" -> {

                            if (it is AppCompatButton) {
                                result.text = ""
                            }
                        }
                        "equal" -> {

                            if (it is AppCompatButton) {
                                str = result.text.toString()

                                val expression = ExpressionBuilder(str).build()
                                try {
                                    var newval = expression.evaluate()

                                    println(newval)
                                    result.text = "${newval}"

                                } catch (ex: Exception) {
                                    println("errrorrrrrrr")
                                }

                            }
                        }

                    }
                }
            }

        }
    }
}
