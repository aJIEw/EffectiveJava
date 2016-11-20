package chap11;

import java.io.Serializable;

/**
 * 第74条：谨慎的实现Serializable接口
 * 
 * 1）实现Serializable接口最大的代价是，一旦一个类被发布，就大大降低了改变这个类的实现的灵活性，兼容性遭到破坏。
 * 首先会使类的演变受到限制，如果没有指定serialVersionUID，系统就会自动生成该标识符，然后当你修改这个类，
 * UID也会跟着改变，再次反序列化就会导致InvalidClassException
 * 2）实现序列化增加了bug和安全漏洞出现的可能性。
 * 3）随着发行新的版本，相关的测试负担也会加重。
 * */
public class Law74 implements Serializable{

    private static final long serialVersionUID = 42L;
}
