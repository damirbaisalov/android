package com.example.calculatorp1kotlin


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException
import java.security.KeyStore
import kotlin.text.clear

class MainActivity : AppCompatActivity() , View.OnClickListener{

//    TextView calcScreen
//    TextView txtV;
//    //    private TextView resScreen;
//    public Button n0;
//    public Button n1;
//    public Button n2;
//    public Button n3;
//    public Button n4;
//    public Button n5;
//    public Button n6;
//    public Button n7;
//    public Button n8;
//    public Button n9;
//    public Button btnDot;
//    public Button equal;
//    public Button addit;
//    public Button subs;
//    public Button mult;
//    public Button div;
//    public Button btnDelete;
//    public Button btnSqrt;
//    public Button btnPow;
//    public Button deleteAll;

    private lateinit var calcScreen : TextView
    private var n0 : Button?=null
    private var n1 : Button?=null
    private var n2 : Button?=null
    private var n3 : Button?=null
    private var n4 : Button?=null
    private var n5 : Button?=null
    private var n6 : Button?=null
    private var n7 : Button?=null
    private var n8 : Button?=null
    private var n9 : Button?=null
    private var btnDot : Button?=null
    private var equal : Button?=null
    private var addit : Button?=null
    private var subs : Button?=null
    private var mult : Button?=null
    private var div : Button?=null
    private var btnDelete : Button?=null
    private var btnSqrt : Button?=null
    private var btnPow : Button?=null
    private var clearAll : Button?= null

    private var  isDot = false
    private var num1 = 0.0
    private var num2 = 0.0

    private var state: State = State.START
    private var sign: Sign = Sign.UNDEFINED


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeButtons()
        n0?.setOnClickListener(this)
        n1?.setOnClickListener(this)
        n2?.setOnClickListener(this)
        n3?.setOnClickListener(this)
        n4?.setOnClickListener(this)
        n5?.setOnClickListener(this)
        n6?.setOnClickListener(this)
        n7?.setOnClickListener(this)
        n8?.setOnClickListener(this)
        n9?.setOnClickListener(this)
        btnDot?.setOnClickListener(this)
        equal?.setOnClickListener(this)
        addit?.setOnClickListener(this)
        subs?.setOnClickListener(this)
        mult?.setOnClickListener(this)
        div?.setOnClickListener(this)
        btnDelete?.setOnClickListener(this)
        btnSqrt?.setOnClickListener(this)
        btnPow?.setOnClickListener(this)
        clearAll?.setOnClickListener(this)
    }

    private fun initializeButtons(){
        calcScreen = findViewById(R.id.calcScreen)
        n0 = findViewById(R.id.num0)
        n1 = findViewById(R.id.num1)
        n2 = findViewById(R.id.num2)
        n3 = findViewById(R.id.num3)
        n4 = findViewById(R.id.num4)
        n5 = findViewById(R.id.num5)
        n6 = findViewById(R.id.num6)
        n7 = findViewById(R.id.num7)
        n8 = findViewById(R.id.num8)
        n9 = findViewById(R.id.num9)

        btnDot = findViewById(R.id.dot)
        equal = findViewById(R.id.equal)
        addit  = findViewById(R.id.plus)
        subs = findViewById(R.id.subs)
        mult = findViewById(R.id.mult)
        div = findViewById(R.id.div)
        btnDelete = findViewById(R.id.del)
        btnSqrt = findViewById(R.id.sqrt)
        btnPow = findViewById(R.id.square)
        clearAll  = findViewById(R.id.clear)

    }

    override fun onClick(v: View?) {
        val id : Int = v!!.id
        when(id){
            R.id.clear -> {
                calcScreen.text= ""
                sign = Sign.UNDEFINED
                state = State.START
                isDot = false
                num1 = 0.0
                num2 = 0.0
            }
            R.id.del -> {
                if (calcScreen.text.toString().equals("Infinity")) {
                    calcScreen.text = ""
                }
                if (calcScreen.text.toString().length==0){
                    num1 = 0.0
                    num2 = 0.0
                } else if (calcScreen.text.toString().length != 1){
                    try {
                        calcScreen.text = calcScreen.text.substring(0,calcScreen.text.length-1)
                        num1 = calcScreen.text.toString().toDouble()
                    } catch ( e : NumberFormatException){
                        calcScreen.text = ""
                    }
                } else
                    calcScreen.text = ""
                if (calcScreen.text.toString().contains("."))
                    isDot = true
                else
                    isDot = false
            }
            R.id.dot -> {
                if (calcScreen.text.toString().equals("Infinity")){
                    calcScreen.text = ""
                }
                if (calcScreen.text.toString().contains("."))
                    isDot = true
                if (isDot!=true)
                    calcScreen.append(".")
                isDot = true
            }
            R.id.num1 -> {
                if (calcScreen.text.toString().equals("Infinity")){
                    calcScreen.text = ""
                }
                if (state != State.START && state!=State.EQUAL){
                    state = State.START
                    calcScreen.text= ""
                }
                calcScreen.append("1")
            }
            R.id.num2 -> {
                if (calcScreen.text.toString().equals("Infinity")){
                    calcScreen.text = ""
                }
                if (state != State.START && state!=State.EQUAL){
                    state = State.START
                    calcScreen.text= ""
                }
                calcScreen.append("2")
            }
            R.id.num3 -> {
                if (calcScreen.text.toString().equals("Infinity")){
                    calcScreen.text = ""
                }
                if (state != State.START && state!=State.EQUAL){
                    state = State.START
                    calcScreen.text= ""
                }
                calcScreen.append("3")
            }
            R.id.num4 -> {
                if (calcScreen.text.toString().equals("Infinity")){
                    calcScreen.text = ""
                }
                if (state != State.START && state!=State.EQUAL){
                    state = State.START
                    calcScreen.text= ""
                }
                calcScreen.append("4")
            }
            R.id.num5 -> {
                if (calcScreen.text.toString().equals("Infinity")){
                    calcScreen.text = ""
                }
                if (state != State.START && state!=State.EQUAL){
                    state = State.START
                    calcScreen.text= ""
                }
                calcScreen.append("5")
            }
            R.id.num6 -> {
                if (calcScreen.text.toString().equals("Infinity")){
                    calcScreen.text = ""
                }
                if (state != State.START && state!=State.EQUAL){
                    state = State.START
                    calcScreen.text= ""
                }
                calcScreen.append("6")
            }
            R.id.num7 -> {
                if (calcScreen.text.toString().equals("Infinity")){
                    calcScreen.text = ""
                }
                if (state != State.START && state!=State.EQUAL){
                    state = State.START
                    calcScreen.text= ""
                }
                calcScreen.append("7")
            }
            R.id.num8 -> {
                if (calcScreen.text.toString().equals("Infinity")){
                    calcScreen.text = ""
                }
                if (state != State.START && state!=State.EQUAL){
                    state = State.START
                    calcScreen.text= ""
                }
                calcScreen.append("8")
            }
            R.id.num9 -> {
                if (calcScreen.text.toString().equals("Infinity")){
                    calcScreen.text = ""
                }
                if (state != State.START && state!=State.EQUAL){
                    state = State.START
                    calcScreen.text= ""
                }
                calcScreen.append("9")
            }
            R.id.num0 -> {
                if (calcScreen.text.toString().equals("Infinity")){
                    calcScreen.text = ""
                }
                if (state != State.START && state!=State.EQUAL){
                    state = State.START
                    calcScreen.text= ""
                }
                if ((calcScreen.text.toString().length == 0 && isDot == false) || (calcScreen.text.toString().get(0) == '0' && isDot == false))
                    calcScreen.text="0"
                else
                    calcScreen.append("0")

            }
            R.id.plus -> {
                state = State.PLUS
                sign = Sign.PLUS
                if (calcScreen.text.toString().equals("Infinity")){
                    calcScreen.text = ""
                }
                try {
                    num1 = calcScreen.text.toString().toDouble()
                } catch (e: NumberFormatException){
                    calcScreen.text = ""
                }
                isDot = false
            }
            R.id.subs -> {
                state = State.MINUS
                sign = Sign.MINUS
                if (calcScreen.text.toString().equals("Infinity")){
                    calcScreen.text = ""
                }
                try {
                    num1 = calcScreen.text.toString().toDouble()
                } catch (e: NumberFormatException){
                    calcScreen.text = ""
                }
                isDot = false
            }
            R.id.mult -> {
                state = State.MULT
                sign = Sign.MULT
                if (calcScreen.text.toString().equals("Infinity")){
                    calcScreen.text = ""
                }
                try {
                    num1 = calcScreen.text.toString().toDouble()
                } catch (e: NumberFormatException){
                    calcScreen.text = ""
                }
                isDot = false
            }
            R.id.div -> {
                state = State.DIVIDE
                sign = Sign.DIVIDE
                if (calcScreen.text.toString().equals("Infinity")){
                    calcScreen.text = ""
                }
                if (calcScreen.text.toString().equals("")){
                    calcScreen.text=""
                } else {
                try {
                    num1 = calcScreen.text.toString().toDouble()
                } catch (e: NumberFormatException){
                        calcScreen.text = "Infinity"
                } }
                isDot = false
            }
            R.id.sqrt -> {
                state = State.SQRT
                sign = Sign.SQRT
                if (calcScreen.text.toString().equals("Infinity")){
                    calcScreen.text = ""
                }
                try {
                    num1 = calcScreen.text.toString().toDouble()
                } catch (e: NumberFormatException){
                    calcScreen.text = ""
                }
                if (calcScreen.text.toString().length>0){
                    calcScreen.text = Math.sqrt(num1).toString()
                }
                isDot = false
            }
            R.id.square -> {
                state = State.POW
                sign = Sign.POW
                if (calcScreen.text.toString().equals("Infinity")){
                    calcScreen.text = ""
                }
                try {
                    num1 = calcScreen.text.toString().toDouble()
                } catch (e: NumberFormatException){
                    calcScreen.text = ""
                }
                if (calcScreen.text.toString().length>0){
                    calcScreen.text = Math.pow(num1, 2.0).toString()
                }
                isDot = false
            }
            R.id.equal -> {
                if (calcScreen.text.toString().equals("Infinity")) {
                    calcScreen.text = ""
                }
                try {
                    num2 = calcScreen.text.toString().toDouble()
                } catch (e : NumberFormatException){
                    calcScreen.text = ""
                }
                if (sign == Sign.PLUS)
                    calcScreen.text = (num1+num2).toString()
                else if (sign == Sign.MINUS)
                    calcScreen.text= (num1-num2).toString()
                else if (sign == Sign.MULT)
                    calcScreen.text= (num1*num2).toString()
                else if (sign == Sign.DIVIDE)
                    calcScreen.text= (num1/num2).toString()
                else if (sign == Sign.UNDEFINED)
                    calcScreen.text= calcScreen.text.toString()
                else
                    calcScreen.text = "Infinity"
                state = State.EQUAL

            }
        }

    }
}
