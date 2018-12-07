package spring.boot.sample.api;

/**
 * @Author: majunsheng
 * @Date: 2018/12/7
 * QQ音乐查询返回歌词实体
 **/
public class MusicJsonCallback {

    private String retcode;

    private String code;

    private String subcode;

    private String lyric;

    private String trans;

    public String getRetcode() {
        return retcode;
    }

    public void setRetcode(String retcode) {
        this.retcode = retcode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSubcode() {
        return subcode;
    }

    public void setSubcode(String subcode) {
        this.subcode = subcode;
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }

    public String getTrans() {
        return trans;
    }

    public void setTrans(String trans) {
        this.trans = trans;
    }
}
