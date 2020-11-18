package com.randommlabs.github_info.modules.github_search.fragments

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.randommlabs.github_info.databinding.RepoDetailsBinding
import javax.inject.Inject


/**
 * Created by aditya on 18/11/20.
 */

class RepoListAdaptor @Inject constructor(
    context: Context,
    repoList: List<RepoData>
) :
    RecyclerView.Adapter<RepoListAdaptor.RepoDetailsViewHolder?>() {
    private val context: Context
    var repoList: List<RepoData>?= emptyList()

    @NonNull
    override fun onCreateViewHolder(@NonNull viewGroup: ViewGroup, i: Int): RepoDetailsViewHolder {
        val layoutInflater =LayoutInflater.from(viewGroup.context)
        val itemBinding: RepoDetailsBinding =
            RepoDetailsBinding.inflate(layoutInflater,  viewGroup, false)
        return RepoDetailsViewHolder(itemBinding)
    }

    override fun onBindViewHolder(@NonNull holder: RepoDetailsViewHolder, position: Int) {
        val data: RepoData = repoList!!.get(position)
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return  repoList!!.size
    }

    fun updateData(value: List<RepoData>) {
        repoList = value
        notifyDataSetChanged()
    }

    init {
        this.context = context
        this.repoList = repoList
    }

    class RepoDetailsViewHolder(var binding: RepoDetailsBinding) : RecyclerView.ViewHolder(binding.root) {


        fun bind(repoData: RepoData?) {
            binding!!.repoData=repoData
            binding!!.executePendingBindings()
        }
    }
}