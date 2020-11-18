package com.randommlabs.github_info.modules.github_search

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.randommlabs.github_info.R
import com.randommlabs.github_info.base.networks.GithubApiService
import com.randommlabs.github_info.modules.github_search.models.UserDetails
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


/**
 * Created by aditya on 15/11/20.
 */

class GithubSearchViewModel : ViewModel {

    var githubApiService: GithubApiService? = null
    private val disposables = CompositeDisposable()
    var error: String? = null

    var navigateEvent = MutableLiveData<String>(null);

    var user = MutableLiveData<String>(null)

    var name = MutableLiveData<String>(null)
    var id = MutableLiveData<String>(null)
    var company = MutableLiveData<String>(null)
    var location = MutableLiveData<String>(null)
    var email = MutableLiveData<String>(null)
    var bio = MutableLiveData<String>(null)
    var public_repos = MutableLiveData<String>(null)
    var public_gists = MutableLiveData<String>(null)
    var followers = MutableLiveData<String>(null)
    var following = MutableLiveData<String>(null)

    constructor(githubApiService: GithubApiService?) {
        this.githubApiService = githubApiService;
    }

    fun onClick(view: View?) {
        when (view?.id) {
            R.id.tv_view_repos -> onClickViewRepos()
            R.id.bt_search -> onClickserch();
            else -> return
        }
    }

    fun onClickViewRepos() {
        navigateEvent.value="open fragment"
    }

    fun getUserDetails(): Observable<UserDetails>? {
        (user.value == null || user.value == "") && return null

        name.value = null
        id.value = null
        company.value = null
        location.value = null
        email.value = null
        bio.value = null
        public_repos.value = null
        public_gists.value = null
        followers.value = null
        following.value = null

        return githubApiService?.getData(user.value);
    }


    fun onClickserch() {
        getUserDetails()?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe({ userDetails ->
                changeData(userDetails)
            }, { throwable ->
                error = throwable.localizedMessage;
            })?.let {
                disposables.add(
                    it
                )
            }
    }

    fun changeData(userDetails: UserDetails) {
        if (userDetails.id != null) {
            name.value = userDetails.name
            id.value = userDetails.id.toString()
            company.value = userDetails.company
            location.value = userDetails.location
            email.value = userDetails.email
            bio.value = userDetails.bio
            public_repos.value = userDetails.public_repos.toString()
            public_gists.value = userDetails.public_gists.toString()
            followers.value = userDetails.followers.toString()
            following.value = userDetails.following.toString()
        } else if (userDetails.message != null && userDetails.message != "") {
            error = userDetails.message;
        } else
            error = "something went wrong";
    }


}