package com.randommlabs.github_info.modules.github_search.fragments

import android.graphics.Movie
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.randommlabs.github_info.R
import com.randommlabs.github_info.base.BaseFragment
import com.randommlabs.github_info.databinding.RepoListFragmentBinding
import javax.inject.Inject


/**
 * Created by aditya on 18/11/20.
 */

open class RepoListFragment : BaseFragment<RepoListViewModel>() {

    @Inject
    lateinit var repoListViewModel: RepoListViewModel
    var adapter: RepoListAdaptor? = null

    var binding: RepoListFragmentBinding? = null

    override fun getViewModel(): RepoListViewModel {
        return repoListViewModel;
    }

    open fun setupRecyclerView() {
        val recyclerView: RecyclerView =
            binding!!.recyclerView
        val layoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = layoutManager
        adapter = RepoListAdaptor(activity!!, emptyList())
        recyclerView.adapter = adapter
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.repo_list_fragment, container, false
        )
        val view: View? = binding?.root
        setupRecyclerView()
        setupListeners()
        return view
    }


    fun setupListeners() {
        repoListViewModel.repoList.observe(this, Observer {
            adapter?.updateData(it)
        })
        repoListViewModel.message.observe(this, Observer {
            if (it != null && it.equals("close"))
                getActivity()?.onBackPressed();
        })
    }

}