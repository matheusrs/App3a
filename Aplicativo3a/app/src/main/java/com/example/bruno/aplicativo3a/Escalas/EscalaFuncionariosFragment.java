package com.example.bruno.aplicativo3a.Escalas;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bruno.aplicativo3a.Escalas.Dias.Quarta.QuaFragment;
import com.example.bruno.aplicativo3a.Escalas.Dias.Quinta.QuiFragment;
import com.example.bruno.aplicativo3a.Escalas.Dias.Segunda.SegFragment;
import com.example.bruno.aplicativo3a.Escalas.Dias.Sexta.SexFragment;
import com.example.bruno.aplicativo3a.Escalas.Dias.Terca.TerFragment;
import com.example.bruno.aplicativo3a.Main.SectionsPagerAdapter;
import com.example.bruno.aplicativo3a.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EscalaFuncionariosFragment extends Fragment {

    private FragmentActivity context;
    public EscalaFuncionariosFragment() {
        // Required empty public constructor
    }

    private SectionsPagerAdapter mSectionsPagerAdapter;

    @BindView(R.id.viewPagerEscala)
    ViewPager mViewPager;

    @BindView(R.id.tabsEscala)
    TabLayout tabLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_escala_funcionarios, container, false);
        ButterKnife.bind(this,view);
        mSectionsPagerAdapter = new SectionsPagerAdapter(context.getSupportFragmentManager());

        setupViewPager(mViewPager);

        tabLayout.setupWithViewPager(mViewPager);

        return view;
    }

    private void setupViewPager(ViewPager viewPager) {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(context.getSupportFragmentManager());
        adapter.addFragment(new SegFragment(), "Seg");
        adapter.addFragment(new TerFragment(), "Ter");
        adapter.addFragment(new QuaFragment(), "Qua");
        adapter.addFragment(new QuiFragment(), "Qui");
        adapter.addFragment(new SexFragment(), "Sex");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onAttach(Activity activity) {
        context=(FragmentActivity) activity;
        super.onAttach(activity);
    }

}
