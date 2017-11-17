package jxd.com.jxdapplication.HttpReQuest;

/**
 * Created by Landy.K
 * 返回结果
 */
public class Result<T> {

    /**
     * 状态码
     */
    public int StateCode;

    /**
     * 消息
     */
    public String Message;

    /**
     * 记录数
     */
    public int TotalCount;

    /**
     * 返回结果
     */
    public T JsonData;
}
