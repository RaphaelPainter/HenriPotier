package fr.android.paintersimon.presentation
import android.view.KeyCharacterMap.load
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.android.paintersimon.R
import fr.android.paintersimon.domain.Book
import java.lang.System.load


class LibraryAdapter(private var mList: List<Book>) : RecyclerView.Adapter<LibraryAdapter.ViewHolder>() {



        // create new views
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            // inflates the card_view_design view
            // that is used to hold list item
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.card_view_design, parent, false)

            return ViewHolder(view)
        }

        // binds the list items to a view
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {

            val ItemsViewModel = mList[position]

            // sets the text to the textview from our itemHolder class
            holder.textView.text = mList.get(position).title
            Picasso.get().load(mList.get(position).cover).into(holder.imageView);

        }

        // return the number of the items in the list
        override fun getItemCount(): Int {
            return mList.size
        }

        // Holds the views for adding it to image and text
        class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
            val textView: TextView = itemView.findViewById(R.id.textView)
            val imageView: ImageView = itemView.findViewById(R.id.imageview)
        }
        fun setList(booksP:List<Book> ){
            mList = booksP
        }

    }