package au.sj.owl.restimagegallery.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import au.sj.owl.restimagegallery.R
import au.sj.owl.restimagegallery.home.link.Link
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.rv_icon.view.rv_iconPlaceholder
import timber.log.Timber


class GalleryAdapter(var activity: MainActivity,
                     var items: List<Link>) : RecyclerView.Adapter<GalleryAdapter.ViewHolder>() {

    var options = RequestOptions()
            .placeholder(R.mipmap.ic_launcher_round)
            .error(R.mipmap.ic_launcher)

    override fun onBindViewHolder(holder: ViewHolder,
                                  position: Int) {
        //        Single.fromCallable {
        //
        //        }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe()
        Glide.with(activity)
                .load(items[position].link)
                .apply(options)
                .into(holder.icon!!)


        Timber.d("jsp loaded ${items[position].link}")
    }

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.rv_icon, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var icon: ImageView? = v.rv_iconPlaceholder
    }
}

