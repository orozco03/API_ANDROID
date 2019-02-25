package www.mensajerosurbanos.com.co.login.Models;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.AbsListView;

public abstract class ScrollListener extends RecyclerView.OnScrollListener {

    private int visibleThreshold = 10;
    private int PagActual = 0;
    private int PagAnterior = 0;
    private boolean loading = true;
    private int Indice = 0;

    RecyclerView.LayoutManager LayoutManager;

    public ScrollListener(LinearLayoutManager layoutManager) {
        this.LayoutManager = layoutManager;
    }

    public ScrollListener(GridLayoutManager layoutManager) {
        this.LayoutManager = layoutManager;
        visibleThreshold = visibleThreshold * layoutManager.getSpanCount();
    }

    public ScrollListener(StaggeredGridLayoutManager layoutManager) {
        this.LayoutManager = layoutManager;
        visibleThreshold = visibleThreshold * layoutManager.getSpanCount();
    }



    public int getLastVisibleItem(int[] lastVisibleItemPositions) {
        int maxSize = 0;
        for (int i  : lastVisibleItemPositions) {
            if (i == 0) {
                maxSize = lastVisibleItemPositions[i];
            }
            else if (lastVisibleItemPositions[i] > maxSize) {
                maxSize = lastVisibleItemPositions[i];
            }
        }
        return maxSize;
    }

    @Override
    public void onScrolled(RecyclerView view, int dx, int dy) {
        int lastVisibleItemPosition = 0;
        int totalItemCount = LayoutManager.getItemCount();

        if (LayoutManager instanceof StaggeredGridLayoutManager) {

            int[] lastVisibleItemPositions = ((StaggeredGridLayoutManager) LayoutManager).findLastVisibleItemPositions(null);
            lastVisibleItemPosition = getLastVisibleItem(lastVisibleItemPositions);
        } else if (LayoutManager instanceof GridLayoutManager) {

            lastVisibleItemPosition = ((GridLayoutManager) LayoutManager).findLastVisibleItemPosition();
        } else if (LayoutManager instanceof LinearLayoutManager) {

            lastVisibleItemPosition = ((LinearLayoutManager) LayoutManager).findLastVisibleItemPosition();
        }

        if (loading && (totalItemCount > PagAnterior)) {
            loading = false;
            PagAnterior = totalItemCount;
        }

        if (!loading && (lastVisibleItemPosition + visibleThreshold) > totalItemCount) {
            PagActual++;
            onLoadMore(PagActual, totalItemCount, view);
            loading = true;
        }
    }

    public void resetState() {
        this.PagActual = this.Indice;
        this.PagAnterior = 0;
        this.loading = true;
    }

    public abstract void onLoadMore(int page, int totalItemsCount, RecyclerView view);


}