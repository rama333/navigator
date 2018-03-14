package ru.rt.navigator.view.adapters;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.rt.navigator.R;
import ru.rt.navigator.view.FormActivity;
import ru.rt.navigator.view.MapsActivity;
import ru.rt.navigator.view.dto.ProgramDto;

/**
 * Created by ramil on 19.11.2017.
 */

public class NavigatorAdapter extends RecyclerView.Adapter<NavigatorAdapter.ViewHolder> {

    List<ProgramDto> list;
    Context context;
    int lastPosition=0;

    public NavigatorAdapter(List<ProgramDto> list, Context context ) {

        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View rowView = layoutInflater.inflate(R.layout.list_row, parent, false);
        return new ViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final String map = list.get(position).getAddressIntitution();
        final String name = list.get(position).getNameIntitution();
        final String phone = list.get(position).getPhone();
        holder.textName.setText(list.get(position).getTitle());
        holder.desc.setText(list.get(position).getDescription());

        setAnimation(holder.cardView, position);

        holder.mult.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {


                holder.mult.setVisibility(View.INVISIBLE);

                holder.desc.setEllipsize(null);

                ValueAnimator animator = ValueAnimator.ofInt(4, 25).setDuration(350);

                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    int lastValue = -1;

                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int value = (int) animation.getAnimatedValue();

                        if (value == lastValue) {
                            return;
                        }

                        lastValue = value;

                        holder.desc.setMaxLines(value);
                    }
                });

                animator.start();

                return false;
            }
        });



        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFormActivity(list.get(position).getTitle());
            }
        });

       /* holder.map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mapIntent(map, name, phone);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });*/

       holder.map.setOnTouchListener(new View.OnTouchListener() {
           @Override
           public boolean onTouch(View v, MotionEvent event) {
               try {
                   mapIntent(map, name, phone);
               } catch (IOException e) {
                   e.printStackTrace();
               }
               return false;
           }
       });

        String real = "";
        if (list.get(position).getRealizationForm().equals("FULL_TIME")) {
            real = "Очное";
        } else {
            real = "Заочное";
        }
        holder.state.setText(real);
        holder.date.setText(list.get(position).getStartDate() + " - " + list.get(position).getFinishDate());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated

        if(position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(context, R.anim.load);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;}

    }

    private void mapIntent(String address, String dis, String phone) throws IOException {
        //String dis1 = "Образовательный центр: " + dis + "\n" + "Телефон: " + phone;
        Geocoder geocoder = new Geocoder(context);
        List<Address> addresses;
        double latitude = 0;
        double longitude = 0;

        addresses = geocoder.getFromLocationName(address, 1);
        if(addresses.size() > 0) {
            latitude= addresses.get(0).getLatitude();
            longitude= addresses.get(0).getLongitude();
        }


        Intent intent = new Intent(context, MapsActivity.class);
        intent.putExtra("LATITUDE", String.valueOf(latitude));
        intent.putExtra("LONGITUDE", String.valueOf(longitude));
        intent.putExtra("ADDRESS", address);
        intent.putExtra("DIS", dis);
        intent.putExtra("PHONE", phone);
        context.startActivity(intent);

        /*Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + latitude + "," + longitude + "(" + dis1 +")");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(mapIntent);
        } else {
            Toast.makeText(context, "Установите Google maps", Toast.LENGTH_LONG).show();
        }
*/
    }

    public void add(int i, List<ProgramDto> programDtos) {
        this.list.clear();
        this.list.addAll(i, programDtos);
        notifyDataSetChanged();
        this.lastPosition = 0;
    }

    public void startFormActivity(String programTitle) {
        Intent intent = new Intent(context, FormActivity.class);
        intent.putExtra("TITLE", programTitle);
        context.startActivity(intent);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.textName)
        TextView textName;
        @BindView(R.id.desc)
        TextView desc;
        @BindView(R.id.state)
        TextView state;
        @BindView(R.id.date)
        TextView date;
        @BindView(R.id.buttonN)
        Button button;
        @BindView(R.id.map)
        ImageView map;
        @BindView(R.id.mult)
        TextView mult;
        @BindView(R.id.card_view)
        CardView cardView;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
