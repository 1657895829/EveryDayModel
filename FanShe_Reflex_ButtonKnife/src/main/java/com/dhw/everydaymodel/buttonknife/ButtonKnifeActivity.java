package com.dhw.everydaymodel.buttonknife;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.dhw.everydaymodel.R;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//自定义ButtonKnife
public class ButtonKnifeActivity extends AppCompatActivity {
    //调用自定义注解
    @IBindView(R.id.button_01)
    Button button01;
    @IBindView(R.id.button_02)
    Button button02;
    @IBindView(R.id.button_03)
    Button button03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_knife);

        initClick(this);

        //设置点击按钮时的提示值
        button01.setText("按钮 1 ");
        button02.setText("按钮 2 ");
        button03.setText("按钮 3 ");
    }

    //初始化id的方法
    public static   void initId(Activity activity){
        Class clazz =   activity.getClass() ;

        //获取当前类的所有属性
        Field[] fields =  clazz.getDeclaredFields();
        // 遍历属性
        for (Field field : fields){
            // 判断当前属性 身上是否有IBindView 注解
            if(field.isAnnotationPresent(IBindView.class)){
                // 获取当前属性身上的注解
                IBindView iBindView =   field.getAnnotation(IBindView.class);
                //取出注解 对应的值
                int id = iBindView.value();
                //查找控件
                View view =  activity.findViewById(id);
                try {
                    // 把view 设置给当前的属性
                    field.set(activity,view);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //初始化点击的方法
    public static void initClick(final Activity activity){

        Class clazz =   activity.getClass() ;

        Field [] fields =  clazz.getDeclaredFields();
        for(Field field : fields) {
            if (field.isAnnotationPresent(IBindView.class)) {
                IBindView bindView = field.getAnnotation(IBindView.class);
                View view =  activity.findViewById(bindView.value());
                try {
                    field.set(activity,view);
                    // 获取当前类的public 方法
                    Method[] methods =  clazz.getMethods();
                    for (final Method method: methods){
                        //判断当前方法上是否有IOnClick 注解
                        if(method.isAnnotationPresent(IOnClick.class)){
                            //获取方法上的注解
                            IOnClick click =  method.getAnnotation(IOnClick.class);
                            // 获取注解值
                            int id =  click.value();
                            //点击事件出发条件
                            if(bindView.value() == id){
                                view.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {

                                        try {
                                            // 调用点击事件方法
                                            method.invoke(activity);
                                        } catch (IllegalAccessException e) {
                                            e.printStackTrace();
                                        } catch (InvocationTargetException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });
                            }
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @IOnClick(R.id.button_01)
    public void onViewClicked(){
        Toast.makeText(this, "按钮Button  1 ", Toast.LENGTH_SHORT).show();
    }

}

