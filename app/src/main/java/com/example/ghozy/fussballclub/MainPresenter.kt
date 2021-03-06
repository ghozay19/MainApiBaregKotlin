package com.example.ghozy.fussballclub

import com.example.ghozy.fussballclub.Api.ApiRepository
import com.example.ghozy.fussballclub.Api.TheSportDBApi
import com.example.ghozy.fussballclub.model.TeamResponse
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainPresenter(
        private val view: MainView,
        private val apiRepository: ApiRepository,
        private val gson: Gson){

    fun getTeamList( league: String?){
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                    .doRequest(TheSportDBApi.getTeams(league)),
                    TeamResponse::class.java)

            uiThread {
                view.hideLoading()
                view.showTeamList(data.teams)
            }

        }
    }

}