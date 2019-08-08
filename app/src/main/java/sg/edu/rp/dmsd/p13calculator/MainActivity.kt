package sg.edu.rp.dmsd.p13calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var globalNum = ""
    var total = 0.0
    var once = ""
    var change = false
    var dot = false
    var op = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonAC.setOnClickListener {
            once = ""
            globalNum = ""
            tvSum.text = ""
            change = false
            dot = false

        }


    }

    fun btnOnClick(view: View) {

        val btnSelected = view as Button
        if (change == false) {
            when (btnSelected.id) {
                button00.id -> once = once + "0"
                button01.id -> once = once + "1"
                button02.id -> once = once + "2"
                button03.id -> once = once + "3"
                button04.id -> once = once + "4"
                button05.id -> once = once + "5"
                button06.id -> once = once + "6"
                button07.id -> once = once + "7"
                button08.id -> once = once + "8"
                button09.id -> once = once + "9"
            }
            tvSum.text = "$once"
        } else {
            when (btnSelected.id) {
                button00.id -> globalNum = globalNum + "0"
                button01.id -> globalNum = globalNum + "1"
                button02.id -> globalNum = globalNum + "2"
                button03.id -> globalNum = globalNum + "3"
                button04.id -> globalNum = globalNum + "4"
                button05.id -> globalNum = globalNum + "5"
                button06.id -> globalNum = globalNum + "6"
                button07.id -> globalNum = globalNum + "7"
                button08.id -> globalNum = globalNum + "8"
                button09.id -> globalNum = globalNum + "9"
            }
            tvSum.text = "$globalNum"
        }


    }

    fun btnOnOperatorClick(view: View) {
        val btnSelected = view as Button
        when (btnSelected.id) {
            buttonDivide.id -> op = "/"
            buttonMinus.id -> op = "-"
            buttonTimes.id -> op = "*"
            buttonPlus.id -> op = "+"
        }
        if (op == "+" && globalNum != "") {
            total = once.toDouble() + globalNum.toDouble()
            once = total.toString()
            globalNum = ""
            total = 0.0
        } else if (op == "-" && globalNum != "") {
            total = once.toDouble() - globalNum.toDouble()
            once = total.toString()
            globalNum = ""
            total = 0.0
        } else if (op == "*" && globalNum != "") {
            total = once.toDouble() * globalNum.toDouble()
            once = total.toString()
            globalNum = ""
            total = 0.0
        } else if (op == "/" && globalNum != "") {
            total = once.toDouble() / globalNum.toDouble()
            once = total.toString()
            globalNum = ""
            total = 0.0
        }
        change = true
        dot = false
        tvSum.text = ""
        buttonDot.isEnabled = true

    }


    fun btnDotClick(view: View) {
        if (change == false) {
            once = once + "."
            tvSum.text = "$once"
        } else if (change == true) {
            globalNum = globalNum + "."
            tvSum.text = "$globalNum"
        }
        if (dot == false) {
            dot = true
            buttonDot.isEnabled = false
        }

    }

    fun btnEqualClick(view: View) {
        if (op == "+") {
            total = once.toDouble() + globalNum.toDouble()
        } else if (op == "-") {
            total = once.toDouble() - globalNum.toDouble()
        } else if (op == "*") {
            total = once.toDouble() * globalNum.toDouble()
        } else if (op == "/") {
            total = once.toDouble() / globalNum.toDouble()
        }
        tvSum.text = total.toString()
        once = total.toString()
        total = 0.0
        globalNum = ""
        dot = false
        buttonDot.isEnabled = true

    }

}
