package com.example.ghozy.fussballclub

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.ghozy.fussballclub.R.id.team_badge
import com.example.ghozy.fussballclub.R.id.team_name
import com.example.ghozy.fussballclub.model.Team
import org.jetbrains.anko.*

class MainAdapter(private val teams: List<Team>) : RecyclerView.Adapter<MainAdapter.TeamViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): TeamViewHolder {
        return TeamViewHolder(TeamUI().createView(AnkoContext.create(p0.context, p0)))
    }

    override fun getItemCount(): Int = teams.size

    //p0 = holder , p1 = position
    /**
     * normally ini bentuknya gini
     * override fun onBindViewHolder(holder: TeamViewHolder, position:Int)
     */
    override fun onBindViewHolder(p0: TeamViewHolder, p1: Int) {
       p0.bindItem(teams[p1])
    }

    class TeamViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val teamBadge: ImageView = view.find(team_badge)
        private val teamName: TextView = view.find(team_name)

        fun bindItem(teams: Team) {

            Glide.with(itemView.context).load(teams.teamBadge).into(teamBadge)
            teamName.text = teams.teamName

        }
    }


    class TeamUI : AnkoComponent<ViewGroup> {
        override fun createView(ui: AnkoContext<ViewGroup>): View {
            return with(ui) {
                linearLayout {
                    lparams(width = matchParent, height = wrapContent)
                    padding = dip(16)
                    orientation = LinearLayout.HORIZONTAL

                    imageView {
                        id = R.id.team_badge
                    }.lparams {
                        height = dip(50)
                        width = dip(50)
                    }

                    textView {
                        id = R.id.team_name
                        textSize = 16f
                    }.lparams{
                        margin = dip(15)
                    }

                }
            }
        }
    }

}