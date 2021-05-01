package com.emrekaydu.soccerleauge.ui.team.view_model

import android.content.Context
import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.bumptech.glide.Glide
import com.emrekaydu.soccerleauge.R
import de.hdodenhof.circleimageview.CircleImageView

@EpoxyModelClass(layout = R.layout.item_team)
abstract class TeamItemModel: EpoxyModelWithHolder<TeamItemModel.Holder>() {

    @EpoxyAttribute
    var teamId: Int? = null

    @EpoxyAttribute
    lateinit var teamName: String

    @EpoxyAttribute
    lateinit var logoImage: String

    @EpoxyAttribute
    lateinit var context: Context

    override fun bind(holder: Holder) {
        super.bind(holder)

        logoImage.let {
            Glide.with(context).load(logoImage).into(holder.teamLogo)
        }
        holder.teamName.text = teamName
        holder.no.text = teamId.toString()
    }

    class Holder: EpoxyHolder() {
        lateinit var no: TextView
        lateinit var teamName: TextView
        lateinit var teamLogo: CircleImageView
        override fun bindView(itemView: View) {
            no = itemView.findViewById(R.id.text_view_no)
            teamName = itemView.findViewById(R.id.text_view_team_name)
            teamLogo = itemView.findViewById(R.id.circle_image_view_team_logo)

        }

    }
}