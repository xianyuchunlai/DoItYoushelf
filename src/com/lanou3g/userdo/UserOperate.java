package com.lanou3g.userdo;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static com.lanou3g.constant.Constant.*;

public class UserOperate {


    public static void register() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("选择注册成功，请输入用户名（用户名只能是手机或邮箱）");
        String userName = input.next();
        if (userName.matches(regex0) == true && userName.matches(regex1) == true) {
            System.out.println("账户格式正确，请输入密码");
        }
        String passWord = input.next();
        if (passWord.matches(regex2) == true) {
            System.out.println("密码格式正确注册成功");
        }


        Document document = DocumentHelper.createDocument();
        Element users = document.addElement("users");
        Element userName1 = users.addElement("userName");
        Element passWord1 = users.addElement("passWord");
        userName1.addAttribute("userName", userName);
        passWord1.addAttribute("passWord", passWord);
        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        outputFormat.setEncoding("utf-8");
        XMLWriter xmlWriter = new XMLWriter(new FileWriter("src/users.xml"), outputFormat);
        xmlWriter.write(document);
        xmlWriter.close();

    }

    public static void login() throws DocumentException {
        Scanner input = new Scanner(System.in);
        System.out.println("选择登陆成功");
        System.out.println("输入用户名");
        String name = input.next();
        System.out.println("输入密码");
        String pass = input.next();

        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File("src/users.xml"));
        Element root = document.getRootElement();
        Element username1 = root.element("userName");
        Element password1 = root.element("password");
        Attribute username = username1.attribute("userName");
        String usernameValue = username.getValue();
        Attribute password = password1.attribute("password");
        String passwordValue = password.getValue();

        if (name.equals(usernameValue) && pass.equals(passwordValue)) {
            System.out.println("登录成功");
        } else {
            System.out.println("账户与密码不匹配");
        }
        System.out.println("用户名为：" + usernameValue);

    }

}
