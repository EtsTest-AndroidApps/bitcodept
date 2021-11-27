package com.drbrosdev.qrscannerfromlib.ui.support

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.drbrosdev.qrscannerfromlib.R
import com.drbrosdev.qrscannerfromlib.databinding.FragmentSupportBinding
import com.drbrosdev.qrscannerfromlib.ui.epoxy.supportText
import com.drbrosdev.qrscannerfromlib.ui.epoxy.supportTierItem
import com.drbrosdev.qrscannerfromlib.util.getColor
import com.google.android.material.transition.MaterialSharedAxis

class SupportFragment: Fragment(R.layout.fragment_support) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        enterTransition = MaterialSharedAxis(MaterialSharedAxis.X, true)
        returnTransition = MaterialSharedAxis(MaterialSharedAxis.X, false)

        val binding = FragmentSupportBinding.bind(view)

        val list = listOf(
            SupportItem(title = "Tier 1", price = "2.00$", color = getColor(R.color.candy_blue)),
            SupportItem(title = "Tier 2", price = "5.00$", color = getColor(R.color.candy_red)),
            SupportItem(title = "Tier 3", price = "10.00$", color = getColor(R.color.candy_yellow)),
            SupportItem(title = "Tier 4", price = "20.00$", color = getColor(R.color.candy_orange)),
        )

        binding.recyclerView.apply {
            //sets spacing between items, NOT on start and end (horizontal)
            setItemSpacingPx(12)
            withModels {
                spanCount = 2
                supportText {
                    id("info")

                    //sets the span to fill the screen, spanSize = 2 (out of span count2)
                    spanSizeOverride { totalSpanCount, _, _ ->
                        totalSpanCount
                    }
                }

                list.forEach {
                    supportTierItem {
                        id(it.price)
                        price(it.price)
                        colorInt(it.color)
                        tierText(it.title)
                        onItemClicked {  }
                    }
                }
            }
        }
    }
}