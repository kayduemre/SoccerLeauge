package com.emrekaydu.soccerleauge.ui.fixture.view_model

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.bumptech.glide.Glide
import com.emrekaydu.soccerleauge.R
import com.emrekaydu.soccerleauge.app.App
import com.emrekaydu.soccerleauge.ui.fixture.match.PairTeams
import com.emrekaydu.soccerleauge.ui.fixture.match.Week

@EpoxyModelClass(layout = R.layout.item_mached_team)
abstract class PairedTeamsModel: EpoxyModelWithHolder<PairedTeamsModel.Holder>() {

    @EpoxyAttribute
    var week: PairTeams? = null

    @EpoxyAttribute
    var season : Int = 0


    override fun bind(holder: Holder) {
        super.bind(holder)


        if (season == 1) {

            holder.awayTeamName.text = week?.away?.teamName
            holder.homeTeamName.text = week?.home?.teamName

            week?.home?.logo.let {
                Glide.with(holder.imageViewHome).load(week?.home?.logo).into(holder.imageViewHome)
            }
            week?.away?.logo.let {
                Glide.with(holder.imageViewAway).load(week?.away?.logo).into(holder.imageViewAway)
            }

        } else if (season == 2) {

            holder.awayTeamName.text = week?.home?.teamName
            holder.homeTeamName.text = week?.away?.teamName

            week?.home?.logo.let {
                Glide.with(holder.imageViewAway).load(week?.away?.logo).into(holder.imageViewHome)
            }
            week?.away?.logo.let {
                Glide.with(holder.imageViewHome).load(week?.home?.logo).into(holder.imageViewAway)
            }
        }

    }

    class Holder: EpoxyHolder() {

        lateinit var imageViewHome: ImageView
        lateinit var imageViewAway: ImageView
        lateinit var homeTeamName: TextView
        lateinit var awayTeamName: TextView

        override fun bindView(itemView: View) {
            imageViewHome = itemView.findViewById(R.id.circle_image_paired_view_team_logo)
            imageViewAway = itemView.findViewById(R.id.circle_image_paired_view_destination_team_logo)
            homeTeamName = itemView.findViewById(R.id.text_view_paired_team_name)
            awayTeamName = itemView.findViewById(R.id.text_view_paired_team_destination_name)
        }

    }

}