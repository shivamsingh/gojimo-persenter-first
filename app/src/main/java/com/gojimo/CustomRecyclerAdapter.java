package com.gojimo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class CustomRecyclerAdapter<T, V extends View & BaseListItemView<T>> extends
        RecyclerView.Adapter<CustomRecyclerAdapter.CustomViewHolder> {

    private List<T> items;
    private final Function0<V> viewBuilder;

    public CustomRecyclerAdapter(List<T> items, Function0<V> viewBuilder) {
        this.items = items;
        this.viewBuilder = viewBuilder;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CustomViewHolder(viewBuilder.call());
    }

    @Override
    public void onBindViewHolder(CustomRecyclerAdapter.CustomViewHolder holder, int position) {
        ((BaseListItemView) holder.getItemView()).bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public T getItem(final int position) {
        return items.get(position);
    }

    public void setItems(List<T> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        private V itemView;

        public CustomViewHolder(V itemView) {
            super(itemView);
            this.itemView = itemView;
        }

        public V getItemView() {
            return itemView;
        }
    }
}
