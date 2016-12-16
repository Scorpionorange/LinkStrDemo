/**
 * Created by ScorpionOrange on 2016/12/12.
 * re-update in 2016.12.17
 */
class LinkChar{
    // 字符域
    private char aChar;

    // 节点连接引用域
    private LinkChar next;

    public char getaChar(){
        return aChar;
    }

    public void setaChar(char aChar){
        this.aChar = aChar;
    }

    public LinkChar getNext(){
        return next;
    }

    public void setNext(LinkChar next){
        this.next = next;
    }
}
class LinkStr{
    // 头节点
    private LinkChar hc;
    // 字符串长度
    private int length;

    // 带字符数组参数的构造方法
    public LinkStr(char[] chars){
        hc = new LinkChar();
        LinkChar q = hc;
        for(int i = 0; i < chars.length; i++){
            LinkChar p = new LinkChar();
            p.setaChar(chars[i]);
            q.setNext(p);
            q = p;
        }

        // 设置最后一个字符节点的引用域为空
        q.setNext(null);

        // 设置字符串长度
        this.length = chars.length;
    }

    /**
     * 返回一个新字符串，它是此字符串的一个子字符串。该子字符串从指定的beginIndex处开始，直到索引endIndex-1处的字符。
     */
    public LinkStr substring(int beginIndex, int endIndex){
        int len = endIndex - beginIndex;
        if(beginIndex < 0 || endIndex > length -1 || len <= 0){
            System.out.println("substring方法参数输入错误！");
            return null;
        }
        char[] chars = new char[len];
        LinkChar p = hc.getNext();
        // 找到beginIndex位置的字符
        for(int i = 0; i < beginIndex; i++){
            p = p.getNext();
        }

        /**
         * 将从指定的beginIndex处到索引endIndex-1处的字符，依次放到新建字符串数组chars中
         */
        for(int i = 0; i < len; i++){
            chars[i] = p.getaChar();
            p = p.getNext();
        }
        LinkStr str = new LinkStr(chars);
        return str;
    }

    // 返回字符串长度
    public int getLength(){
        return length;
    }

    public String toString(){
        char[] chars = new char[this.length];
        int i = -1;

        LinkChar q = hc;

        while (q.getNext() != null){
            q = q.getNext();
            i++;
            chars[i] = q.getaChar();
        }
        return new String(chars);
    }
}

public class LinkStrDemo {
    public static void main(String[] args){
        String s = "Hello World!";
        char[] charArray = s.toCharArray();
        LinkStr ls= new LinkStr(charArray);
        System.out.println("源字符串为：" + s);
        System.out.println("字符串为：" + ls);
        System.out.println("字符串的长度为：" + ls.getLength());
        System.out.println("子串(4, 7)：" + ls.substring(4, 7));
        System.out.println("子串(5, 9)：" + ls.substring(5, 9));
    }
}
