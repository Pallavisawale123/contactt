package com.example.contactt;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder>
{
    ArrayList<model> dataholder;
    private Context context;
    public myadapter(Context context, ArrayList<model> dataholder) {
        this.context = context;
        this.dataholder = dataholder;
    }
/*public RecyclerViewAdapter(Context context, List<Contact> contactList) {
        this.context = context;
        this.contactList = contactList;
    }
    // Where to get the single card as viewholder Object
    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new ViewHolder(view);
    }

    // What will happen after we create the viewholder object
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        Contact contact = contactList.get(position);

        holder.contactName.setText(contact.getName());
        holder.phoneNumber.setText(contact.getPhoneNumber());

    }*/
    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position)
    {
       /* model contact =dataholder.get ( position );
        holder.dname.setText(dataholder.get(position).getName());
        holder.dcontact.setText(dataholder.get(position).getContact());
        holder.demail.setText(dataholder.get(position).getEmail());*/
       model contact = dataholder.get(position);

        holder.dname.setText(contact.getName());
        //holder.emailT.setText ( contact.getEmail () );
        holder.dcontact.setText(contact.getContact ());
        holder.demail.setText ( contact.getEmail () );

    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

   /* class myviewholder extends RecyclerView.ViewHolder
    {
        TextView dname,dcontact,demail;
        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            dname=(TextView)itemView.findViewById(R.id.displayname);
            dcontact=(TextView)itemView.findViewById(R.id.displaycontact);
            demail=(TextView)itemView.findViewById(R.id.displayemail);

        }
    }*/
    class myviewholder extends RecyclerView.ViewHolder implements View.OnClickListener
	{

        TextView dname,dcontact,demail;

        public  myviewholder(@NonNull View itemView)
	{
            super(itemView);
            itemView.setOnClickListener(this);

             dname=(TextView)itemView.findViewById(R.id.displayname);
            dcontact=(TextView)itemView.findViewById(R.id.displaycontact);
            demail=(TextView)itemView.findViewById(R.id.displayemail);

             // demail.setOnClickListener(this);
        }

        @Override
        public void onClick(View view)
	{
         Log.d("ClickFromViewHolder", "Clicked");
        // Toast.makeText ( context,"postion is",Toast.LENGTH_SHORT ).show ();
            int position = this.getAdapterPosition();
        model contact = dataholder.get(position);
       // model contact =dataholder.get ( position );
        Toast.makeText ( context,"postion is" +String.valueOf(position),Toast.LENGTH_SHORT ).show ();
        String name = contact.getName();
        String phone = contact.getContact ();
        String email=contact.getEmail ();
        Toast.makeText(context, "The position is " + String.valueOf(position) +
                " Name: " + name + ", Phone:" + phone +",Email:" + email, Toast.LENGTH_SHORT).show();
         //  model contact = dataholder.get(position);
                    Intent intent = new Intent(context, displayContact.class);
            intent.putExtra("Rname", name);
            intent.putExtra("Rphone", phone);
            intent.putExtra ( "Remail",email );
            context.startActivity(intent);
           /* String name = contact.getName();
            String phone = contact.getContact ();
           String email=contact.getEmail ();
            Toast.makeText(context, "The position is " + String.valueOf(position) +
                    " Name: " + name + ", Phone:" + phone +",Email:" + email, Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(context, displayContact.class);
            intent.putExtra("Rname", name);
            intent.putExtra("Rphone", phone);
            intent.putExtra ( "Remail",email );
            context.startActivity(intent);*/

        }
    }

}

