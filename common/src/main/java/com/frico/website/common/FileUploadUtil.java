package com.frico.website.common;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 上传图片的公共类
 * User: xrb
 * Date: 2018/3/21
 * Time: 17:49
 * Java gives me life and I have to work hard.
 */
public class FileUploadUtil {

    private static final String pathString = "";  //这里要定义图片放入地址

    private static final String basepathString = "\\save";

    public static Map<String,String> copyFile(File myfile, String filename) {

        try {
            Map<String, String> map = new HashMap <>();

            File fileupload = new File(pathString); //获取被复制对象的File对象

            if(!fileupload.exists()){     //判断复制到的目录是否存在,不存在就创建
                fileupload.mkdirs();
            }
            //这里生成一个随机名
            String filenamenew = DateUtil.getManyString(15)
                    + DateUtil.getTimeString();
            String filetype = "jpg";
            String [] filenametempStrings = filename.split("\\.");

            if (filenametempStrings.length > 0){
                filetype = filenametempStrings[filenametempStrings.length - 1];
            }

            map.put("savepath", basepathString + "\\" +filenamenew + "." + filetype);

            final String finalFilePath = pathString + "\\" + filenamenew + "." + filetype;

            File filewrteFile = new File(finalFilePath);
            //获取被复制对象的输入流
            FileInputStream fis = new FileInputStream(myfile);
            //获取目标位置的输出流
            FileOutputStream fos = new FileOutputStream(filewrteFile);
            //用byte数组去接流信息
            byte[] bs = new byte[fis.available()];


            fis.read(bs);
            fos.write(bs);

            fis.close();
            fos.close();

            map.put("realpath", finalFilePath);

            return map;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }


    /**
     * 截取图片
     * width :宽度
     * height: 高度
     * int x: 横坐标
     * int y: 纵坐标
     */
    public static Map<String, String> cutImge(File myfeile, String fileName,
                                              int width, int height, int x, int y, int imgwidth){
        try{
            Map<String, String> map = new HashMap <>();
            File fileupload = new File(pathString);

            if (!fileupload.exists()){
                fileupload.mkdirs();
            }

            //生成一个随机数  以随机生成的文件名 + 时间来命名
            String filenamenew = DateUtil.getManyString(10) + DateUtil.getTimeString();
            String filetype = "jpg";
            String[] finanametempStrings = fileName.split("\\.");
            if (finanametempStrings.length > 0){
                filetype = finanametempStrings[finanametempStrings.length - 1];
            }

            map.put("savepath", basepathString + "\\" +filenamenew + "." + filetype);

            final String finalFilePath = pathString + "\\" + filenamenew + "." + filetype;

            File filewrteFile = new File(finalFilePath);
            //获取图片读入器
            Iterator readers = ImageIO.getImageReadersByFormatName(filetype);
            ImageReader reader = (ImageReader) readers.next();

            //获取图片读入流
            InputStream sourceiput = new FileInputStream(myfeile);
            ImageInputStream iis = ImageIO.createImageInputStream(sourceiput);
            reader.setInput(iis,true);
            //图片参数
            ImageReadParam param = reader.getDefaultReadParam();
            //获取图片实际宽度和高度
            int realwidth = reader.getWidth(0);
            int realheight = reader.getHeight(0);
            //截取时宽度与实际宽度比例
            double wb = realwidth / imgwidth;
            double hb = realheight / ((realheight / realwidth) * imgwidth);
            // x轴 y轴  宽度  高度  new  Rectangle(x坐标 y坐标 宽度 高度)
            Rectangle rect = new Rectangle((int) (x * wb), (int) (y * hb), (int) (width * hb),
                    (int) (height * hb));
            param.setSourceRegion(rect);  //设置即将储存的图片参数
            BufferedImage bi = reader.read(0, param);  //读取图片的流
            ImageIO.write(bi, filetype, filewrteFile); //存写
            map.put("realpath", finalFilePath);

            return map;

        }catch (Exception e){
            e.printStackTrace();
        }
        return  null;
    }

}

















































