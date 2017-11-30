package com.dhw.greendao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import com.dhw.greendao.bean.NewsBean;
import com.dhw.greendao.bean.NewslistBean;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// 使用Retrofit封装的方法,操作数据库
public class MainActivity extends AppCompatActivity {
    @BindView(R.id.btn)
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btn)
    public void onViewClicked() {
        //创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.tianapi.com")// 设置 网络请求 Url
                .addConverterFactory(GsonConverterFactory.create())//设置使用Gson解析(记得加入依赖)
                .build();

        //创建 网络请求接口 的实例
        GetDataInterface request = retrofit.create(GetDataInterface.class);

        //对 发送请求 进行封装
        Call<NewsBean> call = request.getData();

        //发送网络请求(异步)
        call.enqueue(new Callback<NewsBean>() {
            @Override
            public void onResponse(Call<NewsBean> call, Response<NewsBean> response) {
                //返回的数据
                NewsBean newsBean = response.body();
                System.out.println("News：" + newsBean);

                //通过IApplication.session操作数据库  //insertInIx 将集合添加到数据库
                IApplication.session.getNewslistBeanDao().insertInTx(newsBean.getNewslist());

                //添加完查询一下  loadAll()查询数据库全部内容
                List<NewslistBean> list = IApplication.session.getNewslistBeanDao().loadAll();
                for (NewslistBean bean : list) {
                    System.out.println("查询数据 = " + bean.toString());
                }
            }

            @Override
            public void onFailure(Call<NewsBean> call, Throwable t) {

            }
        });
    }
}
