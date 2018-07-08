package com.example.bruno.aplicativo3a.Escalas;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bruno.aplicativo3a.Escalas.Dias.Quarta.EscalaQuaFragment;
import com.example.bruno.aplicativo3a.Escalas.Dias.Quinta.EscalaQuiFragment;
import com.example.bruno.aplicativo3a.Escalas.Dias.Segunda.EscalaSegFragment;
import com.example.bruno.aplicativo3a.Escalas.Dias.Sexta.EscalaSexFragment;
import com.example.bruno.aplicativo3a.Escalas.Dias.Terca.EscalaTerFragment;
import com.example.bruno.aplicativo3a.Main.SectionsPagerAdapter;
import com.example.bruno.aplicativo3a.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EscalaFuncionariosFragment extends Fragment {

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
        mSectionsPagerAdapter = new SectionsPagerAdapter(getActivity().getSupportFragmentManager());

        setupViewPager(mViewPager);

        tabLayout.setupWithViewPager(mViewPager);

        return view;
    }

    private void setupViewPager(ViewPager viewPager) {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getActivity().getSupportFragmentManager());
        adapter.addFragment(new EscalaSegFragment(), "Seg");
        adapter.addFragment(new EscalaTerFragment(), "Ter");
        adapter.addFragment(new EscalaQuaFragment(), "Qua");
        adapter.addFragment(new EscalaQuiFragment(), "Qui");
        adapter.addFragment(new EscalaSexFragment(), "Sex");
        viewPager.setAdapter(adapter);
    }


}
