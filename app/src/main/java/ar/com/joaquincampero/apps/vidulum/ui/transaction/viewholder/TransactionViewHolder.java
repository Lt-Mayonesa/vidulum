package ar.com.joaquincampero.apps.vidulum.ui.transaction.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import ar.com.joaquincampero.apps.vidulum.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Joaquin Campero
 * on 2/3/19.
 */
public class TransactionViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.text_transaction_amount)
    public TextView amount;

    public TransactionViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

}
