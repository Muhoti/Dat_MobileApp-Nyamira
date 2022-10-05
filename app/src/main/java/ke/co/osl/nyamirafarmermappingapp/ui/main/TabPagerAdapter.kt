package ke.co.osl.nyamirafarmermappingapp.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import ke.co.osl.nyamirafarmermappingapp.fragments.CollectData
import ke.co.osl.nyamirafarmermappingapp.fragments.UpdateData


class TabPagerAdapter(fm: FragmentManager?, var tabCount: Int) :
    FragmentPagerAdapter(fm!!) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
               System.out.println("fragment 1")
                CollectData()
            }
            1 -> {
                System.out.println("fragment 2")
                UpdateData()
            }
            else -> {
                System.out.println("other")
                CollectData()
            }
        }
    }

    override fun getCount(): Int {
        return tabCount
    }
}