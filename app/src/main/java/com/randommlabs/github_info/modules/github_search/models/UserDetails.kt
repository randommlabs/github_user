package com.randommlabs.github_info.modules.github_search.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by aditya on 18/11/20.
 */

open class UserDetails() : Parcelable {

    var id: Long? = null;
    var name: String? = null;
    var company: String? = null;
    var location: String? = null;
    var email: String? = null;
    var bio: String? = null;
    var message: String? = null;
    var public_repos: Int? = null
    var public_gists: Int? = null;
    var followers: Int? = null;
    var following: Int? = null;


    constructor(parcel: Parcel) : this() {
        id = parcel.readValue(Long::class.java.classLoader) as? Long
        name = parcel.readString()
        company = parcel.readString()
        location = parcel.readString()
        email = parcel.readString()
        bio = parcel.readString()
        message = parcel.readString()
        public_repos = parcel.readValue(Int::class.java.classLoader) as? Int
        public_gists = parcel.readValue(Int::class.java.classLoader) as? Int
        followers = parcel.readValue(Int::class.java.classLoader) as? Int
        following = parcel.readValue(Int::class.java.classLoader) as? Int
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(name)
        parcel.writeString(company)
        parcel.writeString(location)
        parcel.writeString(email)
        parcel.writeString(bio)
        parcel.writeString(message)
        parcel.writeValue(public_repos)
        parcel.writeValue(public_gists)
        parcel.writeValue(followers)
        parcel.writeValue(following)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserDetails> {
        override fun createFromParcel(parcel: Parcel): UserDetails {
            return UserDetails(parcel)
        }

        override fun newArray(size: Int): Array<UserDetails?> {
            return arrayOfNulls(size)
        }
    }

}