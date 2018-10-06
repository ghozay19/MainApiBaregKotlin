package com.example.ghozy.fussballclub

import com.example.ghozy.fussballclub.model.Team

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)
}