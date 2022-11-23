package com.tingtu.ax.admin.commons.utils;

import cn.hutool.core.util.StrUtil;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * 根据RFC 5987规范生成disposition值, 解决浏览器兼容以及中文乱码问题
 *
 * @author Administrator
 */
public class WebFilenameUtils {
    private static final String DISPOSITION_FORMAT = "attachment; filename=%s; filename*=utf-8''%s";

    /**
     * 未编码文件名转Content-Disposition值
     *
     * @param filename 未编码的文件名(包含文件后缀)
     * @return Content-Disposition值
     */
    public static String disposition(String filename) throws UnsupportedEncodingException {
        String codedFilename = filename;
        if (StrUtil.isNotBlank(filename)) {
            codedFilename = java.net.URLEncoder.encode(filename, StandardCharsets.UTF_8.displayName());
        }
        return String.format(DISPOSITION_FORMAT, codedFilename, codedFilename);

    }
}
