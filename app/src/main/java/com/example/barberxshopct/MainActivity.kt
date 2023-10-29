package com.example.barberxshopct

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.barberxshopct.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val tabIcons = intArrayOf(
        R.drawable.ic_localization,
        R.drawable.ic_professional,
        R.drawable.ic_service,
        R.drawable.ic_time,
        R.drawable.ic_schedule,
        R.drawable.ic_settings
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        configTabLayout()
    }


    private fun configTabLayout() {
        val adapter = ViewPagerAdapter(this)
        binding.viewPager.setAdapter(adapter)

        adapter.addFragment(LocalizationFragment(), "Local")
        adapter.addFragment(ProfessionalFragment(), "Barber")
        adapter.addFragment(ServiceFragment(), "Serviço")
        adapter.addFragment(TimeFragment(), "Aponta")
        adapter.addFragment(ScheduledFragment(), "Agenda")
        adapter.addFragment(SettingsFragment(), "Configs")

        binding.viewPager.setOffscreenPageLimit(adapter.itemCount)

        val mediator: TabLayoutMediator

        mediator = TabLayoutMediator(
            binding.tabs,
            binding.viewPager
        ) { tab: TabLayout.Tab, position: Int ->
            tab.text = adapter.getTitle(position)
            tab.setIcon(tabIcons.get(position))
        }
        mediator.attach()
    }

}