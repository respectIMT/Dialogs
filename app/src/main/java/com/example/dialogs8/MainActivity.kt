package com.example.dialogs8
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.dialogs8.databinding.ActivityMainBinding
import com.example.dialogs8.databinding.MyDialogViewBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar
import java.util.*

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAlert.setOnClickListener {
            val alert = AlertDialog.Builder(this)

            alert.setTitle("Ogohlantirish")
            alert.setMessage("Ilovadan chiqasizmi")

            alert.setCancelable(false)

            alert.setPositiveButton("Yes"
            ) { _, _ ->
                Toast.makeText(this@MainActivity, "Saqlandi", Toast.LENGTH_SHORT).show()
            }
            alert.setNegativeButton("No"
            ) { _, _ ->
                Toast.makeText(this@MainActivity, "Saqlanmadi", Toast.LENGTH_SHORT).show()
            }
            alert.setNeutralButton("Cencel"
            ) { _, _ ->
                Toast.makeText(
                    this@MainActivity,
                    "Bekor qilindi",
                    Toast.LENGTH_SHORT
                ).show()
            }
            alert.show()
        }

        binding.btnCustom.setOnClickListener {
            val custom = android.app.AlertDialog.Builder(this,).create()

            val myDialogViewBinding = MyDialogViewBinding.inflate(layoutInflater)
            custom.setView(myDialogViewBinding.root)
            myDialogViewBinding.btnRozilik.setOnClickListener {
                Toast.makeText(this, "Muvaffaqqiyatli", Toast.LENGTH_SHORT).show()
                custom.cancel()
            }

            custom.show()
        }

        binding.btnFragment.setOnClickListener {
            val blankFragment = BlankFragment()
            blankFragment.show(supportFragmentManager, blankFragment.toString())

        }


        binding.btnTimePicker.setOnClickListener {
            val timePickerDialog = TimePickerDialog(
                this,
                { _, hourOfDay, minute -> Toast.makeText(this@MainActivity, "$hourOfDay:$minute", Toast.LENGTH_SHORT).show() },
                24,
                60,
                true

            )
            val date = Date()
            timePickerDialog.updateTime(date.hours, date.minutes)
            timePickerDialog.show()
        }


        binding.btnDatepicker.setOnClickListener {
            val datePickerDialog = DatePickerDialog(
                this,
                { _, year, month, dayOfMonth -> Toast.makeText(this@MainActivity, "$year/$month/$dayOfMonth", Toast.LENGTH_SHORT).show() },
                2022,
                7,
                28

            )
            datePickerDialog.show()
        }
        binding.btnBottomsheet.setOnClickListener {
            val bottomSheetDialog = BottomSheetDialog(this)
            val myDialogViewBinding = MyDialogViewBinding.inflate(layoutInflater)
            bottomSheetDialog.setContentView(myDialogViewBinding.root)
            bottomSheetDialog.show()
            myDialogViewBinding.btnRozilik.setOnClickListener {
                Toast.makeText(this, "Muvaffaqqiyatli", Toast.LENGTH_SHORT).show()
                bottomSheetDialog.cancel()
            }

        }

        binding.btnSnackbar.setOnClickListener {
            val snackbar = Snackbar.make(it, "Ma'lumotlar qayta ishlanmoqda", Snackbar.LENGTH_LONG)

            snackbar.setAction("Click", object : View.OnClickListener {
                override fun onClick(v: View?) {
                    Toast.makeText(this@MainActivity, "Ulandi", Toast.LENGTH_SHORT).show()
                }

            })
            snackbar.show()

        }
    }
}