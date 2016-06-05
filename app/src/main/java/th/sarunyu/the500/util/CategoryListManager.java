package th.sarunyu.the500.util;

import java.util.ArrayList;
import java.util.List;

import th.sarunyu.the500.dao.CategoryItemDao;

/**
 * Created by Sarunyu on 4/6/2016.
 */
public class CategoryListManager {

    List<CategoryItemDao> list;

    public List<CategoryItemDao> getList() {
        return list;
    }

    private static CategoryListManager ourInstance = new CategoryListManager();

    public static CategoryListManager getInstance() {
        return ourInstance;
    }

    private CategoryListManager() {
        initialCategoryList();
    }

    private void initialCategoryList(){
        list = new ArrayList<CategoryItemDao>();
        list.add(new CategoryItemDao("0","Uncategorized","Uncategorized"));
        list.add(new CategoryItemDao("10","Abstract","Abstract"));
        list.add(new CategoryItemDao("11","Animals","Animals"));
        list.add(new CategoryItemDao("5","Black and White","Black and White"));
        list.add(new CategoryItemDao("1","Celebrities","Celebrities"));
        list.add(new CategoryItemDao("9","City and Architecture","City and Architecture"));
        list.add(new CategoryItemDao("15","Commercial","Commercial"));
        list.add(new CategoryItemDao("16","Concert","Concert"));
        list.add(new CategoryItemDao("20","Family","Family"));
        list.add(new CategoryItemDao("14","Fashion","Fashion"));
        list.add(new CategoryItemDao("2","Film","Film"));
        list.add(new CategoryItemDao("24","Fine Art","Fine Art"));
        list.add(new CategoryItemDao("23","Food","Food"));
        list.add(new CategoryItemDao("3","Journalism","Journalism"));
        list.add(new CategoryItemDao("8","Landscapes","Landscapes"));
        list.add(new CategoryItemDao("12","Macro","Macro"));
        list.add(new CategoryItemDao("18","Nature","Nature"));
        list.add(new CategoryItemDao("4","Nude","Nude"));
        list.add(new CategoryItemDao("7","People","People"));
        list.add(new CategoryItemDao("19","Performing Arts","Performing Arts"));
        list.add(new CategoryItemDao("17","Sport","Sport"));
        list.add(new CategoryItemDao("6","Still Life","Still Life"));
        list.add(new CategoryItemDao("21","Street","Street"));
        list.add(new CategoryItemDao("26","Transportation","Transportation"));
        list.add(new CategoryItemDao("13","Travel","Travel"));
        list.add(new CategoryItemDao("22","Underwater","Underwater"));
        list.add(new CategoryItemDao("27","Urban Exploration","Urban Exploration"));
        list.add(new CategoryItemDao("25","Wedding","Wedding"));
    }
}
