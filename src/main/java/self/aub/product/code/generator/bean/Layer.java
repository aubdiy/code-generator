package self.aub.product.code.generator.bean;

import static self.aub.product.code.generator.util.Constant.JAVA_FILE_SUFFIX;

/**
 * @author aub
 */
public class Layer {
    private String layerNameAct;
    private String fileSuffixAct;
    private String classSuffixAct;
    private String layerNameBiz;
    private String fileSuffixBiz;
    private String classSuffixBiz;
    private String layerNameDao;
    private String fileSuffixDao;
    private String classSuffixDao;
    private String layerNamePo;
    private String fileSuffixPo;
    private String classSuffixPo;


    public Layer(String classSuffixAct, String classSuffixBiz, String classSuffixDao, String classSuffixPo) {
        this.classSuffixAct = classSuffixAct;
        this.layerNameAct = classSuffixAct.toLowerCase();
        this.fileSuffixAct = classSuffixAct + JAVA_FILE_SUFFIX;

        this.classSuffixBiz = classSuffixBiz;
        this.layerNameBiz = classSuffixBiz.toLowerCase();
        this.fileSuffixBiz = classSuffixBiz + JAVA_FILE_SUFFIX;

        this.classSuffixDao = classSuffixDao;
        this.layerNameDao = classSuffixDao.toLowerCase();
        this.fileSuffixDao = classSuffixDao + JAVA_FILE_SUFFIX;

        this.classSuffixPo = classSuffixPo;
        this.layerNamePo = classSuffixPo.toLowerCase();
        //TODO 固定pojo命名
        //this.layerNamePo = "pojo";
        this.fileSuffixPo = classSuffixPo + JAVA_FILE_SUFFIX;
    }


    public static String getJavaFileSuffix() {
        return JAVA_FILE_SUFFIX;
    }

    public String getLayerNameAct() {
        return layerNameAct;
    }

    public String getFileSuffixAct() {
        return fileSuffixAct;
    }

    public String getClassSuffixAct() {
        return classSuffixAct;
    }

    public String getLayerNameBiz() {
        return layerNameBiz;
    }

    public String getFileSuffixBiz() {
        return fileSuffixBiz;
    }

    public String getClassSuffixBiz() {
        return classSuffixBiz;
    }

    public String getLayerNameDao() {
        return layerNameDao;
    }

    public String getFileSuffixDao() {
        return fileSuffixDao;
    }

    public String getClassSuffixDao() {
        return classSuffixDao;
    }

    public String getLayerNamePo() {
        return layerNamePo;
    }

    public String getFileSuffixPo() {
        return fileSuffixPo;
    }

    public String getClassSuffixPo() {
        return classSuffixPo;
    }
}
