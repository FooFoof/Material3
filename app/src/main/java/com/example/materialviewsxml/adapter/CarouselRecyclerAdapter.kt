package com.example.materialviewsxml.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.example.materialviewsxml.R
import com.google.android.material.carousel.MaskableFrameLayout

class CarouselRecyclerAdapter : RecyclerView.Adapter<CarouselRecyclerAdapter.CarouselViewHolder>() {

    private val items = listOf(
        "Item 1",
        "Item 2",
        "Item 3",
        "Item 4",
        "Item 5",
        "Item 6",
        "Item 7",
        "Item 8",
        "Item 9",
        "Item 10",
        "Item 11",
        "Item 12",
        "Item 13",
        "Item 14",
        "Item 15",
        "Item 16",
        "Item 17",
        "Item 18",
        "Item 19",
        "Item 20",
    )

//    override fun getItemViewType(position: Int): Int {
//        return when(position % 2) {
//            0 -> TYPE_ITEM_ONE
//            else -> TYPE_ITEM_TWO
//        }
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselViewHolder {
        // カルーセルの最大幅は、先頭のアイテムの要素によって決定します。
        // 下記とgetItemViewTypeをコメントアウトすると、先頭のアイテムのサイズによってカルーセルの最大幅が変わることが確認できます。
//        val view = when(viewType) {
//            TYPE_ITEM_ONE -> {
//                LayoutInflater.from(parent.context)
//                    .inflate(R.layout.carousel_recycler_item, parent, false)
//            }
//            else -> {
//                LayoutInflater.from(parent.context)
//                    .inflate(R.layout.carousel_recycler_item_two, parent, false)
//            }
//        }
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.carousel_recycler_item, parent, false)
        return CarouselViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarouselViewHolder, position: Int) {
        holder.textMember.text = items[position]
        holder.item.background = when (position % 3) {
            0 -> AppCompatResources.getDrawable(holder.item.context, R.color.light_blue)
            1 -> AppCompatResources.getDrawable(holder.item.context, R.color.dark_brown)
            else ->  AppCompatResources.getDrawable(holder.item.context, R.color.light_green)
        }
        (holder.itemView as MaskableFrameLayout).setOnMaskChangedListener {
                maskRect ->
            // Any custom motion to run when mask size changes
            holder.textMember.translationX = maskRect.left
            holder.textMember.alpha = lerp(1F, 0F, 0F, 80F, maskRect.left)
        }
    }

    override fun getItemCount(): Int = items.size

    class CarouselViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textMember: TextView = itemView.findViewById(R.id.text_member)
        val item: View = itemView.rootView
    }

    companion object {
        const val TYPE_ITEM_ONE = 1
        const val TYPE_ITEM_TWO = 2

        fun lerp(
                outputMin: Float,
                outputMax: Float,
                inputMin: Float,
                inputMax: Float,
                value: Float
        ): Float {
                if (value <= inputMin) {
                    return outputMin;
                }
                if (value >= inputMax) {
                    return outputMax;
                }

                return  outputMin + ((value - inputMin) / (inputMax - inputMin)) * ( outputMax - outputMin)
            }
        }
    }
