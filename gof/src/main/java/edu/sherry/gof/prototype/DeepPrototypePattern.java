package edu.sherry.gof.prototype;

import edu.sherry.gof.prototype.entry.Attachment;
import edu.sherry.gof.prototype.entry.Form;

import java.io.IOException;

/**
 * 4.原型模式 - 深克隆
 */
public class DeepPrototypePattern {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //  原型对象
        Attachment prototypeAtt = new Attachment("file 1");
        Form prototypeForm = new Form();
        prototypeForm.setAttachment(prototypeAtt);

        //  深度克隆
        Form deepCloneForm = prototypeForm.deepClone();

        //  改变原型中的属性
        prototypeAtt.setFileName("file 2");

        System.out.println("prototypeForm attachment file: " + prototypeForm.getAttachment().getFileName());
        System.out.println("prototypeForm attachment hashCode: " + prototypeForm.getAttachment().hashCode());

        System.out.println("deepCloneForm attachment file: " + deepCloneForm.getAttachment().getFileName());
        System.out.println("deepCloneForm attachment hashCode: " + deepCloneForm.getAttachment().hashCode());

    }
}
