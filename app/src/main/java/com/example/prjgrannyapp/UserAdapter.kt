package com.example.prjgrannyapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class UserAdapter :ListAdapter<User,UserAdapter.UserAdapter>(UserViewHolder())
{
    class UserAdapter(view : View):RecyclerView.ViewHolder(view)
    {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter {
        val inflater = LayoutInflater.from(parent.context)
        return com.example.prjgrannyapp.UserAdapter.UserAdapter(inflater.inflate(
            R.layout.userlayout,parent,false))
    }

    override fun onBindViewHolder(holder: UserAdapter, position: Int) {

    }
}
class UserViewHolder :DiffUtil.ItemCallback<User>()
{
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.Name == newItem.Name
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return areItemsTheSame(oldItem,newItem)
    }


}
