package com.randommlabs.github_info.modules.github_search.fragments

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.randommlabs.github_info.base.networks.GithubApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by aditya on 18/11/20.
 */
class RepoListViewModel(var githubApiService: GithubApiService) : ViewModel() {

    var repoList = MutableLiveData<List<RepoData>>(emptyList())
    var message =MutableLiveData<String>(null)
    private val disposables = CompositeDisposable()

    init {
        getRepos().subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe({ userDetails ->
                repoList.value=userDetails
            }, { throwable ->
                var error = throwable.localizedMessage;
            })?.let {
                disposables.add(
                    it
                )
            }
    }

    fun getRepos(): io.reactivex.Observable<List<RepoData>> {
        return githubApiService.getRepos();
    }

    fun onClick(view: View?)
    {
        message.value="close"
    }
}